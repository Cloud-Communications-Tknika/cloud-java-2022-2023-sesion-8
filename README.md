# Practica Cloud Java 2022-2023

Aitor Iturrioz & Pablo Rubio 

Este repositorio es el código inicial del ejercicio principal del Curso Cloud de Tknika.

Es una rest API simple con tres métodos:

    GET persona/{id}

    PUT persona/add pasando la persona en el cuerpot

    GET persona/init para introducir 3 datos en la BBDD.

Utiliza Maven como gestor de paquetes, por lo que:

Para empaquetar el proyecto usar:

    mvn package

Para realizar los test:

    mvn test

Generar la documentación:

    mvn javadoc:javadoc

Tras hacer mvn package para ejecutar la aplicación debemos ejecutar.

    java -jar ./targe/*.jar

Para utilizar una BBDD, primero debemos añadir la dependencia del conector mysql al pom.xml y luego modificar el fichero PersistenceBeanConfiguration.java

DE:

    @Bean
    IPersonaGBD getIPersonaGDB() throws InvalidAttributeValueException, NumberFormatException, IOException
    {
      File f = new File("datos.txt");
      
      return new TextBD(f);
    }


A:

    @Bean
    IPersonaGBD getIPersonaGDB() throws InvalidAttributeValueException, NumberFormatException, IOException
    {
        Session session = getSession();

        return new HibernatePersonaDB(session);

    }
    

Opciones de la aplicación java.

    -Ddbhost: Dirección del host de la BBDD, default: 127.0.0.1
    -Ddbport: Puerto de la BBDD, default: 3306
    -Ddbuser: Ususario de la BBDD, default: root
    -Ddbpassword: Contraseña de la BBDD, default: root
    -Ddbdatabase: nombre de la base de datos, default: database1
    -Dport: Puerto en el que se ejecuta la aplicación, default: 8080