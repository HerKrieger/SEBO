/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb;

import interfaces.EJBMagasinierLocal;
import javax.ejb.Stateless;
import metier.Magasinier;
import metier.Retour;

/**
 *
 * @author Frontoni
 */
@Stateless
public class    EJBMagasinier implements EJBMagasinierLocal
{
    Magasinier  magasinier;

    public  EJBMagasinier()
    {
        magasinier = new Magasinier();
    }

    @Override
    public Retour   recupererArticles()
    {
        return magasinier.recupererArticles();
    }

    @Override
    public Retour   recupererArticlesEnDessousSeuil()
    {
        return magasinier.recupererArticlesEnDessousSeuil();
    }

    @Override
    public Retour   recupererFournisseurs()
    {
        return magasinier.recupererFournisseurs();
    }

    @Override
    public Retour   modifierQuantiteEnStock(int idArticle, int quantitéAjoutee)
    {
        return magasinier.modifierQuantiteEnStock(idArticle, quantitéAjoutee);
    }

    @Override
    public Retour   ajouterFournisseur(String nom, String adresse, String codePostal, String ville, String telephone, String email)
    {
        return magasinier.ajouterFournisseur(nom, adresse, codePostal, ville, telephone, email);
    }

    @Override
    public Retour   creerCommandeReappro()
    {
        return magasinier.creerCommandeReappro();
    }

    @Override
    public Retour   ajouterLigneCommandeReappro(int idCommandeReappro, int idArticle, int quantite)
    {
        return magasinier.ajouterLigneCommandeReappro(idCommandeReappro, idArticle, quantite);
    }

    @Override
    public Retour   associerArticleFournisseur(int idArticle, int idFournisseur, String referenceArticleChezFournisseur, int seuilMinDeCommande)
    {
        return magasinier.associerArticleFournisseur(idArticle, idFournisseur, referenceArticleChezFournisseur, seuilMinDeCommande);
    }

    @Override
    public Retour   modifierFournisseur(int idFournisseur, String nom, String adresse, String codePostal, String ville, String telephone, String email)
    {
        return magasinier.modifierFournisseur(idFournisseur, nom, adresse, codePostal, ville, telephone, email);
    }

    @Override
    public Retour   modifierSeuilReappro(int idCommandeReappro, int idArticle, int quantite)
    {
        return magasinier.modifierSeuilReappro(idCommandeReappro, idArticle, quantite);
    }

    @Override
    public Retour   retirerFournisseur(int idFournisseur)
    {
        return magasinier.retirerFournisseur(idFournisseur);
    }

}
