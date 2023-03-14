package com.cursojava.practica.dominio;

import javax.persistence.*;

@Entity
@Table(name = "PERSONA")
public class Persona {
    
    @Id
    @Column(name = "id")
    private String id;
    @Column(name="name")
    private String name;
    @Column(name="age")
    private int age;
    @Column(name="alive")
    private boolean alive;


    
    public Persona(String id, String name, int age)
    {
        this.id=id;
        this.age=age;
        this.name=name;
        this.alive=true;
    }
    
    public Persona(String id, String name, int age, boolean alive)
    {
        this.id=id;
        this.age=age;
        this.name=name;
        this.alive=alive;
    }

    public void hBirthday()
    {
        if(alive)
        {
            age++;
        }
        
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isAlive() {
        return this.alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}