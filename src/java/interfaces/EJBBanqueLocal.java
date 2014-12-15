/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import javax.ejb.Local;
import metier.Adresse;

/**
 *
 * @author gruselle
 */
@Local
public interface EJBBanqueLocal 
{
    int getIdBanque();
    Adresse getAdresseBanque();
    void valider();
}
