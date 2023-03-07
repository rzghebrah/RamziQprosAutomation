package com.qpros.demoblaze.pages;

import com.qpros.demoblaze.common.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageBase {

    protected static WebDriver driver;
    private WebDriverWait _wait;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void waitAlertIsPresent() {
        _wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.ELEMENT_WAIT_PERIOD_SEC));
        _wait.until(ExpectedConditions.alertIsPresent());
    }

    public void waitElementIsClickable(WebElement webElement) {
        _wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.ELEMENT_WAIT_PERIOD_SEC));
        _wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void waitMilliseconds(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
