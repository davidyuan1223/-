package action;

import bean.Environment;
import org.apache.struts2.util.StrutsTypeConverter;

import java.util.Map;

/**
 * @Classname EnvironmentConverter
 * @Description TODO
 * @Date 2020/11/2 14:12
 * @Created by Administrator
 */
public class EnvironmentConverter extends StrutsTypeConverter {
    @Override
    public Object convertFromString(Map map, String[] strings, Class aClass) {
        return new Environment(strings[0]);
    }

    @Override
    public String convertToString(Map map, Object o) {
        Environment environment= (Environment) o;
        return environment==null?null:environment.getName();
    }
}
