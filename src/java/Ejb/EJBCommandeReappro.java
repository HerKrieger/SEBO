/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb;

import interfaces.EJBCommandeReapproLocal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import metier.Article;
import metier.CommandeReappro;
import metier.Connexion;
import metier.LigneCommandeReappro;

/**
 *
 * @author jean
 */
@Stateless
public class EJBCommandeReappro implements EJBCommandeReapproLocal
{
    @Override
    public void ajouterArticle(Article article, int qt, int refCommande)
    {
        LigneCommandeReappro ligne = new LigneCommandeReappro(article, qt);
        CommandeReappro commande = new CommandeReappro(refCommande);
        commande.ajouterLigne(ligne);
    }
    
    @Override
    public List<Article> getListEnDessousSeuil() 
    {
        List<Article> articles = new ArrayList<Article>();
        Connexion connexion = new Connexion();
        try {
            Connection con = connexion.getConnection();
        } catch (Exception ex) {
            System.out.println("No connection to DB : "+ex.getMessage());
        }
        
        return articles;
    }
}