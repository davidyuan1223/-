package action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @Classname EmployeeAction
 * @Description TODO
 * @Date 2020/11/1 17:03
 * @Created by Administrator
 */
public class EmployeeAction extends ActionSupport {
    private String name;
    private int age;

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
    public void validate(){
        if (name==null||name.trim().equals("")){
            addFieldError("name","The name is required");
        }
        if (age<28||age>65){
            addFieldError("age","age must be in between 28 and 65");
        }
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
