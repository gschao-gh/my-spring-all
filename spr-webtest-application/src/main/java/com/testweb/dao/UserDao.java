package com.testweb.dao;


import com.testweb.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/5/16.
 */
@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int getMatchCount(String name,String passwd){
        String sqlStr = "select count(*) from t_user where user_name=? and password=?";
        return jdbcTemplate.queryForObject(sqlStr,new Object[]{name,passwd},Integer.class);
    }

    public User findUserByUserName(final String name){
        String sqlStr = "Select user_id,user_name,credits from t_user where user_name=?";
        final  User user = new User();
        jdbcTemplate.query(sqlStr, new Object[]{name}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setUserId(resultSet.getInt("user_id"));
                user.setUserName(name);
                user.setCredits(resultSet.getInt("credits"));
            }
        });
        return user;
    }

    public void updateLoginInfo(User user){
        String sqlStr = "UPDATE t_user set last_visit =? ,last_ip=? ,credis=? where user_id=?";
        jdbcTemplate.update(sqlStr,new Object[]{user.getLastVisit(),user.getLastIp(),user.getCredits(),user.getUserId()});
    }


}
