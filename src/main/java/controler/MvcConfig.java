package controler;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        
        registry.addViewController("/wyswietl_koszyk").setViewName("client");
        
        registry.addViewController("/login").setViewName("login");
        
        registry.addViewController("/admin").setViewName("admin");
        registry.addViewController("/staff").setViewName("staff");
        registry.addViewController("/client").setViewName("client");


    }    
}



