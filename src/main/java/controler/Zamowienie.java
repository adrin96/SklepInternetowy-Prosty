
package controler;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Zamowienie {
    
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private int id_pracownika;
    private int id_koszyka;
    private String data;
    
       
    @ManyToOne
    private Pracownik pracownik;
    
    @OneToOne 
    private Koszyk koszyk;
    
    
    public Zamowienie(){      
    }

    public Zamowienie(int id_pracownika,int id_koszyka, String data) {
        pracownik = null;
        koszyk = null;
        this.id_pracownika = id_pracownika;
        this.id_koszyka = id_koszyka;
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    
    
    public int getId_koszyka() {
        return id_koszyka;
    }

    public void setId_koszyka(int id_koszyka) {
        this.id_koszyka = id_koszyka;
    }

    public Koszyk getKoszyk() {
        return koszyk;
    }

    public void setKoszyk(Koszyk koszyk) {
        this.koszyk = koszyk;
    }

    
    public int getId_pracownika() {
        return id_pracownika;
    }

    public void setId_pracownika(int id_pracownika) {
        this.id_pracownika = id_pracownika;
    }


  
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public Pracownik getPracownik() {
        return pracownik;
    }

    public void setPracownik(Pracownik pracownik) {
        this.pracownik = pracownik;
    }


 
          
 
 
    
}
