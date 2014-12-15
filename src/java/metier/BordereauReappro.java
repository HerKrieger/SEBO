/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

/**
 *
 * @author jean
 */
public class BordereauReappro
{
    private String format;
    private String contenu;
    private Fournisseur fournisseur;

    public Fournisseur getFournisseur()
    {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public BordereauReappro(String format, String contenu)
    {
        this.format = format;
        this.contenu = contenu;
    }
    public String getFormat()
    {
        return format;
    }

    public void setFormat(String format)
    {
        this.format = format;
    }

    public String getContenu()
    {
        return contenu;
    }

    public void setContenu(String contenu)
    {
        this.contenu = contenu;
    }
}