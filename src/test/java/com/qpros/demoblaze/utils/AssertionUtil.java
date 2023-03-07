package com.qpros.demoblaze.utils;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;

import static com.qpros.demoblaze.logger.AutomationLogger.Logger;

public class AssertionUtil {

    public void assertResponseMessage(String actualMessage, String expectedMessage, String extraMessage, ExtentTest extentTest) {
        String successValidationMessage = extraMessage + " validation passed and messages match, *** Expected Message: " + expectedMessage + " *** Actual Message: " + actualMessage;
        String failedValidationMessage = extraMessage + " validation failed and messages doesn't match, *** Expected Message: " + expectedMessage + " *** Actual Message: " + actualMessage;
        if (actualMessage.equals(expectedMessage)) {
            Logger(successValidationMessage);
            extentTest.log(LogStatus.PASS, successValidationMessage);
            Assert.assertTrue(true);
        } else {
            Logger(failedValidationMessage);
            extentTest.log(LogStatus.FAIL, failedValidationMessage);
            Assert.fail(failedValidationMessage);
        }
    }

    public void booleanAssertion(boolean condition, String extraMessage, ExtentTest extentTest) {
        String successAssertion = extraMessage + " Validation Passed";
        String failedAssertion = extraMessage + " Validation Failed";
        if (condition) {
            Logger(successAssertion);
            extentTest.log(LogStatus.PASS, successAssertion);
            Assert.assertTrue(true);
        } else {
            Logger(failedAssertion);
            extentTest.log(LogStatus.FAIL, failedAssertion);
            Assert.fail(failedAssertion);
        }
    }

}
