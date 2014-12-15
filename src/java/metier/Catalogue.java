/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sylvainbron
 */
public class Catalogue {
    
    private ArrayList<Article> articles;
    private ArrayList<Categorie> categories;
    private ArrayList<Genre> genres;
    
    public Catalogue() {
        articles = new ArrayList<Article>();
        categories = new ArrayList<Categorie>();
        genres = new ArrayList<Genre>();
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Article> articles) {
        this.articles = articles;
    }

    public ArrayList<Categorie> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Categorie> categories) {
        this.categories = categories;
    }

    public ArrayList<Genre> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<Genre> genres) {
        this.genres = genres;
    }
    
    public Retour<ArrayList<Article>> getListeEnDessousSeuil()
    {
        Retour leRetour = null;
        ArrayList<Article> v = null;
        
        try
        {
            //ouverture de la connexion
        Connection co = Connexion.getConnection();
            
        //requete sql
        Statement st = co.createStatement();
        ResultSet resultat = st.executeQuery("SELECT idArticle FROM Article WHERE Article.quantiteEnStock <= Article.seuilDeReappro" );
        
            while(resultat.next())
            {
                Article artTemp = new Article();
                artTemp.fillArticleById(resultat.getInt("idArticle"));
                v.add(artTemp);       
            }
            leRetour.setResultat(v);
        }
        catch(Exception e)
        {
            Logger.getLogger(CompteClient.class.getName()).log(Level.SEVERE, null, e);
            leRetour = new Retour(-1, e.toString());
        }
        
        return leRetour;
    }
    
}
