package com.qpros.demoblaze.executor;

import com.qpros.demoblaze.common.Constants;
import com.qpros.demoblaze.scenarios.TestCases;
import com.qpros.demoblaze.utils.AutomationUtil;
import com.qpros.demoblaze.utils.DriverUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.LocalDateTime;

public class Executor {

    public WebDriver driver;
    ExtentReports extentReports;
    ExtentTest extentTest;
    AutomationUtil automationUtil = new AutomationUtil();

    @BeforeTest
    public void setup(){
        extentReports = new ExtentReports(Constants.REPORT_PATH + "AutomationReport_" + LocalDateTime.now() + ".html", false);
        DriverUtil driverUtil = new DriverUtil();
        driver = driverUtil.initiateWebDriver();
    }

    @Test
    public void executeTest(){
        TestCases testCases = new TestCases(driver);
        testCases.registerAndLogin(extentReports);
        testCases.validateCategoryItemsExistence(extentReports);
        testCases.addRandomItem(extentReports);
        testCases.removeItem(extentReports);
        testCases.completeCheckout(extentReports);
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        Reporter.setCurrentTestResult(result);
        if(ITestResult.FAILURE == result.getStatus()){
            automationUtil.takeScreenshot(driver);
        }
        extentReports.endTest(extentTest);
        extentReports.flush();
        driver.quit();
    }
}
