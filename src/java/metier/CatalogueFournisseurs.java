/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

/**
 *
 * @author jean
 */
public class CatalogueFournisseurs
{
    private ArticleFournisseur[] liste;

    public ArticleFournisseur[] getListe()
    {
        return liste;
    }

    public void setListe(ArticleFournisseur[] liste)
    {
        this.liste = liste;
    }
    
    public ArticleFournisseur ArticleAt(int index)
    {
        return liste[index];
    }
    
}