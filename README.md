# Q-Pros Automation Assignment
# Assignee [Ramzi Abu Zghebrah]

# What:
UI Automation framework "data driven" following page object model design, maven based project to test use cases in QPros Technical Assessment. framework was implemented using Selenium WebDriver + Java 8 and TestNG unit test framework. Also, HTML Extent Report is used as a reporting solution.


# How to Run
The below two ways are available to run the test:

1- Run "Executor" class under path ```"src/test/java/com/qpros/demoblaze/executor/Executor.java"```

2- Run ```"execute.xml"```

* If you want to execute test in headless mode, please add "headless_mode=true" to the execution VM options ```"-Dheadless_mode=true"```  [Default value is false and browser session will start]
* If you would like to test the same flow with different login credentials, please add the new username in data provider under "UsernameData" method --> class ```Executor.java```

# Reporting
Two reporting types are available:

1- Extent report (HTML Report) with structured design and a pleasing user interface, this report is saved after each execution under ```"target/Reports"``` path

2- TestNG report after execution


* Note: Screenshot for failed cases are saved under ````"target/screenshots"````