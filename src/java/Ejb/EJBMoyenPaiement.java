/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb;

import interfaces.EJBMoyenPaiementLocal;
import javax.ejb.Stateless;
import metier.MoyenPaiement;

/**
 *
 * @author gruselle
 */
@Stateless
public class EJBMoyenPaiement implements EJBMoyenPaiementLocal 
{
    private MoyenPaiement moyenPaie = new MoyenPaiement();

    @Override
    public String getTypeCB() 
    {
        return moyenPaie.getTypeCB();
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
