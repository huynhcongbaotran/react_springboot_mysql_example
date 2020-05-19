package com.mukundmadhav.springboot.springboot.service;
import java.util.List;
import com.mukundmadhav.springboot.springboot.modal.Employee;
public interface EmployeeService {
List<Employee> get();
 
 Employee get(int id);
 
 void save(Employee employee);
 
 void insert(Employee employee);
 
 void delete(int id);
}