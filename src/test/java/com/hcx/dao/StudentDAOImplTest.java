package com.hcx.dao;

import com.hcx.domain.Student;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by HCX on 2019/3/10.
 */
public class StudentDAOImplTest {

    @Test
    public void testQuery() throws Exception {

        StudentDAO studentDAO = new StudentDAOImpl();
        List<Student> students = studentDAO.query();

        for (Student student : students) {
            System.out.println("id:" + student.getId()
                    + " ,name:" + student.getName()
                    + " ,age:" + student.getAge());
        }

    }

    @Test
    public void testSave(){
        StudentDAO studentDAO = new StudentDAOImpl();
        Student student = new Student();
        student.setName("test");
        student.setAge(60);
        studentDAO.save(student);
    }
}