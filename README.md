# Student Management System

## Overview
The Student Management System is a web-based application built using the Spring MVC framework, designed to manage student records with CRUD (Create, Read, Update, Delete) operations. This project provides a user-friendly interface to add, view, edit, and delete student information (ID, name, and email) while incorporating logging functionality to track application activities. It is an educational example showcasing Spring Boot integration with MySQL, Thymeleaf templating, and Aspect-Oriented Programming (AOP) for logging.

## Technologies Used
- **Java**: 21 (with potential adjustment to 15 due to Maven configuration)
- **Spring Framework**: 6.1.14 (MVC, JDBC, AOP)
- **Thymeleaf**: 3.1.2.RELEASE (for dynamic HTML templating)
- **MySQL**: 8.0.33 (database)
- **HikariCP**: 5.1.0 (connection pooling)
- **SLF4J/Logback**: 2.0.16 / 1.5.12 (logging)
- **Maven**: For dependency management and build
- **AspectJ**: 1.9.22.1 (for AOP)
- **Jakarta Servlet API**: 6.0.0
- **Hibernate Validator**: 6.2.5.Final (input validation)

## Features
- **CRUD Operations**: Add, view, edit, and delete student records.
- **Input Validation**: Ensures valid name and email formats using Hibernate Validator.
- **Logging**: Tracks method executions and errors with AOP and Logback, viewable via a logs page.
- **Responsive UI**: Styled with CSS for a clean user interface.
- **Database Integration**: Stores data in a MySQL database with automatic table creation.

## Installation and Setup
1. **Prerequisites**:
   - Java Development Kit (JDK) 15 or 21 (adjust based on `pom.xml` configuration)
   - Maven 3.x
   - MySQL Server
   - Apache Tomcat (or any compatible servlet container)

2. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-username/student-management-system.git
   cd student-management-system

3. Configure MySQL:
   Create a database named studentdb.
   Update SpringConfig.java with your MySQL credentials:
   dataSource.setUsername("your-username");
   dataSource.setPassword("your-password");

   Ensure the database is running on localhost:3306.

4.Build the Project:
  mvn clean install

5.Deploy the WAR File:
  Copy the generated target/student-crud-using-spring.war to your Tomcat webapps directory.
  Start Tomcat and access the application at http://localhost:8080/student-crud-using-spring. 

6.Usage:
  Navigate to the home page and use the navigation links to manage students or view logs.

*Known Issues
Java Version Mismatch: pom.xml specifies Java 21 but uses Java 15 in the compiler plugin. Update <source> and <target> to 21 for consistency.
WebConfig Reference: web.xml references WebConfig, but the configuration is in SpringConfig.java. Update the path or rename the class.
Security: Database credentials are hardcoded in SpringConfig.java. Consider using environment variables or a properties file.

*Contributing
Feel free to fork this repository, submit pull requests, or open issues for enhancements or bug fixes. Contributions are welcome!

*License
This project is licensed under the MIT License - see the LICENSE file for details.

*Acknowledgments
Inspired by educational examples from the Spring community.
Thanks to the open-source libraries that power this project.


---

### **Explanation**
- **Overview**: Provides a high-level description of the project's purpose and technical foundation.
- **Technologies Used**: Lists all libraries and frameworks, ensuring clarity for potential contributors.
- **Features**: Highlights key functionalities to attract users and developers.
- **Installation and Setup**: Offers step-by-step instructions, including prerequisites and configuration details, with code examples for MySQL setup.
- **Known Issues**: Notes potential problems (e.g., Java version mismatch, security concerns) to guide future improvements.
- **Contributing and License**: Encourages collaboration and specifies licensing terms.
- **Acknowledgments**: Gives credit to influences and dependencies.

### **Customization**
- Replace `https://github.com/your-username/student-management-system.git` with your actual GitHub repository URL.
- Add a `LICENSE` file if not already present, and update the link accordingly.
- Adjust the MySQL credentials and port in the setup instructions based on your environment.

This README provides a solid foundation for your GitHub project page. Let me know if you'd like to refine it further or add specific sections!
