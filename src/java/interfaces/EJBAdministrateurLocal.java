/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.Date;
import javax.ejb.Local;
import metier.Retour;

/**
 *
 * @author Frontoni
 */
@Local
public interface    EJBAdministrateurLocal
{
    Retour  creerCompteSalarie(String nom);
    
    Retour  ajouterUnRole(String nom, String role);
    
    Retour  supprimerUnRole(String nom, String role);
    
    Retour  desactiverUnCompte(String nom);
    
    Retour  modificationFrequencePurge(int nbJours);
    
    Retour  modificationDatePurge(Date date);
    
    Retour  dureeSauvegardeArchive(int nbMois);
    
    Retour  recupererSalaries();
}
