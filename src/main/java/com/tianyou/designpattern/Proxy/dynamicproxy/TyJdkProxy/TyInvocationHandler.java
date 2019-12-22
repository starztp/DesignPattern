package com.tianyou.designpattern.Proxy.dynamicproxy.TyJdkProxy;

import java.lang.reflect.Method;

public interface TyInvocationHandler {

    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;
}
