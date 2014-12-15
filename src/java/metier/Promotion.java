/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package metier;

import java.util.Date;

/**
 *
 * @author bron
 */
public class Promotion {
    private int idPromo;
    private int idArticle;
    private Date dateDebPromo;
    private Date datefinPromo;
    private float remisePromo;

    
    /*
    *Cette methode permet d'obtenir l'id en BDD de la promotion
    *@return idPromo qui est l'id en BDD de la promotion 
    */
    public int getIdPromo() {
        return idPromo;
    }

        /*
    *Cette methode permet d'ajouter l'id en BDD de la promotion
    *@param idPromo qui est l'id en BDD de la promotion 
    */
    public void setIdPromo(int idPromo) {
        this.idPromo = idPromo;
    }

        /*
    *Cette methode permet d'obtenir l'id en BDD de l'article en promotion
    *@return idArticle qui est l'id en BDD de l'article en promotion 
    */
    public int getIdArticle() {
        return idArticle;
    }
     
    /*
    *Cette methode permet d'ajouter l'id en BDD de l'article en promotion
    *@param idPromo qui est l'id en BDD de l'article promotion 
    */
    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    /*
    *Cette methode permet d'obtenir la date de debut de promotion
    *@return dateDebPromo qui est la date de debut de la promotion 
    */
    public Date getDateDebPromo() {
        return dateDebPromo;
    }

    /*
    *Cette methode permet de mettre une date de debut de la promotion
    *@param dateDebPromo qui la date de debut de la promotion
    */
    public void setDateDebPromo(Date dateDebPromo) {
        this.dateDebPromo = dateDebPromo;
    }
    /*
    *Cette methode permet d'obtenir la date de fin de promotion
    *@return dateDebPromo qui est la date de fin de la promotion 
    */
    public Date getDatefinPromo() {
        return datefinPromo;
    }

        /*
    *Cette methode permet de mettre une date de fin de la promotion
    *@param dateDebPromo qui la date de fin de la promotion
    */
    public void setDatefinPromo(Date datefinPromo) {
        this.datefinPromo = datefinPromo;
    }

    /*
    *Cette methode permet de mettre une remise au prix de l'article en promotion
    *@return remisePromo qui est le pourcentage de remise
    */
    public float getRemisePromo() {
        return remisePromo;
    }

        /*
    *Cette methode permet d'obtenir la remise d'un article en promotion
    *@param remisePromo qui est le pourcentage de remise
    */
    public void setRemisePromo(float remisePromo) {
        this.remisePromo = remisePromo;
    }
    
    
}
