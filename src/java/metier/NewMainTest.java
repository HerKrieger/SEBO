/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import Ejb.EJBArticle;
import Ejb.EJBCompteClient;
import interfaces.EJBArticleLocal;
import java.sql.Connection;
import javax.sql.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.*;

/**
 *
 * @author gruselle
 */
public class NewMainTest {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     /*   try
        {
            
            //appel distant
            Hashtable vEnv = new Hashtable();
            vEnv.put("org.omg.CORBA.ORBInitialHost", "127.0.0.1");
            vEnv.put("org.omg.CORBA.ORBInitialPort", "3700");
            Context c = new InitialContext(vEnv);
            DataSource ds = (javax.sql.DataSource)c.lookup("jdbc/SEBO2014");
            /**/
          /*
            Connection con = Connexion.getConnection();
            Statement select = con.createStatement();
            ResultSet result = select.executeQuery("SELECT quantiteEnStock FROM Article WHERE idArticle = 1");
            while(result.next())
            {
                //String nom = result.getString("nom");
                int stock = result.getInt("quantiteEnStock");
                System.out.println(stock);
            }
            select.close();
            con.close();
            */ 
            
        /*} catch (Exception e)
        {
            System.out.println("BUUUUG : " + e.getMessage());
            e.printStackTrace();
        }

        try {
            Context c = new InitialContext();
            EJBCompteClient eJBCompteClient = new EJBCompteClient();
            Retour<CompteClient> creerCompteClient = eJBCompteClient.creerCompteClient("Did", "g", "06115632pouet", "emailfait@chier", "mdpfuck", "6", "rue saoulée", "00cpourri", "ElPontoDellaClaixe");
        } catch (NamingException ne) 
        {
           
            throw new RuntimeException(ne);
        }
     */
        /*
        String cb = "0123456789120";
        EJBArticle test = new EJBArticle();        
        Article aAfficher = test.getArticleByCodeBarre(cb);
        System.out.println(aAfficher);*/
        /*
        int quantite = 15;
        EJBArticle test = new EJBArticle();
        Retour<Integer> plouf = test.ajouterQuantiteArticleAuStock(3, quantite);
        System.out.println(plouf);*/
        
        Fournisseur fourn = Fournisseur.fillFournisseurById(1);
        System.out.println(fourn.getAdresse());
    }
}
