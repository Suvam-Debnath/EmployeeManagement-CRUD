<h1 align="center">🚀 Spring Boot CRUD Application (H2 Database)</h1>

<p align="center">
  A simple <b>Spring Boot CRUD Application</b> built using an <b>H2 in-memory database</b>.  
  Demonstrates full <b>CRUD (Create, Read, Update, Delete)</b> operations via RESTful APIs with  
  Service Layer, Repository Layer, and Global Exception Handling.
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
│   │   │           │   ├── EmployeeService.java
│   │   │           │   └── EmployeeServiceImpl.java
│   │   │           │
│   │   │           ├── repository/
│   │   │           │   └── EmployeeRepository.java
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
</pre>

<hr/>

<h2>🧩 Technologies Used</h2>

<ul>
  <li>Spring Boot</li>
  <li>Spring Web (REST API)</li>
  <li>Spring Data JPA</li>
  <li>H2 In-Memory Database</li>
  <li>Jakarta Validation API</li>
  <li>Maven</li>
  <li>Java 21+</li>
</ul>

<hr/>

<h2>📦 All API Endpoints</h2>

<h3>👨‍💼 Employee Management APIs</h3>

<table border="1" cellpadding="6" cellspacing="0">
  <thead>
    <tr>
      <th>HTTP Method</th>
      <th>Endpoint (Full URL)</th>
      <th>Description</th>
      <th>Request Body</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><b>GET</b></td>
      <td>http://localhost:8081/demo/employee</td>
      <td>Retrieve all employees</td>
      <td>❌ None</td>
    </tr>
    <tr>
      <td><b>GET</b></td>
      <td>http://localhost:8081/demo/employee/{id}</td>
      <td>Retrieve a specific employee by ID</td>
      <td>❌ None</td>
    </tr>
    <tr>
      <td><b>POST</b></td>
      <td>http://localhost:8081/demo/employee</td>
      <td>Create a new employee</td>
      <td>✅ JSON (Employee Object)</td>
    </tr>
    <tr>
      <td><b>PUT</b></td>
      <td>http://localhost:8081/demo/employee/{id}</td>
      <td>Update an existing employee</td>
      <td>✅ JSON (Employee Object)</td>
    </tr>
    <tr>
      <td><b>DELETE</b></td>
      <td>http://localhost:8081/demo/employee/{id}</td>
      <td>Delete an employee by ID</td>
      <td>❌ None</td>
    </tr>
  </tbody>
</table>

<h3>⚙️ Utility & System Endpoints</h3>

<table border="1" cellpadding="6" cellspacing="0">
  <thead>
    <tr>
      <th>HTTP Method</th>
      <th>Endpoint (Full URL)</th>
      <th>Description</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><b>GET</b></td>
      <td>http://localhost:8081/h2-console</td>
      <td>Access H2 database console (must enable in properties)</td>
    </tr>
    <tr>
      <td><b>GET</b></td>
      <td>http://localhost:8081/actuator/health</td>
      <td>Check application health (if Spring Boot Actuator is enabled)</td>
    </tr>
    <tr>
      <td><b>GET</b></td>
      <td>http://localhost:8081/error</td>
      <td>Default Spring Boot error handler endpoint</td>
    </tr>
  </tbody>
</table>

<hr/>

<h2>⚠️ Global Exception Handling</h2>

<p>
The application includes a <b>GlobalExceptionHandler</b> that handles errors across all controllers  
and returns meaningful HTTP responses to the client.
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
    public ResponseEntity&lt;String&gt; handleResourceNotFound(ResourceNotFoundException ex) {
        return new ResponseEntity&lt;&gt;(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity&lt;String&gt; handleGenericException(Exception ex) {
        return new ResponseEntity&lt;&gt;(
            "An unexpected error occurred: " + ex.getMessage(),
            HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
</pre>

<hr/>

<h2>📘 Example JSON Requests and Responses</h2>

<h3>✅ POST (Create Employee)</h3>
<pre>
POST http://localhost:8081/demo/employee
Content-Type: application/json

Request Body:
{
  "firstName": "Suvam",
  "lastName": "Debnath",
  "email": "suvam@example.com",
  "department": "Engineering"
}

Response:
{
  "id": 1,
  "firstName": "Suvam",
  "lastName": "Debnath",
  "email": "suvam@example.com",
  "department": "Engineering"
}
</pre>

<h3>✅ GET (All Employees)</h3>
<pre>
GET http://localhost:8081/demo/employee

Response:
[
  {
    "id": 1,
    "firstName": "Suvam",
    "lastName": "Debnath",
    "email": "suvam@example.com",
    "department": "Engineering"
  },
  {
    "id": 2,
    "firstName": "Rahul",
    "lastName": "Singh",
    "email": "rahul@example.com",
    "department": "Finance"
  }
]
</pre>

<h3>✅ PUT (Update Employee)</h3>
<pre>
PUT http://localhost:8081/demo/employee/1
Content-Type: application/json

Request Body:
{
  "firstName": "Suvam",
  "lastName": "Updated",
  "email": "suvam.updated@example.com",
  "department": "IT"
}

Response:
{
  "id": 1,
  "firstName": "Suvam",
  "lastName": "Updated",
  "email": "suvam.updated@example.com",
  "department": "IT"
}
</pre>

<h3>✅ DELETE (Remove Employee)</h3>
<pre>
DELETE http://localhost:8081/demo/employee/1

Response:
{
  "deleted": true
}
</pre>

<hr/>

<h2>📊 H2 Database Console</h2>

<p>To enable and use the H2 web console:</p>

<ol>
  <li>Add the following property in <code>application.properties</code>:</li>
  <pre>spring.h2.console.enabled=true</pre>
  
  <li>Open H2 console in your browser:</li>
  <pre>http://localhost:8081/h2-console</pre>
  
  <li>Enter the following credentials:</li>
  <pre>
  JDBC URL: jdbc:h2:mem:testdb
  Username: sa
  Password: password
  </pre>
</ol>

<hr/>


<hr/>

<h2>📜 pom.xml - Key Dependencies</h2>

<pre>
&lt;dependencies&gt;
    &lt;dependency&gt;
        &lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;
        &lt;artifactId&gt;spring-boot-starter-web&lt;/artifactId&gt;
    &lt;/dependency&gt;

    &lt;dependency&gt;
        &lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;
        &lt;artifactId&gt;spring-boot-starter-data-jpa&lt;/artifactId&gt;
    &lt;/dependency&gt;

    &lt;dependency&gt;
        &lt;groupId&gt;com.h2database&lt;/groupId&gt;
        &lt;artifactId&gt;h2&lt;/artifactId&gt;
        &lt;scope&gt;runtime&lt;/scope&gt;
    &lt;/dependency&gt;

    &lt;dependency&gt;
        &lt;groupId&gt;jakarta.validation&lt;/groupId&gt;
        &lt;artifactId&gt;jakarta.validation-api&lt;/artifactId&gt;
    &lt;/dependency&gt;

    &lt;dependency&gt;
        &lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;
        &lt;artifactId&gt;spring-boot-starter-test&lt;/artifactId&gt;
        &lt;scope&gt;test&lt;/scope&gt;
    &lt;/dependency&gt;
&lt;/dependencies&gt;
</pre>

<hr/>

<h2>🧠 Author</h2>

<p><b>Developed by:</b> Suvam Debnath</p>



