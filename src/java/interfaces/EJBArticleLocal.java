/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import javax.ejb.Local;
import metier.Article;
import metier.Categorie;
import metier.Genre;
import metier.Retour;

/**
 * 
 * 
 * @author gruselle
 */
@Local
public interface EJBArticleLocal 
{

    int getIdArticle();
    Genre getGenreArticle();
    float getPrixArticle();
    String getTitreArticle();
    String getAuteurArticle();
    String getEditeurArticle();
    String getDescriptionArticle();
    Categorie getIdCategorie();
    String getLienPhoto();
    int getSeuilStockMin();
    Article.EtatArticle getEtatArticle();
    void ajouterPanier();
    boolean isEnDessousSeuilMini() throws Exception;
    Article getArticleByCodeBarre(String codeBarre);
    Retour<Integer> ajouterQuantiteArticleAuStock(int idArticle, int quantiteAAJouter);
    
}
