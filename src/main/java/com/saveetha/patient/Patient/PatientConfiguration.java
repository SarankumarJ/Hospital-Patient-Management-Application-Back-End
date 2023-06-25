package com.saveetha.patient.Patient;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class PatientConfiguration {
    @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository) {
        return args -> {
            Patient saran = new Patient(
                    245L,
                    "Saran",
                    20,
                    "Male",
                    "Fever",
                    "6379615515"

            );
            Patient kumar = new Patient(
                    234L,
                    "Kumar",
                    21,
                    "Male",
                    "Cold",
                    "9876543210"

            );
            patientRepository.saveAll(List.of(saran, kumar));
        };
    }

    @Configuration
    public class CORSConfiguration implements WebMvcConfigurer {
        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")
                    .allowedOrigins("http://localhost:3000")
                    .allowedMethods("GET", "POST", "PUT", "DELETE")
                    .allowedHeaders("*");
        }
    }
}
