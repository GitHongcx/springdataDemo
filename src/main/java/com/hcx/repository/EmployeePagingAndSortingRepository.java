package com.hcx.repository;

import com.hcx.domain.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by HCX on 2019/3/15.
 */
public interface EmployeePagingAndSortingRepository extends PagingAndSortingRepository<Employee,Integer>{
}
