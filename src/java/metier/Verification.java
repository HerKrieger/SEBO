/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

/**
 *
 * @author Frontoni
 */
public class    Verification
{
    static public boolean   estNomPropre(String s)
    {
        return (s != null && s.matches("^[a-zA-Zéêè -]+$"));
    }
    
    static public boolean   estPrenom(String s)
    {
        return (s != null && s.matches("^[a-zA-Zéêè ]+-?[a-zA-Zéêè ]*$"));
    }
    
    static public boolean   estTelephone(String s)
    {
        return (s != null && s.length() >= 10 && s.matches("^[0-9.]+$"));
    }
    
    static public boolean   estCodePostal(String s)
    {
        return (s != null && s.length() == 5 && s.matches("^[0-9]+$"));
    }
    
    static public boolean   estEmail(String s)
    {
        return (s != null && s.matches("^[a-zA-Z.]+@[a-zA-Z]+.[a-zA-Z]+$"));
    }
    static public boolean   estDescription(String s)
    {
        return (s != null && s.matches("^[a-zA-Zéêè0-9,?.;:!%\'\"() -]+$"));
    }
    
}
