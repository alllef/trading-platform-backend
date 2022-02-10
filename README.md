# Project setup
To setup this project on your local machine you should have:
- PostgreSQL
- Java 17
- Maven

You have to create PostgreSQL database on your local machine and enter properties in [datasource.properties](src/main/resources/datasource.properties) file.
Data for testing can be configured via [data.sql](src/main/resources/data.sql) file or programmatically in [MainConfig](src/main/java/com/github/alllef/tradingplatformbackend/MainConfig.java) createData() method.