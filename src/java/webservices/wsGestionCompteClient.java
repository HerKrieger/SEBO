/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import interfaces.EJBCompteClientLocal;
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
import metier.CompteClient;
import metier.Retour;
import metier.XmlCreator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * REST Web Service
 *
 * @author krieger
 */
@Path("SEBOGestionCompteClient")
public class wsGestionCompteClient
{
    @EJB EJBCompteClientLocal ejbCompteClient;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of SEBOGestionCompteClient
     */
    public wsGestionCompteClient() {
    }
    
    @GET
    @Path("/inscrireClient")
    @Produces("application/xml")
    public String inscrireClient(@QueryParam("nom") String nom, @QueryParam("prenom") String prenom, @QueryParam("telephone") String telephone, @QueryParam("email") String email, 
                                @QueryParam("motDePasse") String motDePasse, @QueryParam("numeroRue") String numeroRue, @QueryParam("nomRue") String nomRue, 
                                @QueryParam("codePostal") String codePostal, @QueryParam("ville") String ville)
    {
        Retour<CompteClient> retourEjb = ejbCompteClient.creerCompteClient(nom, prenom, telephone, email, motDePasse, numeroRue, nomRue, codePostal, ville);
        
        return XmlCreator.creerXmlCompteClient(retourEjb);
    }

    
    
    
}
