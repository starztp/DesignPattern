package com.tianyou.designpattern.Adapter.LoginExample.V2;

import com.tianyou.designpattern.Adapter.LoginExample.V2.adapter.LoginAdapter;
import com.tianyou.designpattern.Adapter.LoginExample.V2.adapter.LoginForQQAdapter;
import com.tianyou.designpattern.Adapter.LoginExample.V2.adapter.LoginForWechatAdapter;
import com.tianyou.designpattern.ResultMesg;

public class LoginForThirdPartyAdapter implements ThirdPartyLogin {
    @Override
    public ResultMesg QQLogin(String id) {
        try {
            return processLogin(id,LoginForQQAdapter.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultMesg WechatLoagin(String id) {
        try {
            return processLogin(id,LoginForWechatAdapter.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private ResultMesg processLogin(String id, Class<? extends LoginAdapter> clazz) throws Exception {
        LoginAdapter adapter=clazz.newInstance();
        if(adapter.IsSupport(adapter)){
            return adapter.Login(id,adapter);
        }
        return null;
    }
}
