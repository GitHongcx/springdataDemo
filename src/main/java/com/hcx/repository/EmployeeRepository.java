package com.hcx.repository;

import com.hcx.domain.Employee;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;

import java.util.List;


/**
 * Created by HCX on 2019/3/11.
 */
@RepositoryDefinition(domainClass = Employee.class,idClass = Integer.class)
public interface EmployeeRepository {// extends Repository<Employee,Integer>

    //Repository<Employee,Integer> 操作的实体类和主键

    /**
     * 根据名字查找员工
     * @param name  名字
     * @return
     */
    public Employee findByName(String name);

    /**
     * 根据名字和年龄来查询
     * @param name 名字以某个字符开头
     * @param age 年龄小于多少
     * @return
     */
    public List<Employee> findByNameStartingWithAndAgeLessThan(String name,Integer age);


    /**
     * 根据名字和年龄来查询
     * @param name 名字以某个字符结束
     * @param age
     * @return 年龄小于多少
     */
    public List<Employee> findByNameEndingWithAndAgeLessThan(String name,Integer age);

    /**
     * 根据名字和年龄来查询
     * @param names 名字在names集合中
     * @param age
     * @return
     */
    public List<Employee> findByNameInOrAgeLessThan(List<String> names,Integer age);


    /**
     * 根据名字和年龄来查询
     * @param names
     * @param age
     * @return
     */
    public List<Employee> findByNameInAndAgeLessThan(List<String> names,Integer age);


    /**
     * 查询员工表中id最大的数据
     * @return
     */
    @Query("select o from Employee o where id=(select max(id) from Employee t1)") //注意：此处Employee是类名
    public Employee getEmployeeByMaxId();


    /**
     * 根据名字和年龄查询 使用索引参数
     * @param name
     * @param age
     * @return
     */
    @Query("select o from Employee o where o.name=?1 and o.age=?2")
    public List<Employee> queryParams1(String name,Integer age);


    /**
     * 根据名字和年龄查询 使用命名参数
     * @param name
     * @param age
     * @return
     */
    @Query("select o from Employee o where o.name=:name and o.age=:age")
    public List<Employee> queryParams2(@Param("name") String name, @Param("age") Integer age);


    /**
     * 模糊查询 使用索引参数
     * @param name
     * @return
     */
    @Query("select o from Employee o where o.name like %?1%")
    public List<Employee> queryLike1(String name);


    /**
     * 模糊查询 使用命名参数
     * @param name
     * @return
     */
    @Query("select o from Employee o where o.name like %:name%")
    public List<Employee> queryLike2(@Param("name")String name);


    /**
     * 使用原生态的方式查询
     * @return
     */
    @Query(nativeQuery = true,value="select count(1) from employee") //原生态查询，使用表名
    public long getCount();


    /**
     * 通过id更新年龄
     * @param id
     * @param age
     */
    @Modifying
    @Query("update Employee o set o.age=:age where o.id=:id")
    public void update(@Param("id")Integer id,@Param("age")Integer age);


}
