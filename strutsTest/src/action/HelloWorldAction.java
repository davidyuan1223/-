package action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @Classname HelloWorldAction
 * @Description TODO
 * @Date 2020/11/2 14:30
 * @Created by Administrator
 */
public class HelloWorldAction extends ActionSupport {
    private String name;

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
}
