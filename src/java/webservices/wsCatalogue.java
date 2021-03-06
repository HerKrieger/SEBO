/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import interfaces.EJBCatalogueLocal;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import metier.Article;
import metier.Retour;
import metier.XmlCreator;

/**
 * REST Web Service
 *
 * @author krieger
 */
@Path("SEBOCatalogue")
public class wsCatalogue
{
    @EJB EJBCatalogueLocal ejbCatalogue;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of wsCatalogue
     */
    public wsCatalogue() {
    }
    
    @GET
    @Path("/getListeArticle")
    @Produces("application/xml")
    public String getListeArticle()
    {
        System.out.println("getListeArticle()");
        Retour<ArrayList<Article>> retourEjb = ejbCatalogue.getListeArticle();
        return XmlCreator.creerXmlListeArticles(retourEjb);
    }
    
    @GET
    @Path("/getListeArticleFiltree")
    @Produces("application/xml")
    public String getListeArticleFiltree(@QueryParam("nomCategorie") String nomCategorie, @QueryParam("nomGenre") String nomGenre)
    {
        System.out.println("getListeArticle(nomCategorie = " + nomCategorie + ", nomGenre = " + nomGenre + ")");
        Retour<ArrayList<Article>> retourEjb = ejbCatalogue.getListeArticle(nomCategorie, nomGenre);
        return XmlCreator.creerXmlListeArticles(retourEjb);
    }

    @GET
    @Path("/getListeEnDessousSeuil")
    @Produces("application/xml")
    public String getListeEnDessousSeuil()
    {
        System.out.println("getListeEnDessousSeuil()");
        Retour<ArrayList<Article>> retourEjb = ejbCatalogue.getListeEnDessousSeuil();
        return XmlCreator.creerXmlListeArticles(retourEjb);
    }

    @GET
    @Path("/getListeArticlesEnPromotion")
    @Produces("application/xml")
    public String getListeArticlesEnPromotion()
    {
        System.out.println("getListeArticlesEnPromotion()");
        Retour<ArrayList<Article>> retourEjb = ejbCatalogue.getListeArticlesEnPromotion();
        return XmlCreator.creerXmlListeArticles(retourEjb);
    }
    
    @GET
    @Path("/getListeArticlesSansPromotion")
    @Produces("application/xml")
    public String getListeArticlesSansPromotion()
    {
        System.out.println("getListeArticlesSansPromotion()");
        Retour<ArrayList<Article>> retourEjb = ejbCatalogue.getListeArticlesSansPromotion();
        return XmlCreator.creerXmlListeArticles(retourEjb);
    }
}
