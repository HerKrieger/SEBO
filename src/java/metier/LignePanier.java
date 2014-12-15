/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

/**
 *
 * @author gruselle
 */
public class LignePanier 
{
    int quantite;
    int idArticle;
    float prixUnitaire;
    float sommeIntermediaire;

    public int getQuantite() 
    {
        return quantite;
    }

    public void setQuantite(int quantite) 
    {
        this.quantite = quantite;
    }

    public float getSommeIntermediaire() 
    {
        return prixUnitaire * quantite;
    }

    public void setSommeIntermediaire(float sommeIntermediaire) 
    {
        this.sommeIntermediaire = sommeIntermediaire;
    }

    public int getIdArticle() 
    {
        return idArticle;
    }

    public void setIdArticle(int idArticle) 
    {
        this.idArticle = idArticle;
    }

    public float getPrixUnitaire() 
    {
        return prixUnitaire;
    }

    public void setPrixUnitaire(float prixUnitaire) 
    {
        this.prixUnitaire = prixUnitaire;
    }
    
    
}
