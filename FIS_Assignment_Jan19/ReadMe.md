# Selenium and REST-Assured Automation Framework

This is a hybrid automation framework designed for both **UI Testing** and **API Testing** using **Selenium**, **REST-Assured**, **TestNG**, and **ExtentReports**.

---

## **Features**
1. **UI Testing**
    - Automates web application testing using Selenium WebDriver.
    - Page Object Model (POM) design pattern for maintainability and scalability.

2. **API Testing**
    - Automates RESTful API testing using REST-Assured.
    - Extensible utility classes for reusable API methods.

3. **Reports**
    - Generates detailed HTML reports using ExtentReports.

4. **Configurable**
    - `config.properties` file for environment-specific configurations.

5. **Maven Profiles**
    - Separate Maven profiles to execute different test suites (e.g., UI, API).

6. **Customized WebDriver Waits**
    - Utility methods for explicit waits in Selenium.

---

## **Prerequisites**
- Java 17 or higher
- Selenium 4.2 and above
- Maven 3.9 or higher
- WebDriver binaries for browsers (e.g., ChromeDriver)
- TestNG plugin
- Extent Reports plugin

---

## **Framework Structure**

```plaintext
src/
├── main/
│   ├── java/
│   │   ├── pages/             # Page classes for UI automation
│   │   ├── utils/             # Utility classes for common operations
├── test/
│   ├── java/
│   │   ├── tests/             #Base Test and Test classes for UI and API 
│   │   ├── utils/             #API Utils class 
│   └── resources/
│       └── config.properties  # Configuration file
│       └── testng.xml file
├── test-output/               # TestNG and ExtentReports output
├── target/                    # Compiled classes and test results
├── pom.xml                    # Maven build file
└── .gitignore                 # Files and folders to exclude from Git