package com.mukundmadhav.springboot.springboot.dao;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mukundmadhav.springboot.springboot.modal.Employee;
@Repository //???
public class EmployeeDAOImp implements EmployeeDAO {
@Autowired
 private EntityManager entityManager;
@Override
 public List<Employee> get() {
  Session currSession = entityManager.unwrap(Session.class);
  Query<Employee> query = currSession.createQuery("from Employee", Employee.class);//Hibernate Query Language (HQL) 
  List<Employee> list = query.getResultList();
  return list;
}
@Override
 public Employee get(int id) {
  Session currSession = entityManager.unwrap(Session.class);
  Employee emp = currSession.get(Employee.class, id);
  return emp;
 }
@Override
 public void save(Employee employee) {
  System.out.println("EmployeeDAOImp.save<Employee employee>is called.");
  Session currSession = entityManager.unwrap(Session.class);
  currSession.saveOrUpdate(employee); //update only, no insert
  //currSession.save(employee); // for insert only
  System.out.println("EmployeeDAOImp.save<Employee employee>is called. Testing!");
}
@Override
 public void delete(int id) {
  Session currSession = entityManager.unwrap(Session.class);
  Employee emp = currSession.get(Employee.class, id);
  currSession.delete(emp);
}

@Override
public void insert(Employee employee) {
 System.out.println("EmployeeDAOImp.insert<Employee employee> is called.");
 Session currSession = entityManager.unwrap(Session.class);
 //currSession.saveOrUpdate(employee); //update only, no insert
 currSession.save(employee); // for insert only
 System.out.println("EmployeeDAOImp.insert<Employee employee>is called. Testing!");
}

}