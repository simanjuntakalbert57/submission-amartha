# API Automation Testing

## Overview
This project is designed for API automation testing using TestNG and Rest-Assured with Java as the programming language. The build management tool used for this project is Maven.

## Features
- API testing using **Rest-Assured**
- Test execution and reporting with **TestNG**
- **Java** as the programming language
- **Maven** for project dependency management

## Prerequisites
Before running the tests, ensure that you have the following installed:
- **Java JDK 8 or later**
- **Apache Maven**
- **An IDE (such as IntelliJ IDEA or Eclipse)**

## Installation
1. Clone the repository:
   ```sh
   git clone <repository-url>
   ```
2. Navigate to the project directory:
   ```sh
   cd <project-folder>
   ```
3. Install dependencies:
   ```sh
   mvn clean install
   ```

## Running Tests
To execute the API tests, run the following command:
```sh
mvn test
```

To run tests with a specific TestNG suite:
```sh
mvn test -DsuiteXmlFile=testng.xml
```

## Reporting
After running the tests, you can view the reports generated by TestNG.
The reports are located in the `test-output` folder.

## License
This project is open-source and can be modified as per requirements.


