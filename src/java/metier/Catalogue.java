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
    
    /**
     * Permet d'obtenir la liste des articles à réapprovisionner
     * @return la liste de tous les articles dont la quantité 
     * en stock est = ou inférieure à la quantité de réappro
     */
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

                //remplissage de la liste
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
    
    /**
     * Permet d'obtenir la liste de tous les articles
     * @return la liste de tous les articles
     */
    public Retour<ArrayList<Article>> getListeArticle()
    {
        Retour leRetour=null;
        articles = new ArrayList<Article>();
        
        try
        {
            //ouverture de la connexion
            Connection co = Connexion.getConnection();
            
            //requete sql
            Statement st = co.createStatement();
            ResultSet resultat = st.executeQuery("SELECT Article.nom, Genre.nom as Genre, Categorie.nom as Categorie, idArticle, Article.idGenre,"
                    + " Article.idCategorie, prix, auteur, editeur, [description], lienPhoto, "
                    + " seuilDeReappro, etat, quantiteEnStock, EAN13 FROM Article, Genre, Categorie "
                    + " WHERE Article.idCategorie = Categorie.idCategorie AND Article.idGenre = Genre.idGenre");
            
            //création de la liste
            while (resultat.next())
            {
                articles.add(new Article(resultat.getInt("idArticle") ,new Genre(resultat.getInt("idGenre"), resultat.getString("Genre")), resultat.getFloat("prix"),
                                           resultat.getString("nom"), resultat.getString("auteur"), resultat.getString("editeur"),
                                           resultat.getString("description"),new Categorie(resultat.getInt("idCategorie"), resultat.getString("categorie")),
                                           resultat.getString("lienPhoto"),resultat.getInt("seuilDeReappro"), resultat.getInt("etat"), resultat.getInt("quantiteEnStock"),
                                           resultat.getString("EAN13")));  
            } 
            
            leRetour = new Retour(articles,0,"liste créée avec succès");
            
            //fermeture de la connexion
            st.close();
            co.close();
        }
        catch (Exception e)
        {
            System.out.println("article inexistant ou invalide : "+e.getMessage());
        }
        
        return leRetour;
    }
    
    /**
     * permet d'obtenir la liste des articles en promotion à la date du jour
     * @return la liste d'articles en promotion à la date du jour
     */
    public Retour<ArrayList<Article>> getListeArticlesEnPromotion()
    {
        Retour leRetour = null;
        this.getListeArticle();
        
        ArrayList<Article> listeEnPromo = new ArrayList<Article>();
        
        for(Article art : articles)
        {
            if(art.isEnPromotion())
            {
                listeEnPromo.add(art);
            }
        }
        articles = listeEnPromo;
        leRetour = new Retour(articles,0,"liste des articles en promotion");
                
        return leRetour;
    }
       
    /**
     * Permet d'obtenir les articles sans promotions à la date du jour
     * @return une liste d'articles sans promotion à la date du jour
     */
    public Retour<ArrayList<Article>> getListeArticlesSansPromotion()
    {
        Retour leRetour = null;
        this.getListeArticle();
        
        ArrayList<Article> listeEnPromo = new ArrayList<Article>();
        
        for(Article art : articles)
        {
            if(!art.isEnPromotion())
            {
                listeEnPromo.add(art);
            }
        }
        articles = listeEnPromo;
        leRetour = new Retour(articles,0,"liste des articles sans promotion");
                
        return leRetour;
    }
    
    public String toString()
    {
        String retour = "";
        
        for(Article art : articles)
        {
            retour = retour + art+"\n";
        }      
        
        return retour;
    }
    
}
