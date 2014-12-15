/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import javax.ejb.Local;
import metier.Retour;

/**
 *
 * @author Frontoni
 */
@Local
public interface    EJBMagasinierLocal
{
    Retour  recupererArticles();
    
    Retour  recupererArticlesEnDessousSeuil();
    
    Retour  recupererFournisseurs();
    
    Retour  modifierQuantiteEnStock(int idArticle, int quantitéAjoutee);
    
    Retour  ajouterFournisseur(String nom, String adresse, String codePostal, String ville, String telephone, String email);
    
    Retour  creerCommandeReappro();
    
    Retour  ajouterLigneCommandeReappro(int idCommandeReappro, int idArticle, int quantite);
    
    Retour  associerArticleFournisseur(int idArticle, int idFournisseur, String referenceArticleChezFournisseur, int seuilMinDeCommande);
    
    Retour  modifierFournisseur(int idFournisseur, String nom, String adresse, String codePostal, String ville, String telephone, String email);
    
    Retour  modifierSeuilReappro(int idCommandeReappro, int idArticle, int quantite);
    
    Retour  retirerFournisseur(int idFournisseur);
}
