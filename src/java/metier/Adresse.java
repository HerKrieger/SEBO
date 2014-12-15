/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

/**
 * Représente l'adresse d'une personne, fournisseurs ou clients par ex
 * @author jean
 */
public class Adresse
{
    private int idAdresse;
    private int idClient;
    private String numRue;
    private String nomRue;
    private String codePostal;
    private String ville;

    public Adresse ()
    {
        
    }
    
    public Adresse (String numeroRue, String nomDeRue, String CP, String laVille)
    {
        setNumRue(numeroRue);
        setNomRue(nomDeRue);
        setCodePostal(CP);
        setVille(laVille);
    }
    /*
    * Cette methode permet d'obtenir l'id de l'adresse
    * @return idAdresse qui est l'id de l'adresse
    */
    public int getIdAdresse() {
        return idAdresse;
    }
    
    public void setIdAdresse(int id)
    {
        this.idAdresse = id;
    }
    
    /*
    * Cette methode permet d'obtenir l'id du client ayant cette adresse
    * @return idClient qui est l'id du client domicilie a cette adresse
    */
    public int getIdClient() {
        return idClient;
    }

      /*
    * Cette methode permet de définir l'id du client ayant cette adresse
    * @param idClient qui est l'id du client domicilie a cette adresse
    */
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getNumRue()
    {
        return numRue;
    }

    public void setNumRue(String numRue)
    {
        this.numRue = numRue;
    }

    public String getNomRue()
    {
        return nomRue;
    }

    public void setNomRue(String nomRue)
    {
        this.nomRue = nomRue;
    }

    public String getCodePostal()
    {
        return codePostal;
    }

    public void setCodePostal(String codePostal)
    {
        this.codePostal = codePostal;
    }

    public String getVille()
    {
        return ville;
    }

    public void setVille(String Ville)
    {
        this.ville = Ville;
    }
    
    public void creerAdresse()
    {
        
    }
}
