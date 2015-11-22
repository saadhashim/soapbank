# jstabanken
Här finner du en exekverbar fil som startar en soap-tjänst.
Tjänsten är en enkel bank och är avsedd för undervisning i testautomatisering av soaptjänsttester med SoapUI
Du finner även källkoden här om du vill ändra på tjänsterna.

För att köra banken:
1. Klona repot: git clone https://github.com/saadhashim/jstabanken.git
2. För att bygga efter ändringar kör följande från rooten av repot: mvn clean install
3. För att köra tjänsten gå till target mappen och kör: java -jar soapservice-1.0-SNAPSHOT-jetty-console.war 
4. Du får en app där du kan välja port och starta servicen 

Nu har du en soaptjänst med addressen:
http://localhost:8080/JSTABanken?wsdl

Databasen är en fil som skapas där du exekverade tjänsten och heter stabanken.db. Det är en sqlite databas.

För kurser i SoapUI och testautomatisering gå till http://jsta.se

------------------------------------------------------------------------------------------
Here you can find an executable jar file that starts a Soap service.
The service is a simple bank that is to be used when learning test automation of soap service tests with SoapUI.
You also have the source code if you want to change something.

To run the bank:
1. Clone the repo: git clone https://github.com/saadhashim/jstabanken.git
2. To build changes go to the project root and run: mvn clean install
3. To run the service run: java -jar soapservice-1.0-SNAPSHOT-jetty-console.war 
4. You will start the app and can choose on which port you want to start the Soap service 

Now you have a Soap service with the address:
http://localhost:8080/JSTABanken?wsdl

The database used by the bank is a file that will be created where you execute the war file. The file name is jstabanken.db. The database is an sqlite database. 

For cources in SoapUI and test automation go to http://jsta.se

