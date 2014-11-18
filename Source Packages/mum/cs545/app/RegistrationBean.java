/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.cs545.app;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import mum.cs545.model.RegisterEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author zahid
 */
@Named
@SessionScoped
public class RegistrationBean implements Serializable {

    RegisterEntity register = new RegisterEntity();
    private static SessionFactory sessionFactory;
    private static Transaction tx;

    static {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        StandardServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        sessionFactory = config.buildSessionFactory(sr);
    }

    public RegisterEntity getRegister() {
        return register;
    }

    public void setRegister(RegisterEntity register) {
        this.register = register;
    }

    public String save() {

        System.out.print("inside save");
        register = new RegisterEntity(getRegister().getFirstName(), getRegister().getLastName(), getRegister().getEmailAddress(),
                getRegister().getAge(), getRegister().getContactNumber(), getRegister().getHomeAddress(), getRegister().getZip(),
                getRegister().getState());

        Session session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.save(register);
        tx.commit();
        session.close();

        return "index";
    }

}