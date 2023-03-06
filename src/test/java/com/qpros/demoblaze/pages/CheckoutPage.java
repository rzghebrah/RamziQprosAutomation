package com.qpros.demoblaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends PageBase{

    public CheckoutPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "name")
    private WebElement nameField;

    public WebElement getNameField(){return nameField;}

    @FindBy(id = "country")
    private WebElement countryField;

    public WebElement getCountryField(){return countryField;}

    @FindBy(id = "city")
    private WebElement cityField;

    public WebElement getCityField(){return cityField;}

    @FindBy(id = "card")
    private WebElement creditCardField;

    public WebElement getCreditCardField(){return creditCardField;}

    @FindBy(id = "month")
    private WebElement monthField;

    public WebElement getMonthField(){return monthField;}

    @FindBy(id = "year")
    private WebElement yearField;

    public WebElement getYearField(){return yearField;}

    @FindBy(xpath = "/html/body/div[3]/div/div/div[3]/button[2]")
    private WebElement purchaseButton;

    public WebElement getPurchaseButton(){return purchaseButton;}

    @FindBy(xpath = "/html/body/div[10]/h2")
    private WebElement orderConfirmation;

    public WebElement getOrderConfirmation(){return orderConfirmation;}
}
