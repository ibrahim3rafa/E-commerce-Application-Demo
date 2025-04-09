# E-commerce Test Automation Framework

![Selenium](https://img.shields.io/badge/-Selenium-43B02A?logo=selenium&logoColor=white)
![TestNG](https://img.shields.io/badge/-TestNG-FF6464?logo=testng&logoColor=white)
![Java](https://img.shields.io/badge/-Java-007396?logo=java&logoColor=white)

A robust test automation framework for e-commerce applications using Selenium WebDriver, TestNG, and Java with Page Object Model design pattern.

## Features

- **Page Object Model** implementation for maintainable test code
- **Data-Driven Testing** with JSON data files
- **TestNG** integration for test execution and reporting
- **Error Handling** with dedicated validation tests
- **Cross-Browser** support (configurable)
- **Screenshot** capability for test failures
- **Grouping Tests** for selective execution
- **Dependent Tests** for order verification

## Framework Structure

## e-commerce-test-framework/
# Framework Structure

e-commerce-test-framework/
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── abstractComponents/
│   │       │   └── abstractComponent.java
│   │       ├── pageObjects/
│   │       │   ├── cartPage.java
│   │       │   ├── landingPage.java
│   │       │   ├── orderPage.java
│   │       │   ├── placeOrderPage.java
│   │       │   ├── productCatalogue.java
│   │       │   └── submitPage.java
│   │       └── testComponents/
│   │           └── baseTest.java
│   └── test/
│       ├── java/
│       │   ├── testData/
│       │   │   └── dataReader.java
│       │   └── tests/
│       │       ├── errorValidationsTest.java
│       │       ├── StandAloneTest.java
│       │       └── submitOrderTest.java
│       └── resources/
│           ├── testData/
│           │   └── purchaseOrder.json
│           └── config/
│               ├── globalData.properties
│               ├── errorHandling.xml
│               ├── purchcase.xml
│               └── testng.xml
└── pom.xml

## Prerequisites

- Java JDK 8+
- Maven 3.6.3+
- Chrome/Firefox browser
- Selenium WebDriver 4.0.0+
- TestNG 7.4.0+


## Prerequisites

- Java JDK 8+
- Maven
- Chrome/Firefox browser
- Selenium WebDriver

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/ibrahim3rafa/E-commerce-Application-Demo.git


## Configuration
Update globalData.properties with your browser preferences:

## properties

browser=chrome

## Test Data
[
{
"mail": "your-email@example.com",
"pass": "your-password",
"productName": "PRODUCT_NAME"
}
]



## Test Cases

Login Error Validation - Verifies incorrect login scenarios

Product Validation - Checks product presence in cart

Order Submission - Complete purchase flow

Order Verification - Confirms order appears in history


## Key Components
- baseTest.java: Base class with setup/teardown and utilities

- abstractComponent.java: Reusable WebDriver methods

- Page Objects: Represent application pages and elements

- Data Providers: Supply test data from JSON files

## Best Practices
- Follows Page Object Model pattern

- Uses explicit waits for element interactions

- Implements clean separation of test code and page logic

- Supports parallel test execution

- Includes screenshot capability for debugging

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.