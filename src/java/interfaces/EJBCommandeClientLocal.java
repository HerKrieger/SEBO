/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

import java.awt.Image;
import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author bron
 */
@Local
public interface EJBCommandeClientLocal {
    
       int getIdClient();
       void setIdClient(int idClient);
       Date getDateCommande();
       void setDateCommande(Date dateCommande);
       float getTotalCommande();
       void setTotalCommande(float totalCommande);
       int getStatutCommande();
       void setStatutCommande(int statutCommande);
       String getAccuseCommande();
       void setAccuseCommande(String urlAccuseCommande);
       Date getDateRembCommande();
       void setDateRembCommande(Date dateRembCommande);
}
