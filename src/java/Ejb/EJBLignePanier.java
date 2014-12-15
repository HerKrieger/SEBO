/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb;

import interfaces.EJBLignePanierLocal;
import javax.ejb.Stateless;
import metier.LignePanier;

/**
 *
 * @author gruselle
 */
@Stateless
public class EJBLignePanier implements EJBLignePanierLocal 
{
    
    private LignePanier lignePan = new LignePanier();
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public int getQuantite() 
    {
        return lignePan.getQuantite();
    }

    @Override
    public float getSommeIntermediaire() 
    {
        return lignePan.getSommeIntermediaire();
    }

    @Override
    public float getPrixUnitaire() 
    {
        return lignePan.getPrixUnitaire();
    }

    @Override
    public void setPrixUnitaire(float prixUnitaire) 
    {
        lignePan.setPrixUnitaire(prixUnitaire);
    }
    
    
}
