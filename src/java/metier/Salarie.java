/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

/**
 *
 * @author Frontoni
 */
public class        Salarie
{
    String          nom;
    String          prenom;
    
    public  Salarie()
    {
    }
    
    public  Salarie(String nom, String prenom)
    {
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getNom()
    {
        return nom;
    }

    public void setNom(String nom)
    {
        this.nom = nom;
    }

    public String getPrenom()
    {
        return prenom;
    }

    public void setPrenom(String prenom)
    {
        this.prenom = prenom;
    }

}
