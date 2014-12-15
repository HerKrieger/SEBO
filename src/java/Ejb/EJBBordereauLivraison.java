/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb;

import interfaces.EJBBordereauLivraisonLocal;
import javax.ejb.Stateless;
import metier.BordereauLivraison;

/**
 *
 * @author sylvainbron
 */
@Stateless
public class EJBBordereauLivraison implements EJBBordereauLivraisonLocal {
    private BordereauLivraison bordereau;
    
    public EJBBordereauLivraison() {
        bordereau = new BordereauLivraison();
    } 
    
    @Override
    public String getContenu() {
        return bordereau.getContenu();
    }

    @Override
    public void setContenu(String contenu) {
        bordereau.setContenu(contenu);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void remplirContenu() {
       
    }
}
