# testprojectjunit

### Run Tests

Execute Below commands to run tests in feature classes  

##### mvn clean test

The above will generate the allure results will get generated in the 'target/allure-results' folder. 

### View Allure reports

Extract allure-2.7.0.zip and add the allure bin folder to system path file

Check allure version with below command

##### allure --version

On project base directory run below command. This will open the report on Chrome or the default browser

##### allure serve target/allure-results