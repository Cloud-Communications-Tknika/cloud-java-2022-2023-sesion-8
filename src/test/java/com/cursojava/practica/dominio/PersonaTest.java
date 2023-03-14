package com.cursojava.practica.dominio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PersonaTest {
    @Test
    void testHBirthday() {

        Persona persona1 = new Persona("1234", "Juan", 19),
                persona2 = new Persona("1235", "Pedro", 78, false);

        persona1.hBirthday();
        persona2.hBirthday();

        assertEquals(20, persona1.getAge());
        assertEquals(78, persona2.getAge());

    }
}
