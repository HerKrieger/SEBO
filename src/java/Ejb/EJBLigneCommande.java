/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb;

import interfaces.EJBLigneCommandeLocal;
import javax.ejb.Stateless;
import metier.LigneCommande;

/**
 *
 * @author sylvainbron
 */
@Stateless
public class EJBLigneCommande implements EJBLigneCommandeLocal {
    
    private LigneCommande ligne;



    @Override
    public float getSstotal() {
        return ligne.getSstotal();
    }

    @Override
    public void setSstotal(float sstotal) {
        ligne.setSstotal(sstotal);
    }

    @Override
    public boolean isIsARembourser() {
        return ligne.isIsARembourser();
    }

    @Override
    public void setIsARembourser(boolean isARembourser) {
        ligne.setIsARembourser(isARembourser);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public int getQuantiteCommande() {
        return ligne.getQuantiteCommande();
    }

    @Override
    public void setQuantiteCommande(int quantiteCommande) {
        ligne.setQuantiteCommande(quantiteCommande);
    }

    @Override
    public int getQuantiteLivree() {
        return ligne.getQuantiteLivree();
    }

    @Override
    public void setQuantiteLivree(int quantiteLivree) {
        ligne.setQuantiteLivree(quantiteLivree);
    }
}
