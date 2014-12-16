/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb;

import interfaces.EJBCatalogueLocal;
import interfaces.EJBCategorieLocal;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import metier.Article;
import metier.Catalogue;
import metier.Retour;

/**
 *
 * @author sylvainbron
 */
@Stateless
public class EJBCatalogue implements EJBCatalogueLocal {
    @EJB EJBCategorieLocal categorie;
    Catalogue catalogue = new Catalogue();

    @Override
    public void commencerReduction(Article article, float tauxReduction) {
    }

    @Override
    public void terminerReduction(Article article) {
    }

    @Override
    public void modifierPrixArticle(String referenceArticle, float nouveauPrix) {
    }

    @Override
    public void retirerArticle(String referenceArticle) {
    }

    @Override
    public ArrayList<Article> afficherArticles() {
        return null;
    }

    @Override
    public void creerGenre(String libelleGenre) {
        
    }

    @Override
    public void creerCategorie(String libelleCategorie) {
        categorie.creerGenre(libelleCategorie);
    }

    @Override
    public Retour<ArrayList<Article>> getListeEnDessousSeuil() {
        return catalogue.getListeEnDessousSeuil();
    }

    @Override
    public Retour<ArrayList<Article>> getListeArticlesEnPromotion() {
        return catalogue.getListeArticlesEnPromotion();
    }

    @Override
    public Retour<ArrayList<Article>> getListeArticlesSansPromotion() {
        return catalogue.getListeArticlesSansPromotion();
    }

    @Override
    public Retour<ArrayList<Article>> getListeArticle() {
        return catalogue.getListeArticle();
    }

    @Override
    public Retour<ArrayList<Article>> getListeArticle(String nomCategorie, String nomGenre) {
        return catalogue.getListeArticle(nomCategorie, nomGenre);
    }
    
    
    
    
}
