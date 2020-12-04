package com.offcn.shopping.dao.impl;

import com.offcn.shopping.bean.User;
import com.offcn.shopping.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by 金喆
 */

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insertUser(User user) {

        String sql = "insert into user (username , password , sex , name , email ,birthday ) values" +
                " (?,?,?,?,?,?)";

        int result = jdbcTemplate.update(sql , user.getUsername() , user.getPassword() ,
                user.getSex() , user.getName() , user.getEmail() , user.getBirthday());

        System.out.println("这个代码执行。。。。。。");
        return result;
    }

    public User findUserByUserNameAndPassword(String username, String password) {

        String sql = "select userid, username , password , sex , name , email , birthday from user where username = ? and password = ?";

        return jdbcTemplate.queryForObject(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {

                User user = new User();
                user.setUserId(rs.getInt("userid"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setSex(rs.getString("sex"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setBirthday(rs.getDate("birthday"));

                return user;
            }
        },username,password);
    }
}
