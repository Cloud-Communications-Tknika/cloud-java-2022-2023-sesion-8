package com.cursojava.practica.persistencia;

import com.cursojava.practica.dominio.Persona;

public interface IPersonaGBD {

    /**
     * Se obtiene una persona de la BD mediante su identificador.
     * @param id id de la Persona que se desea obtener
     * @return Persona con el id indicado, si no existe dicha persona en la base de datos devuelve null
     */
    public Persona getPersona(String id);

    /**
     * Añade la persona al sistema de persistencia, por ejemplo, una base de datos.
     * @param persona Objeto de la clase persona que se desea introducir en el sistema de persistencia, debe tener un id distinto a todos los que hay en la persistencia.
     * @return true si se introducido correctamente, false si existe una Persona con el mismo id en el sistema de presistencia.
     */
    public boolean addPersona(Persona persona);

    /**
     * Actualiza una Persona del sistema de persistencia.
     * @param persona Persona que se desea actualizar, debe haber una persona con 
     * @return devuelve true si la Persona se ha actualizado correctamente, false si no existia ninguna Persona con ese id en el sistema de persistencia.
     */
    public boolean updatePersona(Persona persona);

    /**
     * Elimina a una Persona del sistema de persistencia.
     * @param id id de la Persona que se desea eliminar.
     * @return true si se ha eliminado correctamente, false si no existia ninguna Persona con ese id en el sistema de persistencia.
     */
    public boolean removePersona(String id);
    
}

