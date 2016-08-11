package com.daoTests;

import com.AbstractTest;
import app.common.dao.UserDao;
import app.common.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * Created by user on 08.08.2016.
 */


@Transactional

public class UserDaoTest extends AbstractTest {


    @Autowired
    private UserDao userDao;

    @Test
    public void testFindAll() {

        List<User> list = userDao.findAll();
//        User user= userDao.f

        Assert.assertNotNull("failure - expected not null", list);
        assertEquals("failure - expected list size", 4, list.size());

    }


    @Test
    public void testFindbyLogin() {

        User user= userDao.findByLogin("asd");

        Assert.assertNotNull("failure - expected not null", user);
        assertThat(user.getLogin()).isEqualTo("asd");
        assertThat(user.getPassword()).isEqualTo("asd");

    }


}
