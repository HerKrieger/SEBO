/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.util.ArrayList;
import java.util.Date;
import javax.ejb.Local;
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
@Local
public interface facadeLocal 
{
    /*
     * méthodes article
     */
    int getIdArticle();
    Genre getGenreArticle();
    float getPrixArticle();
    String getTitreArticle();
    String getAuteurArticle();
    String getEditeurArticle();
    String getDescriptionArticle();
    Categorie getIdCategorie();
    String getLienPhoto();
    int getSeuilStockMin();
    Article.EtatArticle getEtatArticle();
    void ajouterPanier();
    boolean isEnDessousSeuilMini() throws Exception;
    
    /*
     * méthodes panier
     */
    int getIdPanier();
    ArrayList<LignePanier> getLignePanier();
    
    /*
     * méthodes lignePanier
     */
    int getQuantite();
    float getSommeIntermediaire();
    float getPrixUnitaire();
    void setPrixUnitaire(float prixUnitaire);
    
    /*
     * méthodes compteClient
     */
    int getIdCompteClient();
    String getNomCompteClient();
    String getPrenomCompteClient();
    Adresse getAdresseCompteClient();
    String getEmailCompteClient();
    String getMdpCompteClient();
    Retour<CompteClient> creerCompteClient(String nom, String prenom, String telephone, String email, String motDePasse, String numeroRue, String nomRue, String codePostal, String ville);
    void modifierCompteClient();
    void ajouterAdresse();
    void modifierAdresse();
    void supprimerAdresse();
    void seConnecter();
    void seDeconnecter();
    
    /*
     * méthodes banque
     */
    int getIdBanque();
    Adresse getAdresseBanque();
    void valider();
    
    /*
     * méthodes MoyenPaiement
     */
    String getTypeCB();
    
    // Méthode de l'EJB LigneDeStock
    
    /**
     * 
     * @param refArticle
     * @return 
     */
    public boolean isEnDessousSeuil(Article article);
    
    // Méthode de l'EJB Catalogue Fournisseur
    /**
     * Récupère un article fournisseur en se basant sur une référence d'article SEBO
     * @param refArticle la référence SEBO de l'article
     * @param fournisseur le fournisseur qui vend l'article
     * @return l'article fournisseur ou null si l'article n'est pas vendu par le fournisseur
     */
    public ArticleFournisseur getArticle(Article article, Fournisseur fournisseur);
    
    /**
     * Récupère la liste d'article fournisseur à partir de la référence SEBO d'un
     * article
     * @param refArticle
     * @return 
     */
    public ArticleFournisseur[] getArticles(Article article);
    
    
    // Méthode de l'EJB Commande Reappro
    /**
     * Ajoute un article et la quantité à commander à la commande
     * @param article l'article fournisseur à commander
     * @param qt la quantité à commander
     * @param refCommande la référence de la commande dans laquelle ajouter
     * l'article
     */
    public void ajouterArticle(Article article, int qt, int refCommande);

/*
        METHODES CATALOGUE
    */
   
    void commencerReduction(Article article, float tauxReduction);
    void terminerReduction(Article article);
    void modifierPrixArticle(String referenceArticle, float nouveauPrix);
    void retirerArticle(String referenceArticle);
    ArrayList<Article> afficherArticles();
    void creerCategorie(String libelleCategorie);
    
    /*
        METHODES CATEGORIE
    */
    
    
    /*
        METHODES GENRE
    */
    int getIdGenre();
    void setIdGenre(int idGenre);
    String getNomGenre();
    void setNomGenre(String titreGenre);
    String getReferenceGenre();
    void setReferenceGenre(String referenceGenre);
    void creerGenre(String libelleGenre);
    
    /*
    * METHODES BORDEREAULIVRAISON
    */
    String getContenu();
    void setContenu(String contenu);
    void remplirContenu();
    
    /*
    * METHODES REMBOURSEMENT
    */
    Date getDate();
    void setDate(Date date);
    void genererLettre();
    void genererCheque();
    
    /*
    * METHODES CHEQUE
    */
    float getMontant();
    void setMontant(float montant);
    String getNumero();
    void setNumero(String numero);
    
    /*
    * METHODES LETTRE
    */
    String getContenuLettre();
    void setContenuLettre(String contenu);
    
    /*
    * METHODES ACCUSERECEPTION
    */
    Date getDateReception(); 
    void setDateReception(Date dateReception);
    
    /*
    * METHODES LIGNECOMMANDE
    */
    
    int getQuantiteCommande();
    void setQuantiteCommande(int quantite);
    int getQuantiteLivree();
    void setQuantiteLivree(int quantite);
    float getSstotal();
    void setSstotal(float sstotal);
    boolean isIsARembourser();
    void setIsARembourser(boolean isARembourser);
    
    /*
    * METHODES COMMANDE
    */
    int getIdClientCommande();
    void setIdClientCommande(int idClient);
    Date getDateCommande();
    void setDateCommande(Date dateCommande);
    float getTotalCommande();
    void setTotalCommande(float totalCommande);
    int getStatutCommande();
    void setStatutCommande(int statutCommande);
    String getAccuseCommande();
    void setAccuseCommande(String urlAccuseCommande);
    Date getDateRembCommande();
    void setDateRembCommande(Date dateRembCommande);

}
