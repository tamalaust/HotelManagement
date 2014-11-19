/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.cs545.app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;
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
    private static SessionFactory sessionFactory = null;
    private static Transaction tx = null;

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

    public List<RoomManagementEntity> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomManagementEntity> rooms) {
        this.rooms = rooms;
    }

    public void updateTable() {
        rooms = new ArrayList();
        Session session = sessionFactory.openSession();
        tx = session.beginTransaction();
        String type = getReservation().getTypeRoom();
        String hql = "FROM RoomManagementEntity R WHERE R.typeRoom='Luxury'";
        Query query = session.createQuery(hql);
        for (Iterator it = query.iterate(); it.hasNext();) {

           // System.out.println(((RoomManagementEntity)it.next()).getRoomNumber());
            rooms.add((RoomManagementEntity) it.next());

        }

        tx.commit();
        session.close();

    }

}
