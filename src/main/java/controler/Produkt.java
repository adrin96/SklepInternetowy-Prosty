package controler;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Produkt {
    
     
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String nazwa;
    private int ilosc;
    private double cena;
    private int id_koszyka;
    
    
    @ManyToMany
    private Set<Koszyk> koszyk;
    
    
    public Produkt(){
        
    }
    
 public Produkt(Long id, String nazwa,int ilosc, double cena) {
        this.id = id;
        this.ilosc = ilosc;
        this.nazwa = nazwa;
        this.cena = cena;
        koszyk = new HashSet<Koszyk>();
    }
    
    
    public Produkt(String nazwa,int ilosc, double cena) {
        this.ilosc = ilosc;
        this.nazwa = nazwa;
        this.cena = cena;
        koszyk = new HashSet<Koszyk>();
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }
    
     @Override
    public String toString() {
        return String.format("Produkt[id=%d, nazwa='%s', cena='%.2f]",id,nazwa,cena);
    }

       public int getId_koszyka() {
        return id_koszyka;
    }

    public void setId_koszyka(int id_koszyka) {
        this.id_koszyka = id_koszyka;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }


    public double getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public Set<Koszyk> getKoszyk() {
        return koszyk;
    }

    public void setKoszyk(Set<Koszyk> koszyk) {
        this.koszyk = koszyk;
    }
    
    
    
    
}
