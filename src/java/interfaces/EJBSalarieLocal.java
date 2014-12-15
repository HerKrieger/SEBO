/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import javax.ejb.Local;

/**
 *
 * @author Frontoni
 */
@Local
public interface EJBSalarieLocal
{
    void setNom(String nom);
    
    String getNom();

    String getPrenom();

    void setPrenom(String prenom);
}
