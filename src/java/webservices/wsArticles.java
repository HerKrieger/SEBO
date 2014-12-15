/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import interfaces.EJBArticleLocal;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import metier.Article;
import metier.Retour;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * REST Web Service
 *
 * @author krieger
 */
@Path("SEBOArticles")
public class wsArticles {

    @EJB EJBArticleLocal ejbArticle;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of SEBOArticles
     */
    public wsArticles() {
    }
    
    @GET
    @Path("/getArticleByCodeBarre")
    @Produces("application/xml")
    public String getArticleByCodeBarre(@QueryParam("codeBarre") String codeBarre)
    {
        System.out.println("getArticleByCodeBarre(" + codeBarre + ")");
        
        Article retourArticle = ejbArticle.getArticleByCodeBarre(codeBarre);
        
        return creerXmlGetArticleByCodeBarre(retourArticle);
    }

    private String creerXmlGetArticleByCodeBarre(Article retourArticle)
    {
        boolean erreur = (retourArticle == null);
        String retour = null;
        
        try
        {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element racine = doc.createElement("racine");
            
            Element rapport = doc.createElement("rapport");
            Element codeRetour = doc.createElement("codeRetour");
            Element messageRetour = doc.createElement("messageRetour");
            Element article = doc.createElement("Article");
            Element idArticle = doc.createElement("idArticle");
            Element categorie = doc.createElement("Categorie");
            Element genre = doc.createElement("Genre");
            Element nom = doc.createElement("Nom");
            Element auteur = doc.createElement("Auteur");
            Element editeur = doc.createElement("Editeur");
            Element description = doc.createElement("Description");
            Element lienPhoto = doc.createElement("lienPhoto");
            Element prix = doc.createElement("Prix");
            Element etat = doc.createElement("Etat");
            Element qteStock = doc.createElement("QuantiteStock");
            Element seuilReappro = doc.createElement("SeuilReappro");
            Element codeBarre = doc.createElement("codeBarre");
            
            if (erreur)
            {
                codeRetour.appendChild(doc.createTextNode("1"));
                messageRetour.appendChild(doc.createTextNode("Code barre invalide ou inexistant"));
                idArticle.appendChild(doc.createTextNode(""));
                categorie.appendChild(doc.createTextNode(""));
                genre.appendChild(doc.createTextNode(""));
                nom.appendChild(doc.createTextNode(""));
                auteur.appendChild(doc.createTextNode(""));
                editeur.appendChild(doc.createTextNode(""));
                description.appendChild(doc.createTextNode(""));
                lienPhoto.appendChild(doc.createTextNode(""));
                prix.appendChild(doc.createTextNode(""));
                etat.appendChild(doc.createTextNode(""));
                qteStock.appendChild(doc.createTextNode(""));
                seuilReappro.appendChild(doc.createTextNode(""));
                codeBarre.appendChild(doc.createTextNode(""));
            }
            else
            {
                codeRetour.appendChild(doc.createTextNode("0"));
                messageRetour.appendChild(doc.createTextNode("Article trouvé"));
                idArticle.appendChild(doc.createTextNode(Integer.toString(retourArticle.getIdArticle())));
                categorie.appendChild(doc.createTextNode(retourArticle.getCategorieArticle().getReferenceCategorie()));
                genre.appendChild(doc.createTextNode(retourArticle.getGenreArticle().getNomGenre()));
                nom.appendChild(doc.createTextNode(retourArticle.getTitreArticle()));
                auteur.appendChild(doc.createTextNode(retourArticle.getAuteurArticle()));
                editeur.appendChild(doc.createTextNode(retourArticle.getEditeurArticle()));
                description.appendChild(doc.createTextNode(retourArticle.getDescriptionArticle()));
                lienPhoto.appendChild(doc.createTextNode(retourArticle.getLienPhoto()));
                prix.appendChild(doc.createTextNode(Float.toString(retourArticle.getPrixArticle())));
                etat.appendChild(doc.createTextNode(retourArticle.getEtatArticle().name()));
                qteStock.appendChild(doc.createTextNode(Integer.toString(retourArticle.getQuantiteEnStock())));
                seuilReappro.appendChild(doc.createTextNode(Integer.toString(retourArticle.getSeuilStockMin())));
                codeBarre.appendChild(doc.createTextNode(retourArticle.getCodeBarre()));
            }
            
            
            doc.appendChild(racine);
            
            rapport.appendChild(codeRetour);
            rapport.appendChild(messageRetour);
            
            racine.appendChild(rapport);
            
            article.appendChild(idArticle);
            article.appendChild(categorie);
            article.appendChild(genre);
            article.appendChild(nom);
            article.appendChild(auteur);
            article.appendChild(editeur);
            article.appendChild(description);
            article.appendChild(lienPhoto);
            article.appendChild(prix);
            article.appendChild(etat);
            article.appendChild(qteStock);
            article.appendChild(seuilReappro);
            article.appendChild(codeBarre);
            
            racine.appendChild(article);
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            
            StringWriter resultSW = new StringWriter();
            
            StreamResult result = new StreamResult(resultSW);
            
            transformer.transform(source, result);
            
            retour = resultSW.toString();
        }
        catch (ParserConfigurationException | TransformerException ex)
        {
            Logger.getLogger(wsArticles.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return retour;
    }
    
    @GET
    @Path("/ajouterQuantiteStock")
    @Produces("application/xml")
    public String ajouterQuantiteStock(@QueryParam("idArticle") int idArticle, @QueryParam("quantiteAjoutee") int quantiteAjoutee)
    {
        System.out.println("ajouterQuantiteStock(" + idArticle + ", " + quantiteAjoutee + ")");
        
        Retour<Integer> retourEjb = ejbArticle.ajouterQuantiteArticleAuStock(idArticle, quantiteAjoutee);
        
        return creerXmlAjouterQuantiteStock(retourEjb);
    }

    private String creerXmlAjouterQuantiteStock(Retour<Integer> retourEjb)
    {
        String retour = null;
        
        try
        {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element racine = doc.createElement("racine");
            doc.appendChild(racine);
            
            Element rapport = doc.createElement("rapport");
            
            Element codeRetour = doc.createElement("codeRetour");
            codeRetour.appendChild(doc.createTextNode(Integer.toString(retourEjb.getIdRetour())));
            rapport.appendChild(codeRetour);
            Element messageRetour = doc.createElement("messageRetour");
            messageRetour.appendChild(doc.createTextNode(retourEjb.getMessageRetour()));
            rapport.appendChild(messageRetour);
            
            racine.appendChild(rapport);
            
            Element article = doc.createElement("article");
            
            Element quantite = doc.createElement("quantite");
            quantite.appendChild(doc.createTextNode(Integer.toString(retourEjb.getResultat())));
            article.appendChild(quantite);
            
            racine.appendChild(article);
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            
            StringWriter resultSW = new StringWriter();
            
            StreamResult result = new StreamResult(resultSW);
            
            transformer.transform(source, result);
            
            retour = resultSW.toString();
        }
        catch (ParserConfigurationException | TransformerException ex)
        {
            Logger.getLogger(wsArticles.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return retour;
    }
}
