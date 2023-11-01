package com.example.ggaapi.configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoresConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer()
    {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/gga_api/**")  // Puedes ajustar este patrón de acuerdo a tus endpoints
                        .allowedOrigins("https://localhost:7183")  // URL de tu cliente Blazor
                        .allowedMethods("GET", "POST", "PUT", "DELETE")  // Métodos permitidos
                        .allowCredentials(true)
                        .allowedHeaders("*");
            }
        };
    }
}
