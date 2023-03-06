package com.qpros.demoblaze.scenarios;

import com.qpros.demoblaze.common.Constants;
import com.qpros.demoblaze.pages.*;
import com.qpros.demoblaze.utils.AssertionUtil;
import com.qpros.demoblaze.utils.AutomationUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TestCases extends PageBase {

    ExtentTest extentTest;
    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);
    CartPage cartPage = new CartPage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);

    AssertionUtil assertionUtil = new AssertionUtil();
    AutomationUtil automationUtil = new AutomationUtil();

    String username = "Qpros_" + automationUtil.generateRandomValue();

    public TestCases(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    /**
     * Method that navigates to https://www.demoblaze.com/ website signup using a new random user, validate successful signup and login using the created user.
     */
    public void registerAndLogin(ExtentReports extentReports) {
        extentTest = extentReports.startTest("Register and Login to https://www.demoblaze.com/");
        /* Navigate to website and signup */
        driver.get(Constants.DEMO_BLAZE_WEBSITE);
        doSignup();
        /* validate success message on signup */
        waitAlertIsPresent();
        String actualMessage = driver.switchTo().alert().getText();
        assertionUtil.assertResponseMessage(actualMessage, Constants.EXPECTED_SIGNUP_SUCCESS_MESSAGE, "Signup Verification:", extentTest);
        driver.switchTo().alert().accept();
        /* Login and validate successful login */
        doLogin();
        String welcomeMessage = homePage.getWelcomeMessageButton().getText();
        assertionUtil.assertResponseMessage(welcomeMessage, Constants.EXPECTED_WELCOME_MESSAGE + username, "Login Verification:", extentTest);
    }

    /**
     * Steps to complete signup
     */
    private void doSignup() {
        homePage.getSignupButton().click();
        waitElementIsClickable(homePage.getSignupUsernameField());
        homePage.getSignupUsernameField().sendKeys(username);
        homePage.getSignupPasswordField().sendKeys(Constants.LOGIN_PASSWORD);
        homePage.getPopupSignupButton().click();
    }

    /**
     * Steps to complete login
     */
    private void doLogin() {
        homePage.getLoginButton().click();
        waitElementIsClickable(homePage.getPopupLoginButton());
        homePage.getLoginUsernameField().sendKeys(username);
        homePage.getLoginPasswordField().sendKeys(Constants.LOGIN_PASSWORD);
        homePage.getPopupLoginButton().click();
        waitMilliseconds(1000);
        waitElementIsClickable(homePage.getLogoutButton());
    }

    /**
     * Method that validates each category in the login page at least has 1 item
     */
    public void validateCategoryItemsExistence(ExtentReports extentReports) {
        extentTest = extentReports.startTest("Check the listed Categories has Items");
        loginPage.getPhonesCategoryButton().click();
        String getListText = loginPage.getFirstElementInCategoryList().getText();
        assertionUtil.booleanAssertion(!getListText.equals(""), "Phones List", extentTest);
        loginPage.getLaptopsCategoryButton().click();
        assertionUtil.booleanAssertion(!getListText.equals(""), "Laptops List", extentTest);
        loginPage.getMonitorsCategoryButton().click();
        waitMilliseconds(1000);
        assertionUtil.booleanAssertion(!getListText.equals(""), "Monitors List", extentTest);
    }

    /**
     * Method that add random item to the cart and validate that item has been added successfully
     */
    public void addRandomItem(ExtentReports extentReports) {
        extentTest = extentReports.startTest("Validate adding random item to the cart");
        waitElementIsClickable(loginPage.getFirstElementInCategoryList());
        addItemToCart();
        String actualMessage = driver.switchTo().alert().getText();
        assertionUtil.assertResponseMessage(actualMessage, Constants.EXPECTED_ITEM_ADDITION_SUCCESS_MESSAGE, "Adding item to cart:", extentTest);
        driver.switchTo().alert().accept();
    }

    /**
     * Method validate removing items from the cart
     */
    public void removeItem(ExtentReports extentReports) {
        extentTest = extentReports.startTest("Validate removing item from cart");
        cartPage.getCartButton().click();
        waitElementIsClickable(cartPage.getDeleteItemButton());
        cartPage.getDeleteItemButton().click();
        waitMilliseconds(2000);
        String cartElements = cartPage.getItemsTable().getText();
        assertionUtil.booleanAssertion(cartElements.equals(""), "Item Removed:", extentTest);
    }

    /**
     * Method to validate end-to-end checkout process
     */
    public void completeCheckout(ExtentReports extentReports) {
        extentTest = extentReports.startTest("Complete successful checkout with random item");
        loginPage.getHomeButton().click();
        waitMilliseconds(1000);
        addItemToCart();
        driver.switchTo().alert().accept();
        cartPage.getCartButton().click();
        cartPage.getPlaceOrderButton().click();
        waitElementIsClickable(checkoutPage.getNameField());
        checkoutPage.getNameField().sendKeys(Constants.NAME);
        checkoutPage.getCountryField().sendKeys(Constants.COUNTRY);
        checkoutPage.getCityField().sendKeys(Constants.CITY);
        checkoutPage.getCreditCardField().sendKeys(Constants.CREDIT_CARD);
        checkoutPage.getMonthField().sendKeys(Constants.MONTH);
        checkoutPage.getYearField().sendKeys(Constants.YEAR);

        checkoutPage.getPurchaseButton().click();
        waitElementIsClickable(checkoutPage.getOrderConfirmation());
        String confirmationMessage = checkoutPage.getOrderConfirmation().getText();
        assertionUtil.assertResponseMessage(confirmationMessage, Constants.EXPECTED_ORDER_CONFIRMATION_MESSAGE, "Order placed successfully,", extentTest);
    }

    /**
     * Method to add item to cart
     */
    private void addItemToCart() {
        waitElementIsClickable(loginPage.getFirstElementInCategoryList());
        loginPage.getFirstElementInCategoryList().click();
        waitMilliseconds(1000);
        waitElementIsClickable(loginPage.getAddToCartButton());
        loginPage.getAddToCartButton().click();
        waitAlertIsPresent();
    }
}
