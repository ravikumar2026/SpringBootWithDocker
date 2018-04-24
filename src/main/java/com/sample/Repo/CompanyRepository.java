package com.sample.Repo;

import com.sample.Model.Company;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public interface CompanyRepository extends PagingAndSortingRepository<Company, Long> {

    Company findCompanyByName(@RequestParam String name);

}
