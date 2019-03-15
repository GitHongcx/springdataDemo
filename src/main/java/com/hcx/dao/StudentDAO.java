package com.hcx.dao;

import com.hcx.domain.Student;

import java.util.List;

/**
 * StudentDAO访问接口
 * Created by HCX on 2019/3/10.
 */
public interface StudentDAO {

    /**
     * 查询所有学生
     * @return  所有学生
     */
    public List<Student> query();

    /**
     * 添加一个学生
     * @param student 待添加的学生
     */
    public void save(Student student);


}
