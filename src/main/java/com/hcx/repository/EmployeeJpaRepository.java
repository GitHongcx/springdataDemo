package com.hcx.repository;

import com.hcx.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by HCX on 2019/3/15.
 */
public interface EmployeeJpaRepository extends JpaRepository<Employee,Integer>{
}
