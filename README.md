# Website Monitoring Tool

This web service that will monitor the state of one or more external web applications by periodically page downloading by URL, and monitoring the response time of servers, the HTTP response code, the size of the response in some given range.

## Features

### Backend
Backend was built by using Spring Boot Framework, H2 database, lombok library, Maven build tool. 
Application backend allows:
- Do CRUD operations with objects
- Do monitoring operation of given websites
- Save expected and received data to DB
- Temporary exclusion of URL from monitoring
- Set date period for URL to monitoring
- Get data by REST controllers
- Handle exceptions
- Logging operations results

### Frontend
Frontend was built by using Bootstrap library, custom js scripts and css styles.
Application frontend allows:
- See monitoring results of all websites in one table
- See detail monitoring results of given URL
- See all websites (active, inactive)
- Add, update and delete websites
- Monitoring by some time period
- Sound effects, when website status go to Warning or Critical

## Running application
### Running from an IDE
You can run a Website Monitoring Tool application from your IDE as a simple Java application. However, you first need to import project. Import steps vary depending on your IDE and build system. Most IDEs can import Maven projects directly. 

If you cannot directly import your project into your IDE, you may be able to generate IDE metadata by using a build plugin. Maven includes plugins for Eclipse and IDEA. Gradle offers plugins for various IDEs.

### Running as a Packaged Application

If you use the Spring Boot Maven or Gradle plugins to create an executable jar, you can run your application using java -jar, as shown in the following example:
```
$ java -jar target/providesupport-0.0.1-SNAPSHOT.jar
```
