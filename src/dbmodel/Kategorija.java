package dbmodel;



import java.util.HashSet;
import java.util.Set;

/**
 * Kategorija generated by hbm2java
 */
public class Kategorija  implements java.io.Serializable {


     private Integer idkategorije;
     private String nazivkategorije;
     private Set vozilos = new HashSet(0);

    public Kategorija() {
    }

    public Kategorija(String nazivkategorije, Set vozilos) {
       this.nazivkategorije = nazivkategorije;
       this.vozilos = vozilos;
    }
   
    public Integer getIdkategorije() {
        return this.idkategorije;
    }
    
    public void setIdkategorije(Integer idkategorije) {
        this.idkategorije = idkategorije;
    }
    public String getNazivkategorije() {
        return this.nazivkategorije;
    }
    
    public void setNazivkategorije(String nazivkategorije) {
        this.nazivkategorije = nazivkategorije;
    }
    public Set getVozilos() {
        return this.vozilos;
    }
    
    public void setVozilos(Set vozilos) {
        this.vozilos = vozilos;
    }




}

