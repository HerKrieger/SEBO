package metier;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author gruselle
 * Représente tous les attributs d'un article
 */
public class Article 
{
    public enum EtatArticle{Disponible, A_Reapprovisionner, En_Cours_De_Reapprovisionnement, Sorti_Du_Catalogue};
    
    private int idArticle;
    private Genre genreArticle;
    private float prixArticle;
    private String titreArticle;
    private String auteurArticle;
    private String editeurArticle;
    private String descriptionArticle;
    private Categorie categorieArticle;
    private String lienPhoto;
    private int seuilStockMin;
    private EtatArticle etat;
    private int quantiteEnStock;
    private String codeBarre;

    
    public Article()
    {
        
    }
    
    public Article(int lIdArticle, Genre leGenreArticle, float lePrixArticle, String leTitreArticle, 
                  String lAuteurArticle, String lEditeurArticle, String laDescriptionArticle, 
                  Categorie laCategorie, String leLienPhoto, int leSeuilStockMin, EtatArticle lEtat, int laQuantiteEnstock, String leCodeBarre) 
    {
        setIdArticle(lIdArticle);
        setGenreArticle(leGenreArticle);
        setPrixArticle(lePrixArticle);
        setTitreArticle(leTitreArticle);
        setAuteurArticle(lAuteurArticle);
        setEditeurArticle(lEditeurArticle);
        setDescriptionArticle(laDescriptionArticle);
        setCategorieArticle(laCategorie);
        setLienPhoto(leLienPhoto);
        setSeuilStockMin(leSeuilStockMin);
        setEtatArticle(lEtat);
        setQuantiteEnStock(laQuantiteEnstock);
        setCodeBarre(leCodeBarre);
    }
    
    public Article(int lIdArticle, Genre leGenreArticle, float lePrixArticle, String leTitreArticle, 
                  String lAuteurArticle, String lEditeurArticle, String laDescriptionArticle, 
                  Categorie laCategorie, String leLienPhoto, int leSeuilStockMin, int lEtat, int laQuantiteEnstock, String leCodeBarre) 
    {
        setIdArticle(lIdArticle);
        setGenreArticle(leGenreArticle);
        setPrixArticle(lePrixArticle);
        setTitreArticle(leTitreArticle);
        setAuteurArticle(lAuteurArticle);
        setEditeurArticle(lEditeurArticle);
        setDescriptionArticle(laDescriptionArticle);
        setCategorieArticle(laCategorie);
        setLienPhoto(leLienPhoto);
        setSeuilStockMin(leSeuilStockMin);
        setEtatArticle(lEtat);
        setQuantiteEnStock(laQuantiteEnstock);
        setCodeBarre(leCodeBarre);
    }

    public int getQuantiteEnStock() 
    {
        return quantiteEnStock;
    }

    public void setQuantiteEnStock(int quantiteEnStock) 
    {
        this.quantiteEnStock = quantiteEnStock;
    }

    /**
     * retourne l'identifiant de l'article.
     */
    public int getIdArticle() 
    {
        return idArticle;
    }

    /**
     * Permet d'assigner un identifiant à un article
     * @param idArticle est un entier représentant l'id de l'article
     */
    public void setIdArticle(int idArticle) 
    {
        this.idArticle = idArticle;
    }

    /**
     * Permet d'obtenir le genre d'un article
     */
    public Genre getGenreArticle() 
    {
        return genreArticle;
    }

    /**
     * Permet d'assigner un genre à un article
     * @param genreArticle est un genre
     */
    public void setGenreArticle(Genre genreArticle) 
    {
        this.genreArticle = genreArticle;
    }

    /**
     * Permet d'obtenir le prix d'un article
     */
    public float getPrixArticle() 
    {
        return prixArticle;
    }

    /**
     * Permet d'assigner un prix à un article
     * @param prixArticle est de type float
     */
    public void setPrixArticle(float prixArticle) 
    {
        this.prixArticle = prixArticle;
    }

