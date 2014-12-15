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
        
        return creerXmlRetourInscription(retourEjb);
    }

    private String creerXmlRetourInscription(Retour<CompteClient> paramRetour)
    {
        String retour = null;
        
        try
        {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element racine = doc.createElement("racine");
            doc.appendChild(racine);
            
            Element rapport = doc.createElement("rapport");
            
            Element codeRetour = doc.createElement("codeRetour");
            codeRetour.appendChild(doc.createTextNode(Integer.toString(paramRetour.getIdRetour())));
            rapport.appendChild(codeRetour);
            Element messageRetour = doc.createElement("messageRetour");
            messageRetour.appendChild(doc.createTextNode(paramRetour.getMessageRetour()));
            rapport.appendChild(messageRetour);
            
            racine.appendChild(rapport);
            
            Element cptClient = doc.createElement("compteClient");
            
            Element idClient = doc.createElement("idClient");
            idClient.appendChild(doc.createTextNode(Integer.toString(paramRetour.getResultat().getIdCompteClient())));
            cptClient.appendChild(idClient);
            
            racine.appendChild(cptClient);
            
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
            Logger.getLogger(wsGestionCompteClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return retour;
    }
    
    
}
