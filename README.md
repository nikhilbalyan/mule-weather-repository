# Weather Extension

Add description ...


...


...


Add this dependency to your application pom.xml

```
<groupId>in.nikhil.muleConnector</groupId>
<artifactId>mule-weather-connector</artifactId>
<version>1.0.0</version>
<classifier>mule-plugin</classifier>
```


link used for the developement :- https://dzone.com/articles/mulesoft-custom-connector-using-mule-sdk-for-mule
command used for generating the project :- mvn org.mule.extensions:mule-extensions-archetype-maven-plugin:generate
answered 5 questions with below answers :- Enter the name of the extension: Weather Connector
                                           Enter the extension's groupId: us.nikhil.muleConnector
                                           Enter the extension's artifactId: mule-weather-connector
                                           Enter the extension's version: 1.0.0
                                           Enter the extension's main package: org.mule.extension.weather

WeatherExtension.java
This class would identify the various properties of your connector. Note that in Mule 4 a connector is nothing but an extension.
This class would identify which is the configuration class, which are the Operation classes etc.


WeatherConfiguration.java
This would contain all the information that you want from the global configuration of the Connector.

WeatherConnection.java
The connection class is responsible for handling the connection and in our case, most of the actual coding will be here.

WeatherConnectionProvider.java
This class is used to manage and provide the connection with the target system.
The connection provider must implement once of the connection provide available in mule.
The options are PoolingConnectionProvider, CachedConnectionProvider and ConnectionProvider. We will use PoolingConnectionProvider.

WeatherOperations.java
This would be the class where you would define all the necessary operations. There can be multiple operation class files.


Command used to generate the jar is:-
mvn clean install -DskipTests





