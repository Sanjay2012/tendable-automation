# Tendable Automation Testing Project
## Project Description
This repository contains automated test scripts for testing key functionalities of the Tendable website using Selenium WebDriver and TestNG. These scripts are designed to verify critical user interactions and validate error handling mechanisms for form submissions.

##  Test Scenarios
The following scenarios are automated in this project:

1. Top-Level Menu Accessibility
Verifies the presence and accessibility of the  "About", "Products", "Sectors", "Content Hub" and "Contact" menus.

2. "Request a Demo" Button Validation
Confirms the presence and activation of the "Request a Demo" button on all top-level menu pages.

3. "Contact Us" Form Validation
Tests the error handling mechanism when the "Message" field is left blank in the "Contact Us" form.

## Strategy
Approach:
Reusable Methods:
Built reusable methods for driver setup & Tear down in Base Test class for better maintainability and scalability.

POM pattern:
Used POM pattern to write elements & respective actioning methods for each page for better maintainability & to extend it for further test cases

TestNG Annotations:
Used @Test to define individual test cases and grouped them logically to ensure modularity.

Validation Focus:
Scripts emphasize validating visible elements, interactive states, and error messages, ensuring robustness in user experience.

##  Tools & Frameworks:
1. Programming Language: Java
2. Framework: TestNG
3. Browser: Google Chrome
4. Build Tool: Maven
5. Version Control: GitHub
6. How to Run the Tests > using maven commands or run testng.xml file 

## Pre-requisites:
1. Install Java Development Kit (JDK).
2. Install Apache Maven.
3. Install Google Chrome and ensure the ChromeDriver version matches the browser version.

## Clone this repository:
> git clone https://github.com/your-repository-name/tendable-automation.git

> cd tendable-automation

## Steps to Run:
Install Dependencies: Execute the following Maven command to download all dependencies:
> mvn clean install

Execute TestNG Suite: Run all test cases using the TestNG XML file:
> mvn test

Run Individual Test Classes: To execute a specific test class, use:
> mvn -Dtest=TestClassName test

Example:
> mvn -Dtest=ContactUsFormTest test

View Test Results: Test results are available in the target/surefire-reports directory.

## Bug Report
A bug report has been included in this repository to document a known issue with the "Contact Us" form validation.

## Author
Sanjay
For queries, reach out at sanjaywaware04@gmail.com.

