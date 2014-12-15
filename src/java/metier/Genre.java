/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

/**
 *
 * @author sylvainbron
 */
public class Genre {
    
    private int idGenre;
    private String nomGenre;
    private String referenceGenre;
    
    public Genre (int idGenre, String nomGenre)
    {
        setIdGenre(idGenre);
        setNomGenre(nomGenre);
    }

    public Genre() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(int idGenre) {
        this.idGenre = idGenre;
    }

    public String getNomGenre() {
        return nomGenre;
    }

    public void setNomGenre(String titreGenre) {
        this.nomGenre = titreGenre;
    }

    public String getReferenceGenre() {
        return referenceGenre;
    }

    public void setReferenceGenre(String referenceGenre) {
        this.referenceGenre = referenceGenre;
    }
    
    public void creerGenre()
    {
        
    }
    
}
