package com.hcx.service;

import com.hcx.domain.Employee;
import com.hcx.repository.EmployeeCrudRepository;
import com.hcx.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by HCX on 2019/3/13.
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeCrudRepository employeeCrudRepository;

    @Transactional
    public void update(Integer id,Integer age){
        employeeRepository.update(id,age);
    }

    @Transactional
    public void save(List<Employee> employees){
        employeeCrudRepository.save(employees);
    }

    @Transactional
    public void save(Employee employee){
        employeeCrudRepository.save(employee);
    }

}
