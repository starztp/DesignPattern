package com.tianyou.designpattern.Adapter.LoginExample.V2;

import com.tianyou.designpattern.ResultMesg;

/**
 * 所有第三方渠道登录,其实没有必要加这个接口，只是为了代码规范
 */
public interface ThirdPartyLogin {

    ResultMesg QQLogin(String id);

    ResultMesg WechatLoagin(String id);
}
