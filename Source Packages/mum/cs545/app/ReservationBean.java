/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.cs545.app;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import mum.cs545.model.ReservationEntity;

/**
 *
 * @author zahid
 */
@Named
@SessionScoped

public class ReservationBean implements Serializable{
    private ReservationEntity reservation = new ReservationEntity();
    
    
    
}
