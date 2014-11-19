/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.cs545.app;

import java.io.Serializable;
import java.util.Iterator;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import mum.cs545.model.RegisterEntity;
import net.sf.ehcache.hibernate.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author atan
 */
@Named
@SessionScoped
public class LoginBean implements Serializable {
//    private RegisterEntity login = new RegisterEntity();
    private String userEmail;
    private String password;
    private static SessionFactory sessionFactory;
    private static Transaction tx;
    static {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        StandardServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        sessionFactory = config.buildSessionFactory(sr);
    }
    
    public String verifyPassword(){
       
        Session session = sessionFactory.openSession();
        tx = session.beginTransaction();
        String SQL_QUERY = "from RegisterEntity";
        Query query = session.createQuery(SQL_QUERY);
       
        tx.commit();
        //session.close();
        String emailAddress="";
        String password="";
        for (Iterator it = query.iterate(); it.hasNext();) {
            RegisterEntity row= (RegisterEntity) it.next();
            emailAddress=row.getEmailAddress();
            password=row.getPassword();
            
        
        if(getUserEmail().equals(emailAddress)&& 
                getPassword().equals(password)){
            session.close();
            return "welcomeCustomer";
        }
        }
         session.close();
        return "index";    
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
