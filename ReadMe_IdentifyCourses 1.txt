# Identify Courses
## Overview
This project aims to automate the coursera.org website  using Selenium WebDriver. The automation process involves Handling different webpages, search option,Extract multiple drop down list items & store in collections, Navigating back to home page, Scrolling down in web page, Capture warning message.

## Libraries and Dependencies
- Maven Repository: Maven 4.0.0
- TestNG: 7.10.2
- Selenium: 4.21.0
- Extent Report: 5.1.1
- Apache POI: 5.2.2

## Automation Flow
1. Navigate to coursera.org website.
2. Search for web development courses for Beginners level and English language.
3. Extract the course names, total learning hours & rating for first 2 courses
4. Extract all the languages and different levels with its total count & display them.
5. In Home page, go to "For Enterprise"; Look into Courses for Campus under Product; Fill the  "Ready to transform" form with any one input invalid.
6. Capture the error message & display.

## How to Run
1. Open Eclipse IDE
2. Launch Eclipse IDE on your machine.
Import Project:
3. Select File -> Import from the menu.
4. Choose Existing Maven Projects and click Next.
5. Browse to the directory where you cloned the repository and select the project.
Update Maven Project:
6. Right-click on the project in the Project Explorer.
7. Choose Maven -> Update Project.
8. Click OK to update dependencies.
Update any configuration parameters like browser type, URLs, etc., if needed.

## Run Test Suite:
1. Locate the test suite file (testng.xml)
2. Right-click on the file and choose Run As -> TestNG Suite.

## Libraries Explanation:
- Maven Repository: Used for project management and dependency resolution.
- TestNG: Facilitates test case organization and execution.
- TestNG Report: Generates comprehensive test reports.
- Selenium WebDriver: Automates browser interactions.
- Extent Report : Generate Comprehensive test report .

## View Reports
1. After execution, open the test-output folder.
2. Find the TestNG file (index.html) for detailed test case reports.
3. For Extent Report, navigate to testngReports folder.

## Screenshots
Screenshots captured during test execution are stored in the HackathonScreenShots folder which is present in the project 

## Analyze Results
Utilize the visual representation in the TestNG Report to quickly identify test status and any issues encountered during the test run.

## Logs
Post execution of the project, failed test cases can be rechecked with the logs -> app.log file to understand where the issue has been instantiated.

## Remote Repository
Project folder has been moved to local repository using Git to remote repository, respective pushing of folder is captured and saved in gitBashSS folder.
### Repository link: 
https://github.com/VaishnaviCASGitHub/IdentifyCourses.git

## Team Members
Vanka, Chennaiah(2332944)
C A S, Vaishnavi(2332901)
Shaik, Asif(2318105)
Vamsikrishna, Marripudi(2332922)


