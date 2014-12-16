/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import interfaces.EJBCompteClientLocal;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import metier.CompteClient;
import metier.Retour;
import metier.XmlCreator;

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
