package action;

import bean.Environment;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @Classname SystemDetails
 * @Description TODO
 * @Date 2020/11/2 11:22
 * @Created by Administrator
 */
public class SystemDetails extends ActionSupport {
    private Environment environment = new Environment("Development");
    private String operatingSystem = "Windows XP SP3";

    public String execute() {
        return SUCCESS;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }
}
