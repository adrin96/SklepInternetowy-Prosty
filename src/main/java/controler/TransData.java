package controler;

public class TransData
{

    private String firstName;
    private String lastName;
    private String age;
    private String weight;
    private String sex;
    
    private String imie;
    private String nazwisko;
    private String adres;
    private String telefon;
    private String stanowisko;
    private String placa;
    private String przedmiot;
    private String ilosc;
    private String cena;
    private String id;
    private String nazwa;
    private String data;

    
    private String id_pracownika;
    private String id_klienta;
    private String id_koszyka;
    private String id_produktu;
    
    
    
      public TransData()
    {
        
        
        this.data = "";
        this.firstName = "";
        this.lastName = "";
        this.age = "";
        this.weight = "";
        this.sex = "";
        
        this.imie = "";
        this.nazwisko = "";
        this.adres = "";
        this.telefon = "";
        this.stanowisko = "";
        this.placa = "";
        this.przedmiot = "";
        this.ilosc = "";
        this.cena = "";
        this.id = "";
        this.nazwa = "";
        
        this.id_klienta = "";
        this.id_pracownika = "";
        this.id_koszyka = "";
        this.id_produktu = "";
        
    }

      
      
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
      
    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getId_produktu() {
        return id_produktu;
    }

    public void setId_produktu(String id_produktu) {
        this.id_produktu = id_produktu;
    }

    public String getId_pracownika() {
        return id_pracownika;
    }

    public void setId_pracownika(String id_pracownika) {
        this.id_pracownika = id_pracownika;
    }

    public String getId_klienta() {
        return id_klienta;
    }

    public void setId_klienta(String id_klienta) {
        this.id_klienta = id_klienta;
    }
      
      

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getPrzedmiot() {
        return przedmiot;
    }

    public void setPrzedmiot(String przedmiot) {
        this.przedmiot = przedmiot;
    }

    public String getIlosc() {
        return ilosc;
    }

    public void setIlosc(String ilosc) {
        this.ilosc = ilosc;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    public String getId_koszyka() {
        return id_koszyka;
    }

    public void setId_koszyka(String id_koszyka) {
        this.id_koszyka = id_koszyka;
    }
   

    
  

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }


}
