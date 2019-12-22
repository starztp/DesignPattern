package com.tianyou.designpattern.Proxy.dynamicproxy.TyJdkProxy;

import sun.reflect.Reflection;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.*;
import java.security.AccessController;
import java.security.PrivilegedAction;


public class TyProxy {

    public static final String ln = "\r\n";

    /**
     * newProxyInstance，方法有三个参数：
     *
     * loader: 用哪个类加载器去加载代理对象
     *
     * interfaces:动态代理类需要实现的接口
     *
     * h:动态代理方法在执行时，会调用h里面的invoke方法去执行
     */

    public static Object newProxyInstance(TyClassLoader loader, Class<?>[] interfaces, TyInvocationHandler h) throws IllegalArgumentException {

        try{
            //1.动态生成源代码
            String src=generateSrc(interfaces);

            //2.将java文件输出到磁盘
            String filepath=TyProxy.class.getResource("").getPath();//获取类路径
            File file=new File(filepath+"$Proxy0.java");//将类路径转化为文件
            FileWriter fileWriter=new FileWriter(file);
            fileWriter.write(src);//将生成的代码写入Proxy0.java文件
            //刷新流对象中的缓冲中的数据
            //将数据刷到目的地中
            fileWriter.flush();
            //关闭流资源，但是关闭之前会刷新一次内部的缓冲中的数据。
            //将数据刷到目的地中去。
            //和flush区别：flush 刷新后，流可以继续使用，close刷新后，会将流关闭。
            fileWriter.close();

            //3、把生成的.java文件编译成.class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manage = compiler.getStandardFileManager(null,null,null);
            Iterable iterable = manage.getJavaFileObjects(file);
            JavaCompiler.CompilationTask task = compiler.getTask(null,manage,null,null,null,iterable);
            task.call();
            manage.close();

            //4.编译生成的class到JVM中
            Class ProxyClass=loader.findClass("$Proxy0");
            Constructor constructor=ProxyClass.getConstructor(TyInvocationHandler.class);

            //5、返回字节码重组以后的新的代理对象
            return constructor.newInstance(h);
        }catch (Exception e){

        }

        return null;
    }

    private static String generateSrc(Class<?>[] interfaces) {
        StringBuffer sb=new StringBuffer();
        sb.append("package com.tianyou.designpattern.Proxy.dynamicproxy.TyJdkProxy;"+ln);
        sb.append("import com.tianyou.designpattern.Proxy.Person;"+ln);
        sb.append("import java.lang.reflect.*;"+ln);
        sb.append("public class $Proxy0 implements "+interfaces[0].getName()+"{");
        sb.append("TyInvocationHandler h;"+ln);
        sb.append("public $Proxy0(TyInvocationHandler h){"+ln);
        sb.append("this.h=h");
        sb.append("}"+ln);
        for(Method method:interfaces[0].getMethods()){
            sb.append("public "+method.getReturnType()+""+method.getName()+"{"+ln);
            sb.append("try{" + ln);
            //sb.append("Method m = " + interfaces[0].getName() + ".class.getMethod(\"" + method.getName() + "\",new Class[]{" + paramClasses.toString() + "});" + ln);
            //sb.append((hasReturnValue(m.getReturnType()) ? "return " : "") + getCaseCode("this.h.invoke(this,m,new Object[]{" + paramValues + "})",m.getReturnType()) + ";" + ln);
            sb.append("}catch(Error _ex) { }");
            sb.append("catch(Throwable e){" + ln);
            sb.append("throw new UndeclaredThrowableException(e);" + ln);
            sb.append("}");
            sb.append("}");
        }
        sb.append("}");
        return sb.toString();
    }
}
