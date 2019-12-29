package com.tianyou.designpattern.Adapter.LoginExample.V2.adapter;

import com.tianyou.designpattern.ResultMesg;

/**
 * 登录适配器
 */
public interface LoginAdapter {

    /**
     * 是否兼容
     * @param adapter
     * @return
     */
    boolean IsSupport(Object adapter);


    ResultMesg Login(String Id,Object adapter);
}
