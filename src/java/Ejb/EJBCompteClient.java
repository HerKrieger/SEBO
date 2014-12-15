/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb;

import interfaces.EJBCompteClientLocal;
import javax.ejb.Stateless;
import metier.Adresse;
import metier.CompteClient;
import metier.Retour;

/**
 *
 * @author gruselle
 */
@Stateless
public class EJBCompteClient implements EJBCompteClientLocal 
{
    private CompteClient compteCli = new CompteClient();
    
    @Override
    public int getIdCompteClient() 
    {
        return compteCli.getIdCompteClient();
    }

    @Override
    public String getNomCompteClient() 
    {
        return compteCli.getNomCompteClient();
    }

    @Override
    public String getPrenomCompteClient() 
    {
        return compteCli.getPrenomCompteClient();
    }

    @Override
    public Adresse getAdresseCompteClient() 
    {
        return compteCli.getAdresseCompteClient();
    }

    @Override
    public String getEmailCompteClient() 
    {
        return compteCli.getEmailCompteClient();
    }

    @Override
    public String getMdpCompteClient() 
    {
        return compteCli.getMdpCompteClient();
    }

    @Override
    public String getTelCompteClient() 
    {
        return compteCli.getTelCompteClient();
    }

    @Override
    public Retour<CompteClient> creerCompteClient(String nom, String prenom, String telephone, String email, String motDePasse,
                                                  String numeroRue, String nomRue, String codePostal, String ville) 
    {
        compteCli.setNomCompteClient(nom);
        compteCli.setPrenomCompteClient(prenom);
        compteCli.setTelCompteClient(telephone);
        compteCli.setEmailCompteClient(email);
        compteCli.setMdpCompteClient(motDePasse);

        Adresse lAdresse = new Adresse(numeroRue, nomRue, codePostal, ville);
                
        compteCli.setAdresseCompteClient(lAdresse);
        
        return compteCli.insertIntoBDD();
    }

    @Override
    public void modifierCompteClient() 
    {
        compteCli.modifierCompteClient();
    }

    @Override
    public void ajouterAdresse() 
    {
        compteCli.ajouterAdresse();
    }

    @Override
    public void modifierAdresse() 
    {
        compteCli.modifierAdresse();
    }

    @Override
    public void supprimerAdresse() 
    {
        compteCli.supprimerAdresse();
    }

    @Override
    public void seConnecter() 
    {
        compteCli.seConnecter();
    }

    @Override
    public void seDeconnecter() 
    {
        compteCli.seDeconnecter();
    }
}
