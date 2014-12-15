/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ejb;

import interfaces.EJBCommandeClientLocal;
import java.awt.Image;
import java.util.Date;
import javax.ejb.Stateless;
import metier.Commande;

/**
 *
 * @author bron
 */
@Stateless
public class EJBCommandeClient implements EJBCommandeClientLocal {
    
    private Commande commande;
    
    public EJBCommandeClient() {
        commande = new Commande();
    }
    
    public int getIdClient() {
        return commande.getIdClient();
    }

    public void setIdClient(int idClient) {
        commande.setIdClient(idClient);
    }

    public Date getDateCommande() {
        return commande.getDateCommande();
    }

    public void setDateCommande(Date dateCommande) {
        commande.setDateCommande(dateCommande);
    }

    public float getTotalCommande() {
        return commande.getTotalCommande();
    }

    public void setTotalCommande(float totalCommande) {
        commande.setTotalCommande(totalCommande);
    }

    public int getStatutCommande() {
        return commande.getStatutCommande();
    }

    public void setStatutCommande(int statutCommande) {
        commande.setStatutCommande(statutCommande);
    }

    public String getAccuseCommande() {
        return commande.getAccuseCommande();
    }

    public void setAccuseCommande(String urlAccuseCommande) {
        commande.setAccuseCommande(urlAccuseCommande);
    }

    public Date getDateRembCommande() {
        return commande.getDateRembCommande();
    }

    public void setDateRembCommande(Date dateRembCommande) {
        commande.setDateRembCommande(dateRembCommande);
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
