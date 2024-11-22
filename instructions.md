Ablauf
mvn compile
mvn package
mvn install
* Run the jar file (Mind you: Complete name of jar file)
java -jar password-validator-1.0.0-20241121.173543-6.jar target/password_validator-1.0-SNAPSHOT.jar

**Compile and run the PasswordValidatorTester:** 
* Compile the tester: 
--> hinfällig, weil wir den Tester nicht direkt implementieren sollen

javac -d target/classes src/main/java/com/chrisceltin password_validator/*.java 

* Run the tester:
java -cp target/classes:target/my-app-1.0-SNAPSHOT.jar com.cthiebaud.PasswordValidatorTester target/my-app-1.0-SNAPSHOT.jar


**Problem**
rm -rf ~/.m2/repository/com/cthiebaud/password-validator/1.0.0
mvn clean install -U