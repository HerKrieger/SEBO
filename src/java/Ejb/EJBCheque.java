/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb;

import interfaces.EJBChequeLocal;
import javax.ejb.Stateless;
import metier.Cheque;

/**
 *
 * @author sylvainbron
 */
@Stateless
public class EJBCheque implements EJBChequeLocal {
    
    private Cheque cheque;
    
    //Constructeur
    public EJBCheque() {
        cheque = new Cheque();
    }

    @Override
    public float getMontant() {
        return cheque.getMontant();
    }

    @Override
    public void setMontant(float montant) {
        cheque.getMontant();
    }

    @Override
    public String getNumero() {
        return cheque.getNumero();
    }

    @Override
    public void setNumero(String numero) {
        cheque.setNumero(numero);
    }   
}
