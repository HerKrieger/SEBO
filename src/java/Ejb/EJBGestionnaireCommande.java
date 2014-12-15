/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb;

import interfaces.EJBGestionnaireCommandeLocal;
import javax.ejb.Stateless;
import metier.Article;
import metier.Commande;
import metier.GestionnaireCommande;
import metier.Retour;

/**
 *
 * @author Frontoni
 */
@Stateless
public class                EJBGestionnaireCommande implements EJBGestionnaireCommandeLocal
{
    GestionnaireCommande    commande;
    
    public  EJBGestionnaireCommande()
    {
        commande = new GestionnaireCommande();
    }

    @Override
    public Retour recupererCommandes()
    {
        return commande.recupererCommandes();
    }

    @Override
    public Retour recupererLignesCommande(Commande com)
    {
        return commande.recupererLignesCommande(com);
    }

    @Override
    public Retour modifierStatutCommande(Commande com, int nouveauStatut)
    {
        return commande.modifierStatutCommande(com, nouveauStatut);
    }

    @Override
    public Retour mettreEnRemboursement(Commande com, Article art)
    {
        return commande.mettreEnRemboursement(com, art);
    }

    @Override
    public Retour saisirAccuseReception(Commande com, String lienImage)
    {
        return commande.saisirAccuseReception(com, lienImage);
    }
}
