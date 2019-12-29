package com.tianyou.designpattern.Adapter.LoginExample.V1;

import com.tianyou.designpattern.Adapter.LoginExample.SignService;
import com.tianyou.designpattern.ResultMesg;

/**
 * 第三方登录
 * 之所以继承，是为了将第三方登录的参数封装成原来老代码的登录参数，再回调老代码，从而打到兼容的目的
 */
public class SignforThirdParty extends SignService {

    /**
     * 使用QQ登录
     * @param QQopenId 可以将openID看成username
     * @return
     */
    public ResultMesg LoginforQQ(String QQopenId){
        System.out.println("QQ登录:"+QQopenId);
        return RegistAndLogin(QQopenId,null);
    }

    private ResultMesg RegistAndLogin(String username,String password){
        super.Regist(username,password);
        return super.Signin(username,password);
    }
}
