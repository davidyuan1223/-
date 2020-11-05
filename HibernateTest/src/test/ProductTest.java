package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import bean.ProductEntity;

/**
 * @Classname ProductTest
 * @Description TODO
 * @Date 2020/10/13 14:43
 * @Created by Administrator
 */
public class ProductTest {
    public static void main(String[] args) {
        SessionFactory sf=new Configuration().configure().buildSessionFactory();
        Session s=sf.openSession();
        s.beginTransaction();
        ProductEntity p=new ProductEntity();
        p.setName("iphone7");
        p.setPrice(7000.0);
        s.save(p);
        s.getTransaction().commit();
        s.close();
        sf.close();
    }
}
