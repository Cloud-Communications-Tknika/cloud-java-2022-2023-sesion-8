# Seleccionamos la base de nuestro contenedor
FROM adoptopenjdk/openjdk13:jre-13.0.2_8-alpine

# Movemos el fichero .jar previamente compilado al sistema de ficheros del contenedor
COPY target/*.jar app.jar

# Definimos los valores por defecto de las variables de entorno
ENV DBHOST=127.0.0.1
ENV DBPASS=1234
ENV DBUSER=root
ENV DBPORT=3306
ENV DBNAME=database1

# Ejecutamos nuestro aplicación Java con los valores de las variables de entorno
CMD java -jar -Ddbhost=$DBHOST -Ddbuser=$DBUSER -Ddbport=$DBPORT -Ddbdatabase=$DBNAME -Ddbpassword=$DBPASS app.jar