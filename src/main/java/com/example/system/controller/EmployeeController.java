package com.example.system.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.system.main.Employee;
import com.example.system.service.EmployeeService;

@Controller
//http://localhost:8080/xxxからマッピングされる
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @GetMapping
    public String index(Model model) {
        List<Employee> employees = service.findAll();
        model.addAttribute("employees", employees);
        return "employees/index";
    }

    @GetMapping("new")
    public String newEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employees/new";
    }

    @GetMapping("{id}/edit")
//    URL上の値を取得することができる
    public String edit(@PathVariable Long id, Model model) {
        Employee employee = service.findOne(id);
        model.addAttribute("employee", employee);
        return "employees/edit";
    }

    @GetMapping("{id}")
    public String show(@PathVariable Long id, Model model) {
        Employee employee = service.findOne(id);
        model.addAttribute("employee", employee);
        return "employees/show";
    }

    @PostMapping
//    bodyの情報を取得
    public String create(@Valid @ModelAttribute Employee employee, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) return "employees/new";
        service.save(employee);
//    初期画面へ
        return "redirect:/employees";
    }

    @PutMapping("{id}")
    public String update(@PathVariable Long id, @Valid @ModelAttribute Employee employee,BindingResult bindingResult) {
        if(bindingResult.hasErrors()) return "employees/edit";
        employee.setId(id);
        service.save(employee);
        return "redirect:/employees";
    }

    @DeleteMapping("{id}")
    public String destroy(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/employees";
    }
}