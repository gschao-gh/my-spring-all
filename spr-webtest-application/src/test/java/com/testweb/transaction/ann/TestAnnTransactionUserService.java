package com.testweb.transaction.ann;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * 测试注解声明式事务
 * Created by Administrator on 2017/5/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class TestAnnTransactionUserService {
    @Autowired
    private AnnTransactionUserService annTransactionUserService;

    @Test
    public void testLoginSuccess(){
        try {
           int result = annTransactionUserService.loginSuccess();
            System.out.println("result:"+result);
            assertTrue(1==result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
