package com.matc.entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Sebastian Greenholtz
 */
public class UserTest {

    private User user;

    @Before
    public void setUp() throws Exception {
        user = new User();
        user.setDOB("1994-03-13");
    }

    @Test
    public void getAge() throws Exception {
        Integer expected = 22;
        Integer result = user.getAge();
        Assert.assertEquals(expected, result);
    }

}