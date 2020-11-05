package test;

import bean.Employee;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * @Classname EmployeeTest2
 * @Description TODO
 * @Date 2020/10/16 22:34
 * @Created by Administrator
 */
public class EmployeeTest2 {
    private static SessionFactory factory;
    public static void main(String[] args) {
        factory=new Configuration().configure().buildSessionFactory();

        addEmployee("Zara","Ali",2000);
        addEmployee("Daisy","Das",5000);
        addEmployee("John","Paul",5000);
        addEmployee("Mohd","Yasee",3000);


        listEmployees();
        countEmployee();
        totalSalary();
    }

    private static void totalSalary() {
        Session session=factory.openSession();
        session.beginTransaction();
        Criteria cr=session.createCriteria(Employee.class);
        cr.setProjection(Projections.sum("salary"));
        List totalSalary=cr.list();
        System.out.println("Total Salary:"+totalSalary.get(0));
        session.getTransaction().commit();
        session.close();
    }

    private static void countEmployee() {
        Session session=factory.openSession();
        session.beginTransaction();
        Criteria cr=session.createCriteria(Employee.class);
        cr.setProjection(Projections.rowCount());
        List rowCount=cr.list();
        System.out.println("Total Count:"+rowCount.get(0));
        session.getTransaction().commit();
        session.close();
    }

    private static void listEmployees() {
        Session session=factory.openSession();
        session.beginTransaction();
        Criteria cr=session.createCriteria(Employee.class);
        cr.add(Restrictions.gt("salary",2000));
        List employees=cr.list();
        for (Object object : employees) {
            Employee employee= (Employee) object;
            System.out.print("FirstName:"+employee.getFirstName()+"   LastName: "+employee.getLastName()+"   salary: "+employee.getSalary());
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
