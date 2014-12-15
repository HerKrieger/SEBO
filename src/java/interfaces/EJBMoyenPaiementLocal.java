/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import javax.ejb.Local;

/**
 *
 * @author gruselle
 */
@Local
public interface EJBMoyenPaiementLocal 
{
    String getTypeCB();
}
