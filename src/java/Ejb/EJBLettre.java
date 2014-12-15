/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb;

import interfaces.EJBLettreLocal;
import javax.ejb.Stateless;
import metier.Lettre;

/**
 *
 * @author sylvainbron
 */
@Stateless
public class EJBLettre implements EJBLettreLocal {
    
    private Lettre lettre;
    
    public EJBLettre() {
        lettre = new Lettre();
    }

    public String getContenu() {
        return lettre.getContenu();
    }

    public void setContenu(String contenu) {
        lettre.setContenu(contenu);
    }
}
