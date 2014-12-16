/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import interfaces.EJBArticleLocal;
import java.io.StringWriter;
import java.util.ArrayList;
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
import metier.XmlCreator;
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
        
        Retour<Article> retourEjb = ejbArticle.getArticleByCodeBarre(codeBarre);
        ArrayList<Article> liste = new ArrayList<>();
        liste.add(retourEjb.getResultat());
        Retour<ArrayList<Article>> retour = new Retour<>(liste, retourEjb.getIdRetour(), retourEjb.getMessageRetour());
        
        return XmlCreator.creerXmlListeArticles(retour);
    }
    
    @GET
    @Path("/ajouterQuantiteStock")
    @Produces("application/xml")
    public String ajouterQuantiteStock(@QueryParam("idArticle") int idArticle, @QueryParam("quantiteAjoutee") int quantiteAjoutee)
    {
        System.out.println("ajouterQuantiteStock(" + idArticle + ", " + quantiteAjoutee + ")");
        
        Retour<Article> retourEjb = ejbArticle.ajouterQuantiteArticleAuStock(idArticle, quantiteAjoutee);
        
        ArrayList<Article> liste = new ArrayList<>();
        liste.add(retourEjb.getResultat());
        
        Retour<ArrayList<Article>> retourListe = new Retour<>(liste, retourEjb.getIdRetour(), retourEjb.getMessageRetour());
        
        return XmlCreator.creerXmlListeArticles(retourListe);
    }
}
