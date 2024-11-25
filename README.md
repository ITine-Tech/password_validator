# password_validator

## Table of Contents

---

1. [General Info] (#general-info)
2. [Components] (#components)
3. [Technologies] (#technologies)
4. [Installation] (#installation)

## General Info

---

Our project is a password validator. It was created and documented by Christine Gundel, Celine Hager and Tina Ranft. It is a project of the course "Programming 1" of the Baden-Wuerttemberg Cooperative State University Heilbronn, November 2024.

## Components

---

**MyPasswordValidator**

MyPasswordValidator implements the PasswordValidator Interface and the ValidationResult Record provided by C Thiebaud in a JAR.
The password validation logic enforces the following rules to ensure secure and creative passwords:

- No whitespace
- At least one uppercase letter: Promotes case sensitivity.
- At least five lowercase letters: Increases complexity.
- At least one numeric character: Ensures a mix of character types.
- Include your favorite animal: Adds a creative, user-specific element to the password.

If all criteria are met, the program will confirm with a "Password valid" message.

## Technologies

---

A list of technologies used within the project:

- [java] : Version 23
- [maven] : Version 3.13.0
- [Junit] : Version 5.11.2


## Installation

---

To install and run the project, follow these steps:

1. **Clone the repository**:
   First, clone the repository to your local machine using the following command:

   ```sh
   git clone https://github.com/athenaeum-brew/password-validator-impl.git
   cd password-validator-impl

   ```

2. **Install dependencies:**
   Ensure you have Maven installed. If not, you can download and install it from Maven's official website (https://maven.apache.org/download.cgi). Once Maven is installed, run the following command to install the project dependencies:

    ````sh
    mvn clean install
    ```

3. **Build the project:**
Compile and package the project using Maven:

    ````sh
    mvn package
    ```

4. **Run the application:**
After packaging, you can run the application using the following command: 

   ````sh
   java -jar password-validator-1.0.0-20241121.173543-6.jar target/password_validator-1.0-SNAPSHOT.jar
   ```

5. **Run the tests:**
To run the unit tests, use the following command:

   ```sh
   mvn test
   ````
