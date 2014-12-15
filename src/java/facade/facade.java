/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import Ejb.EJBAccuseReception;
import Ejb.EJBArticle;
import Ejb.EJBBanque;
import Ejb.EJBBordereauLivraison;
import Ejb.EJBCatalogue;
import Ejb.EJBCategorie;
import Ejb.EJBCheque;
import Ejb.EJBCommandeClient;
import Ejb.EJBCompteClient;
import Ejb.EJBGenre;
import Ejb.EJBLettre;
import Ejb.EJBLigneCommande;
import Ejb.EJBLignePanier;
import Ejb.EJBMoyenPaiement;
import Ejb.EJBPanier;
import Ejb.EJBRemboursement;
import interfaces.EJBCatalogueFournisseursLocal;
import interfaces.EJBCommandeReapproLocal;
import java.util.ArrayList;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import metier.Adresse;
import metier.Article;
import metier.ArticleFournisseur;
import metier.Categorie;
import metier.CompteClient;
import metier.Fournisseur;
import metier.Genre;
import metier.LignePanier;
import metier.Retour;

/**
 *
 * @author gruselle
 */
@Stateless
public class facade implements facadeLocal 
{
    @EJB EJBArticle ejb_art;
    @EJB EJBPanier ejb_pan;
    @EJB EJBLignePanier ejb_lignePan;
    @EJB EJBCompteClient ejb_compteCli;
    @EJB EJBBanque ejb_banque;
    @EJB EJBMoyenPaiement ejb_typePaiement;

    @EJB EJBCatalogueFournisseursLocal ejbCatFournisseur;
    @EJB EJBCommandeReapproLocal ejbCmdFournisseur;
    //Sylvain
    @EJB EJBCatalogue catalogue;
    @EJB EJBCategorie categorie;
    @EJB EJBGenre genre;
    @EJB EJBBordereauLivraison bordereau;
    @EJB EJBRemboursement rmb;
    @EJB EJBCheque cheque;
    @EJB EJBLettre lettre;
    @EJB EJBAccuseReception accuse;
    @EJB EJBLigneCommande ligne;
    @EJB EJBCommandeClient commande;
    
    /*
     * Méthodes article
     */
    @Override
    public int getIdArticle() 
    {
        return ejb_art.getIdArticle();
    }

    @Override
    public float getPrixArticle() 
    {
        return ejb_art.getPrixArticle();
    }

    @Override
    public String getTitreArticle() 
    {
        return ejb_art.getTitreArticle();
    }

    @Override
    public String getAuteurArticle() 
    {
        return ejb_art.getAuteurArticle();
    }

    @Override
    public String getEditeurArticle() 
    {
        return ejb_art.getEditeurArticle();
    }

    @Override
    public String getDescriptionArticle() 
    {
        return ejb_art.getDescriptionArticle();
    }

    @Override
    public String getLienPhoto() 
    {
        return ejb_art.getLienPhoto();
    }

    @Override
    public int getSeuilStockMin() 
    {
        return ejb_art.getSeuilStockMin();
    }

    @Override
    public Article.EtatArticle getEtatArticle() 
    {
        return ejb_art.getEtatArticle();
    }
    
    @Override
    public Genre getGenreArticle() 
    {
        return ejb_art.getGenreArticle();
    }

    @Override
    public Categorie getIdCategorie() 
    {
        return ejb_art.getIdCategorie();
    }
    
    @Override
    public void ajouterPanier() 
    {
        ejb_art.ajouterPanier();
    }
    
     @Override
    public boolean isEnDessousSeuilMini() throws Exception
     {
        return ejb_art.isEnDessousSeuilMini();
    }


    /*
     * méthodes panier
     */
    @Override
    public int getIdPanier() 
    {
        return ejb_pan.getIdPanier();
    }

    @Override
    public ArrayList<LignePanier> getLignePanier() 
    {
        return ejb_pan.getLignePanier();
    }

    /*
     * méthodes lignePanier
     */
    @Override
    public int getQuantite() 
    {
        return ejb_lignePan.getQuantite();
    }

    @Override
    public float getSommeIntermediaire() 
    {
        return ejb_lignePan.getSommeIntermediaire();
    }
    
