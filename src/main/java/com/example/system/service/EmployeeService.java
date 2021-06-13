package com.example.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.system.main.Employee;
import com.example.system.repository.EmployeeRepository;

@Service
public class EmployeeService {
//	newせず他クラスを呼び出せる
    @Autowired
    private EmployeeRepository repository;

    public List<Employee> findAll() {
        return repository.findAll();
    }

    public Employee findOne(Long id) {
        return repository.findById(id).orElse(null);
    }
    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}