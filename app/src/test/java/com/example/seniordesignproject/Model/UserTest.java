package com.example.seniordesignproject.Model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    private User user;

    @Before
    public void setUp() throws Exception {
        user = new User();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void createUserTest() throws Exception {
     user.setName("Test");
     user.setAddress("Test Address");
     assertEquals(user.getName(), "Test");

    }


}