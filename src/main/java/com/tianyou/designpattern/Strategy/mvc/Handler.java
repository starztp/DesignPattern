package com.tianyou.designpattern.Strategy.mvc;

import java.lang.reflect.Method;

/**
 * Created by tianyou on 2019/12/26.
 */
public class Handler {

    private String url;
    private Method method;
    private Class<?> clazz;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }
}
