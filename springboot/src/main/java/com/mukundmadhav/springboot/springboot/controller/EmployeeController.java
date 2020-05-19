/*
 * https://medium.com/@mukundmadhav/build-and-deploy-react-app-with-spring-boot-and-mysql-6f888eb0c600
 */
package com.mukundmadhav.springboot.springboot.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mukundmadhav.springboot.springboot.service.EmployeeService;
import com.mukundmadhav.springboot.springboot.modal.Employee;
@RestController//???
@RequestMapping("/api")
public class EmployeeController {
 
 @Autowired
 private EmployeeService employeeService;
 
 //http://localhost:8080/api/employee
 @GetMapping("/employee")
 public List<Employee> get() {
  System.out.println("EmployeeController.List<Employee> get() is called with @GetMapping.");
  return employeeService.get();
 }
 
 //http://localhost:8080/api/employee for @PostMapping, update only, not insert a Employee record 
 @PostMapping("/employee")
 public Employee save(@RequestBody Employee employee) {
  System.out.println("EmployeeController.List<Employee> get() is called with @PostMapping.");	 
  employeeService.save(employee);
  return employee;
 }
 
 //http://localhost:8080/api/employee/3
 @GetMapping("/employee/{id}")
 public Employee get(@PathVariable int id) {
  return employeeService.get(id);
 }
 
 //http://localhost:8080/api/employee/3 for @DeleteMapping 
 //{id} must be existed in the database
 @DeleteMapping("/employee/{id}")
 public String delete(@PathVariable int id) {
  
  employeeService.delete(id);
  
  return "Employee removed with id "+id;
  
 }
 
 //http://localhost:8080/api/employee/
 //udpate only
  /*
 //@RequestBody
    {
        "id": 11,
        "name": "dd",
        "department": "aa",
        "dob": "1998-04-01",
        "gender": "aa"
    }
 */
 @PutMapping("/employee")
 public Employee update(@RequestBody Employee employee) {
  System.out.println("EmployeeController.update() is called with @PutMapping.");
  employeeService.save(employee); 
  return employee;
 }
 
 //http://localhost:8080/api/insert_employee/
 /*
 //@RequestBody
    {
        "id": 11,
        "name": "dd",
        "department": "aa",
        "dob": "1998-04-01",
        "gender": "aa"
    }
 */
 @PutMapping("/insert_employee")
 public Employee insert_employee(@RequestBody Employee employee) {
  System.out.println("EmployeeController.insert_employee() is called with @PutMapping.");
  employeeService.insert(employee);
  return employee;
 }

}