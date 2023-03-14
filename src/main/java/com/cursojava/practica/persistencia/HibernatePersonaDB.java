package com.cursojava.practica.persistencia;



import com.cursojava.practica.dominio.Persona;

import org.hibernate.Session;

public class HibernatePersonaDB implements IPersonaGBD{

    private Session session;

    public HibernatePersonaDB(Session session)
    {
        this.session = session;
                 
    }
    
    @Override
    public Persona getPersona(String id) {

        Persona p = (Persona) session.get(Persona.class, id);

        return p;
        
    }

    @Override
    public boolean addPersona(Persona persona) {

        Persona per = (Persona) session.get(Persona.class, persona.getId());

        if(per==null)
        {
            session.beginTransaction();  
            session.save(persona);
            session.getTransaction().commit();
            return true;
        }

        return false;
        
    }

    @Override
    public boolean updatePersona(Persona persona) {
        
        Persona per = (Persona) session.get(Persona.class, persona.getId());

        if (per!=null)
        {
            session.beginTransaction();
            session.update(persona);
            session.getTransaction().commit();
            return true;
        }

        return false;

       
    }

    @Override
    public boolean removePersona(String id) {
        
        Persona p = (Persona) session.get(Persona.class, id);

        if(p!=null)
        {
            session.beginTransaction();
            session.remove(p);           
            session.getTransaction().commit();

            return true;
        }

        return false;
        
    }
    
}
