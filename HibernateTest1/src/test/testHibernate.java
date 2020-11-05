package test;

import bean.ProductEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @Classname testHibernate
 * @Description TODO
 * @Date 2020/10/15 18:34
 * @Created by Administrator
 */
public class testHibernate {
    public static void main(String[] args) {
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        ProductEntity productEntity=new ProductEntity();
        productEntity.setName("test");
        productEntity.setPrice(8000.0);
        session.save(productEntity);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
