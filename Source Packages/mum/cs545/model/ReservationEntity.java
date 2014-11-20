/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.cs545.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 *
 * @author zahid
 */
@Entity
public class ReservationEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String startDate;
    private String endDate;
    private String roomNumber;
  
    private String typeRoom;
    //private Long customerId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ReservationEntity(){
    }
    public ReservationEntity(String startDate, String endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public ReservationEntity(String startDate, String endDate,String roomNumber, String typeRoom) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.roomNumber = roomNumber;
        this.typeRoom = typeRoom;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }
    
    

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    


    public String getTypeRoom() {
        return typeRoom;
    }

    public void setTypeRoom(String typeRoom) {
        this.typeRoom = typeRoom;
    }
    
    @Override
    public String toString()
    {
       return typeRoom;
    }
 
}
