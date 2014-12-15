/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb;

import java.util.Date;
import javax.ejb.Stateless;
import metier.Administrateur;
import interfaces.EJBAdministrateurLocal;
import metier.Retour;

/**
 *
 * @author Frontoni
 */
@Stateless
public class        EJBAdministrateur implements EJBAdministrateurLocal
{
    Administrateur  admin;
    
    public  EJBAdministrateur() 
    {
        admin = new Administrateur();
    }

    @Override
    public Retour   modificationFrequencePurge(int nbJours)
    {
        return admin.modificationFrequencePurge(nbJours);
    }

    @Override
    public Retour   modificationDatePurge(Date date)
    {
        return admin.modificationDatePurge(date);
    }

    @Override
    public Retour   dureeSauvegardeArchive(int nbMois)
    {
        return admin.dureeSauvegardeArchive(nbMois);
    }

    @Override
    public Retour   ajouterUnRole(String nom, String role)
    {
        return admin.ajouterUnRole(nom, role);
    }

    @Override
    public Retour   supprimerUnRole(String nom, String role)
    {
        return admin.supprimerUnRole(nom, role);
    }

    @Override
    public Retour   desactiverUnCompte(String nom)
    {
        return admin.desactiverUnCompte(nom);
    }

    @Override
    public Retour   recupererSalaries()
    {
        return admin.recupererSalaries();
    }

    @Override
    public Retour   creerCompteSalarie(String nom)
    {
        return admin.creerCompteSalarie(nom);
    }
}
