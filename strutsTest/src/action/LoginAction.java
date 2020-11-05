package action;

import com.opensymphony.xwork2.ActionSupport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @Classname LoginAction
 * @Description TODO
 * @Date 2020/11/1 13:01
 * @Created by Administrator
 */
public class LoginAction extends ActionSupport {
    private String name;
    private String gender;
    private String qq;
    private int age;
    private String address;
    private String email;

    @Override
    public String execute() throws Exception {
        String ret=ERROR;
        Connection connection=null;
        try {
            String URL="jdbc:mysql://localhost/anli";
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection(URL,"root","123456");
            String sql="select * from user where name =?";
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setString(1,name);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                gender=rs.getString(3);
                age=rs.getInt(4);
                address=rs.getString(5);
                qq=rs.getString(6);
                email=rs.getString(7);
                ret=SUCCESS;
            }
        }catch (Exception e){
            ret=ERROR;
        }finally {
            if (connection != null) {
                connection.close();
            }
        }
        return ret;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
