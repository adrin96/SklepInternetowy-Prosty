package controler;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MyController {

    @Autowired
    PracownikRepository pracownikRepository;

    @Autowired
    KlientRepository klientRepository;

    @Autowired
    ZamowienieRepository zamowienieRepository;

    @Autowired
    KoszykRepository koszykRepository;

    @Autowired
    ProduktRepository produktRepository;

    @Autowired
    KlientKoszykRepository klientKoszykRepository;
    
    static double suma = 0;
   
    @RequestMapping("/client")
    public String clientPage() {
        return "client";

    }


    @RequestMapping("/dodaj_klienta")
    public String dodajKlient(Model model) {
        TransData transData = new TransData();
        model.addAttribute("transData", transData);
        return "dodajKlienta";
    }

    @RequestMapping(value = "/dodaj_klienta", method = RequestMethod.POST)
    public String dodajKlient(Model model, TransData transData) {
        String imie = transData.getImie();
        String nazwisko = transData.getNazwisko();
        int telefon = Integer.parseInt(transData.getTelefon());
        String adres = transData.getAdres();

        klientRepository.save(new Klient(imie, nazwisko, telefon, adres));

        model.addAttribute("header", "Wstawiono do bazy klienta");
        model.addAttribute("message", "" + imie + " " + nazwisko);
        return "viewmessagePracownik";
    }

    @RequestMapping("/nowy_klient")
    public String nowy_Klient(Model model) {
        TransData transData = new TransData();
        model.addAttribute("transData", transData);
        return "nowyKlient";
    }

    @RequestMapping(value = "/nowy_klient", method = RequestMethod.POST)
    public String nowy_Klient(Model model, TransData transData) {
        String imie = transData.getImie();
        String nazwisko = transData.getNazwisko();
        int telefon = Integer.parseInt(transData.getTelefon());
        String adres = transData.getAdres();

        klientRepository.save(new Klient(imie, nazwisko, telefon, adres));

        model.addAttribute("header", "Utworzono nowego klienta");
        model.addAttribute("message", "" + imie + " " + nazwisko + " " + telefon + " " + adres);
        return "viewmessage";
    }

///edytuj_pracownika
    @RequestMapping("/edytuj_pracownikow/{id}")
    public String edytujPracownik(Model model, TransData transData, @PathVariable(name = "id") Long id) {
        Pracownik pracownik = pracownikRepository.findByid(id).get(0);

        long id_pracownika = pracownik.getId();
        String imie = pracownik.getImie();
        String nazwisko = pracownik.getNazwisko();
        String stanowisko = pracownik.getStanowisko();
        float placa = pracownik.getPlaca();

        System.out.println("ID " + id_pracownika + "imie " + imie + " nazwisko " + nazwisko + " stanowisko " + stanowisko + " placa " + placa);

        model.addAttribute("id", id_pracownika);
        model.addAttribute("nazwa", imie);
        model.addAttribute("nazwisko", nazwisko);
        model.addAttribute("stanowisko", stanowisko);
        model.addAttribute("placa", placa);

        model.addAttribute("transData", transData);
        return "edytujPracownikow";

    }

    @RequestMapping(value = "/edytuj_pracownikow", method = RequestMethod.POST)
    public String edytujPracownik(Model model, TransData transData) {
        Long id_pracownika = Long.parseLong(transData.getId());
        String imie = transData.getImie();
        String nazwisko = transData.getNazwisko();
        String stanowisko = transData.getStanowisko();
        float placa = Float.parseFloat(transData.getPlaca());

        pracownikRepository.save(new Pracownik(id_pracownika, imie, nazwisko, stanowisko, placa));

        model.addAttribute("header", "Zaktualizowano w bazie danych pracownika ");
        model.addAttribute("message", "" + imie + " " + nazwisko + " " + stanowisko + " " + placa);
        return "viewmessageAdmin";
    }

    //edytuj pracownika
    @RequestMapping("/edytuj_produkty/{id}")
    public String edytujProdukt(Model model, TransData transData, @PathVariable(name = "id") Long id) {

        Produkt produkt = produktRepository.findByid(id).get(0);

        long id_produktu = produkt.getId();
        String nazwa = produkt.getNazwa();
        int ilosc = produkt.getIlosc();
        double cena = produkt.getCena();

        System.out.println("id_produktu " + id + "nazwa " + nazwa + " ilosc " + ilosc + " cena " + cena);

        model.addAttribute("id", id_produktu);
        model.addAttribute("nazwa", nazwa);
        model.addAttribute("ilosc", ilosc);
        model.addAttribute("cena", cena);

        model.addAttribute("transData", transData);
        return "edytujProdukty";
    }

    @RequestMapping(value = "/edytuj_produkty", method = RequestMethod.POST)
    public String edytujProdukt(Model model, TransData transData) {

        Long id_produktu = Long.parseLong(transData.getId());
        String nazwa = transData.getNazwa();
        double cena = Double.parseDouble(transData.getCena());
        int ilosc = Integer.parseInt(transData.getIlosc());

        produktRepository.save(new Produkt(id_produktu, nazwa, ilosc, cena));

        model.addAttribute("header", "Zaktualizowano w bazie danych produkt ");
        model.addAttribute("message", "" + nazwa + " " + cena);
        return "viewmessagePracownik";
    }

    @RequestMapping("/edytuj_klienta/{id}")
    public String edytujKlient(Model model, TransData transData, @PathVariable(name = "id") Long id) {
        Klient klient = klientRepository.findByid(id).get(0);

        long id_klienta = klient.getId();
        String imie_klienta = klient.getImie();
        String nazwisko = klient.getNazwisko();
        String adres = klient.getAdres();
        int telefon = klient.getTelefon();

        System.out.println("id_klienta " + id + "imie " + imie_klienta + " nazwisko " + nazwisko + " adres " + adres + " telefon " + telefon);

        model.addAttribute("id", id_klienta);
        model.addAttribute("imie", imie_klienta);
        model.addAttribute("nazwisko", nazwisko);
        model.addAttribute("adres", adres);
        model.addAttribute("telefon", telefon);

        model.addAttribute("transData", transData);
        return "edytujKlienta";
    }

    @RequestMapping(value = "/edytuj_klienta", method = RequestMethod.POST)
    public String edytujKlient(Model model, TransData transData) {

        Long id_klienta = Long.parseLong(transData.getId());
        String imie = transData.getImie();
        String nazwisko = transData.getNazwisko();
        int telefon = Integer.parseInt(transData.getTelefon());
        String adres = transData.getAdres();

        klientRepository.save(new Klient(id_klienta, imie, nazwisko, telefon, adres));

        model.addAttribute("header", "Zaktualizowano dane klienta");
        model.addAttribute("message", "" + imie + " " + nazwisko + " " + telefon + " " + adres);
        return "viewmessagePracownik";
    }

    @RequestMapping("/dodaj_pracownika")
    public String dodajPracownik(Model model) {
        TransData transData = new TransData();
        model.addAttribute("transData", transData);
        return "dodajPracownika";
    }

    @RequestMapping(value = "/dodaj_pracownika", method = RequestMethod.POST)
    public String dodajPracownik(Model model, TransData transData) {
        String imie = transData.getImie();
        String nazwisko = transData.getNazwisko();
        String stanowisko = transData.getStanowisko();
        float placa = Float.parseFloat(transData.getPlaca());

        pracownikRepository.save(new Pracownik(imie, nazwisko, stanowisko, placa));

        model.addAttribute("header", "Wstawiono do bazy pracownika:");
        model.addAttribute("message", imie + " " + nazwisko + " " + stanowisko + " " + placa);
        return "viewmessageAdmin";
    }

    @RequestMapping(value = "/wyswietl_koszyk", method = RequestMethod.GET)
    public String wyswietlKoszyk(Model model) {

        List<Koszyk> koszykList = koszykRepository.findAll();

        model.addAttribute("header", "Lista wszystkich koszyków");
        model.addAttribute("koszykList", koszykList);

        return "wyswietlKoszyk";

    }

    @RequestMapping("/dodaj_produkt")
    public String dodajProdukt(Model model) {
        TransData transData = new TransData();
        model.addAttribute("transData", transData);
        return "dodajProdukt";
    }

    @RequestMapping(value = "/dodaj_produkt", method = RequestMethod.POST)
    public String dodajProdukt(Model model, TransData transData) {

        String nazwa = transData.getNazwa();
        int ilosc = Integer.parseInt(transData.getIlosc());
        Double cena = Double.parseDouble(transData.getCena());

        produktRepository.save(new Produkt(nazwa, ilosc, cena));

        model.addAttribute("header", "Wstawiono nowy produkt do bazy");
        model.addAttribute("message", "" + nazwa);
        return "viewmessagePracownik";
    }

    @RequestMapping(value = "/wyswietl_klientow", method = RequestMethod.GET)
    public String wyswietlKlientow(Model model) {

        List<Klient> klientList = klientRepository.findAll();

        model.addAttribute("header", "Lista wszystkich klientów");
        model.addAttribute("klientList", klientList);

        return "wyswietlKlienta";

    }

    @RequestMapping("/koniec_zamowienia")
    public String koniecZamowienia(Model model) {

        klientKoszykRepository.deleteAll();

        model.addAttribute("komunikat", "Dziękujemy za zakupy!");

        Klient klient = klientRepository.findByImie("Adrian");
        Pracownik pracownik = pracownikRepository.findByImie("Magda");

        int id_pracownika = pracownik.getId().intValue();
        int id_klienta = klient.getId().intValue();

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String data = formatter.format(date);

        Zamowienie zamowienie = new Zamowienie(id_pracownika, id_klienta, data);
        zamowienieRepository.save(zamowienie);
        pracownik.getZamowienie().add(zamowienie);

        zamowienie.setPracownik(pracownik);
        zamowienieRepository.save(zamowienie);
        pracownikRepository.save(pracownik);

        return "koniecZamowienia";
    }

    @RequestMapping(value = "/wyswietl_klientow/{id}")
    public String wyswietlKlientowUsun(Model model, TransData transData, @PathVariable(name = "id") Long id) {

        Long coUsunac = Long.parseLong(transData.getId());
        List<Klient> klientList = klientRepository.findByid(coUsunac);

        long id_klienta = klientList.get(0).getId();
        String coUsunieto = klientList.get(0).toString();
        klientRepository.deleteById(id_klienta);
        model.addAttribute("header", "Usunięto klienta");
        model.addAttribute("message", "" + coUsunieto);
        return "viewmessagePracownik";

    }

    @RequestMapping(value = "/realizacja_zamowienia")
    public String realizacjaZamowienia(Model model, TransData transData) {

        List<KlientKoszyk> produktyList = klientKoszykRepository.findAll();
        model.addAttribute("produktyList", produktyList);

        Klient klientList = klientRepository.findByImie("Adrian");

        suma = 0.00;
        for (int i = 0; i < produktyList.size(); i++) {
            suma += produktyList.get(i).getCena();
            System.out.println("Suma: " + suma);
        }

        model.addAttribute("suma", "" + suma);
        suma += 15.00;
        model.addAttribute("sumaDostawa", "" + suma);

        model.addAttribute("produktyList", produktyList);
        model.addAttribute("klientList", klientList);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String data = formatter.format(date);

        model.addAttribute("data", data);

        return "realizacjaZamowienia";

    }

    @RequestMapping(value = "/wyswietl_pracownikow", method = RequestMethod.GET)
    public String wyswietlpracownikow(Model model) {

        List<Pracownik> pracownikList = pracownikRepository.findAll();

        // model.addAttribute("header","Lista wszystkich pracownikow"); 
        model.addAttribute("pracownikList", pracownikList);

        return "wyswietlPracownika";

    }

    @RequestMapping(value = "/wyswietl_pracownikow/{id}")
    public String wyswietlpracownikowUsun(Model model, TransData transData, @PathVariable(name = "id") Long id) {

        Long coUsunac = Long.parseLong(transData.getId());
        List<Pracownik> pracownikList = pracownikRepository.findByid(coUsunac);

        long id_pracownika = pracownikList.get(0).getId();
        String coUsunieto = pracownikList.get(0).toString();
        pracownikRepository.deleteById(id_pracownika);
        model.addAttribute("header", "Usunięto pracownika");
        model.addAttribute("message", coUsunieto);
        return "viewmessageAdmin";

    }

    @RequestMapping(value = "/wyswietl_zamowienia", method = RequestMethod.GET)
    public String wyswietlzamowienia(Model model) {


        List<Zamowienie> zamowieniaList = zamowienieRepository.findAll();
        Pracownik pracownik  = pracownikRepository.findByImie("Magda");
        Klient klient = klientRepository.findByImie("Adrian");
        
        System.out.println("Pracownik"+pracownik.getImie() + " Nazwisko "+pracownik.getNazwisko());
        System.out.println("klient"+klient.getImie() + " Nazwisko "+klient.getNazwisko());
 
        
        model.addAttribute("header", "Lista wszystkich zamówień");
        model.addAttribute("zamowieniaList", zamowieniaList);
        model.addAttribute("pracownik",pracownik);
        model.addAttribute("klient",klient);
        
        return "wyswietlZamowienia";
    }

    @RequestMapping(value = "/wyswietl_zamowienia/{id}")
    public String wyswietlzamowieniaUsun(Model model, TransData transData, @PathVariable(name = "id") Long id) {

        Long coUsunac = Long.parseLong(transData.getId());
        List<Zamowienie> zamowieniaList = zamowienieRepository.findByid(coUsunac);

        long id_zamowienia = zamowieniaList.get(0).getId();
        zamowienieRepository.deleteById(id_zamowienia);

        model.addAttribute("header", "Usunięto zamowienie:");
        model.addAttribute("message", "" + id_zamowienia);
        return "viewmessagePracownik";

    }

    @RequestMapping(value = "/wyswietl_produkty_pracownik")
    public String wyswietlproduktpracownik(Model model) {

        List<Produkt> produktyList = produktRepository.findAll();

        if (produktyList.isEmpty()) {
            List<KlientKoszyk> produktyListKlient = klientKoszykRepository.findAll();
            model.addAttribute("produktyList", produktyListKlient); //Dodanie obiektu do pamieci lokalnej modelu
        }

        model.addAttribute("header", "Lista wszystkich produktów"); //Dodanie obiektu do pamieci lokalnej modelu
        model.addAttribute("produktyList", produktyList); //Dodanie obiektu do pamieci lokalnej modelu
        return "wyswietlProduktyPracownik";

    }

    @RequestMapping(value = "/wyswietl_produkty_pracownik/{id}")
    public String wyswietlproduktPracownik(Model model, TransData transData, @PathVariable(name = "id") Long id) {
        Long coUsunac = Long.parseLong(transData.getId());
        List<Produkt> produktList = produktRepository.findByid(coUsunac);

        long id_produktu = produktList.get(0).getId();
        String coUsunieto = produktList.get(0).toString();
        produktRepository.deleteById(id_produktu);
        model.addAttribute("header", "Usunięto produkt");
        model.addAttribute("message", "" + coUsunieto);
        return "viewmessagePracownik";

    }

    @RequestMapping(value = "/wyswietl_produkty")
    public String wyswietlprodukt(Model model) {

        
        List<Produkt> produktyList = produktRepository.findAll();

        boolean wyswietlanie_komunikatu = false;

        //DO USUWANIA KONKRETNEGO PRODUKTU 
//        String liczba = "5";
//        Long id = Long.parseLong(liczba);
//        System.out.println("CO USUWAM: " + id);
//
//        for (int i = 0; i < produktyList.size(); i++) {
//            if (produktyList.get(i).getId() == id) {
//                produktyList.remove(i);
//            }
//        }

        //produktyList.remove(produktRepository.findByid(id));
        List<KlientKoszyk> klientKoszyk = klientKoszykRepository.findAll();
        int liczba_produktow = klientKoszyk.size();

        if (produktyList.isEmpty()) {
            wyswietlanie_komunikatu = true;
            model.addAttribute("liczba_produktow", "Liczba produktów: " + liczba_produktow);
            model.addAttribute("wyswietlanie_komunikatu", wyswietlanie_komunikatu);
            model.addAttribute("komunikat", "Zapraszamy do sklepu, po uzupełnieniu towarów!");
            return "wyswietlProdukty";

        }

        List<Integer> tempProduktId = new ArrayList<Integer>();

        List<Koszyk> koszykList = koszykRepository.findAll();

        for (int i = 0; i < koszykList.size(); i++) {
            //  System.out.println("Id produktu do usuniecia: " + koszykList.get(i).getId_produktu());
            tempProduktId.add(koszykList.get(i).getId_produktu());

        }

        List<Produkt> tempProduktList = produktyList;

        for (int i = 0; i < tempProduktId.size(); i++) {
            tempProduktList.remove(tempProduktId.get(i));
            //  System.out.println("Co usuwam: " + tempProduktId.get(i));
        }

        model.addAttribute("wyswietlanie_komunikatu", wyswietlanie_komunikatu);
        model.addAttribute("liczba_produktow", "Liczba produktów: " + liczba_produktow);
        model.addAttribute("header", "Lista wszystkich produktow");
        model.addAttribute("produktyList", produktyList);

        return "wyswietlProdukty";

    }

    @RequestMapping(value = "/wyswietl_produkty/{id}")
    public String wyswietlproduktUsunKup(Model model, TransData transData, @PathVariable(name = "id") Long id) {

        Long coUsunac = Long.parseLong(transData.getId());
        List<Produkt> produktList = produktRepository.findByid(coUsunac);

        long id_produktu = produktList.get(0).getId();
        String produkt = produktList.get(0).toString();
        produktRepository.deleteById(id_produktu);

        String nazwa = produktList.get(0).getNazwa();
        int ilosc = produktList.get(0).getIlosc();
        double cena = produktList.get(0).getCena();

        klientKoszykRepository.save(new KlientKoszyk(nazwa, ilosc, cena));

        model.addAttribute("header", "Dodano do koszyka: ");
        model.addAttribute("message", "" + nazwa);

        return "viewmessageKoszyk";

    }

    @RequestMapping(value = "/wyswietl_koszyk_klienta")
    public String wyswietlproduktKlienta(Model model) {

        List<KlientKoszyk> produktyList = klientKoszykRepository.findAll();
        model.addAttribute("produktyList", produktyList);
        boolean wyswietlanie_komunikatu = false;

         suma = 0;
        for (int i = 0; i < produktyList.size(); i++) {
            suma += produktyList.get(i).getCena();
            System.out.println("Suma: " + suma);
        }

        if (produktyList.size() > 0) {
            wyswietlanie_komunikatu = true;
            model.addAttribute("wyswietlanie_komunikatu", wyswietlanie_komunikatu);
        }

        model.addAttribute("wyswietlanie_komunikatu", wyswietlanie_komunikatu);
        model.addAttribute("suma", "" + suma);
        return "klientKoszyk";

    }

    @RequestMapping(value = "/wyswietl_koszyk_klienta/{id}")
    public String wyswietlprodukt(Model model, TransData transData, @PathVariable(name = "id") Long id) {
        Long coUsunac = Long.parseLong(transData.getId());
        KlientKoszyk klient_koszyk = klientKoszykRepository.findByid(coUsunac).get(0);

        long id_produktu = klient_koszyk.getId();
        klientKoszykRepository.deleteById(id_produktu);

        String nazwa = klient_koszyk.getPrzedmiot();
        int ilosc = klient_koszyk.getIlosc();
        double cena = klient_koszyk.getCena();

        produktRepository.save(new Produkt(nazwa, ilosc, cena));
        System.out.println("nazwa" + nazwa + " " + cena);
        model.addAttribute("header", "Usunięto z koszyka: ");
        model.addAttribute("message", "" + nazwa);
        return "viewmessageKoszyk";

    }

    @RequestMapping(value = "/wyswietl_koszyk_klienta_dodaj/{id}")
    public String wyswietlproduktv2(Model model, TransData transData, @PathVariable(name = "id") Long id) {

        List<KlientKoszyk> klient_koszyk = klientKoszykRepository.findByid(id);
        System.out.println("Rozmiar tabeli: " + klient_koszyk.size());
        String nazwa;
        int ilosc;
        Double cena;

        for (KlientKoszyk klientKoszyk : klient_koszyk) {
            nazwa = klientKoszyk.getPrzedmiot();
            ilosc = klientKoszyk.getIlosc();
            cena = klientKoszyk.getCena();
            System.out.println("Dodano: " + nazwa + " ilosc " + ilosc + " cena: " + cena);
            KlientKoszyk klient_koszyk_1 = new KlientKoszyk(nazwa, ilosc, cena);
            klientKoszykRepository.save(klient_koszyk_1);
        }

        klientKoszykRepository.save(new KlientKoszyk("Przedmiot", 2, 50));
        return "klientKoszyk";

    }

    @RequestMapping("/dodaj_zamowienie")
    public String dodajZamowienie(Model model) {
        TransData transData = new TransData();
        model.addAttribute("transData", transData);
        return "dodajZamowienie";
    }

    @RequestMapping(value = "/dodaj_zamowienie", method = RequestMethod.POST)
    public String dodajZamowienie(Model model, TransData transData) {

        int id_pracownika = Integer.parseInt(transData.getId_pracownika());
        int id_koszyka = Integer.parseInt(transData.getId_koszyka());

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String data = formatter.format(date);

        zamowienieRepository.save(new Zamowienie(id_pracownika, id_koszyka, data));

        model.addAttribute("header", "Wstawiono nowe zamowienia do bazy");
        model.addAttribute("message", "" + id_pracownika + " " + id_koszyka);
        return "viewmessagePracownik";
    }

    @RequestMapping("/usun_pracownika")
    public String deleteEmplyee(Model model) {
        TransData transData = new TransData();
        model.addAttribute("transData", transData);
        return "usunPracownika";
    }

    @RequestMapping(value = "/usun_pracownika", method = RequestMethod.POST)
    public String deleteEmplyee(Model model, TransData transData) {
        Long coUsunac = Long.parseLong(transData.getId());
        List<Pracownik> pracownikList = pracownikRepository.findByid(coUsunac);

        if (pracownikList.size() == 0) {
            model.addAttribute("header", "Wynik");
            model.addAttribute("message", "Nie ma takiego pracownika");
            return "viewmessage";
        } else {
            long id_pracownika = pracownikList.get(0).getId();
            String coUsunieto = pracownikList.get(0).toString();
            pracownikRepository.deleteById(id_pracownika);
            model.addAttribute("header", "Wynik");
            model.addAttribute("message", "Usunięto pracownika: " + coUsunieto);
            return "viewmessage";
        }
    }

    @RequestMapping("/usun_produkt")
    public String usunProdukt(Model model) {
        TransData transData = new TransData();
        model.addAttribute("transData", transData);
        return "usunProdukt";
    }

    @RequestMapping(value = "/usun_produkt", method = RequestMethod.POST)
    public String usunProdukt(Model model, TransData transData) {
        Long coUsunac = Long.parseLong(transData.getId());
        List<Produkt> produktList = produktRepository.findByid(coUsunac);

        if (produktList.size() == 0) {
            model.addAttribute("header", "Wynik");
            model.addAttribute("message", "Nie ma takiego produktu");
            return "viewmessage";
        } else {
            long id_produktu = produktList.get(0).getId();
            String coUsunieto = produktList.get(0).toString();
            produktRepository.deleteById(id_produktu);
            model.addAttribute("header", "Wynik");
            model.addAttribute("message", "Usunięto produkt: " + coUsunieto);
            return "viewmessage";
        }
    }

    @RequestMapping("/usun_klienta")
    public String deleteCustomer(Model model) {
        TransData transData = new TransData();
        model.addAttribute("transData", transData);
        return "usunKlienta";
    }

    @RequestMapping(value = "/usun_klienta", method = RequestMethod.POST)
    public String deleteCustomer(Model model, TransData transData) {
        Long coUsunac = Long.parseLong(transData.getId());
        List<Klient> klientList = klientRepository.findByid(coUsunac);

        if (klientList.size() == 0) {
            model.addAttribute("header", "Wynik");
            model.addAttribute("message", "Nie ma takiego klienta");
            return "viewmessage";
        } else {
            long id_klienta = klientList.get(0).getId();
            String coUsunieto = klientList.get(0).toString();
            klientRepository.deleteById(id_klienta);
            model.addAttribute("header", "Wynik");
            model.addAttribute("message", "Usunięto klienta: " + coUsunieto);
            return "viewmessage";
        }
    }

    @RequestMapping("/usun_zamowienie")
    public String deleteOrder(Model model) {
        TransData transData = new TransData();
        model.addAttribute("transData", transData);
        return "usunZamowienie";
    }

    @RequestMapping(value = "/usun_zamowienie", method = RequestMethod.POST)
    public String deleteOrder(Model model, TransData transData) {
        Long coUsunac = Long.parseLong(transData.getId());
        List<Zamowienie> zamowienieList = zamowienieRepository.findByid(coUsunac);

        if (zamowienieList.size() == 0) {
            model.addAttribute("header", "Wynik");
            model.addAttribute("message", "Nie ma takiego zamowienia");
            return "viewmessage";
        } else {
            long id_zamowienia = zamowienieList.get(0).getId();
            String coUsunieto = zamowienieList.get(0).toString();
            zamowienieRepository.deleteById(id_zamowienia);
            model.addAttribute("header", "Wynik");
            model.addAttribute("message", "Usunięto zamowienie: " + coUsunieto);
            return "viewmessage";
        }
    }

    @RequestMapping("/delete_one")
    public String deletePerson(Model model) {
        TransData transData = new TransData();
        model.addAttribute("transData", transData);
        return "deleteform";
    }

    @ExceptionHandler
    public String handlerException(Model model, Exception exception) {
        String message = exception.getMessage();
        model.addAttribute("errormessage", message);
        return "errorpage";
    }

}
