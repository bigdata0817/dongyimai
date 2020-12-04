package com.offcn.shopping.service.impl;

import com.offcn.shopping.bean.User;
import com.offcn.shopping.dao.UserDao;
import com.offcn.shopping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 金喆
 */

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao ;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean registerUser(User user) {

        int result = userDao.insertUser(user);
        if(1 == result)
        {
            return true ;
        }
        return false;
    }

    public User findUserByUserNameAndPassword(String username, String password) {

        try{
            return userDao.findUserByUserNameAndPassword(username , password);

        }catch (Exception e)
        {
            return null ;
        }
    }
}
