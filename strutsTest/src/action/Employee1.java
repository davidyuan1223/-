package action;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.bcel.internal.generic.ACONST_NULL;
import org.apache.struts2.util.SubsetIteratorFilter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Employee1
 * @Description TODO
 * @Date 2020/11/2 14:41
 * @Created by Administrator
 */
public class Employee1 extends ActionSupport {
    private String name;
    private String department;
    private List employees;
    private List contractors;

    public Employee1(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public Employee1() {
    }

    public List getEmployees() {
        return employees;
    }

    public void setEmployees(List employees) {
        this.employees = employees;
    }

    public List getContractors() {
        return contractors;
    }

    public void setContractors(List contractors) {
        this.contractors = contractors;
    }

    @Override
    public String execute() throws Exception {
        employees=new ArrayList();
        employees.add(new Employee1("George","Recruitment"));
        employees.add(new Employee1("Danielle","Accounts"));
        employees.add(new Employee1("Melissa","Recruitment"));
        employees.add(new Employee1("Rose","Accounts"));
        contractors=new ArrayList();
        contractors.add(new Employee1("Mindy","Database"));
        contractors.add(new Employee1("Vanessa","Network"));
        return SUCCESS;
    }
    public SubsetIteratorFilter.Decider getRecruitmentDecider(){
        return new SubsetIteratorFilter.Decider() {
            @Override
            public boolean decide(Object o) throws Exception {
                Employee1 employee1= (Employee1) o;
                return employee1.getDepartment().equals("Recruitment");
            }
        };
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
