package com.testweb.transaction.service;

import com.testweb.dao.UserDao;
import com.testweb.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Date;

/**
 * 手动编程式事务
 * Created by Administrator on 2017/5/24.
 */
@Service
public class TransUserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private TransactionTemplate transactionTemplate;

    public void insertUser(final User user){
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                userDao.insertUser(user);
                User user2 = new User();
                user2.setUserName("admin");
                user2.setCredits(0);
                user2.setLastVisit(new Date());
                user2.setLastIp("0.0.0.0");
                userDao.updateLoginInfo(user2);
            }
        });
    }
}
