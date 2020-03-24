
package controler;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class KlientKoszyk {
    
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String przedmiot;
    private int ilosc;
    private double cena;
    
      
    public KlientKoszyk(){
        
    }

    public KlientKoszyk(String przedmiot, int ilosc, double cena) {
        this.przedmiot = przedmiot;
        this.ilosc = ilosc;
        this.cena = cena;
    }
   
    
   @Override
    public String toString() {
        return String.format(
                "Zamowienie[id=%d, przedmiot='%s', ilosc='%d', cena='%f']",id, przedmiot, ilosc,cena);
    }
  
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrzedmiot() {
        return przedmiot;
    }

    public void setPrzedmiot(String przedmiot) {
        this.przedmiot = przedmiot;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }


 
          
 
 
    
}
