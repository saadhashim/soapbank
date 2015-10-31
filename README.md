# jstabanken

1. Klona repot: https://github.com/saadhashim/jstabanken.git
2. Kör följande från rooten av repot: mvn package jetty:run

Nu har du en soaptjänst med addressen:
http://localhost:8080/jaxws-service/JSTABanken?wsdl

Databasen är en fil som ligger i rooten på repot och heter stabanken.db. Det är en sqlite databas.
