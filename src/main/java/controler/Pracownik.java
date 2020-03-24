package controler;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Pracownik {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String imie;
    private String nazwisko;
    private String stanowisko;
    private float placa;

      
    @OneToMany(mappedBy = "pracownik")
    private Set<Zamowienie> zamowienie;

    protected Pracownik() {
    }

    public Pracownik(String imie, String nazwisko, String stanowisko, float placa) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.stanowisko = stanowisko;
        this.placa = placa;
        zamowienie = new HashSet<Zamowienie>();
    }

    Pracownik(Long id_pracownika, String imie, String nazwisko, String stanowisko, float placa) {
        this.id = id_pracownika;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.stanowisko = stanowisko;
        this.placa = placa;
        zamowienie = new HashSet<Zamowienie>();
    }

    @Override
    public String toString() {
        return String.format(
                "Pracownik[id=%d, imie='%s', nazwisko='%s', placa='%f', stanowisko='%s']", id, imie, nazwisko, placa, stanowisko);
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

    public float getPlaca() {
        return placa;
    }

    public void setPlaca(float placa) {
        this.placa = placa;
    }

    public String getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    public Set<Zamowienie> getZamowienie() {
        return zamowienie;
    }

    public void setZamowienie(Set<Zamowienie> zamowienie) {
        this.zamowienie = zamowienie;
    }

}
