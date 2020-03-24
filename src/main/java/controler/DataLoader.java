package controler;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//Dodanie osob do repozytorium na samym poczatku
//SPring wszystkie komponenty w ten sposob mozna utworzyc jesli bedzie tak utworzoyn
@Component
public class DataLoader implements ApplicationRunner {

    private KlientRepository klientRepository;
    private ZamowienieRepository zamowienieRepository;
    private PracownikRepository pracownikRepository;
    private KoszykRepository koszykRepository;
    private ProduktRepository produktRepository;
    private KlientKoszykRepository klientKoszykRepository;

    @Autowired
    public DataLoader(KlientRepository klientRepository, ZamowienieRepository zamowienieRepository,
            PracownikRepository pracownikRepository, KoszykRepository koszykRepository,
            ProduktRepository produktRepository, KlientKoszykRepository klientKoszykRepository) {
        this.klientRepository = klientRepository;
        this.zamowienieRepository = zamowienieRepository;
        this.pracownikRepository = pracownikRepository;
        this.koszykRepository = koszykRepository;
        this.produktRepository = produktRepository;
        this.klientKoszykRepository = klientKoszykRepository;

    }

    public void run(ApplicationArguments args) {

        Pracownik pracownik_1 = new Pracownik("Janusz", "Kowalski", "Kierownik", 9000);
        Pracownik pracownik_2 = new Pracownik("Magda", "Rozek", "Sprzedawca", 2500);

        Klient klient_1 = new Klient("Adrian", "Kut", 123456789, "Test 110, 38-999 Testowo");
        Klient klient_2 = new Klient("Lukasz", "Lolek", 732736095, "Rzeszów 220");

        Produkt produkt_1 = new Produkt("8GB DDR3 3200MHz", 1, 300);
        Produkt produkt_2 = new Produkt("i5-9400F", 1, 900);
        Produkt produkt_3 = new Produkt("AMD Ryzen 5 2600", 1, 499.99);
        Produkt produkt_4 = new Produkt("Asus Horus GK2000 RGB Cherry MX Red", 1, 817);
        Produkt produkt_5 = new Produkt("ASUS XONAR DGX", 1, 210);

        Koszyk koszyk_1 = new Koszyk(1, 1);
        Koszyk koszyk_2 = new Koszyk(2, 2);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String data = formatter.format(date);
        
         // Zamowienie zamowienie_1 = new Zamowienie(2, 1,data);
        //Zamowienie zamowienie_2 = new Zamowienie(2,2);

        KlientKoszyk klient_koszyk_1 = new KlientKoszyk(produkt_1.getNazwa(), 1, produkt_1.getCena());

        pracownikRepository.save(pracownik_1);
        pracownikRepository.save(pracownik_2);

        klientRepository.save(klient_1);
        klientRepository.save(klient_2);

        produktRepository.save(produkt_1);
        produktRepository.save(produkt_2);
        produktRepository.save(produkt_3);
        produktRepository.save(produkt_4);
        produktRepository.save(produkt_5);

        koszykRepository.save(koszyk_1);
        koszykRepository.save(koszyk_2);

      //  zamowienieRepository.save(zamowienie_1);
        //  zamowienieRepository.save(zamowienie_2);
        
        //  Przypisanie klientow do koszyka
       //   klient_1.getKoszyk().add(koszyk_1);
        //  klient_2.getKoszyk().add(koszyk_2);
        
        //Przypisanie pracownikow do zamowienia
         // pracownik_2.getZamowienie().add(zamowienie_1);
        //  pracownik_2.getZamowienie().add(zamowienie_2);
        //  //Przypisanie produktow do koszyka
        
     //   koszyk_1.getProdukt().add(produkt_1);
        //  koszyk_2.getProdukt().add(produkt_3);
        
        //  koszyk_1.setZamowienie(zamowienie_1);
        //   koszyk_2.setZamowienie(zamowienie_2);
      //     koszyk_1.setKlient(klient_1);
        //   koszyk_2.setKlient(klient_2);
        
        // zamowienie_1.setPracownik(pracownik_2);
        //  zamowienie_2.setPracownik(pracownik_2);
         //zamowienie_1.setKoszyk(koszyk_1);
        //  zamowienie_2.setKoszyk(koszyk_2);
        
        pracownikRepository.save(pracownik_1);
        pracownikRepository.save(pracownik_2);

        klientRepository.save(klient_1);
        klientRepository.save(klient_2);

        produktRepository.save(produkt_1);
        produktRepository.save(produkt_2);
        produktRepository.save(produkt_3);
        produktRepository.save(produkt_4);
        produktRepository.save(produkt_5);

      //  koszykRepository.save(koszyk_1);
      //  koszykRepository.save(koszyk_2);

       //  zamowienieRepository.save(zamowienie_1);
        //   zamowienieRepository.save(zamowienie_2);
        //produkt w koszyku
        //klientKoszykRepository.save(klient_koszyk_1);
    }
}
