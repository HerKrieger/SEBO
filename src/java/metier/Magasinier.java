/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

/**
 *
 * @author Frontoni
 */
public class    Magasinier extends CompteSalarie
{
    public      Magasinier()
    {
    }
    
    public Retour   recupererArticles()
    {
        return null;
    }
    
    public Retour   recupererArticlesEnDessousSeuil()
    {
        return null;
    }
    
    public Retour   recupererFournisseurs()
    {
        return null;
    }
    
    public Retour   modifierQuantiteEnStock(int idArticle, int quantitéAjoutee)
    {
        return null;
    }
    
    public Retour   ajouterFournisseur(String nom, String adresse, String codePostal, String ville, String telephone, String email)
    {
        return null;
    }
    
    public Retour   creerCommandeReappro()
    {
        return null;
    }
    
    public Retour   ajouterLigneCommandeReappro(int idCommandeReappro, int idArticle, int quantite)
    {
        return null;
    }
    
    public Retour   associerArticleFournisseur(int idArticle, int idFournisseur, String referenceArticleChezFournisseur, int seuilMinDeCommande)
    {
        return null;
    }
    
    public Retour   modifierFournisseur(int idFournisseur, String nom, String adresse, String codePostal, String ville, String telephone, String email)
    {
        return null;
    }
    
    public Retour   modifierSeuilReappro(int idCommandeReappro, int idArticle, int quantite)
    {
        return null;
    }
    
    public Retour   retirerFournisseur(int idFournisseur)
    {
        return null;
    }
}
