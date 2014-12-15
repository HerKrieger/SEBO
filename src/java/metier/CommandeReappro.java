/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author jean
 */
public class CommandeReappro
{
    private ArrayList<LigneCommandeReappro> lignes;
    private Date date;
    private int idCommande;

    public CommandeReappro()
    {
        lignes = new ArrayList<LigneCommandeReappro>();
    }
    
    public CommandeReappro(int id)
    {
        idCommande = id;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public int getIdCommande()
    {
        return idCommande;
    }

    public void setIdCommande(int idCommande)
    {
        this.idCommande = idCommande;
    }
    
    public void ajouterLigne(LigneCommandeReappro ligne)
    {
        if(ligne != null)
        {
            lignes.add(ligne);
        }
    }
}