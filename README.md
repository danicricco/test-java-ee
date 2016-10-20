Ejercicio para evaluación de candidatos para Developers Java EE
===============================================================

Requisitos
----------

* [Java Platform (JDK) 8](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
* [Apache Maven 3.x](http://maven.apache.org/)
* [Jboss Wildfly 10.1.0](http://download.jboss.org/wildfly/10.1.0.Final/wildfly-10.1.0.Final.zip)
* IDE favorito
* Git

Descripción del Proyecto
------------------------

Esta aplicación es para un manejador de tareas. 

La intención de la aplicación es la de presentar en una página, una lista de tareas que es obtenida desde una base de dato relacional. 

También debe proveer endpoints REST para hacer un CRUD de las tareas.

El resto de esta documentación se escribe en inglés con propósitos de evaluar la comprensión del idioma de los participantes.

Your Tasks
-----------

## Backend Tasks

Add a REST web service for querying, adding, updating and removing tasks.
The service should respond to the following URLs:

*   `api/tasks` - list all tasks
*   `api/tasks?[queryParameters..]` - list tasks accepting query parameters for pagination and filters
*   `api/tasks` - create a new task
*   `api/tasks/<id>` - retrieve details of the task identified by *id*
*   `api/tasks/<id>` - update the existing task identified by *id*
*   `api/tasks/<id>` - delete the existing task identified by *id*

**Implementation Requirements**: 

*   The REST services should be implemented by adding resources classes using [JAX-RS](https://jax-rs-spec.java.net/).

*   The JAX-RS resource classes should use EJB services to access the business logic of the application. 
    Create a Local, Stateless or Session Bean that expose the needed service methods needed by the resource(s).

*   The EJB's should access the database by methods exposed from repository classes. 
    The repository classes should be 'injected' into the EJB's using the most appropriate annotation.
    You should only use the `EntityManager` as a private field from repository classes.
    EJB's should not have access to the entityManager.

## Bugs to Fix

*   After you've added your first endpoint `api/tasks` to request all tasks in the database, you will get an error when trying to call the url.
    
    This is a BUG in the provided code base. 
    
    Your task here is to fix the bug with as few lines of code as possible.
    
    After fixing the bug, you should be able to see a `json` with all tasks and its assignees. Like this:
    
      [
       {
         "description":"Implement REST service for task list.",
         "assignee":{
            "name":"John Smith",
            "email":"jsmith@gmail.com",
            "createdAt":null
         },
         "due":1378069200000,
         "completedAt":null,
         "createdAt":null
       },
     ...
   

## Easy Tasks

Write an utility class with the following methods:

*   A method that returns `true` if a given `Task` was completed BEFORE its due date.
*   A method that returns `true` if a `Task` due date has expired.
*   A method that returns `true` if a `Task` due date has expired and the `Task` was not completed.  
*   Write UNIT tests for the utility class and its methods.

## Frontend Tasks

*   When you build and run the project (see section below), you will
    have access to the URL `http://localhost:8080/testjee/tasks.html`. There 
    you will see a page that allows the user to create, list and mark tasks 
    as completed. 
    
    This page stores information about the tasks only client-side by using 
    the [browser localStorage](http://www.w3schools.com/html/html5_webstorage.asp). 
    
    The tasks should be retrieved from and stored in the backend.

    For instance, when you add a new task in the page, the REST URL to add 
    new tasks should be invoked with an AJAX request in order to store the new task 
    in the backend database. 
    
    Similar operations should be implementend in JavaScript to list or update the tasks, 
    and also when you "clear completed" tasks.

    Your task here is to connect the JavaScript code with the REST services 
    added to the backend, by using AJAX requests. 
    
    
## General guidelines

The URLs for the REST services should have the appropiate HTTP verb regarding each operation.

The services MUST accept and return resources in JSON format. Design the JSON schema you feel is appropriate given the existing data structure.

Evaluation Criteria
-------------------

1.  Correctness of solution

    Naturally, the project you submit must be functional.  You will also be
    evaluated on *how* your solution addresses the assigned tasks.  

2.  Java EE Platform knowledge

    Does your code demonstrate your knowledge of the capabilities of the
    Java EE platform and its resources? Do you know which annotations to use 
    and how to deploy the application to a Java EE application server?

3.  Coding style

    Is your coding style neat?  Does it fit in with the prevailing style of
    the project?  Is it idiomatic such that it will be easily understood by
    other Java developers?  Is it adequately (but not excessively)
    commented?

4.  Tooling knowledge

    Do you know how to use Maven and run it from a command line? The candidates
    should at least be able to build the base project using Maven.
    

5.  Understanding the specification

    You should be able to complete the tasks by reading the specification
    in this README and building the solution as the specification is asking.


Getting Started
---------------

### Clone the project to your local machine

You are probably reading this on GitHub already.  If not, you can find the
project [on GitHub](https://www.github.com/rodrigojv/test-java-ee).

To begin work on the project, start by cloning the repository to your local
machine.  Do your work locally, committing your changes to your local git
repository as you go.


### Building the project

The project includes a pom.xml file allowing it to be built by
[Maven](http://maven.apache.org).  Simply running `mvn package` will
download all dependencies and build a standard WAR file.


### Managing the database

When you deploy the application, Jboss will automatically create an H2 database for you with the `TASKS` and `ASSIGNEES` tables. It does so by reading the configuration in the `persistence.xml` file.

If you need to recreate your tables, you can re-deploy the application and restart Jboss.


### Running the application

You can run the project inside a Jboss Wildfly container by generating the WAR:

    mvn package

Then start the Wildfly server on your local machine.  

To see the application's home page, point your browser to
`http://localhost:8080/testjee`.  This page shows a welcome message to the user.


Submitting Your Code For Evaluation
-----------------------------------

When you are finished and ready to submit your work, commit your changes
and use the following command to generate a series of patch files with all 
of your changes:

    git format-patch origin/master

This will create one or more numbered patch files.

Send an email with the patch files attached to the person who sent you this
test.
