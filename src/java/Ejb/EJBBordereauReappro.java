/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb;

import interfaces.EJBBordereauReapproLocal;
import javax.ejb.Stateless;
import metier.CommandeReappro;

/**
 *
 * @author jean
 */
@Stateless
public class EJBBordereauReappro implements EJBBordereauReapproLocal
{

    @Override
    public String genererTexte(CommandeReappro commande)
    {
        return null;
    }
    
}
