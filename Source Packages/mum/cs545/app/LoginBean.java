/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.cs545.app;

import java.io.Serializable;
import java.util.Iterator;
import javax.enterprise.context.RequestScoped;
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
@RequestScoped
public class LoginBean implements Serializable {
//private RegisterEntity login = new RegisterEntity();
    private String userEmail;
    private String password;
    private String errorMessage;

    
    
    
    private static SessionFactory sessionFactory;
    private static Transaction tx;
    static {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        StandardServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        sessionFactory = config.buildSessionFactory(sr);
    }
    
    public String verifyPassword(){
       
        
        if(userEmail.equals("admin")&& password.equals("admin"))
            return "AdminWelcome";
        
        Session session = sessionFactory.openSession();
        tx = session.beginTransaction();
        String SQL_QUERY = "select id,emailAddress from  RegisterEntity where emailAddress ='"+userEmail +"' and password= '"+password+"'";
        Query query = session.createQuery(SQL_QUERY);
        
        tx.commit();
        
        if(query.list().size()==0)
        {
            errorMessage="Invalid user name and password ";
            return "login";
        }
        
        
        
           session.close();
         return "welcomeCustomer";
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
    
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
}
