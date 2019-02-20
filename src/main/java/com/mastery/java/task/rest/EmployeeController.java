package com.mastery.java.task.rest;

import java.util.List;

import com.mastery.java.task.dao.EmployeeDAO;
import com.mastery.java.task.dto.Employee;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDAO;

    @RequestMapping("/")
    @ResponseBody
    public String welcome() {
        System.out.println("Welcome");
        return "Welcome to RestTemplate Example.";
    }

    @RequestMapping("/init")
    @ResponseBody
    public String init() {
        employeeDAO.firstInit();
        return "Data loaded...";
    }

    // URL:
    // http://localhost:8080/employees
    // Read ALL
    @RequestMapping
            (value = "/employees",
                    method = RequestMethod.GET
            )
    @ResponseBody
    public List<Employee> getEmployees() {
        return employeeDAO.findAll();
    }

    // URL:
    // http://localhost:8080/employees/2
    // Read ONE
    @RequestMapping
            (value = "/employees/{empNo}", //
                    method = RequestMethod.GET
            )
    @ResponseBody
    public Employee getEmployee(@PathVariable("empNo") String empNo) {
        return employeeDAO.findById(Long.valueOf(empNo));
    }

    // URL:
    // http://localhost:8080/employees
    // Delete ALL
    @RequestMapping
            (value = "/employees",
                    method = RequestMethod.DELETE
            )
    @ResponseBody
    public void deleteAllEmployees() {
        employeeDAO.deleteAll();
    }

    // URL:
    // http://localhost:8080/employees/2
    // Delete ONE
    @RequestMapping
            (value = "/employees/{empNo}",
                    method = RequestMethod.DELETE
            )
    @ResponseBody
    public void deleteEmployee(@PathVariable("empNo") String empNo) {
        employeeDAO.deleteById(Long.valueOf(empNo));
    }

    // URL:
    // http://localhost:8080/employees
    // Create ONE
    @RequestMapping
            (value = "/employees",
                    method = RequestMethod.POST
            )
    @ResponseBody
    public Employee addEmployee(@RequestBody Employee emp) {
        return employeeDAO.createEmployee(emp);
    }

    // URL:
    // http://localhost:8080/employees/2
    // Update ONE
    @RequestMapping
            (value = "/employees/{empNo}", //
                    method = RequestMethod.PUT
                    )
    @ResponseBody
    public Employee updateEmployee(@PathVariable("empNo") String empNo,@RequestBody Employee emp) {
        return employeeDAO.updateEmployee(Long.valueOf(empNo), emp);
    }

}
