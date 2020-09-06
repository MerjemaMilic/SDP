package com.example.seniordesignproject.Model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RateTest {

    private Rate rate;

    @Before
    public void setUp() throws Exception {
        rate = new Rate();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void createReviewTest() throws Exception {
        rate.setUser_id("Test ID");
        rate.setRate_id("Test rate ID");
        rate.setContent("Content");
        rate.setNeighborhood("Test neigbhorhood");

        assertEquals(rate.getUser_id(),"Test ID");
        assertEquals(rate.getNeighborhood(),"Test neigbhorhood");
        assertEquals(rate.getRate_id(),"Test rate ID");
        assertEquals(rate.getContent(),"Content");

    }

}

