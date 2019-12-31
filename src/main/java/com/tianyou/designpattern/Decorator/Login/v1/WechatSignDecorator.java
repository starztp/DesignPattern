package com.tianyou.designpattern.Decorator.Login.v1;

/**
 * Created by tianyou on 2019/12/31.
 */
public class WechatSignDecorator extends ThirdPartySignDecorator {


    public WechatSignDecorator(ThirdPartySign thirdPartySign) {
        super(thirdPartySign);
    }

    @Override
    public String login(String openid) {
        return super.login(openid)+"微信登录";
    }
}
