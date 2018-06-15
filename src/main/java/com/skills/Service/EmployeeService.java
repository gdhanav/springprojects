package com.skills.Service;

import com.skills.model.Employee;

public interface EmployeeService {
    Employee save(Employee employee) throws Exception;
    Employee delete(Employee employee) throws Exception;
    Employee findById(long id) throws Exception;
}
