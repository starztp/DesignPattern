package com.tianyou.designpattern.Proxy.dynamicproxy.TyJdkProxy;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class TyClassLoader extends ClassLoader {

    private File classPathFile;
    public TyClassLoader(){
        String classPath = TyClassLoader.class.getResource("").getPath();
        this.classPathFile = new File(classPath);
    }

    @Override
    /**
     * 通过类名称找到class文件，并将class文件转化为对象
     * 将class文件转化为字节码文件，再通过jdk底层方法将字节码文件转为class对象
     */
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String className = TyClassLoader.class.getPackage().getName() + "." + name;
        if(classPathFile  != null){
            //找到通过TyProxy.java编译好的class文件
            File classFile = new File(classPathFile,name.replaceAll("\\.","/") + ".class");
            if(classFile.exists()){
                FileInputStream in = null;
                ByteArrayOutputStream out = null;
                try{
                    in = new FileInputStream(classFile);
                    out = new ByteArrayOutputStream();
                    byte [] buff = new byte[1024];
                    int len;
                    while ((len = in.read(buff)) != -1){//read返回-1表示文件内容已经全部读完
                        out.write(buff,0,len);//将.class文件变成字节码文件
                    }
                    //通过jdk底层方法重新构造字节码文件，返回class对象
                    return defineClass(className,out.toByteArray(),0,out.size());
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
