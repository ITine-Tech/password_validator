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