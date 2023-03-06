package com.qpros.demoblaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "signin2")
    private WebElement signupButton;

    public WebElement getSignupButton() {
        return signupButton;
    }

    @FindBy(id = "sign-username")
    private WebElement signupUsernameField;

    public WebElement getSignupUsernameField() {
        return signupUsernameField;
    }

    @FindBy(id = "sign-password")
    private WebElement signupPasswordField;

    public WebElement getSignupPasswordField() {
        return signupPasswordField;
    }

    @FindBy(xpath = "/html/body/div[2]/div/div/div[3]/button[2]")
    private WebElement popupSignupButton;

    public WebElement getPopupSignupButton() {
        return popupSignupButton;
    }

    @FindBy(id = "login2")
    private WebElement loginButton;

    public WebElement getLoginButton() {
        return loginButton;
    }

    @FindBy(id = "loginusername")
    private WebElement loginUsernameField;

    public WebElement getLoginUsernameField() {
        return loginUsernameField;
    }

    @FindBy(id = "loginpassword")
    private WebElement loginPasswordButton;

    public WebElement getLoginPasswordField() {
        return loginPasswordButton;
    }

    @FindBy(id = "nameofuser")
    private WebElement welcomeMessage;

    public WebElement getWelcomeMessageButton() {
        return welcomeMessage;
    }

    @FindBy(xpath = "/html/body/div[3]/div/div/div[3]/button[2]")
    private WebElement popupLoginButton;

    public WebElement getPopupLoginButton() {
        return popupLoginButton;
    }

    @FindBy(id = "logout2")
    private WebElement logoutButton;

    public WebElement getLogoutButton() {
        return logoutButton;
    }
}
