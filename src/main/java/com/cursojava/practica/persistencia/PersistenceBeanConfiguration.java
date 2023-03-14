package com.cursojava.practica.persistencia;

import java.io.File;
import java.io.FileNotFoundException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
import org.hibernate.cfg.Configuration;

import javax.management.InvalidAttributeValueException;

import com.cursojava.practica.dominio.Persona;

import java.io.IOException;
import java.util.Properties;


//Para diferenciarlo de la Configuracion de Hibernate
@org.springframework.context.annotation.Configuration
public class PersistenceBeanConfiguration {

   
    
    @Bean
    IPersonaGBD getIPersonaGDB() throws InvalidAttributeValueException, NumberFormatException, IOException
    {
      Session session = getSession();

      return new HibernatePersonaDB(session);
    }


    Session getSession()
    {
      Configuration cfg = new Configuration();

      String connectionURL;

      // -Ddbhost=host -Ddbport=port -Ddbdatabase=databasename
      // String host = (System.getProperty("dbhost")==null)? "127.0.0.1":System.getProperty(data);

      String host = getProperty("dbhost", "127.0.0.1");
      String port = getProperty("dbport","3306");
      String database = getProperty("dbdatabase","database1");

      connectionURL = "jdbc:mysql://" + host + ":" + port + "/" + database;
      cfg.setProperty("hibernate.connection.url", connectionURL);

      // -Ddbuser=user
      String user = getProperty("dbuser", "root");
      cfg.setProperty("hibernate.connection.username", user);

      //-Ddbpassword=password
      String password = getProperty("dbpassword","root");
      cfg.setProperty("hibernate.connection.password", password);

      SessionFactory factory = cfg.configure().addAnnotatedClass(Persona.class).buildSessionFactory();

      Session session = factory.openSession();

      return session;
    }


    private String getProperty(String data, String defaultValue){
        String info = System.getProperty(data);
        if (info == null){
          info = defaultValue;
        }
        return info;
    }
}

