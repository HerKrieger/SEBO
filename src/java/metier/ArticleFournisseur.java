/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author jean
 */
public class ArticleFournisseur
{
    private Article article;
    private Fournisseur fournisseur;
    private String referenceFournisseur;
    private int seuilMinDeCommande;

    public ArticleFournisseur(Article article, Fournisseur fournisseur, String referenceFournisseur, int seuilMinDeCommande) {
        this.article = article;
        this.fournisseur = fournisseur;
        this.referenceFournisseur = referenceFournisseur;
        this.seuilMinDeCommande = seuilMinDeCommande;
    }

    public String getReferenceFournisseur() {
        return referenceFournisseur;
    }

    public void setReferenceFournisseur(String referenceFournisseur) {
        this.referenceFournisseur = referenceFournisseur;
    }

    public int getSeuilMinDeCommande() {
        return seuilMinDeCommande;
    }

    public void setSeuilMinDeCommande(int seuilMinDeCommande) {
        this.seuilMinDeCommande = seuilMinDeCommande;
    }

    public ArticleFournisseur(Article article, Fournisseur fournisseur,
            String idArtFournisseur)
    {
        this.article = article;
        this.fournisseur = fournisseur;
        this.referenceFournisseur = idArtFournisseur;
    }

    public Article getArticle()
    {
        return article;
    }

    public void setArticle(Article article)
    {
        this.article = article;
    }

    public Fournisseur getFournisseur()
    {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur)
    {
        this.fournisseur = fournisseur;
    }
    
    public void fillArticleFournisseur(int idArticle, int idFournisseur)
    {
        Article article = new Article();
        Fournisseur fournisseur = null;
        try
        {
            //ouverture de la connexion
            Connection co = Connexion.getConnection();
            
            //requete sql
            article.fillArticleById(idArticle);
            
            fournisseur = Fournisseur.fillFournisseurById(idFournisseur);
            
            Statement st = co.createStatement();
            ResultSet resultatArtFournisseur = st.executeQuery("SELECT * FROM ArticleFournisseur "
                    + "WHERE idFournisseur="+idFournisseur+ " AND idArticle="+ idArticle);
            
            if(resultatArtFournisseur.next())
            {
                
            }
            
            
            System.out.println(fournisseur.getAdresse());
           
        }
        catch (Exception e)
        {
            System.out.println("article inexistant ou invalide : "+e.getMessage());
        }
        
        setArticle(article);
        setFournisseur(fournisseur);
    }
}
