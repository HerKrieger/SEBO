/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import javax.ejb.Local;
import metier.Article;
import metier.Categorie;
import metier.Genre;
import metier.Retour;

/**
 *
 * @author Frontoni
 */
@Local
public interface    EJBGestionnaireCatalogueLocal
{
    Retour   recupererArticles();
    
    Retour   recupererGenres();
    
    Retour   recupererCategories();
    
    Retour   ajouterArticle(Article art);
    
    Retour   modifierArticle(Article art);
    
    Retour   creerCategorie(Categorie categ);
    
    Retour   creerGenre(Genre genre);
}
