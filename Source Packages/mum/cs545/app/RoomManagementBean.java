/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.cs545.app;

import common.Util;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import mum.cs545.model.RoomManagementEntity;
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
public class RoomManagementBean implements Serializable {
    private RoomManagementEntity room = new RoomManagementEntity();
    private static SessionFactory sessionFactory;
    private static Transaction tx;
    
    static {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        StandardServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        sessionFactory = config.buildSessionFactory(sr);
    }
   
   
    public RoomManagementEntity getRoom() {
        return room;
    }

   
    
    public void setRoom(RoomManagementEntity room) {
        this.room = room;
    }
  
    public String save(){
       
        System.out.print("inside save");
        room.setStatus(true);
        room = new RoomManagementEntity(getRoom().getRoomNumber(),getRoom().getTypeRoom(), getRoom().getDescription(),
                getRoom().getPrice(),getRoom().isStatus()); 
        Session session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.save(room);
        tx.commit();
        session.close();
        return "index";    
    }
    
    
}
