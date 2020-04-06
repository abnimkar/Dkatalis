PROJECT DESCRIPTION:

This Project is for Automation of https://demo.midtrans.com/ which contains the automation flow for
successful and unsuccessful Credit Card Payment.

This is a maven and TestNG project which contains different packages for example:

Pages package Contains: Page Object Model Classes with Page Factory Implemented in it and methods related to
different Selenium Actions.

Reusable Methods package Contains: Reusable Methods Classes with some important methods which are require by
Framework again and again.

TestBase package Contains: TestBase Class which is used for Initializing of Webdriver and launch of browser.
This class also ensures only single instance of Webdriver has been passed to through all the classes present
in framework.

Utilty Package Contains: Utility Class which is used to readin the data from Property file and reding the data
from Excel File as per our requirement.

resources.Config Package Contains: Config.properties file which is used to store the concrete data which means
data which will not change in future.

Test.java package Contains: Test cases, This name can be changed as per our testing and this package will have
different test cases classes for different scenarios.

Pom.xml: requires of dependency and plugin management.

TestNG.xml: name of test cases required which need to be executed.