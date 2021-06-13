package com.example.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.system.main.Employee;

//JpaRepositoryを継承したinterfaceを作成することでテーブル操作をする
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}