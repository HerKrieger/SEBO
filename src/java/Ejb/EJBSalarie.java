/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb;

import interfaces.EJBSalarieLocal;
import javax.ejb.Stateless;
import metier.Salarie;

/**
 *
 * @author Frontoni
 */
@Stateless
public class EJBSalarie implements EJBSalarieLocal
{
    Salarie salarie;

    public EJBSalarie()
    {
        salarie = new Salarie();
    }
    
    @Override
    public void setNom(String nom)
    {
        salarie.setNom(nom);
    }

    @Override
    public String getNom()
    {
        return salarie.getNom();
    }

    @Override
    public String getPrenom()
    {
        return salarie.getPrenom();
    }

    @Override
    public void setPrenom(String prenom)
    {
        salarie.setNom(prenom);
    }
    

}
