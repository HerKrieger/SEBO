/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb;

import interfaces.EJBAccuseReceptionLocal;
import java.util.Date;
import javax.ejb.Stateless;
import metier.AccuseReception;

/**
 *
 * @author sylvainbron
 */
@Stateless
public class EJBAccuseReception implements EJBAccuseReceptionLocal {
    
    private AccuseReception accuse;
    
    public EJBAccuseReception() {
        accuse = new AccuseReception();
    }
    
    @Override
    public Date getDateReception() {
        return accuse.getDateReception();
    }

    @Override
    public void setDateReception(Date dateReception) {
        accuse.setDateReception(dateReception);
    }

}
