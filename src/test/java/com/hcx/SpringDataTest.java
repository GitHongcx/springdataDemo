package com.hcx;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by HCX on 2019/3/11.
 */
public class SpringDataTest {

    private ApplicationContext ctx = null;

    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("beans-jpa.xml");
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void testEntityManagerFactory(){

    }


}
