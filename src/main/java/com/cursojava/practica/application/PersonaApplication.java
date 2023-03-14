package com.cursojava.practica.application;

import com.cursojava.practica.dominio.Persona;
import com.cursojava.practica.persistencia.*;

public class PersonaApplication implements IPersonaApplication{

    private IPersonaGBD GBD;

    public PersonaApplication(IPersonaGBD gbd)
    {
        this.GBD = gbd;
    }

    
    @Override
    public boolean addPersona(Persona p) {
        
        return GBD.addPersona(p);
        
    }

    @Override
    public Persona getPersona(String id) {
        
        return GBD.getPersona(id);
    }

    @Override
    public boolean removePersona(String id) {
        
        return GBD.removePersona(id);
        
    }
    
}
