package action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @Classname Employee
 * @Description TODO
 * @Date 2020/11/2 10:56
 * @Created by Administrator
 */
public class Employee extends ActionSupport {
    private String name;
    private int age;

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
