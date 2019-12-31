package com.tianyou.designpattern.Decorator.Login.v1;

/**
 * Created by tianyou on 2019/12/31.
 */
public class ThirdPartySignDecorator extends ThirdPartySign {

    private ThirdPartySign thirdPartySign;

    public ThirdPartySignDecorator(ThirdPartySign thirdPartySign){
        this.thirdPartySign=thirdPartySign;
    }

    @Override
    public String login(String openid) {
        return this.thirdPartySign.login(openid);
    }
}
