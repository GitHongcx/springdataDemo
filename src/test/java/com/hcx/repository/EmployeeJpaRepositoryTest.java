package com.hcx.repository;

import com.hcx.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by HCX on 2019/3/15.
 */
public class EmployeeJpaRepositoryTest {

    private ApplicationContext ctx = null;
    private EmployeeJpaRepository employeeJpaRepository = null;

    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("beans-jpa.xml");
        employeeJpaRepository = ctx.getBean(EmployeeJpaRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void testFind(){
        Employee employee = employeeJpaRepository.findOne(99);
        System.out.println("employee:"+employee);
        System.out.println("employee(10):"+employeeJpaRepository.exists(10));
        System.out.println("employee(1000):"+employeeJpaRepository.exists(1000));
    }



}