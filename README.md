# Calculator App Automation
### Project Summary: This project automates calculator app testing using Appium, TestNG and Selenium. The first task involves dynamically calculating a mathematical series, passed as a parameter, and verifying the result. The second task automates series calculations from a CSV file, handling complex expressions like 4π2^3, and asserting expected results using SoftAssert in TestNG. The project demonstrates effective automation of both basic and advanced calculations through a robust framework.

### Technologies I have used: 
- Language: Java
- Build System: Gradle
- Automation tool and framework: Appium, Selenium, and TestNG
- IDE: IntelliJ IDEA
- Android Tools: Android Studio (for emulator and SDK management)
- Data Handling: Apache Commons CSV for parsing CSV files
  
### Project Flow:
- Pass a series as a parameter to the test method to automate its calculation and assert the result (e.g., 100/10*5-10+60). (For task-1)
- Read series expressions from a CSV file using Apache Commons CSV, handling operations like π and exponentiation, and assert results against expected values.
- Utilize TestNG’s @DataProvider for parameterized tests and SoftAssert for result validation.
- Implement the Page Object Model (POM) pattern, separating UI interactions in the CalculatorScreen class and test logic in the CalculatorTestRunner class.
- Print and assert calculations from CSV data.
- Run tests using Gradle.
- Generate Allure report.

### How to run?
1. Start the Appium Server: Open Command Prompt and run the Appium server.
2. Launch the Android Emulator: Open Android Studio, navigate to the AVD Manager, and start your preferred emulator.
3. Open IntelliJ IDEA and select New Project.
2. Create a Java project and name it.
3. Open the project in IntelliJ: File > Open > Select and expand folder > Open as project.
4. To run the test suites, execute the command: ```gradle clean test```
7. To generate the Allure report, run: ```allure generate allure-results --clean```
                                       ```allure serve allure-results```

### Screenshots Of the Allure Report:
<img width="960" alt="Screenshot 2024-10-24 235752" src="https://github.com/user-attachments/assets/b2ab34cf-0e7d-4fd1-81ce-2fe5b0708204">
<img width="960" alt="Screenshot 2024-10-24 235822" src="https://github.com/user-attachments/assets/c591f2e2-e1eb-4b02-b1eb-6620360fd1e8">



### Video Record of Calculator App Automation
### https://drive.google.com/file/d/18B1Z51PqclubljTaMwjCGar2t_oQUOxq/view?usp=drive_link



