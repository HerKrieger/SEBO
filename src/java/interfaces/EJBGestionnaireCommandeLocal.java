/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import javax.ejb.Local;
import metier.Article;
import metier.Commande;
import metier.Retour;

/**
 *
 * @author Frontoni
 */
@Local
public interface    EJBGestionnaireCommandeLocal
{
    Retour  modifierStatutCommande(Commande com, int nouveauStatut);
    
    Retour  mettreEnRemboursement(Commande com, Article art);
    
    Retour  saisirAccuseReception(Commande com, String lienImage);
    
    Retour  recupererCommandes();
    
    Retour  recupererLignesCommande(Commande com);
}
