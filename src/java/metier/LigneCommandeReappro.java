/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

/**
 *
 * @author jean
 */
public class LigneCommandeReappro
{
    private Article article;
    private int quantite;

    public LigneCommandeReappro()
    {
        
    }

    public LigneCommandeReappro(Article article, int quantite)
    {
        setArticle(article);
    }
    
    public Article getArticle()
    {
        return article;
    }

    public void setArticle(Article article)
    {
        this.article = article;
    }

    public int getQuantite()
    {
        return quantite;
    }

    public void setQuantite(int quantite)
    {
        this.quantite = quantite;
    }
}
