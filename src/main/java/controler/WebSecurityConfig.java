package controler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/admin","/wyswietl_pracownikow","/dodaj_pracownika","/usun_pracownika","/edytuj_pracownika","/edytuj_pracownikow","/edytuj_pracownikow/**").hasAuthority("ROLE_ADMIN")
                .antMatchers("/wyswietl_produkty","/staff","/dodaj_klienta","/wyswietl_klientow","/wyswietl_zamowienia","/usun_klienta","/usun_zamowienie","/usun_produkt","/dodaj_zamowienie","/dodaj_produkt","/wyswietl_produkty_pracownik","/edytuj_klienta","/edytuj_produkty").hasAuthority("ROLE_STAFF")  
                .antMatchers("/client","/wyswietl_produkty","wyswietl_koszyk_klienta","wyswietl_koszyk_klienta_dodaj","/realizacja_zamowienia","/wyswietl_koszyk_klienta","/koniec_zamowienia").hasAuthority("ROLE_CLIENT")
                .anyRequest().permitAll()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll();
    }
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {      
        auth.inMemoryAuthentication()
                
                .withUser("admin").password("{noop}admin123").roles("ADMIN").and()
                .withUser("pracownik").password("{noop}pracownik123").roles("STAFF").and()
                .withUser("klient").password("{noop}klient123").roles("CLIENT");
        
        

    }
    
}