    /**
     * Permet d'obtenir le titre d'un article
     */
    public String getTitreArticle() 
    {
        return titreArticle;
    }

    /**
     * Permet d'assigner un titre à un article
     * @param titreArticle est un chaine de caractères contenant le titre
     */
    public void setTitreArticle(String titreArticle) 
    {
        this.titreArticle = titreArticle;
    }

    /**
     * Permet d'obtenir l'auteur d'un article. Par auteur, nous entendons auteur, chanteur, réalisateur...
     */
    public String getAuteurArticle() 
    {
        return auteurArticle;
    }

    /**
     * Permet d'assigner un auteur à un article. 
     * @param auteurArticle est une chaine de caractères
     */
    public void setAuteurArticle(String auteurArticle) 
    {
        this.auteurArticle = auteurArticle;
    }

    /**
     * Permet d'obtenir l'éditeur d'un article
     */
    public String getEditeurArticle() 
    {
        return editeurArticle;
    }

    /**
     * Permet d'assigner un éditeur à un article
     * @param editeurArticle  est une chaine de caractères
     */
    public void setEditeurArticle(String editeurArticle) 
    {
        this.editeurArticle = editeurArticle;
    }

    /**
     * Permet d'obtenir la description de l'article
     */
    public String getDescriptionArticle() 
    {
        return descriptionArticle;
    }

    /**
     * Permet d'assigner une description à un article
     * @param descriptionArticle est une chaine de caractères
     */
    public void setDescriptionArticle(String descriptionArticle) 
    {
        this.descriptionArticle = descriptionArticle;
    }

    /**
     * Permet d'obtenir la catégorie d'un article
     */
    public Categorie getCategorieArticle() 
    {
        return categorieArticle;
    }

    /**
     * Permet d'assigner une catégorie à cet article
     * @param laCategorie 
     */
    public void setCategorieArticle(Categorie laCategorie) 
    {
        this.categorieArticle = laCategorie;
    }

    /**
     * Permet d'obtenir le lien d'une photo assignée à un article
     */
    public String getLienPhoto() 
    {
        return lienPhoto;
    }

    /**
     * Permet d'assigner Une photo à un article
     * @param lienPhoto est une chaine de caractère contenant le lien
     */
    public void setLienPhoto(String lienPhoto) 
    {
        this.lienPhoto = lienPhoto;
    }

    /*
     * Permet d'obtenir le seuil minimum d'un stock. 
     * Le seuil minimum déclenche la demande de réapprovisionnement
     */
    public int getSeuilStockMin() 
    {
        return seuilStockMin;
    }

    /**
     * Permet d'assigner un seuil minimum avant 
     * déclenchement de la demande de réapprovisionnement
     * @param seuilStockMin est un entier
     */
    public void setSeuilStockMin(int seuilStockMin) 
    {
        this.seuilStockMin = seuilStockMin;
    }
    
    /**
     * Permet d'obtenir l'état d'un article
     */
    public EtatArticle getEtatArticle()
    {
        return etat;
    }
    
    /**
     * Permet d'assigner un état à un article
     * @param etat peut être "disponible", "à réapprovisionner",
     * "en cours", "rupture définitive"
     */
    public void setEtatArticle(EtatArticle etatArt)
    {
        etat = etatArt;
    }
    
    public void setEtatArticle(int etatInt)
    {
        EtatArticle EtatArt = getEtatDeInt(etatInt);
        etat = EtatArt;
    }
    
    public String getCodeBarre() 
    {
        return codeBarre;
    }

    public void setCodeBarre(String CodeBarre) 
    {
        this.codeBarre = CodeBarre;
    }
    
    public void ajouterPanier()
    {
        
    }
    
    public boolean isEnDessousSeuilMini() throws Exception
    {
       return quantiteEnStock < seuilStockMin; 
    }
    
    public Retour insertIntoBDD()
    {
        return null;
    }
    
    public Retour updateIntoBDD()
    {
        return null;
    }
    
