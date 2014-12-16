/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb;

import interfaces.EJBGestionnaireCatalogueLocal;
import javax.ejb.Stateless;
import metier.Article;
import metier.Categorie;
import metier.Genre;
import metier.GestionnaireCatalogue;
import metier.Retour;
import metier.Verification;

/**
 *
 * @author Frontoni
 */
@Stateless
public class                EJBGestionnaireCatalogue implements EJBGestionnaireCatalogueLocal
{
    GestionnaireCatalogue   gestion;
    
    public  EJBGestionnaireCatalogue()
    {
        gestion = new GestionnaireCatalogue();
    }
    
    @Override
    public Retour   ajouterArticle(Article art)
    {
        return (gestion.ajouterArticle(art));
    }

    @Override
    public Retour   modifierArticle(Article art)
    {
        return (gestion.modifierArticle(art));
    }

    @Override
    public Retour   creerCategorie(Categorie categ)
    {
        return (gestion.creerCategorie(categ));
    }

    @Override
    public Retour<Genre>    creerGenre(String genre)
    {
        Retour              ret;
        
        if (!Verification.estNomPropre(genre))
            ret = new Retour(-1, "Le nom du genre n'est pas valide.");
        else
            ret = gestion.creerGenre(new Genre(genre));
        return (ret);
    }

    @Override
    public Retour   recupererArticles()
    {
        return (gestion.recupererArticles());
    }

    @Override
    public Retour   recupererGenres()
    {
        return (gestion.recupererGenres());
    }

    @Override
    public Retour   recupererCategories()
    {
        return (gestion.recupererCategories());
    }
}
