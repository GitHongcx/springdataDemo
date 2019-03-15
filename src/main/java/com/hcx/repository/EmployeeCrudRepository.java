package com.hcx.repository;

import com.hcx.domain.Employee;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by HCX on 2019/3/14.
 */
public interface EmployeeCrudRepository extends CrudRepository<Employee,Integer>{
}
