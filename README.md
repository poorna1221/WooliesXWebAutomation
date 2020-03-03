# Project Title

 Create an automated smoke test suite for the Acceptance Criteria: I want to be able to add 2 items to the cart and place an order

## Tools/Frameworks used

● Selenium is used along with cucumber BDD framework to complete this task.

### Framework Details

● I have used page object model and updated all application related objects in the java class PageObjects.Java which is located inside the package stepdefinition. Usually i will create multiple classes one for each page, but since the task is simple I have updated all the page objects in the same PageObjects.Java class.

● I have provided all the test data in the ObjectRepository.properties file such that test data maintainence will be easy to whoever wants to modify the test data. ● I have maintainded the scenario is the feature file(AddItemsToCart.feature) using gherkin language/cucubmber framework. The file is located at Feature/AddItemsToCart.feature file and respective implementation for this scenarios is provided in the AddItemsToCart.Java file which is located in stepdefinition package. ● Scenarios to be executed will be provided in the TestRunner.Java class using the tags attribute as tags= {"@smoketest"} to execute all scenarios in the Feature files which are marked as @smoketest. ● Once the testcase is executed results can be viewed at test-output/index.html file ● All the dependencies are provided in the pom.xml file

#### Prerequisites

I assume following software's are installed on the machine where this project will be executed.

● Java 1.8(Path and Class path configured) ● Eclipse(Eclipse IDE for Java Developers or any eclipse to import and execute the project)

● User should already have an account in automationpractice website and shipping address is provided in the account.

##### Running the tests

● Open Eclipse->Import the downloaded Project from Github->Wait for eclipse to build the workspace

● Navigate to src/main/java->runner package->Open TestRunner.Java class-> Right click and run as Junit test

● Program execution will be started and wait till the execution is completed.

● Naviate to /test-output/index.html page to view the results.
