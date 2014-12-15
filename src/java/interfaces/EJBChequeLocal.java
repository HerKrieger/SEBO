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
public interface EJBChequeLocal {
    
    public float getMontant();

    public void setMontant(float montant);

    public String getNumero();

    public void setNumero(String numero);
    
}
