package com.skills.controller;

import com.skills.Service.EmployeeService;
import com.skills.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value="/add/employee")
    private Employee addEmployee(@RequestBody Employee employee) throws Exception {
        return employeeService.save(employee);
    }
    @GetMapping(value="/find/employee/{id}")
    private Employee findEmployee(@PathVariable long id) throws Exception {
        return employeeService.findById(id);
    }
    @DeleteMapping(value="/delete/employee")
    private Employee deleteEmployee(@RequestBody Employee employee) throws Exception {
        return employeeService.delete(employee);
    }
}
