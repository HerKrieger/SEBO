/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.List;

/**
 *
 * @author Frontoni
 */
public class        CompteSalarie
{
    String          login;
    String          password;
    List<String>    roles;

    public  CompteSalarie()
    {
    }
    
    public  CompteSalarie(String login, String password, List<String> roles)
    {
        this.login = login;
        this.password = password;
        this.roles = roles;
    }

    public String   getLogin()
    {
        return login;
    }

    public String   getPassword()
    {
        return password;
    }

    public List<String> getRoles()
    {
        return roles;
    }
    
    public Retour   seConnecter(String loginEntre, String passwordEntre)
    {
        return null;
    }
    
    public Retour   seDeconnecter()
    {
        return null;
    }
}
