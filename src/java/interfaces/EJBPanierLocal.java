/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.ArrayList;
import javax.ejb.Local;
import metier.LignePanier;

/**
 *
 * @author gruselle
 */
@Local
public interface EJBPanierLocal 
{
    int getIdPanier();
    ArrayList<LignePanier> getLignePanier();
}
