/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb;

import interfaces.EJBResponsableMarketingLocal;
import java.util.Date;
import javax.ejb.Stateless;
import metier.ResponsableMarketing;
import metier.Retour;

/**
 *
 * @author Frontoni
 */
@Stateless
public class                EJBResponsableMarketing implements EJBResponsableMarketingLocal
{
    ResponsableMarketing    market;
    
    public  EJBResponsableMarketing()
    {
        market = new ResponsableMarketing();
    }

    @Override
    public Retour   recupererArticles()
    {
        return market.recupererArticles();
    }

    @Override
    public Retour   recupererPromos()
    {
        return market.recupererPromos();
    }

    @Override
    public Retour   creerPromotion(Date dateDebut, Date dateFin, float remise)
    {
        return market.creerPromotion(dateDebut, dateFin, remise);
    }

    @Override
    public Retour   associerPromoArticle(int idPromo, int idArticle)
    {
        return market.associerPromoArticle(idPromo, idArticle);
    }

    @Override
    public Retour   terminerPromotion(int idPromo)
    {
        return market.terminerPromotion(idPromo);
    }

    @Override
    public Retour   modifierPrixArticle(int idArticle, float prix)
    {
        return market.modifierPrixArticle(idArticle, prix);
    }
}
