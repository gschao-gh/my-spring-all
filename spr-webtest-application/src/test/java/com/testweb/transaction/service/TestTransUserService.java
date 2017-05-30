package com.testweb.transaction.service;

import com.testweb.domain.User;
import com.testweb.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by Administrator on 2017/5/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class TestTransUserService {

    @Autowired
    private TransUserService transUserService;
    @Autowired
    private UserService userService;

    @Test
    public void transTest(){
        User user = new User();
        user.setUserName("zhangs");
        user.setPassword("123qwe");
        user.setCredits(0);
        transUserService.insertUser(user);
        User user2 = userService.findUserByUserName("zhangs");
        assertEquals(user2.getUserName(),"zhangs");
    }
}
