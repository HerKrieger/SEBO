/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import javax.ejb.Local;
import metier.Adresse;
import metier.CompteClient;
import metier.Retour;

/**
 *
 * @author gruselle
 */
@Local
public interface EJBCompteClientLocal 
{
    int getIdCompteClient();
    String getNomCompteClient();
    String getPrenomCompteClient();
    Adresse getAdresseCompteClient();
    String getEmailCompteClient();
    String getMdpCompteClient();
    String getTelCompteClient();
    Retour<CompteClient> creerCompteClient(String nom, String prenom, String telephone, String email, String motDePasse, String numeroRue, String nomRue, String codePostal, String ville);
    void modifierCompteClient();
    void ajouterAdresse();
    void modifierAdresse();
    void supprimerAdresse();
    void seConnecter();
    void seDeconnecter();
}
