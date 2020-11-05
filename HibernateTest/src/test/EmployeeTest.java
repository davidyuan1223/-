package test;

import bean.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * @Classname EmployeeTest
 * @Description TODO
 * @Date 2020/10/15 20:39
 * @Created by Administrator
 */
public class EmployeeTest {
    private static SessionFactory factory;

    public static void main(String[] args) {
        factory=new Configuration().configure().buildSessionFactory();
        addEmployee("A","b",100);
        addEmployee("C","d",200);
        addEmployee("E","f",300);
        listEmployee();
        updateEmployee(5,500);
        deleteEmployee(7);
        listEmployee();
    }

    private static void deleteEmployee(int id) {
        Session session=factory.openSession();
        session.beginTransaction();
        Employee employee= (Employee) session.get(Employee.class,id);
        session.delete(employee);
        session.getTransaction().commit();
        session.close();
    }

    private static void updateEmployee(int id,int salary) {
        Session session=factory.openSession();
        session.beginTransaction();
        Employee employee= (Employee) session.get(Employee.class,id);
        employee.setSalary(salary);
        session.update(employee);
        session.getTransaction().commit();
        session.close();
    }

    private static void listEmployee() {
        Session session=factory.openSession();
        session.beginTransaction();
        List employees=session.createQuery("FROM Employee ").list();
        for (Object object : employees) {
            Employee employee= (Employee) object;
            System.out.print("FirstName: "+employee.getFirstName());
            System.out.print("LastName: "+employee.getLastName());
            System.out.print("salary: "+employee.getSalary());
            System.out.println();
        }
        session.getTransaction().commit();
        session.close();
    }

    private static void addEmployee(String firstName, String lastName, int salary) {
        Session session=factory.openSession();
        session.beginTransaction();
        Employee employee=new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setSalary(salary);
        session.save(employee);
        session.getTransaction().commit();
        session.close();
    }
}