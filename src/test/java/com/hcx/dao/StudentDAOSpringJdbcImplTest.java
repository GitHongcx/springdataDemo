package com.hcx.dao;

import com.hcx.domain.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by HCX on 2019/3/10.
 */
public class StudentDAOSpringJdbcImplTest {

    private ApplicationContext ctx = null;
    private StudentDAO studentDAO = null;

    @Before
    public void setup(){
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        studentDAO = (StudentDAO) ctx.getBean("studentDAO");
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        ctx = null;
        System.out.println("tearDown");
    }


    @Test
    public void testQuery() throws Exception {
        List<Student> students = studentDAO.query();

        for (Student student : students) {
            System.out.println("id:" + student.getId()
                    + " ,name:" + student.getName()
                    + " ,age:" + student.getAge());
        }

    }

    @Test
    public void testSave() throws Exception {
        Student student = new Student();
        student.setName("testSpringJDBC");
        student.setAge(80);
        studentDAO.save(student);

    }

    @Test
    public void testGetJdbcTemplate() throws Exception {

    }

    @Test
    public void testSetJdbcTemplate() throws Exception {

    }
}