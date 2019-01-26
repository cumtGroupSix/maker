package cn.cumtmaker.maker.service;


import cn.cumtmaker.maker.model.User;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
    //用户注册方法
    int signUp(String username,String password);
    User getUserByUserName(String username);
    int getUserIdByRequest(HttpServletRequest request);
}
