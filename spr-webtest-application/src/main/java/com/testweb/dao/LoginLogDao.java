package com.testweb.dao;

import com.testweb.domain.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/5/19.
 */
@Repository
public class LoginLogDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int insertLoginLog(LoginLog loginLog){
        String strSql= "insert into t_login_log(user_id,ip,login_datetime) values (?,?,?)";
        Object[] orgs = {loginLog.getUserId(),loginLog.getIp(),loginLog.getLoginDate()};
        return jdbcTemplate.update(strSql,orgs);
    }



}