    @Override
    public float getPrixUnitaire() 
    {
        return ejb_lignePan.getPrixUnitaire();
    }

    @Override
    public void setPrixUnitaire(float prixUnitaire) 
    {
        ejb_lignePan.setPrixUnitaire(prixUnitaire);
    }

    
    /*
     * méthodes compteClient
     */
    @Override
    public int getIdCompteClient() 
    {
        return ejb_compteCli.getIdCompteClient();
    }

    @Override
    public String getNomCompteClient() 
    {
        return ejb_compteCli.getNomCompteClient();
    }

    @Override
    public String getPrenomCompteClient() 
    {
        return ejb_compteCli.getPrenomCompteClient();
    }

    @Override
    public Adresse getAdresseCompteClient() 
    {
        return ejb_compteCli.getAdresseCompteClient();
    }

    @Override
    public String getEmailCompteClient() 
    {
        return ejb_compteCli.getEmailCompteClient();
    }

    @Override
    public String getMdpCompteClient() 
    {
        return ejb_compteCli.getMdpCompteClient();
    }    
    
    @Override
    public Retour<CompteClient> creerCompteClient(String nom, String prenom, String telephone, String email, String motDePasse, String numeroRue, String nomRue, String codePostal, String ville) 
    {
        return ejb_compteCli.creerCompteClient(nom, prenom, telephone, email, motDePasse, numeroRue, nomRue, codePostal, ville);
    }

    @Override
    public void modifierCompteClient() 
    {
        ejb_compteCli.modifierCompteClient();
    }

    @Override
    public void ajouterAdresse() 
    {
        ejb_compteCli.ajouterAdresse();
    }

    @Override
    public void modifierAdresse() 
    {
        ejb_compteCli.modifierAdresse();
    }

    @Override
    public void supprimerAdresse() 
    {
        ejb_compteCli.supprimerAdresse();
    }

    @Override
    public void seConnecter() 
    {
        ejb_compteCli.seConnecter();
    }

    @Override
    public void seDeconnecter() 
    {
        ejb_compteCli.seDeconnecter();
    }

    /*
     * méthodes Banque
     */
    @Override
    public int getIdBanque() 
    {
        return ejb_banque.getIdBanque();
    }

    @Override
    public Adresse getAdresseBanque() 
    {
        return ejb_banque.getAdresseBanque();
    }
    
    @Override
    public void valider() 
    {
        ejb_banque.valider();
    }

    /*
     * méthode moyenPaiement
     */
    @Override
    public String getTypeCB() 
    {
        return ejb_typePaiement.getTypeCB();
    }
    
    @Override
    public boolean isEnDessousSeuil(Article article)
    {
        //TODO A faire : plus d EJB LigneDeStock!
        return false;
    }

    @Override
    public ArticleFournisseur getArticle(Article article, Fournisseur fournisseur)
    {
        return ejbCatFournisseur.getArticle(article, fournisseur);
    }

    @Override
    public ArticleFournisseur[] getArticles(Article article)
    {
        return ejbCatFournisseur.getArticles(article);
    }

    @Override
    public void ajouterArticle(Article article, int qt, int refCommande)
    {
        ejbCmdFournisseur.ajouterArticle(article, qt, refCommande);
    }

    /*
    * METHODES CATALOGUE
    */
    
    @Override
    public void commencerReduction(Article article, float tauxReduction) {
        catalogue.commencerReduction(article, tauxReduction);
    }

    @Override
    public void terminerReduction(Article article) {
        catalogue.terminerReduction(article);
    }

    @Override
    public void modifierPrixArticle(String referenceArticle, float nouveauPrix) {
        catalogue.afficherArticles();   
    }

    @Override
    public void retirerArticle(String referenceArticle) {
        catalogue.retirerArticle(referenceArticle);
    }

    @Override
    public ArrayList<Article> afficherArticles() {
        return catalogue.afficherArticles();
    }

    @Override
    public void creerGenre(String libelleGenre) {
        catalogue.creerGenre(libelleGenre);
    }

    @Override
    public void creerCategorie(String libelleCategorie) {
        catalogue.creerCategorie(libelleCategorie);
    }

    /*
        METHODES GENRE
    */
    
