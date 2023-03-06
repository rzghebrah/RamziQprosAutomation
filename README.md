# Q-Pros Automation Assignment
# Assignee: Ramzi Abu Zghebrah

# What:
UI Automation framework that test use cases in QPros Technical Assessment. framework was implemented using Selenium webdriver + Java 8 abd TestNG unit test framework. Also, Extent Report is used as a reporting solution.


# How to Run
1- Run "Executor" class under path ```"src/test/java/com/qpros/demoblaze/executor/Executor.java"```

2- Run ```"execute.xml"```

* If you want to execute test in headless mode, please add "headless_mode=true" to the execution VM options ```"-Dheadless_mode=true"```  [Default value is false and browser session will start]

# Reporting
two reporting types are available:

1- TestNG report after execution

2- Extent report (HTML Report) with structured design and a pleasing user interface, this report is saved after each execution under ```"target/Reports"``` path


* Note: Screenshot for failed cases are saved under ````"target/screenshots"````