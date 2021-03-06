/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.cs545.db;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mum.cs545.model.RegisterEntity;

/**
 *
 * @author atan
 */
@Stateless
public class RegisterEntityFacade extends AbstractFacade<RegisterEntity> {
    @PersistenceContext(unitName = "HotalManagementPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RegisterEntityFacade() {
        super(RegisterEntity.class);
    }
    
}
