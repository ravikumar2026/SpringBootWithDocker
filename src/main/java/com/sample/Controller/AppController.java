package com.sample.Controller;

import com.sample.Model.Company;
import com.sample.Model.Employee;
import com.sample.Repo.CompanyRepository;
import com.sample.Repo.EmployeeRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/appData")
public class AppController {

    @Autowired
    CompanyRepository companyRepo;

    @Autowired
    EmployeeRepository employeeRepo;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Object> testApp(){

        return new ResponseEntity("App Works", HttpStatus.OK);
    }

    @RequestMapping(value = "/createData", method = RequestMethod.POST)
    public ResponseEntity<Object> createData(@RequestBody String request){

        Company company = new Company(request);
        companyRepo.save(company);
        List<Employee> employeeList = new ArrayList<>();
        Employee employee;
        for(int i=0;i < 10;i++){
            employee = new Employee("Name"+i,company);
            employeeList.add(employee);
        }
        employeeRepo.save(employeeList);
        return new ResponseEntity<>("Data Created",HttpStatus.OK);
    }

    @RequestMapping(value = "/getCompData",method = RequestMethod.GET)
    public ResponseEntity<Object> getCompData(@RequestParam String companyName){
        Company company = companyRepo.findCompanyByName(companyName);
        return new ResponseEntity<>(company.toString(),HttpStatus.OK);
    }

    @RequestMapping(value = "/getEmpData",method = RequestMethod.GET)
    public ResponseEntity<Object> getEmpData(@RequestParam String companyName) throws Exception{

        Company company = companyRepo.findCompanyByName(companyName);
        JSONArray empArr = new JSONArray();
        int i = 0;
        for(Employee employee  : employeeRepo.findEmployeesByCompany(company)){
            empArr.put(i,new JSONObject().put("AutoId",employee.getAutoId())
                                    .put("name",employee.getName()));
            i++;
        }
        return new ResponseEntity<>(empArr.toString(),HttpStatus.OK);
    }

}

