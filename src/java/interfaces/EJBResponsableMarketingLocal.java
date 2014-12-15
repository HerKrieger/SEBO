/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.Date;
import javax.ejb.Local;
import metier.Retour;

/**
 *
 * @author Frontoni
 */
@Local
public interface    EJBResponsableMarketingLocal
{
    Retour  recupererArticles();
    
    Retour  recupererPromos();
    
    Retour  creerPromotion(Date dateDebut, Date dateFin, float remise);
    
    Retour  associerPromoArticle(int idPromo, int idArticle);
    
    Retour  terminerPromotion(int idPromo);
    
    Retour  modifierPrixArticle(int idArticle, float prix);
}