    /**
     * getArticleByCodeBarre permet de récupérer toutes les informations d'un article dans la BDD
     * @param codeBarre contient le num du code barre correspondant à un article
     * @return renvoie un article
     */
    public Retour<Article> getArticleByCodeBarre(String codeBarre)
    {
        Retour<Article> leRetour;
        Article art = null;
        
        try
        {
            //ouverture de la connexion
            Connection co = Connexion.getConnection();
            
            //requete sql
            Statement st = co.createStatement();
            ResultSet resultat = st.executeQuery("SELECT Article.nom, Genre.nom as Genre, Categorie.nom as Categorie, idArticle, Article.idGenre,"
                    + " Article.idCategorie, prix, auteur, editeur, [description], lienPhoto, "
                    + "seuilDeReappro, etat, quantiteEnStock, EAN13 FROM Article, Genre, Categorie "
                    + "WHERE Article.idCategorie = Categorie.idCategorie AND Article.idGenre = Genre.idGenre AND Article.EAN13="+codeBarre);
            while (resultat.next())
            {
                art = new Article(resultat.getInt("idArticle") ,new Genre(resultat.getInt("idGenre"), resultat.getString("Genre")), resultat.getFloat("prix"),
                                           resultat.getString("nom"), resultat.getString("auteur"), resultat.getString("editeur"),
                                           resultat.getString("description"),new Categorie(resultat.getInt("idCategorie"), resultat.getString("categorie")),
                                           resultat.getString("lienPhoto"),resultat.getInt("seuilDeReappro"), resultat.getInt("etat"), resultat.getInt("quantiteEnStock"),
                                           resultat.getString("EAN13"));              
                        
            }
        }
        catch (Exception e)
        {
            System.out.println("article inexistant ou invalide : "+e.getMessage());
        }
        
        if(art == null)
        {
            leRetour = new Retour<>(1, "Aucun article trouvé");
        }
        else
        {
            leRetour = new Retour<>(art, 0, "Article trouvé");
        }
        
        return leRetour;
    }
    /**
     * EtatArticle permet d'avoir un état d'article
     * @param etatBdd
     * @return 
     */
    public EtatArticle getEtatDeInt(int etatBdd)
    {
        EtatArticle retour = null;
        switch(etatBdd)
        {
            case 0 : retour = EtatArticle.Disponible;
                break;
            case 1 : retour = EtatArticle.A_Reapprovisionner;
                break;
            case 2 : retour = EtatArticle.En_Cours_De_Reapprovisionnement;
                break;
            case 3 : retour = EtatArticle.Sorti_Du_Catalogue;
                break;
        }
        return retour;
    }
    
    public String toString()
    {
        String artStr = "";
        artStr = getIdArticle()+"/"+getGenreArticle().getNomGenre()+"/"+getPrixArticle()+"/"+getTitreArticle()+"/"+
                 getAuteurArticle()+"/"+getEditeurArticle()+"/"+getDescriptionArticle()+"/"+getCategorieArticle().getReferenceCategorie()
                +"/"+getLienPhoto()+"/"+getSeuilStockMin()+"/"+getEtatArticle()+"/"+getQuantiteEnStock()+"/"+getCodeBarre();
        
        
        
        return artStr;
    }
    
    public Retour<Article> modifierQuantiteArticleAuStock(int quantiteAAjouter)
    {
        Retour<Article> leRetour;
        
        try
        {
            //connexion a la bdd
            Connection lCon = Connexion.getConnection();
   
            //appel de la procédure stockée
            CallableStatement lStat = lCon.prepareCall("{call modifierQuantiteEnStock(?, ?, ?, ?)}");
            lStat.setInt(1, idArticle);
            lStat.setInt(2, quantiteAAjouter);
            lStat.registerOutParameter(3, java.sql.Types.INTEGER);
            lStat.registerOutParameter(4, java.sql.Types.VARCHAR);
            lStat.executeUpdate();
            
            //rcupération des retour
            int lCodeRetour = lStat.getInt(3);
            Logger.getLogger(CompteClient.class.getName()).log(Level.INFO, ">>>>>>>>>>>>>>>>>>>>>>>>>>" + lCodeRetour);
            
            String lMsgRetour = lStat.getString(4);
            Logger.getLogger(CompteClient.class.getName()).log(Level.INFO, ">>>>>>>>>>>>>>>>>>>>>>>>>>" + lMsgRetour);
            
            if(lCodeRetour == 0)
            {
                this.setQuantiteEnStock(this.getQuantiteEnStock() + quantiteAAjouter);
            }
            
            leRetour = new Retour<>(this, lCodeRetour, lMsgRetour);
            
            //fermeture de la connexion
            lStat.close();
            lCon.close();
        }
        catch(Exception e)
        {
            Logger.getLogger(CompteClient.class.getName()).log(Level.SEVERE, null, e);
            leRetour = new Retour(-1, e.toString());
        }
        
        return leRetour;
    }
    
