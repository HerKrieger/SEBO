/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import javax.ejb.Local;
import metier.Article;

/**
 *
 * @author jean
 */
@Local
public interface EJBCommandeReapproLocal
{
    /**
     * Ajoute un article et la quantité à commander à la commande
     * @param article l'article fournisseur à commander
     * @param qt la quantité à commander
     * @param refCommande la référence de la commande dans laquelle ajouter
     * l'article
     */
    public void ajouterArticle(Article article, int qt, int refCommande);
    
    /**
     * Retourne la liste des articles donc la quantite est en dessous du seuil minimal
     * @return Articles une liste des aricles a commander 
     */
    public List<Article> getListEnDessousSeuil();
}
