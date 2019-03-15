package com.hcx.domain;

import javax.persistence.*;

/**
 * 雇员:开发实体类，通过实体类自动生成数据表
 * Created by HCX on 2019/3/11.
 */
@Entity
@Table(name = "test_employee") //指定表名 不存在会自动创建
public class Employee {

    private Integer id;

    private String name;

    private Integer age;

    @Id  //主键
    @GeneratedValue //自增
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(length = 20) //设置该字段的长度
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
