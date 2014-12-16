/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.ArrayList;
import javax.ejb.Local;
import metier.Article;
import metier.Retour;

/**
 *
 * @author sylvainbron
 */
@Local
public interface EJBCatalogueLocal {

    void commencerReduction(Article article, float tauxReduction);

    void terminerReduction(Article article);

    void modifierPrixArticle(String referenceArticle, float nouveauPrix);

    void retirerArticle(String referenceArticle);

    ArrayList<Article> afficherArticles();

    void creerGenre(String libelleGenre);

    void creerCategorie(String libelleCategorie);
    
    Retour<ArrayList<Article>> getListeArticle();
    
    Retour<ArrayList<Article>> getListeArticle(String nomCategorie, String nomGenre);
    
    Retour<ArrayList<Article>> getListeEnDessousSeuil();
    
    Retour<ArrayList<Article>> getListeArticle();
    
    Retour<ArrayList<Article>> getListeArticlesEnPromotion();
    
    Retour<ArrayList<Article>> getListeArticlesSansPromotion();
    
}
