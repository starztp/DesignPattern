package com.tianyou.designpattern.Adapter.LoginExample.V2.adapter;

import com.tianyou.designpattern.ResultMesg;

public class LoginForQQAdapter implements LoginAdapter {
    @Override
    public boolean IsSupport(Object adapter) {

        return adapter instanceof LoginForQQAdapter;
    }

    @Override
    public ResultMesg Login(String Id, Object adapter) {
        System.out.println("QQ登录："+Id);
        return null;
    }
}
