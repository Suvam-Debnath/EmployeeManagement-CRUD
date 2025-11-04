<h1 align="center">🚀 Spring Boot CRUD Application (H2 Database)</h1>

<p align="center">
  A simple <b>Spring Boot CRUD Application</b> built using <b>H2 in-memory database</b>.  
  This project demonstrates basic CRUD operations using RESTful APIs, service layers, and exception handling.
</p>

<hr/>

<h2>📁 Folder Structure</h2>

<pre>
SpringbootCRUD_h2DB/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── suvam/
│   │   │           ├── controller/
│   │   │           │   └── EmployeeController.java
│   │   │           │
│   │   │           ├── model/
│   │   │           │   └── Employee.java
│   │   │           │
│   │   │           ├── service/
│   │   │           │   └── EmployeeService.java
│   │   │           │
│   │   │           ├── exception/
│   │   │           │   ├── ResourceNotFoundException.java
│   │   │           │   └── GlobalExceptionHandler.java
│   │   │           │
│   │   │           └── SpringbootCrudH2DbApplication.java
│   │   │
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── static/
│   │       └── templates/
│   │
│   └── test/
│       └── ...
│
└── pom.xml
</pre>

<hr/>

<h2>⚙️ Configuration (application.properties)</h2>

<pre>
spring.application.name=SpringbootCRUD_h2DB
server.port=8081

# H2 Database Configuration
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

# Optional Settings
# spring.jpa.show-sql=true
# spring.h2.console.enabled=true
# spring.datasource.url=jdbc:h2:file:./data/demo
# spring.jpa.hibernate.ddl-auto=update
</pre>

<hr/>

<h2>🧩 Technologies Used</h2>

<ul>
  <li>Spring Boot</li>
  <li>Spring Web</li>
  <li>Spring Data JPA</li>
  <li>H2 Database (in-memory)</li>
  <li>Jakarta Validation API</li>
  <li>Maven</li>
  <li>Java 17+</li>
</ul>

<hr/>

<h2>📦 API Endpoints</h2>

<table border="1" cellpadding="6" cellspacing="0">
  <thead>
    <tr>
      <th>HTTP Method</th>
      <th>Endpoint</th>
      <th>Description</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><b>GET</b></td>
      <td>/demo/employee</td>
      <td>Retrieve all employees</td>
    </tr>
    <tr>
      <td><b>GET</b></td>
      <td>/demo/employee/{id}</td>
      <td>Retrieve a specific employee by ID</td>
    </tr>
    <tr>
      <td><b>POST</b></td>
      <td>/demo/employee</td>
      <td>Create a new employee</td>
    </tr>
    <tr>
      <td><b>PUT</b></td>
      <td>/demo/employee/{id}</td>
      <td>Update an existing employee by ID</td>
    </tr>
    <tr>
      <td><b>DELETE</b></td>
      <td>/demo/employee/{id}</td>
      <td>Delete an employee by ID</td>
    </tr>
  </tbody>
</table>

<hr/>

<h2>⚠️ Global Exception Handling</h2>

<p>
The application includes a <b>GlobalExceptionHandler</b> class that handles runtime exceptions globally across all controllers.  
It ensures meaningful error messages are returned to clients.
</p>

<pre>
package com.suvam.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFound(ResourceNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        return new ResponseEntity<>("An unexpected error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
</pre>

<hr/>

<h2>🚀 How to Run the Application</h2>

<ol>
  <li>Clone the repository:</li>
  <pre>git clone https://github.com/your-username/SpringbootCRUD_h2DB.git</pre>
  
  <li>Navigate into the project folder:</li>
  <pre>cd SpringbootCRUD_h2DB</pre>
  
  <li>Build the project using Maven:</li>
  <pre>mvn clean install</pre>
  
  <li>Run the Spring Boot application:</li>
  <pre>mvn spring-boot:run</pre>
  
  <li>Access the app at:</li>
  <pre>http://localhost:8081/demo/employee</pre>
</ol>

<hr/>

<h2>📘 Example JSON (POST Request)</h2>

<pre>
{
  "firstName": "Suvam",
  "lastName": "Debnath",
  "email": "suvam@example.com",
  "department": "Engineering"
}
</pre>

<hr/>

<h2>📊 H2 Database Console (Optional)</h2>

<ul>
  <li>Enable console in <code>application.properties</code> by adding:
    <pre>spring.h2.console.enabled=true</pre>
  </li>
  <li>Access console at:
    <pre>http://localhost:8081/h2-console</pre>
  </li>
  <li>Use JDBC URL:
    <pre>jdbc:h2:mem:testdb</pre>
  </li>
</ul>

<hr/>

<h2>🧠 Author</h2>

<p><b>Developed by:</b> Suvam Debnath</p>
<p>

  🔗 <a href="https://github.com/suvamdebnath">GitHub Profile</a>
</p>

