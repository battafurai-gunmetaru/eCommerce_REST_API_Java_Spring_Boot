# Greeting REST API

## Description

This application is intended to demonstrate competency and developmental understanding in the areas
of data access, Java Spring Boot, REST API principles, and CRUD functionality. The application
allows users to send requests for all CRUD functions in order to manipulate the data of different
text greetings.

## Prerequisites

The instructions detailed herafter assume that the user is using the IDE IntelliJ IDEA, and the
ensuing steps may not be applicable if the user is using another development environment, tool kit,
or editor. First, start up IntelliJ and open the root folder of the application (file -> open ->
rest-greeting). You may also access this application directory through the command line if the path
environment variable has been enabled on your operating system. Command line shortcuts for opening
the application may be found in this link: (<https://tinyurl.com/mr4d3ub4>).

After opening the application directory in IntelliJ, select "RestGreetingApplication" from the drop-
down menu on the configuration pane. The pane can be found near the top of the IDE, on the toolbar.
Press the play button to launch the Spring Boot Application. The Tomcat server will start on port
"8080" by default.

After the application has been started successfully, you may also import the postman collection link
into Postman via the web or desktop application to manually test requests. Swagger-UI may also be
used in order to manually test the API's endpoints. You can find these links in under the links
section.

## Viewing the database

The data source provider for this application is MySQL. Login with MySQL credentials using the
commandline,
or start the MySQL Workbench UI to view the Greeting entity.

## Overview of Classes

All classes have been separated on the basis of concerns via packages, with the exception of the
application runner, RestGreetingApplication. Below you will find an overview of the packages and
classes in the project structure.

### Config

This contains configurations for swagger documentation and springfox swagger ui. It will also 
contain security configurations in the future.

### Constants

This contains all the string messages of errors and endpoints to preserve maintainability across the 
application. These are located in the StringConstants class.

### Controllers

This contains the GreetingController class, which takes methods from the GreetingServiceImpl class
via autowiring to the service interface, GreetingService. It is mapped to basic CRUD functionality
of the common HTTP verbs, GET, PUT, POST, and DELETE. Endpoints have been written to create a uniform
identification of resources.

### Data

This contains the DataLoader class, used to load the Greeting Objects once the application is 
launched. 

### Exceptions

This package contains all custom exception classes used throughout the application, as well as the
Exception Controller, which is used as an exception handler with a global scope. Most of these
exceptions have been incorporated into the logic of the service implementation class, GreetingServiceImpl.

### Models

This package contains the constructors and properties of the Greeting Objects in the Greeting class.

### Repositories

This package contains the GreetingRepository class that extends the JpaRepository to access a library
of methods to manipulate stored Greeting Objects via CRUD operations.

### Services

This package contains the interface GreetingService and its corresponding implementation, the
GreetingServiceImpl class.

### Test Packages

This package contains integration and unit tests for the GreetingController and GreetingServiceImpl
classes, respectively. 

In order to run these tests, select the configuration file containing the name of the class you wish
test and press the play button. Each testing method also has play buttons to test on the method-level,
as well. Right-clicking the class itself will present alternative testing options through a tool tip.
You can run tests with coverage as an option, for example. Current testing line coverage is 100% for
both classes. 

### Linting

The code can be linted through the shortcut Ctrl+Alt+L, or you can right-click the directory or file
containing the code you wish to reformat, and select "Reformat Code". This can be used to lint and
optimize the imports of subdirectories, as well.

### Helpful Links

Postman Collection Link: <https://www.getpostman.com/collections/1775079e9ef4890df39d>

Swagger UI Link: <http://localhost:8080/swagger-ui.html>

LinkedIn: <https://www.linkedin.com/in/brandyn-tse-085872166>

Github: <>

