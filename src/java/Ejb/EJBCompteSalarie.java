/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb;

import interfaces.EJBCompteSalarieLocal;
import java.util.List;
import javax.ejb.Stateless;
import metier.CompteSalarie;
import metier.Retour;

/**
 *
 * @author Frontoni
 */
@Stateless
public class        EJBCompteSalarie implements EJBCompteSalarieLocal
{
    CompteSalarie   salarie;

    public  EJBCompteSalarie()
    {
        salarie = new CompteSalarie();
    }

    @Override
    public List<String> getRoles()
    {
        return salarie.getRoles();
    }

    @Override
    public String getLogin()
    {
        return salarie.getLogin();
    }

    @Override
    public String getPassword()
    {
        return salarie.getPassword();
    }

    @Override
    public Retour seConnecter(String loginEntre, String passwordEntre)
    {
        return salarie.seConnecter(loginEntre, passwordEntre);
    }

    @Override
    public Retour seDeconnecter()
    {
        return salarie.seDeconnecter();
    }
}
