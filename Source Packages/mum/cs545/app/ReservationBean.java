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
import javax.inject.Named;
import mum.cs545.model.ReservationEntity;
import mum.cs545.model.RoomManagementEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author zahid
 */
@Named
@SessionScoped

public class ReservationBean implements Serializable {

    private ReservationEntity reservation = new ReservationEntity();
    private List<RoomManagementEntity> rooms;
    private static SessionFactory sessionFactory;
    private static Transaction tx;

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

    public List<RoomManagementEntity> updateTable() {
        rooms = new ArrayList();
        Session session = sessionFactory.openSession();
        tx = session.beginTransaction();
        String type = getReservation().getTypeRoom();
        String hql = "FROM RoomManagementEntity R WHERE R.typeRoom=" + type;
        Query query = session.createQuery(hql);
        for (Iterator it = query.iterate(); it.hasNext();) {

            rooms.add((RoomManagementEntity)it.next());
        }

        tx.commit();
        session.close();

        return rooms;

    }

}
