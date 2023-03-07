package com.qpros.demoblaze.executor;

import com.qpros.demoblaze.common.Constants;
import com.qpros.demoblaze.scenarios.TestCases;
import com.qpros.demoblaze.utils.AutomationUtil;
import com.qpros.demoblaze.utils.DriverUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.time.LocalDateTime;

public class ExecutorBase {

    public WebDriver driver;
    static ExtentReports extentReports;
    ExtentTest extentTest;
    TestCases testCases;
    AutomationUtil automationUtil = new AutomationUtil();

    static {
        extentReports = new ExtentReports(Constants.REPORT_PATH + "AutomationReport_" + LocalDateTime.now() + ".html", false);
    }

    @BeforeMethod
    public void setup() {
        DriverUtil driverUtil = new DriverUtil();
        driver = driverUtil.initiateWebDriver();
        testCases = new TestCases(driver);
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        Reporter.setCurrentTestResult(result);
        if (ITestResult.FAILURE == result.getStatus()) {
            automationUtil.takeScreenshot(driver);
            extentTest.log(LogStatus.FAIL, "Failed Scenario, please see screenshot");
        }
        extentReports.endTest(extentTest);
        extentReports.flush();
        driver.quit();
    }
}
