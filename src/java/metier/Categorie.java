package metier;

import java.sql.CallableStatement;
import java.sql.Connection;

/**
 * Représente les différentes catégories auxquelles peuvent appartenir les articles
 * @author gruselle
 */
public class Categorie 
{
    private int idCategorie;
    private String referenceCategorie;

    public Categorie() 
    {
        
    }
    
    // Constructeur a utiliser pour creer une categorie
    public Categorie(String referenceCategorie) 
    {
        this.setReferenceCategorie(referenceCategorie);
    }
    
    public Categorie(int idCategorie, String referenceCategorie) 
    {
        this.idCategorie = idCategorie;
        this.referenceCategorie = referenceCategorie;
    }
    
    /**
     * Permet d'obtenir l'identifiant d'une catégorie
     */
    public int getIdCategorie() 
    {
        return idCategorie;
    }

    /**
     * Permet d'assigner un identifiant à une catégorie
     * @param idCategorie est un entier
     */
    public void setIdCategorie(int idCategorie) 
    {
        this.idCategorie = idCategorie;
    }

    /**
     * Permet de récupérer la référence d'une catégorie
     */
    public String getReferenceCategorie() 
    {
        return referenceCategorie;
    }

    /**
     * Permet d'assigner une référence à une catégorie
     * @param referenceCategorie est une chaine de caractère contenant le nom de la ctégorie
     */
    public void setReferenceCategorie(String referenceCategorie) 
    {
        this.referenceCategorie = referenceCategorie;
    }
    
    public Retour<Categorie>    creerCategorie()
    {
        Retour                  leRetour;
        
        if (this.getReferenceCategorie()!= null && !this.getReferenceCategorie().equals(""))
        {
            try 
            {            
                //connexion
                Connection lCon = Connexion.getConnection();

                //appel de la procédure stockée
                CallableStatement lStat = lCon.prepareCall("{call creerCategorie(?, ?, ?, ?)}");
                lStat.setString(1, this.getReferenceCategorie());
                lStat.registerOutParameter(2, java.sql.Types.INTEGER);
                lStat.registerOutParameter(3, java.sql.Types.INTEGER);
                lStat.registerOutParameter(4, java.sql.Types.VARCHAR);
                lStat.executeUpdate();

                //récupération des retours
                int codeRetour = lStat.getInt(3);
                String messageRetour = lStat.getString(4);
                if (codeRetour != 0)
                    leRetour = new Retour(codeRetour, messageRetour);
                else
                {
                    int idCategCree = lStat.getInt(2);
                    this.setIdCategorie(idCategCree);
                    leRetour = new Retour<Categorie>(this, codeRetour, messageRetour);
                }

                //fermeture de la connexion
                lStat.close();
                lCon.close();
            }
            catch (Exception ex) 
            {
                leRetour = new Retour(-1, ex.toString());
            }
        }
        else
            leRetour = new Retour(-2, "La classe Categorie a été mal remplie avant l'insertion dans la base.");
        
        return leRetour;
    }

}
