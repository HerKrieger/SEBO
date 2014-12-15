/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

/**
 *
 * @author Frontoni
 */
public class    GestionnaireCatalogue extends CompteSalarie
{
    public      GestionnaireCatalogue()
    {
    }
    
    public Retour   recupererArticles()
    {
        return null;
    }
    
    public Retour   recupererGenres()
    {
        return null;
    }
    
    public Retour   recupererCategories()
    {
        return null;
    }
    
    public Retour   ajouterArticle(Article art)
    {
        return (art.insertIntoBDD());
    }
    
    public Retour   modifierArticle(Article art)
    {
        return (art.updateIntoBDD());
    }
    
    public Retour   creerCategorie(Categorie categ)
    {
        return (null);
    }
    
    public Retour   creerGenre(Genre genre)
    {
        return (null);
    }
}
