package action;

import com.opensymphony.xwork2.ActionSupport;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @Classname Emailer
 * @Description TODO
 * @Date 2020/11/1 13:41
 * @Created by Administrator
 */
public class Emailer extends ActionSupport {
    private String from;
    private String password;
    private String to;
    private String subject;
    private String body;
    static Properties properties=new Properties();
    static {
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.scoketFactory.port","456");
        properties.put("mail.smtp.scoketFactory.class","javax.net.ssl.SSLScoketFactory");
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.port","456");
    }

    @Override
    public String execute() throws Exception {
        String ret=SUCCESS;
        try {
            Session session=Session.getDefaultInstance(properties,new Authenticator(){
                protected PasswordAuthentication
                getPasswordAuthentication(){
                    return new
                    PasswordAuthentication(from,password);
                }
            });
            Message message=new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(body);
            Transport.send(message);
        }catch (Exception e){
            ret=ERROR;
            e.printStackTrace();
        }
        return ret;

    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public static Properties getProperties() {
        return properties;
    }

    public static void setProperties(Properties properties) {
        Emailer.properties = properties;
    }
}
