/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import javax.ejb.Local;
import metier.Retour;

/**
 *
 * @author Frontoni
 */
@Local
public interface    EJBCompteSalarieLocal
{    
    String          getLogin();
    
    String          getPassword();

    List<String>    getRoles();

    Retour          seConnecter(String loginEntre, String passwordEntre);

    Retour          seDeconnecter();
    
}
