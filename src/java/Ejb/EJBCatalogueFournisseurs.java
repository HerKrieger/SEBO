/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb;

import interfaces.EJBCatalogueFournisseursLocal;
import java.util.ArrayList;
import javax.ejb.Stateless;
import metier.Article;
import metier.ArticleFournisseur;
import metier.CatalogueFournisseurs;
import metier.Fournisseur;

/**
 *
 * @author jean
 */
@Stateless
public class EJBCatalogueFournisseurs implements EJBCatalogueFournisseursLocal
{
    CatalogueFournisseurs catalogue;
    
    public EJBCatalogueFournisseurs()
    {
        // Initialisation du catalogue
        catalogue = new CatalogueFournisseurs();
    }
    @Override
    public ArticleFournisseur getArticle(Article article, Fournisseur fournisseur)
    {
        ArticleFournisseur art = null;
        
        int i = 0;
        while( art == null && i < catalogue.getListe().length)
        {
            if(catalogue.ArticleAt(i).getArticle().getIdArticle() == article.getIdArticle()
                    && catalogue.ArticleAt(i).getFournisseur() == fournisseur)
            {
                art = catalogue.ArticleAt(i);
            }
            i++;
        }
        
        return art;
    }

    @Override
    public ArticleFournisseur[] getArticles(Article article)
    {
        ArrayList<ArticleFournisseur> art = null;
        
        int i = 0;
        while( art == null && i < catalogue.getListe().length)
        {
            if(catalogue.ArticleAt(i).getArticle().getIdArticle() == article.getIdArticle())
            {
                art.add(catalogue.ArticleAt(i));
            }
            i++;
        }
        
        return (ArticleFournisseur[]) art.toArray();
    }

   
}