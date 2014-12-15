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
    public Retour   creerGenre(Genre genre)
    {
        return (gestion.creerGenre(genre));
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
