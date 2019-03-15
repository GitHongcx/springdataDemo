package com.hcx.repository;

import com.hcx.domain.Employee;
import com.hcx.service.EmployeeService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by HCX on 2019/3/14.
 */
public class EmployeeCrudRepositoryTest {

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
    public void testSave() {

        List<Employee> employees = new ArrayList<Employee>();

        Employee employee = null;

        for (int i = 0; i < 100; i++) {
            employee = new Employee();
            employee.setName("test" + i);
            employee.setAge(100-i);
//          employee.setId(1);
            employees.add(employee);
        }

        employeeService.save(employees);

    }

}