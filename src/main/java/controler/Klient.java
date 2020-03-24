
package controler;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Klient {
    
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String imie;
    private String nazwisko;
    private String adres;
    private int telefon;
    
    
    
    @OneToMany(mappedBy = "klient") 
    private Set<Koszyk> koszyk; 
    
    public Klient(){
        
    }
    
  public Klient(long id, String imie, String nazwisko, int telefon,String adres) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.telefon = telefon;
        this.adres = adres;
        koszyk = new HashSet<Koszyk>();
    }
  
  
    public Klient(String imie, String nazwisko, int telefon,String adres) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.telefon = telefon;
        this.adres = adres;
        koszyk = new HashSet<Koszyk>();
    }

          
    @Override
    public String toString() {
        return String.format(
                "Klient[id=%d, imie='%s', nazwisko='%s', telefon='%d', adres='%s']",id, imie, nazwisko,telefon,adres);
    }
    
    
    
    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    public Set<Koszyk> getKoszyk() {
        return koszyk;
    }

    public void setKoszyk(Set<Koszyk> koszyk) {
        this.koszyk = koszyk;
    }

 
    
}
