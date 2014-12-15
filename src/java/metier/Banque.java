package metier;

/**
 * Représente les différentes banques utilisées par les clients
 * @author gruselle
 */
public class Banque 
{
    private int idBanque;
    private Adresse adresseBanque;

    public Banque() 
    {
        
    }    
    
    public Banque(int idBanque, Adresse adresseBanque) 
    {
        this.idBanque = idBanque;
        this.adresseBanque = adresseBanque;
    }   

    /**
     * Permet d'obtenir l'identifiant d'une banque
     */
    public int getIdBanque() 
    {
        return idBanque;
    }

    /**
     * Permet d'assigner un identifiant à une banque
     * @param idBanque est un entier
     */
    public void setIdBanque(int idBanque) 
    {
        this.idBanque = idBanque;
    }

    /**
     * Permet d'otenir l'adresse d'une banque 
     */
    public Adresse getAdresseBanque() 
    {
        return adresseBanque;
    }

    /**
     * Permet d'assigner une adresse à une banque
     * @param adresseBanque est de type Adresse
     */
    public void setAdresseBanque(Adresse adresseBanque) 
    {
        this.adresseBanque = adresseBanque;
    }
    
    public void valider()
    {
        
    }
    
}
