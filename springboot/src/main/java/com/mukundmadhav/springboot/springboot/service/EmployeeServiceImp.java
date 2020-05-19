package com.mukundmadhav.springboot.springboot.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mukundmadhav.springboot.springboot.dao.EmployeeDAO;
import com.mukundmadhav.springboot.springboot.modal.Employee;
@Service//???
public class EmployeeServiceImp implements EmployeeService {
 
 @Autowired
 private EmployeeDAO employeeDao;
@Transactional//???
 @Override
 public List<Employee> get() {
  return employeeDao.get();
 }
@Transactional
 @Override
 public Employee get(int id) {
  return employeeDao.get(id);
 }
@Transactional
 @Override
 public void save(Employee employee) {  	
  System.out.println("EmployeeServiceImp.save<Employee employee> is called.");
  employeeDao.save(employee);
  
 }

@Transactional
@Override
public void insert(Employee employee) {  	
 System.out.println("EmployeeServiceImp.insert<Employee employee> is called.");
 employeeDao.insert(employee);
 
}

@Transactional
 @Override
 public void delete(int id) {
  employeeDao.delete(id);
  
 }
}