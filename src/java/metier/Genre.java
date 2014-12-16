/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.sql.CallableStatement;
import java.sql.Connection;

/**
 *
 * @author sylvainbron
 */
public class Genre
{
    private int idGenre;
    private String nomGenre;
    private String referenceGenre;
    
    // Utiliser ce constructeur pour creer un genre
    public Genre (String nomGenre)
    {
        setNomGenre(nomGenre);
    }
    
    public Genre (int idGenre, String nomGenre)
    {
        setIdGenre(idGenre);
        setNomGenre(nomGenre);
    }

    public Genre()
    {
        
    }

    public int getIdGenre()
    {
        return idGenre;
    }

    public void setIdGenre(int idGenre)
    {
        this.idGenre = idGenre;
    }

    public String getNomGenre()
    {
        return nomGenre;
    }

    public void setNomGenre(String titreGenre)
    {
        this.nomGenre = titreGenre;
    }

    public String getReferenceGenre()
    {
        return referenceGenre;
    }

    public void setReferenceGenre(String referenceGenre)
    {
        this.referenceGenre = referenceGenre;
    }
    
    public Retour<Genre>    creerGenre()
    {
        Retour              leRetour;
        
        if (this.getNomGenre() != null && !this.getNomGenre().equals(""))
        {
            try 
            {            
                //connexion
                Connection lCon = Connexion.getConnection();

                //appel de la procédure stockée
                CallableStatement lStat = lCon.prepareCall("{call creerGenre(?, ?, ?, ?)}");
                lStat.setString(1, this.getNomGenre());
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
                    int idGenreCree = lStat.getInt(2);
                    this.setIdGenre(idGenreCree);
                    leRetour = new Retour<Genre>(this, codeRetour, messageRetour);
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
            leRetour = new Retour(-2, "La classe Genre a été mal remplie avant l'insertion dans la base.");
        
        return leRetour;
    }
}