    /**
     * permet de remplir un article à partir de son id
     * @param idArticle 
     */
    public void fillArticleById(int idArticle)
    {
        try
        {
            //ouverture de la connexion
            Connection co = Connexion.getConnection();
            
            //requete sql
            Statement st = co.createStatement();
            ResultSet resultat = st.executeQuery("SELECT Article.nom, Genre.nom as Genre, Categorie.nom as Categorie, idArticle, Article.idGenre,"
                    + " Article.idCategorie, prix, auteur, editeur, [description], lienPhoto, "
                    + "seuilDeReappro, etat, quantiteEnStock, EAN13 FROM Article, Genre, Categorie "
                    + "WHERE Article.idCategorie = Categorie.idCategorie AND Article.idGenre = Genre.idGenre AND Article.idArticle="+idArticle);
            while (resultat.next())
            {
                setIdArticle(resultat.getInt("idArticle"));
                setAuteurArticle(resultat.getString("auteur"));
                setCategorieArticle(new Categorie(resultat.getInt("idCategorie"), resultat.getString("categorie")));
                setCodeBarre(resultat.getString("EAN13"));
                setDescriptionArticle(resultat.getString("description"));
                setEditeurArticle(resultat.getString("editeur"));
                setEtatArticle(resultat.getInt("etat"));
                setGenreArticle(new Genre(resultat.getInt("idGenre"), resultat.getString("Genre")));
                setLienPhoto(resultat.getString("lienPhoto"));
                setPrixArticle(resultat.getFloat("prix"));
                setQuantiteEnStock(resultat.getInt("quantiteEnStock"));
                setSeuilStockMin(resultat.getInt("seuilDeReappro"));
                setTitreArticle(resultat.getString("nom"));                   
            }  
            //fermeture de la connexion
            st.close();
            co.close();
        }
        catch (Exception e)
        {
            System.out.println("article inexistant ou invalide : "+e.getMessage());
        }
    }
    
    
    public Boolean isEnPromotion()
    {
        Boolean ok = false;
        
        try
        {
            //ouverture de la connexion
            Connection co = Connexion.getConnection();

            //requete sql
            String requete = "SELECT Article.nom, Genre.nom as Genre, Categorie.nom as Categorie, Article.idArticle, Article.idGenre, " +
"                    Article.idCategorie, prix, auteur, editeur, [description], lienPhoto, " +
"                    seuilDeReappro, etat, quantiteEnStock, EAN13 FROM Article, Genre, Categorie,Promotion " +
"                     WHERE Article.idCategorie = Categorie.idCategorie " +
"					 AND Article.idGenre = Genre.idGenre " +
"					 AND Article.idArticle=Promotion.idArticle " +
"					 AND dateDebut<GETDATE() and dateFin>GETDATE() and Article.idArticle=" + this.getIdArticle();
            Statement st = co.createStatement();        
            ResultSet resultat = st.executeQuery(requete);

            if(resultat.next())
            {
                ok = true;
            }
            //fermeture de la connexion
            st.close();
            co.close();
        }
        catch(Exception e)
        {
            System.out.println("article inexistant ou invalide : "+e.getMessage());
        }
        
        return ok;
    }
    
}
