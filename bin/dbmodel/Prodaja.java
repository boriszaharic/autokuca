// default package
// Generated Apr 27, 2014 10:29:38 AM by Hibernate Tools 3.4.0.CR1

package dbmodel;
import java.util.Date;

/**
 * Prodaja generated by hbm2java
 */
public class Prodaja  implements java.io.Serializable {


     private Integer idprodaje;
     private Vozilo vozilo;
     private Prodavac prodavac;
     private Date datum;

    public Prodaja() {
    }

	
    public Prodaja(Vozilo vozilo, Prodavac prodavac) {
        this.vozilo = vozilo;
        this.prodavac = prodavac;
    }
    public Prodaja(Vozilo vozilo, Prodavac prodavac, Date datum) {
       this.vozilo = vozilo;
       this.prodavac = prodavac;
       this.datum = datum;
    }
   
    public Integer getIdprodaje() {
        return this.idprodaje;
    }
    
    public void setIdprodaje(Integer idprodaje) {
        this.idprodaje = idprodaje;
    }
    public Vozilo getVozilo() {
        return this.vozilo;
    }
    
    public void setVozilo(Vozilo vozilo) {
        this.vozilo = vozilo;
    }
    public Prodavac getProdavac() {
        return this.prodavac;
    }
    
    public void setProdavac(Prodavac prodavac) {
        this.prodavac = prodavac;
    }
    public Date getDatum() {
        return this.datum;
    }
    
    public void setDatum(Date datum) {
        this.datum = datum;
    }




}

