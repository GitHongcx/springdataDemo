package com.hcx.repository;

import com.hcx.domain.Employee;
import com.hcx.service.EmployeeService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

import static org.junit.Assert.*;

/**
 * Created by HCX on 2019/3/15.
 */
public class EmployeeJpaSpecificationExecutorRepositoryTest {

    private ApplicationContext ctx = null;
    private EmployeeJpaSpecificationExecutorRepository employeeJpaSpecificationExecutorRepository = null;

    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("beans-jpa.xml");
        employeeJpaSpecificationExecutorRepository = ctx.getBean(EmployeeJpaSpecificationExecutorRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void testQuery() {
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "id");
        Sort sort = new Sort(order);

        Pageable pageable = new PageRequest(0, 5, sort);

        Specification<Employee> specification = new Specification<Employee>() {

            /**
             *
             * @param root 要查询的条件（Employee）
             * @param criteriaQuery  添加查询条件
             * @param criteriaBuilder 构建Predicate
             * @return
             */
            @Override
            public Predicate toPredicate(Root<Employee> root,
                                         CriteriaQuery<?> criteriaQuery,
                                         CriteriaBuilder criteriaBuilder) {
                //root(employee(age))
                Path path = root.get("age");
                Predicate predicate = criteriaBuilder.gt(path, 50);
                return predicate;
            }
        };

        Page<Employee> page = employeeJpaSpecificationExecutorRepository.findAll(specification,pageable);

        System.out.println("查询的总页数：" + page.getTotalPages());
        System.out.println("查询的总记录数" + page.getTotalElements());
        System.out.println("当前第几页" + page.getNumber());
        System.out.println("当前页面的集合" + page.getContent());
        System.out.println("当前页面的记录数" + page.getNumberOfElements());
    }


}