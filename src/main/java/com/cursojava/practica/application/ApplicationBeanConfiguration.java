package com.cursojava.practica.application;

import com.cursojava.practica.persistencia.*;

import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class ApplicationBeanConfiguration {

    @Bean
    IPersonaApplication getPersonaAplication(IPersonaGBD iPersonaGBD)
    {
        return new PersonaApplication(iPersonaGBD);
    }
    
}
