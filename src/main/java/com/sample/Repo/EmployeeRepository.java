package com.sample.Repo;

import com.sample.Model.Company;
import com.sample.Model.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

    List<Employee> findEmployeesByCompany(@RequestParam Company company);
}
