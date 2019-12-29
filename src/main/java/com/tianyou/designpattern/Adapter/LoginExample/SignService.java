package com.tianyou.designpattern.Adapter.LoginExample;

import com.tianyou.designpattern.ResultMesg;

/**
 * 老系统登录注册
 */
public class SignService {

    /**
     * 老系统注册
     * @param username
     * @param password
     * @return
     */
    public ResultMesg Regist(String username,String password){
        return new ResultMesg(200,"注册成功","");
    }

    /**
     * 老系统登录
     * @param username
     * @param password
     * @return
     */
    public ResultMesg Signin(String username,String password){
        return new ResultMesg(200,"登录成功","");
    }
}
