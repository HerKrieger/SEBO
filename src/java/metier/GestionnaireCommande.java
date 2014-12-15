/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

/**
 *
 * @author Frontoni
 */
public class    GestionnaireCommande extends CompteSalarie
{
    public      GestionnaireCommande()
    {
    }
    
    public Retour   recupererCommandes()
    {
        return null;
    }
    
    public Retour   recupererLignesCommande(Commande com)
    {
        return null;
    }
    
    public Retour   modifierStatutCommande(Commande com, int nouveauStatut)
    {
        return null;
    }
    
    public Retour   mettreEnRemboursement(Commande com, Article art)
    {
        return null;
    }
    
    public Retour   saisirAccuseReception(Commande com, String lienImage)
    {
        return null;
    }
}
