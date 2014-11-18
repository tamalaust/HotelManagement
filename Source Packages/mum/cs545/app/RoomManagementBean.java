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
import mum.cs545.db.RoomManagementFacade;
import mum.cs545.model.RegisterEntity;
import mum.cs545.model.RoomManagementEntity;


/**
 *
 * @author zahid
 */
@Named
@SessionScoped
public class RoomManagementBean implements Serializable {
    private RoomManagementEntity room = new RoomManagementEntity();
     @EJB //this annotation causes the container to inject this dependency
    private RoomManagementFacade ejbRoom;

    public RoomManagementEntity getRoom() {
        return room;
    }

    public void setRoom(RoomManagementEntity room) {
        this.room = room;
    }
  
    public String save(){
        System.out.print("inside save");
        room = new RoomManagementEntity(getRoom().getRoomNumber(),getRoom().getTypeRoom(), getRoom().getDescription(),
                getRoom().getPrice(),true);      
        try {

            ejbRoom.create(room);
        } catch (Exception e) {
            System.out.print("Error msg " + e);
        }
        System.out.print("inside save");
        
        return "index";
    
    }
}
