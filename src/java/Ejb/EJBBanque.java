/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb;

import interfaces.EJBBanqueLocal;
import javax.ejb.Stateless;
import metier.Adresse;
import metier.Banque;

/**
 *
 * @author gruselle
 */
@Stateless
public class EJBBanque implements EJBBanqueLocal 
{
    private Banque laBanque = new Banque();
    
    @Override
    public int getIdBanque() 
    {
        return laBanque.getIdBanque();
    }

    @Override
    public Adresse getAdresseBanque() 
    {
        return laBanque.getAdresseBanque();
    }
    
    @Override
    public void valider() 
    {
        laBanque.valider();
    }

}
