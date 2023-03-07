package com.qpros.demoblaze.executor;


import org.testng.annotations.*;


public class Executor extends ExecutorBase {

    /**
     * In case you need to execute the same available test on different users
     */
    @DataProvider(name = "user login")
    public Object[][] usernameData() {
        return new Object[][]{
                {"QPros_" + automationUtil.generateRandomValue()}
        };
    }

    @Test(dataProvider = "user login")
    public void executeTests(String username) {
        extentTest = extentReports.startTest("QPros Technical Assessment Scenario - For user: " + username);
        testCases.registerAndLogin(extentTest, username);
        testCases.validateCategoryItemsExistence(extentTest);
        testCases.addRandomItem(extentTest);
        testCases.removeItem(extentTest);
        testCases.completeCheckout(extentTest);
    }
}
