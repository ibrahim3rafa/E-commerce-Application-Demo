# 🧪 Selenium Automation - E-Commerce Checkout Test

This project demonstrates a Selenium-based automated test for an end-to-end user journey on an e-commerce web
application. It covers login, product selection, cart validation, and completing an order.

## 📌 Project Structure

```
├── StandAloneTest.java            # Entry point to run the full test
├── abstractComponent.java         # Reusable component for waiting utilities
└── pageObjects/                   # Page Object Model (POM) classes
    ├── landingPage.java           # Handles login and page navigation
    ├── productCatalogue.java      # (Not uploaded) Manages product listing & interaction
    ├── cartPage.java              # Validates cart and proceeds to checkout
    └── placeOrderPage.java        # Final step to place and confirm an order
```

## ✅ Test Workflow

1. **Launch Browser** using ChromeDriver
2. **Login** to the website using credentials
3. **Add Product** ("IPHONE 13 PRO") to the cart
4. **Validate Cart** contents
5. **Proceed to Checkout**
6. **Select Country** from dropdown
7. **Place the Order**
8. **Assert Confirmation Message** is as expected

## 🚀 Getting Started

### Prerequisites

- Java SDK 11+
- Maven
- Chrome browser
- ChromeDriver (make sure it's in your PATH)
- Selenium WebDriver
- TestNG or JUnit (optional for future enhancements)

## 📦 Technologies Used

- Java
- Selenium WebDriver
- Page Object Model (POM) Design Pattern
- JUnit (for assertions)
- ChromeDriver

## 🔍 Highlights

- Use of explicit and implicit waits
- Page Object Model for maintainable and scalable test design
- Assertions for cart validation and order confirmation

## 🛠️ Future Enhancements

- Integrate with TestNG or JUnit test suites
- Add `productCatalogue.java` to complete the POM
- Parameterize input (e.g. product name, user credentials)
- Extend test scenarios (e.g. negative tests, search functionality)

## 👤 Author

**Ibrahim Arafa**  
[LinkedIn](https://www.linkedin.com/in/ibrahim-arafa/) | [GitHub](https://github.com/ibrahim3rafa)

---