    @Override
    public int getIdGenre() {
        return genre.getIdGenre();
    }

    @Override
    public void setIdGenre(int idGenre) {
        genre.setIdGenre(idGenre);
    }

    @Override
    public String getNomGenre() {
        return genre.getNomGenre();
    }

    @Override
    public void setNomGenre(String titreGenre) {
        genre.setNomGenre(titreGenre);
    }

    @Override
    public String getReferenceGenre() {
        return genre.getReferenceGenre();
    }

    @Override
    public void setReferenceGenre(String referenceGenre) {
        genre.setReferenceGenre(referenceGenre);
    }

    @Override
    public String getContenu() {
       return bordereau.getContenu();
    }

    @Override
    public void setContenu(String contenu) {
        bordereau.setContenu(contenu);
    }

    @Override
    public void remplirContenu() {
        bordereau.remplirContenu();
    }

    @Override
    public Date getDate() {
        return rmb.getDate();
    }

    @Override
    public void setDate(Date date) {
        rmb.setDate(date);
    }

    @Override
    public void genererLettre() {
        rmb.genererLettre();
    }

    @Override
    public void genererCheque() {
        rmb.genererCheque();
    }

    @Override
    public float getMontant() {
        return cheque.getMontant();
    }

    @Override
    public void setMontant(float montant) {
        cheque.setMontant(montant);
    }

    @Override
    public String getNumero() {
        return cheque.getNumero();
    }

    @Override
    public void setNumero(String numero) {
        cheque.setNumero(numero);
    }
    
    /*
    * METHODES LETTRE
    */

    @Override
    public String getContenuLettre() {
        return lettre.getContenu();
    }

    @Override
    public void setContenuLettre(String contenu) {
        lettre.setContenu(contenu);
    }
    
    /*
    * METHODE ACCUSERECEPTION
    */
    @Override
    public Date getDateReception() {
        return accuse.getDateReception();
    }
    
    @Override
    public void setDateReception(Date dateReception) {
        accuse.setDateReception(dateReception);
    }    

    /*
    * METHODES LIGNECOMMANDE
    */

    @Override
    public float getSstotal() {
        return ligne.getSstotal();
    }

    @Override
    public void setSstotal(float sstotal) {
        ligne.setSstotal(sstotal);    
    }

    @Override
    public boolean isIsARembourser() {
        return ligne.isIsARembourser();
    }

    @Override
    public void setIsARembourser(boolean isARembourser) {
        ligne.setIsARembourser(isARembourser);
    }

    @Override
    public int getQuantiteCommande() {
        return ligne.getQuantiteCommande();
    }

    @Override
    public void setQuantiteCommande(int quantite) {
        ligne.setQuantiteCommande(quantite);
    }

    @Override
    public int getQuantiteLivree() {
        return ligne.getQuantiteLivree();
    }

    @Override
    public void setQuantiteLivree(int quantite) {
        ligne.setQuantiteLivree(quantite);
    }

    @Override
    public int getIdClientCommande() {
        return commande.getIdClient();
    }

    @Override
    public void setIdClientCommande(int idClient) {
        commande.setIdClient(idClient);
    }

    @Override
    public Date getDateCommande() {
        return commande.getDateCommande();
    }

    @Override
    public void setDateCommande(Date dateCommande) {
        commande.setDateCommande(dateCommande);
    }

    @Override
    public float getTotalCommande() {
        return commande.getTotalCommande();
    }

    @Override
    public void setTotalCommande(float totalCommande) {
        commande.setTotalCommande(totalCommande);
    }

    @Override
    public int getStatutCommande() {
        return commande.getStatutCommande();
    }

    @Override
    public void setStatutCommande(int statutCommande) {
        commande.setStatutCommande(statutCommande);
    }

    @Override
    public String getAccuseCommande() {
        return commande.getAccuseCommande();
    }

    @Override
    public void setAccuseCommande(String urlAccuseCommande) {
        commande.setAccuseCommande(urlAccuseCommande);
    }

    @Override
    public Date getDateRembCommande() {
        return commande.getDateCommande();
    }

    @Override
    public void setDateRembCommande(Date dateRembCommande) {
        commande.setDateRembCommande(dateRembCommande);
    }

    

    
   
    

    
}
