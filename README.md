# password_validator

## Table of Contents
***
1.	[General Info] (#general-info)
2.	[Technologies] (#technologies)
3.	[Installation] (#installation)
4.	[Collaboration] (#collaboration)


## General Info
***
Our projekt is a password validator. It was create and documented by Christine Gundel, Celine Hager and Tina Ranft. Our task was: 
1.	A JAR file containing your implementation.
*	Jar file should be pushed to maven repo as described in the exercice, but is it not a strict requirement.
2.	A link to GitHub repo (or a Zip file) with source code, unit tests, and a README with a description of your criterion.
*	At least source code must contain javadoc comments.
*	README format can be any of [plain text, markdown, pdf, latex]. Please do not use exotic formats such as Microsoft Word.
*	NB. Note that zip file, javadoc file, ar any file can also be pushed to maven repo.
*	Requirements:
* Implement the PasswordValidator interface.
*	Ensure your JAR file can be executed by the testing program.
*	Include detailed unit tests that verify your password validation logic.
*	Write a README explaining your criterion, and how it ensures security (or creativity).
*	Document your code with Javadoc.

## Technologies
***
A list of technologies used within the project:
*	[java] : Version 23
*	[maven] : Version 3.13.0
*	[Junit] : Version 5.11.2

## Installation
***
* Compile and run the program in the program directory:
Use javac *.java to compile, and java *.java to run

* Make a JAR (Java Archive) using Maven:
Run: mvn clean package in the root directory 
--> Jar is being created in the target directory

**Compile and run the PasswordValidatorTester:** 
* Compile the tester: 
javac -d target/classes src/main/java/com/chrisceltin password_validator/*.java src/main/java/com/cthiebaud/*.java

* Run the tester:
java -cp target/classes:target/my-app-1.0-SNAPSHOT.jar com.cthiebaud.PasswordValidatorTester target/my-app-1.0-SNAPSHOT.jar

## Collaboration
***
You have to choose your password. 
Your password must include at least:
* One upper letter
*	Five lower letter
*	One number
*	Your favorite animal
*	not contain any whitespace
  
If you do everything right, our project says password valid.

