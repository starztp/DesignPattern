package com.tianyou.designpattern.Decorator.Login.v1;

/**
 * Created by tianyou on 2019/12/31.
 */
public class BaseThirdPartySign extends ThirdPartySign{

    @Override
    public String login(String openid) {
        return "第三方登录";
    }
}
