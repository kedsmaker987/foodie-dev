package com.kejian.service;

public interface UserService {

    /**
     * 判断用户名是否存在
     */
    public boolean queryUserNameIsExist(String userName);
}
