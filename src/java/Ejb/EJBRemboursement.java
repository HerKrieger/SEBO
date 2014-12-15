/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb;

import interfaces.EJBRemboursementLocal;
import java.util.Date;
import javax.ejb.Stateless;
import metier.Remboursement;

/**
 *
 * @author sylvainbron
 */
@Stateless
public class EJBRemboursement implements EJBRemboursementLocal {
    
    Remboursement remboursement;
    
    public EJBRemboursement() {
        remboursement = new Remboursement();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Date getDate() {
        return remboursement.getDate();
    }

    @Override
    public void setDate(Date date) {
        remboursement.setDate(date);
    }

    @Override
    public void genererLettre() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void genererCheque() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
