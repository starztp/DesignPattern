package com.tianyou.designpattern.Proxy.dynamicproxy.JDKproxy.OrderExample;

import com.sun.org.apache.bcel.internal.util.ClassLoader;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Calendar;

public class OrderServiceDynamicProxy implements InvocationHandler {

    private Object target;

    /**
     * 自动创建被代理类的代理对象
     * @param target 被代理的对象
     * @return 返回新的代理对象
     */
    public Object getInstance(Object target){
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
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }


    /**
     *
     * @param proxy 代理对象，getInstance返回的对象
     * @param method    调用的方法
     * @param args      方法中的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object object=method.invoke(this.target,args);
        after();
        return object;
    }

    private void before(){
        Calendar calendar=Calendar.getInstance();
        int currentyear=calendar.get(Calendar.YEAR);
        System.out.println("动态代理自动分配到DB_"+currentyear+"库处理");
    }

    private void after(){
        System.out.println("还原数据库默认配置");
    }
}
