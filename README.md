# SSRAD
## SSRAD Repeat Project
Project was created using the Spring Tool Suite for Eclipse. Project was tested using a Wampserver 3.0.6 (x64) running MySQL 5.7.14 on Google Chrome.

### To run the project:
1. Download the zip folder with the project files.
2. Open Eclipse and import an existing Maven project, pointing to the unzipped folder with project files.
3. Start Wampserver and create a database called "books"
4. In Eclipse, Run the project as a Spring Boot application
5. Go to localhost:8080/

### Testing the application
When the user tries to access any page other than the "/" path, a login will be required. As per specifications, a user with username="user" and password="user" will work for the authentication.
Once logged in, the user can browse any of the other links provided as well as log out from Show Customers page.


