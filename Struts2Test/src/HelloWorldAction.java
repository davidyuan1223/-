/**
 * @Classname HelloWorldAction
 * @Description TODO
 * @Date 2020/10/30 20:01
 * @Created by Administrator
 */
public class HelloWorldAction {
    private String name;
    public String execute(){
        return "success";
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
