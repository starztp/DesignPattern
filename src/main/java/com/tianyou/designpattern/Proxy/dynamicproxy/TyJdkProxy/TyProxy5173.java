package com.tianyou.designpattern.Proxy.dynamicproxy.TyJdkProxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TyProxy5173 implements TyInvocationHandler{

    private Object target;

    private Object getInstance(Object target){
        this.target=target;
        Class<?> clazz=target.getClass();
        /**
         * newProxyInstance，方法有三个参数：
         *
         * loader: 用哪个类加载器去加载代理对象
         *
         * interfaces:动态代理类需要实现的接口
         *
         * h:动态代理方法在执行时，会调用h里面的invoke方法去执行
         */
        return TyProxy.newProxyInstance(new TyClassLoader(),clazz.getInterfaces(),this);
    }

    /**
     *
     * @param proxy     代理对象，newProxyInstance方法的返回对象
     * @param method    调用的方法
     * @param args      方法中的参数
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object obj=method.invoke(this.target,args);
        after();
        return obj;
    }

    public void before(){
        System.out.println("买金币前");
    }

    public void after(){
        System.out.println("买金币后");
    }
}
