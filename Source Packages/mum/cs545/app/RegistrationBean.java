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
import mum.cs545.db.RegisterEntityFacade;
import mum.cs545.model.RegisterEntity;

/**
 *
 * @author zahid
 */
@Named
@SessionScoped
public class RegistrationBean implements Serializable {

    RegisterEntity register=  new RegisterEntity();
    @EJB //this annotation causes the container to inject this dependency
    private RegisterEntityFacade ejbRegister;

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

                
        
        try {

            ejbRegister.create(register);
        } catch (Exception e) {
            System.out.print("Error msg " + e);
        }
        System.out.print("inside save");
        
        return "index";
    }

}
