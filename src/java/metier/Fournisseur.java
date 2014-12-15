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
public class Fournisseur
{
    private int    id;
    private String nom;
    private String email;
    private String telephone;
    private String adresse;
    private String codePostal;
    private String ville;

    
    public Fournisseur()
    {
        
    }

    public Fournisseur(int id, String nom, String email, String telephone, String adresse, String codePostal, String ville)
    {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.telephone = telephone;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
    }
    
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
    
    
    public String getAdresse()
    {
        return adresse;
    }

    public void setAdresse(String adresse)
    {
        this.adresse = adresse;
    }

    public String getCodePostal()
    {
        return codePostal;
    }

    public void setCodePostal(String codePostal)
    {
        this.codePostal = codePostal;
    }

    public String getVille()
    {
        return ville;
    }

    public void setVille(String ville)
    {
        this.ville = ville;
    }

    public String getNom()
    {
        return nom;
    }

    public void setNom(String nom)
    {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getTelephone()
    {
        return telephone;
    }

    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }
    
    public static Fournisseur fillFournisseurById(int idFournisseur)
    {
        Fournisseur fournisseur = null;
        try
        {
            //ouverture de la connexion
            Connection co = Connexion.getConnection();
            
            //requete sql
            Statement stFournisseur = co.createStatement();
            ResultSet resultatFournisseur = stFournisseur.executeQuery("SELECT * FROM Fournisseur "
                    + "WHERE idFournisseur="+idFournisseur);
            while (resultatFournisseur.next())
            {
                fournisseur = new Fournisseur(resultatFournisseur.getInt("idFournisseur"), resultatFournisseur.getString("nom"), resultatFournisseur.getString("email"), resultatFournisseur.getString("telephone"), resultatFournisseur.getString("adresse"), resultatFournisseur.getString("codePostal"), resultatFournisseur.getString("ville"));            
                        
            }
           
        }
        catch (Exception e)
        {
            System.out.println("Fournisseur inexistant ou invalide : "+e.getMessage());
        }
        
        return fournisseur;
    }
}
