package com.testweb.transaction.ann;

import com.testweb.dao.LoginLogDao;
import com.testweb.dao.UserDao;
import com.testweb.domain.LoginLog;
import com.testweb.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * 使用注解声明方式事务
 * Created by Administrator on 2017/5/30.
 */
@Service
@Transactional(rollbackFor = {Exception.class})
public class AnnTransactionUserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private LoginLogDao loginLogDao;

    @Transactional("topic")
    public int loginSuccess() throws Exception{
        User annUser = new User();
        annUser.setUserId(4);
        annUser.setLastIp("0.0.0.1");
        annUser.setLastVisit(new Date());
        annUser.setCredits(5+annUser.getCredits());
        System.out.println(annUser);
        LoginLog annLoginLog = new LoginLog();
        annLoginLog.setUserId(annUser.getUserId());
        annLoginLog.setIp(annUser.getLastIp());
        annLoginLog.setLoginDate(annUser.getLastVisit());
        userDao.updateLoginInfo(annUser);
        if(true){
//            throw new Exception("testExcepion");
        }
        int result = loginLogDao.insertLoginLog(annLoginLog);

        return  result;

    }

}
