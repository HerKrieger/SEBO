/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.Date;

/**
 *
 * @author Frontoni
 */
public class    ResponsableMarketing extends CompteSalarie
{
    public      ResponsableMarketing()
    {
    }
    
    public Retour   recupererArticles()
    {
        return null;
    }
    
    public Retour   recupererPromos()
    {
        return null;
    }
    
    public Retour   creerPromotion(Date dateDebut, Date dateFin, float remise)
    {
        return null;
    }
    
    public Retour   associerPromoArticle(int idPromo, int idArticle)
    {
        return null;
    }
    
    public Retour   terminerPromotion(int idPromo)
    {
        return null;
    }
    
    public Retour   modifierPrixArticle(int idArticle, float prix)
    {
        return null;
    }
}
