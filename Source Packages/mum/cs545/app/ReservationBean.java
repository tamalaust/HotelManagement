/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.cs545.app;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;
import mum.cs545.model.PromotionEntity;
import mum.cs545.model.ReservationEntity;
import mum.cs545.model.RoomManagementEntity;
import org.hibernate.Hibernate;
import org.hibernate.Query;
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

public class ReservationBean implements Serializable {

    private ReservationEntity reservation = new ReservationEntity();
    private List<RoomManagementEntity> rooms;
    private List<RoomManagementEntity> selectedRooms;
    private String promoCode;
    private Long totalPrice= 0L;
    private static SessionFactory sessionFactory;
    private static Transaction tx;

  

    static {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        StandardServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        sessionFactory = config.buildSessionFactory(sr);
    }

    public ReservationEntity getReservation() {
        return reservation;
    }

    public void setReservation(ReservationEntity reservation) {
        this.reservation = reservation;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    

    public List<RoomManagementEntity> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomManagementEntity> rooms) {
        this.rooms = rooms;
    }

    public List<RoomManagementEntity> getSelectedRooms() {
        return selectedRooms;
    }

    public void setSelectedRooms(List<RoomManagementEntity> selectedRooms) {
        this.selectedRooms = selectedRooms;
    }

    public Long getTotalPrice() {
       
        for (RoomManagementEntity re :getSelectedRooms()) {
            totalPrice += re.getPrice();
        }
        return totalPrice;
    }
    public void validPromo()
    {
        List <PromotionEntity> promo;
        Session session = sessionFactory.openSession();
        tx = session.beginTransaction();
       
        promo = (List<PromotionEntity>) session.createQuery("from PromotionEntity P where P.promotionCode=:type")
                .setString("type",getPromoCode())
                .list();
        for(PromotionEntity pr: promo){
            if(pr.getPromotionCode().equals(getPromoCode()))
                  totalPrice = totalPrice -totalPrice*(pr.getDiscount()/100);
        }
        
        tx.commit();
        session.close();
        
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void updateTable(AjaxBehaviorEvent e) {
        rooms = new ArrayList();
        Session session = sessionFactory.openSession();
        tx = session.beginTransaction();
        String type = getReservation().getTypeRoom();
        rooms = (List<RoomManagementEntity>) session.createQuery("from RoomManagementEntity R where R.typeRoom=:type")
                .setString("type", type)
                .list();

//        String hql = "FROM RoomManagementEntity R WHERE R.typeRoom='Luxury'";
//        Query query = session.createQuery(hql);
//        for (Iterator it = query.iterate(); it.hasNext();) {
//
//            System.out.println((RoomManagementEntity)it.next());
//            rooms.add((RoomManagementEntity) it.next());
//
//        }
        tx.commit();

        //RoomManagementEntity r1= new RoomManagementEntity("101", "Luxary","asdasd",(long)122.00, true);
        // rooms.add(r1);
        session.close();

    }

    public String checkOut() {

        String redirect = "?faces-redirect=true";
        return "checkOut" + redirect;

    }

    public void saveReservation() {
        reservation = new ReservationEntity(getReservation().getStartDate(), getReservation().getEndDate());

        Session session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.save(reservation);
        for (RoomManagementEntity rs : rooms) {

            session.save(rs);

        }

        tx.commit();
        session.close();
    }

}
