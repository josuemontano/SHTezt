SHTezt
===

This project aims to provide a sample web application for Spring 4 and AngularJS. We provide an API (mapped at /api/*) the AngulaJS front-end uses. Hibernate is used for DB tasks.

Dependencies
===

This is a Maven web application written in Java. So you need to install first
* JDK 1.7
* Maven 3.2
* PostgreSQL 9

Other dependencies, as Spring 4, will be downloaded by maven and are included in pom.xml. If you wish to use a different DBMS install it and change the database settings found at src/main/resources/database.properties.

Installation
===

Once you have your BDMS installed and running (``` sudo service postgresql restart ```) modify src/main/resources/database.properties to set your DB settings. Then you can run this app as any other Maven project.

* Change your current dir to the location you cloned this repo, e.g.: ``` cd ~/Downloads/SHTezt ```
* Choose a project, ``` cd No XML Configuration ``` or ``` XML Configutarion ```
* ``` mvn jetty:run ```
* Open in your browser ``` http://localhost:8080 ```
