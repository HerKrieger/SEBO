/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import webservices.wsArticles;
import webservices.wsGestionCompteClient;

/**
 *
 * @author krieger
 */
public class XmlCreator
{
    public static String creerXmlListeArticles(Retour<ArrayList<Article>> retourEjb)
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
            
            if(retourEjb.getIdRetour() == 0)
            {
                for (Article art : retourEjb.getResultat())
                {
                    racine.appendChild(creerElementArticle(doc, art));
                }
            }
            
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
    
    private static Element creerElementArticle(Document doc, Article art)
    {
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
        
        idArticle.appendChild(doc.createTextNode(Integer.toString(art.getIdArticle())));
        categorie.appendChild(doc.createTextNode(art.getCategorieArticle().getReferenceCategorie()));
        genre.appendChild(doc.createTextNode(art.getGenreArticle().getNomGenre()));
        nom.appendChild(doc.createTextNode(art.getTitreArticle()));
        auteur.appendChild(doc.createTextNode(art.getAuteurArticle()));
        editeur.appendChild(doc.createTextNode(art.getEditeurArticle()));
        description.appendChild(doc.createTextNode(art.getDescriptionArticle()));
        lienPhoto.appendChild(doc.createTextNode(art.getLienPhoto()));
        prix.appendChild(doc.createTextNode(Float.toString(art.getPrixArticle())));
        etat.appendChild(doc.createTextNode(art.getEtatArticle().name()));
        qteStock.appendChild(doc.createTextNode(Integer.toString(art.getQuantiteEnStock())));
        seuilReappro.appendChild(doc.createTextNode(Integer.toString(art.getSeuilStockMin())));
        codeBarre.appendChild(doc.createTextNode(art.getCodeBarre()));
        
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
        
        return article;
    }
    
    public static String creerXmlCompteClient(Retour<CompteClient> retourEjb)
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
            
            Element cptClient = doc.createElement("compteClient");
            
            Element idClient = doc.createElement("idClient");
            Element nom = doc.createElement("nom");
            Element prenom = doc.createElement("prenom");
            Element adresse = doc.createElement("adresse");
            Element email = doc.createElement("email");
            Element telephone = doc.createElement("telephone");
            
            idClient.appendChild(doc.createTextNode(Integer.toString(retourEjb.getResultat().getIdCompteClient())));
            nom.appendChild(doc.createTextNode(retourEjb.getResultat().getNomCompteClient()));
            prenom.appendChild(doc.createTextNode(retourEjb.getResultat().getPrenomCompteClient()));
            fillXmlAdresse(doc, adresse, retourEjb.getResultat().getAdresseCompteClient());
            email.appendChild(doc.createTextNode(retourEjb.getResultat().getEmailCompteClient()));
            telephone.appendChild(doc.createTextNode(retourEjb.getResultat().getTelCompteClient()));
            
            cptClient.appendChild(idClient);
            cptClient.appendChild(nom);
            cptClient.appendChild(prenom);
            cptClient.appendChild(adresse);
            cptClient.appendChild(email);
            cptClient.appendChild(telephone);
            
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

    private static void fillXmlAdresse(Document doc, Element elemAdresse, Adresse adresseCompteClient)
    {
        if(adresseCompteClient == null)
        {
            elemAdresse.appendChild(doc.createTextNode("Aucune adresse connue"));
        }
        else
        {
            Element numRue = doc.createElement("numeroRue");
            Element nomRue = doc.createElement("nomRue");
            Element codePostal = doc.createElement("codePostal");
            Element ville = doc.createElement("ville");
            
            numRue.appendChild(doc.createTextNode(adresseCompteClient.getNumRue()));
            nomRue.appendChild(doc.createTextNode(adresseCompteClient.getNomRue()));
            codePostal.appendChild(doc.createTextNode(adresseCompteClient.getCodePostal()));
            ville.appendChild(doc.createTextNode(adresseCompteClient.getVille()));
            
            elemAdresse.appendChild(numRue);
            elemAdresse.appendChild(nomRue);
            elemAdresse.appendChild(codePostal);
            elemAdresse.appendChild(ville);
        }
    }
}
