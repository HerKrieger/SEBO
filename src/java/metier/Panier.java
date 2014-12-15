/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author gruselle
 */
public class Panier 
{
    private int idPanier;
    ArrayList<LignePanier> lignePanier;

    public int getIdPanier() 
    {
        return idPanier;
    }

    public void setIdPanier(int idPanier) 
    {
        this.idPanier = idPanier;
    }

    

    public ArrayList getLignePanier() 
    {
        return lignePanier;
    }

    public void setLignePanier(ArrayList lignePanier) 
    {
        this.lignePanier = lignePanier;
    }
    
}
