/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.cs545.app;
import common.UtilityMessage;
import java.io.Serializable;
import java.util.Iterator;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import mum.cs545.model.PromotionEntity;
import mum.cs545.model.RegisterEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;



/**
 *
 * @author Imran
 */
@Named
@SessionScoped
public class PromotionBean implements Serializable {
    
    String message="";

   
    PromotionEntity promotion= new PromotionEntity();
    private static SessionFactory sessionFactory;
    private static Transaction tx;

    
     public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public PromotionEntity getPromotion() {
        return promotion;
    }

    public void setPromotion(PromotionEntity promotion) {
        this.promotion = promotion;
    }
    
    static {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        StandardServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        sessionFactory = config.buildSessionFactory(sr);
    }
    
    public String save() {

        System.out.print("inside save");
        promotion.setPromotionCode(UtilityMessage.generatePassword());
        promotion= new PromotionEntity(getPromotion().getName(),getPromotion().getPromotionCode(),getPromotion().getDescription(),getPromotion().getDiscount(), getPromotion().getStartDate(),getPromotion().getEndDate());
        Session session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.save(promotion);
        tx.commit();
        session.close();
     message="Promtion succesfully added";
        UtilityMessage.SendPromotions(getEmails(), promotion.getName(), promotion.getPromotionCode(), promotion.getDescription());
        
      
        return "AdminWelcome";
    }
    
   public String getEmails()
   {
       Session session = sessionFactory.openSession();
        tx = session.beginTransaction();
        String SQL_QUERY = "select emailAddress from RegisterEntity";
        Query query = session.createQuery(SQL_QUERY);
       
        String emailAddress="";
        tx.commit();
         for (Iterator it = query.iterate(); it.hasNext();) {
         //RegisterEntity row= (RegisterEntity) it.next();
         
         emailAddress+= it.next()+",";
         }
        session.close();
        
    return emailAddress.substring(0, emailAddress.length()-1);
   }
    
}
