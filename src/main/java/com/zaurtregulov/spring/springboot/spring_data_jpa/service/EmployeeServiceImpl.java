package com.zaurtregulov.spring.springboot.spring_data_jpa.service;

import com.zaurtregulov.spring.springboot.spring_data_jpa.dao.EmployeeRepository;
import com.zaurtregulov.spring.springboot.spring_data_jpa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        Employee emp = null;
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if(optionalEmployee.isPresent()) {
            emp = optionalEmployee.get();
        }
        return emp;
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findAllByName(String name) {
        List<Employee> employees = employeeRepository.findAllByName(name);
        return employees;
    }
}
