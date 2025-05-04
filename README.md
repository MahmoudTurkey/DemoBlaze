# 🛒 Demoblaze Web Automation Final Project

This project automates key user scenarios for the [Demoblaze](https://www.demoblaze.com/) e-commerce website using **Java**, **Selenium WebDriver**, **TestNG**, and **Cucumber (BDD)**. It verifies user journeys like sign-up, login, product selection, and checkout.

---

## ✅ Features Covered

### Positive Scenarios

- **User Sign-Up**: Verify that a new user can successfully register.
- **Product Purchase Flow**:
    - Login with valid credentials
    - Add two laptops to the cart
    - Verify cart contents and total price
    - Complete checkout with valid customer details

### Negative Scenarios (Bonus)

- Attempt sign-up with an **existing username**
- Try purchasing with an **expired credit card**
- Add the **same product twice** and confirm quantity update
- Login using **invalid credentials**

---

## 🧪 Technologies Used

- **Language**: Java
- **Automation**: Selenium WebDriver
- **Frameworks**: TestNG, Cucumber (BDD)
- **Reporting**: Extent Reports, Allure Reports
- **Version Control**: Git / GitHub

---

## 📁 Project Structure
├── .idea/ # IDE configuration
├── .mvn/ # Maven wrapper files
├── allure-report/ # Generated Allure report
├── allure-results/ # Raw Allure results
├── Demo Video/ # Test demo video
├── src/
│ └── test/
│ └── java/
│ ├── Locator/ # Page locators
│ ├── StepDefinition/ # Step definitions for Cucumber
│ │ ├── Hooks.java
│ │ ├── TC01_SignUp_Steps.java
│ │ ├── TC02_Products_Steps.java
│ │ └── TC03_TheSameProduct.java
│ ├── TestRunner/ # Cucumber test runner
│ │ └── TestRunner.java
│ └── Utils/ # Utility classes
│
│ └── resources/ # Feature files
├── target/ # Compiled test results
├── .gitignore
├── pom.xml # Maven configuration
└── README.md

## 🧪 How to Run the Tests

1. **Clone the repository**:
   ```bash
   git clone https://github.com/MahmoudTurkey/demoblaze-automation.git
   cd demoblaze-automation
Install dependencies:

bash
Copy
Edit
mvn clean install
Run tests:

bash
Copy
Edit
mvn test
Generate Allure report:

bash
Copy
Edit
mvn allure:report
mvn allure:serve

📹 Demo

You can find a demo video in the Demo Video folder.

📄 Reporting

All test executions are logged and visually reported using Allure Reports. After running the tests, open the report using:

bash
Copy
Edit
mvn allure:serve

✍️ Authors

MahmoudTurkey - Test Automation Engineer

Contact: mahmoudtorki79@gmail.com