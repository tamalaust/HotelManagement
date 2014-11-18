/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.cs545.app;

import common.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

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
   
   
    public RoomManagementEntity getRoom() {
        return room;
    }

    public void sendEmail()
    {
        Util.SendEmail();
    
    }
    
    public void setRoom(RoomManagementEntity room) {
        this.room = room;
    }
  
    public String save(){
       
        return null;
    
    }
    
    
}
