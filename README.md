# jstabanken

1. Klona repot: https://github.com/saadhashim/jstabanken.git
2. För att bygga efter ändringar kör följande från rooten av repot: mvn clean install
3. För att köra tjänsten gå till target mappen och kör: java -jar soapservice-1.0-SNAPSHOT-jetty-console.war 
4. Du får en app där du kan välja port och starta servicen 

Nu har du en soaptjänst med addressen:
http://localhost:8080/JSTABanken?wsdl

Databasen är en fil som ligger i rooten på repot och heter stabanken.db. Det är en sqlite databas.
