FROM adoptopenjdk/openjdk13:jre-13.0.2_8-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
COPY ./datos.txt datos.txt
ENV DBHOST=127.0.0.1
ENV DBPASS=1234
ENV DBUSER=root
ENV DBPORT=3306
ENV DBNAME=database1


CMD java -jar -Ddbhost=$DBHOST -Ddbuser=$DBUSER -Ddbport=$DBPORT -Ddbdatabase=$DBNAME -Ddbpassword=$DBPASS app.jar