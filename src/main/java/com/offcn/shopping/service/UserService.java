package com.offcn.shopping.service;

import com.offcn.shopping.bean.User;

/**
 * Created by 金喆
 */
public interface UserService {

    public boolean registerUser(User user);

    public User findUserByUserNameAndPassword(String username, String password);
}
