<h1 align="center">💼 Employee Management System (Spring Boot + H2 Database)</h1>

<p align="center">
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" alt="Java" width="60" height="60"/>
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" alt="Spring Boot" width="60" height="60"/>
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/maven/maven-original.svg" alt="Maven" width="60" height="60"/>

</p>

<p align="center">
  A simple <b>CRUD-based Employee Management System</b> built using <b>Spring Boot</b> and <b>H2 Database</b>.  
  It demonstrates <b>RESTful APIs</b>, <b>validation using Jakarta annotations</b>, and <b>Global Exception Handling</b>.
</p>

<hr>

<h2>📘 Overview</h2>
<p>
The <b>Employee Management System</b> allows you to manage employee data with CRUD operations — 
Create, Read, Update, and Delete.  
It is designed using the Spring Boot framework, uses an in-memory H2 database, 
and applies <b>Bean Validation</b> with custom error messages via a <b>Global Exception Handler</b>.
</p>

<hr>

<h2>⚙️ Technologies Used</h2>
<ul>
  <li>☕ <b>Java 21+</b></li>
  <li>🌱 <b>Spring Boot</b> (Spring Web, Spring Data JPA)</li>
  <li>🗃️ <b>H2 Database</b> (in-memory)</li>
  <li>🧾 <b>Jakarta Validation</b></li>
  <li>📦 <b>Maven</b></li>
</ul>

<hr>

<h2>📁 Project Folder Structure</h2>

<pre>
src/
 └── main/
     ├── java/
     │    └── com/
     │         └── suvam/
     │              ├── controller/
     │              │     ├── EmployeeController.java
     │              │     └── GlobalExceptionHandeller.java
     │              ├── exception/
     │              │     └── CustomException.java (optional)
     │              ├── model/
     │              │     └── Employee.java
     │              ├── repository/
     │              │     └── EmployeeRepository.java
     │              └── service/
     │                    └── EmployeeService.java
     └── resources/
          ├── application.properties
          └── data.sql (optional)
</pre>

<hr>

<h2>⚙️ Application Configuration</h2>

<pre>
spring.application.name=SpringbootCRUD_h2DB
server.port=8081

spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
</pre>

<hr>

<hr>

<h2>🌐 API Endpoints (with Port Numbers)</h2>

<p>Base URL: <code>http://localhost:8081/demo</code></p>

<table border="1" cellspacing="0" cellpadding="8">
  <thead>
    <tr>
      <th>Method</th>
      <th>Endpoint</th>
      <th>Full URL (Port: 8081)</th>
      <th>Description</th>
      <th>Request Body</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><b>GET</b></td>
      <td><code>/employee</code></td>
      <td><code>http://localhost:8081/demo/employee</code></td>
      <td>Fetch all employees</td>
      <td>❌</td>
    </tr>
    <tr>
      <td><b>GET</b></td>
      <td><code>/employee/{id}</code></td>
      <td><code>http://localhost:8081/demo/employee/{id}</code></td>
      <td>Fetch employee by ID</td>
      <td>❌</td>
    </tr>
    <tr>
      <td><b>POST</b></td>
      <td><code>/employee</code></td>
      <td><code>http://localhost:8081/demo/employee</code></td>
      <td>Create a new employee</td>
      <td>✅ JSON (validated)</td>
    </tr>
    <tr>
      <td><b>PUT</b></td>
      <td><code>/employee/{id}</code></td>
      <td><code>http://localhost:8081/demo/employee/{id}</code></td>
      <td>Update an existing employee</td>
      <td>✅ JSON (validated)</td>
    </tr>
    <tr>
      <td><b>DELETE</b></td>
      <td><code>/employee/{id}</code></td>
      <td><code>http://localhost:8081/demo/employee/{id}</code></td>
      <td>Delete employee by ID</td>
      <td>❌</td>
    </tr>
  </tbody>
</table>

<hr>

<h2>📦 Example JSON for POST / PUT</h2>

<pre>
{
  "fName": "Suvam",
  "lName": "Debnath",
  "email": "suvam.debnath@example.com",
  "gender": "Male"
}
</pre>

<hr>

<h2>⚠️ Global Exception Handling</h2>

<p>
A <b>GlobalExceptionHandeller</b> class handles all validation errors 
using <code>@RestControllerAdvice</code> and <code>@ExceptionHandler</code>.
This ensures clean and consistent error responses.
</p>

<pre>
@RestControllerAdvice
public class GlobalExceptionHandeller {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity&lt;Map&lt;String, String&gt;&gt; handleMethodArgsNotValidException(MethodArgumentNotValidException ex) {
        Map&lt;String, String&gt; resp = new HashMap&lt;&gt;();
        ex.getBindingResult().getAllErrors().forEach((error) -&gt; {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            resp.put(fieldName, message);
        });
        return new ResponseEntity&lt;&gt;(resp, HttpStatus.BAD_REQUEST);
    }
}
</pre>

<hr>

<h1>🧩 Field Validations in Spring Boot Model</h1>

<ul>
  <li><strong>fName</strong> → <code>@NotBlank</code>, <code>@Size(min = 4)</code></li>
  <li><strong>lName</strong> → <code>@NotBlank</code></li>
  <li><strong>email</strong> → <code>@NotBlank</code>, <code>@Email</code></li>
  <li><strong>gender</strong> → <code>@NotBlank</code></li>
</ul>

<pre><code>@NotBlank(message = "First name is required")
@Size(min = 4, message = "First name must be at least 4 characters")
private String fName;

@NotBlank(message = "Last name is required")
private String lName;

@NotBlank(message = "Email is required")
@Email(message = "Email should be valid")
private String email;

@NotBlank(message = "Gender is required")
private String gender;
</code></pre>


<hr>

<h2>📊 H2 Database Console</h2>

<p>Access the in-memory database at:</p>
<pre>http://localhost:8081/h2-console</pre>

<p>Use these credentials:</p>
<ul>
  <li>JDBC URL: <code>jdbc:h2:mem:testdb</code></li>
  <li>Username: <code>sa</code></li>
  <li>Password: <code>password</code></li>
</ul>

<hr>

<h2>🧩 Architecture Flow</h2>

<pre>
Client (Postman / Browser)
       ↓
Controller Layer (EmployeeController)
       ↓
Service Layer (EmployeeService)
       ↓
Repository Layer (EmployeeRepository)
       ↓
Database (H2 in-memory)
</pre>

<hr>

<h2>👨‍💻 Author</h2>
<p><b>Developed by:</b> Suvam Debnath</p>
