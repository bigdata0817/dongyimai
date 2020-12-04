package com.offcn.shopping.dao;

import com.offcn.shopping.bean.User;

/**
 * Created by 金喆
 */
public interface UserDao {

    public int insertUser(User user);

    public User findUserByUserNameAndPassword(String username, String password);

}
