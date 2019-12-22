package com.tianyou.designpattern.Proxy.dynamicproxy.CglibProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibGoldProxy implements MethodInterceptor {

    /**
     *
     * @param clazz 被代理的对象
     * @return 返回创建好的目标类子类
     */
    public Object getInstance(Class<?> clazz){
        //相当于Jdk的Proxy类，代理的工具类，用于动态生成代理对象
        Enhancer enhancer=new Enhancer();
        //生成目标类的子类
        enhancer.setSuperclass(clazz);
        //设置回调，用于调用下面的intercept方法
        enhancer.setCallback(this);
        //返回创建好的代理对象
        return enhancer.create();
    }


    public void before(){
        System.out.println("买金币前");
    }

    public void after(){
        System.out.println("买金币后");
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        before();
        //因为生成的类是子类，要调用父类的逻辑，所以这里是invokeSuper
        Object object=proxy.invokeSuper(obj, args);
        after();
        return object;
    }
}
