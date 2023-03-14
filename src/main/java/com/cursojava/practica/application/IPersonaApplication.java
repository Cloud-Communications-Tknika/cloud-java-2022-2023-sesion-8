package com.cursojava.practica.application;

import com.cursojava.practica.dominio.Persona;

public interface IPersonaApplication {

    /**
     * 
     * @param p persona que se desea añadir a la base de datos, no puede haber otra persona con el mismo identificador.
     * @return true si se introducido correctamente, false si existe una Persona con el mismo id en el sistema de presistencia.
     */
    public boolean addPersona(Persona p);

        /**
     * Se obtiene una persona de la BD mediante su identificador.
     * @param id id de la Persona que se desea obtener
     * @return Persona con el id indicado, si no existe dicha persona en la base de datos devuelve null
     */
    public Persona getPersona (String id);

    /**
     * Elimina a una Persona del sistema de persistencia.
     * @param id id de la Persona que se desea eliminar.
     * @return true si se ha eliminado correctamente, false si no existia ninguna Persona con ese id en el sistema de persistencia.
     */
    public boolean removePersona (String id);

    
}