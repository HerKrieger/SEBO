/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import javax.ejb.Local;
import metier.CommandeReappro;

/**
 *
 * @author jean
 */
@Local
public interface EJBBordereauReapproLocal
{
    public String genererTexte(CommandeReappro commande);
}
