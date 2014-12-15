/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import javax.ejb.Local;

/**
 *
 * @author sylvainbron
 */
@Local
public interface EJBLigneCommandeLocal {
    
    public int getQuantiteCommande();

    public void setQuantiteCommande(int quantiteCommande);

    public int getQuantiteLivree();

    public void setQuantiteLivree(int quantiteLivree);

    public float getSstotal();

    public void setSstotal(float sstotal);

    public boolean isIsARembourser();

    public void setIsARembourser(boolean isARembourser);
    
}
