package metier;

/**
 * Représente les différentes catégories auxquelles peuvent appartenir les articles
 * @author gruselle
 */
public class Categorie 
{
    private int idCategorie;
    private String referenceCategorie;

    public Categorie() 
    {
        
    }
    
    public Categorie(int idCategorie, String referenceCategorie) 
    {
        this.idCategorie = idCategorie;
        this.referenceCategorie = referenceCategorie;
    }
    
    /**
     * Permet d'obtenir l'identifiant d'une catégorie
     */
    public int getIdCategorie() 
    {
        return idCategorie;
    }

    /**
     * Permet d'assigner un identifiant à une catégorie
     * @param idCategorie est un entier
     */
    public void setIdCategorie(int idCategorie) 
    {
        this.idCategorie = idCategorie;
    }

    /**
     * Permet de récupérer la référence d'une catégorie
     */
    public String getReferenceCategorie() 
    {
        return referenceCategorie;
    }

    /**
     * Permet d'assigner une référence à une catégorie
     * @param referenceCategorie est une chaine de caractère contenant le nom de la ctégorie
     */
    public void setReferenceCategorie(String referenceCategorie) 
    {
        this.referenceCategorie = referenceCategorie;
    }
    
    public void creerCategorie()
    {
        
    }

}
