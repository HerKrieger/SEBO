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
public interface EJBLettreLocal {
    
    String getContenu();
    void setContenu(String contenu);
    
}
