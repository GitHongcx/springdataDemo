package com.hcx.service;

import com.hcx.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by HCX on 2019/3/13.
 */
public class EmployeeServiceTest {

    private ApplicationContext ctx = null;
    private EmployeeService employeeService = null;


    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("beans-jpa.xml");
        employeeService = ctx.getBean(EmployeeService.class);
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown");
    }


    @Test
    public void testUpdate() throws Exception {
        employeeService.update(1, 55);
    }
}