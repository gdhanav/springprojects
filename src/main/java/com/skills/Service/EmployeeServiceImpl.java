package com.skills.Service;

import com.skills.model.Employee;
import com.skills.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Employee save(Employee employee) throws Exception {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee delete(Employee employee) throws Exception {
        try{
            employeeRepository.delete(employee);
        }catch(Exception ex){
            System.out.println("Error when delete employee");
            ex.printStackTrace();
        }
        return employee;
    }

    @Override
    public Employee findById(long id) throws Exception {
        Optional<Employee> employee= employeeRepository.findById(id);
        employee.orElseThrow(()-> new Exception("Employee Not Found"));
        return employee.get();
    }
}
