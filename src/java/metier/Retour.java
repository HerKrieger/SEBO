/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

/**
 *
 * @author Frontoni
 */

// Classe permettant de renvoyer les valeurs de retour des procédures stockées
public class        Retour<T>
{
    private T       resultat;
    private int     idRetour;
    private String  messageRetour;
    
    // A utiliser si l'operation s'est bien deroulee
    public  Retour(T res, int idRet, String messageErreur)
    {
        resultat = res;
        idRetour = idRet;
        messageRetour = messageErreur;
       
    }

    // A utiliser si l'operation a rencontre une erreur ou un warning
    public  Retour(int idRet, String messageErreur)
    {
        resultat = null;
        idRetour = idRet;
        messageRetour = messageErreur;
    }
    
    public int  getIdRetour()
    {
        return idRetour;
    }

    public String   getMessageRetour()
    {
        return messageRetour;
    }

    public T    getResultat()
    {
        return resultat;
    }
    
    public boolean setResultat(T res)
    {
        boolean valide = false;
        if (res != null)
        {
            resultat = res;
            valide = true;
        }
        return valide;
    }

   
}
