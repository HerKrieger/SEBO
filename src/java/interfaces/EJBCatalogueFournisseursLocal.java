/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import javax.ejb.Local;
import metier.Article;
import metier.ArticleFournisseur;
import metier.Fournisseur;

/**
 *
 * @author jean
 */
@Local
public interface EJBCatalogueFournisseursLocal
{
    /**
     * Récupère un article fournisseur en se basant sur une référence d'article SEBO
     * @param refArticle la référence SEBO de l'article
     * @param fournisseur le fournisseur qui vend l'article
     * @return l'article fournisseur ou null si l'article n'est pas vendu par le fournisseur
     */
    public ArticleFournisseur getArticle(Article article, Fournisseur fournisseur);
    
    /**
     * Récupère la liste d'article fournisseur à partir de la référence SEBO d'un
     * article
     * @param refArticle
     * @return 
     */
    public ArticleFournisseur[] getArticles(Article article);
}