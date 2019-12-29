package com.tianyou.designpattern.Adapter.LoginExample.V2.adapter;

import com.tianyou.designpattern.ResultMesg;

/**
 * 其实可以无需实现接口
 */
public class LoginForWechatAdapter implements LoginAdapter {
    @Override
    public boolean IsSupport(Object adapter) {
        return adapter instanceof LoginForWechatAdapter;
    }

    @Override
    public ResultMesg Login(String Id, Object adapter) {
        System.out.println("微信登录:"+Id);
        return null;
    }
}
