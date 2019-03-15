package com.hcx.repository;

import com.hcx.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by HCX on 2019/3/11.
 */
public class EmployeeRepositoryTest {

    private ApplicationContext ctx = null;

    private EmployeeRepository employeeRepository = null;

    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("beans-jpa.xml");
        employeeRepository = ctx.getBean(EmployeeRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void testFindByName() throws Exception {
        Employee employee = employeeRepository.findByName("zhangsan");
        System.out.println("id:" + employee.getId() + " " +
                ",name:" + employee.getName()
                + " age:" + employee.getAge());
    }


    @Test
    public void testFindByNameStartingWithAndAgeLessThan() throws Exception {
        List<Employee> employees = employeeRepository.findByNameStartingWithAndAgeLessThan("test", 23);
        for (Employee employee : employees) {
            System.out.println("id:" + employee.getId() + " " +
                    ",name:" + employee.getName()
                    + " age:" + employee.getAge());
        }

    }

    @Test
    public void testFindByNameEndingWithAndAgeLessThan() throws Exception {
        List<Employee> employees = employeeRepository.findByNameEndingWithAndAgeLessThan("6", 60);
        for (Employee employee : employees) {
            System.out.println("id:" + employee.getId() + " " +
                    ",name:" + employee.getName()
                    + " age:" + employee.getAge());
        }

    }

    @Test
    public void testFindByNameInOrAgeLessThan() throws Exception {
        List<String> names = new ArrayList<String>();
        names.add("test1");
        names.add("test2");
        names.add("test3");
        List<Employee> employees = employeeRepository.findByNameInOrAgeLessThan(names, 22);
        for (Employee employee : employees) {
            System.out.println("id:" + employee.getId() + " " +
                    ",name:" + employee.getName()
                    + " age:" + employee.getAge());
        }

    }

    @Test
    public void testFindByNameInAndAgeLessThan() throws Exception {
        List<String> names = new ArrayList<String>();
        names.add("test1");
        names.add("test2");
        names.add("test3");
        List<Employee> employees = employeeRepository.findByNameInAndAgeLessThan(names, 22);
        for (Employee employee : employees) {
            System.out.println("id:" + employee.getId() + " " +
                    ",name:" + employee.getName()
                    + " age:" + employee.getAge());
        }

    }

    @Test
    public void testGetEmployeeByMaxId() throws Exception {

        Employee employee = employeeRepository.getEmployeeByMaxId();
        System.out.println("id:" + employee.getId() + " " +
                ",name:" + employee.getName()
                + " age:" + employee.getAge());

    }


    @Test
    public void testQueryParams1() throws Exception {

        List<Employee> employees = employeeRepository.queryParams1("zhangsan", 20);
        for (Employee employee : employees) {
            System.out.println("id:" + employee.getId() + " " +
                    ",name:" + employee.getName()
                    + " age:" + employee.getAge());

        }
    }

    @Test
    public void testQueryParams2() throws Exception {
        List<Employee> employees = employeeRepository.queryParams2("zhangsan", 20);
        for (Employee employee : employees) {
            System.out.println("id:" + employee.getId() + " " +
                    ",name:" + employee.getName()
                    + " age:" + employee.getAge());

        }
    }


    @Test
    public void testQueryLike1() throws Exception {
        List<Employee> employees = employeeRepository.queryLike1("test");
        for (Employee employee : employees) {
            System.out.println("id:" + employee.getId() + " " +
                    ",name:" + employee.getName()
                    + " age:" + employee.getAge());

        }
    }

    @Test
    public void testQueryLike2() throws Exception {
        List<Employee> employees = employeeRepository.queryLike2("test1");
        for (Employee employee : employees) {
            System.out.println("id:" + employee.getId() + " " +
                    ",name:" + employee.getName()
                    + " age:" + employee.getAge());

        }
    }

    @Test
    public void testGetCount() throws Exception {
        long count = employeeRepository.getCount();
        System.out.println("count:" + count);

    }

    @Test
    public void testUpdate() throws Exception {
        employeeRepository.update(1, 55);

    }

}