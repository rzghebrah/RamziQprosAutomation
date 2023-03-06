package com.qpros.demoblaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

    public LoginPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "/html/body/div[5]/div/div[1]/div/a[2]")
    private WebElement phonesCategoryButton;

    public WebElement getPhonesCategoryButton(){return phonesCategoryButton;}

    @FindBy(xpath = "/html/body/div[5]/div/div[1]/div/a[3]")
    private WebElement laptopsCategoryButton;

    public WebElement getLaptopsCategoryButton(){return laptopsCategoryButton;}

    @FindBy(xpath = "/html/body/div[5]/div/div[1]/div/a[4]")
    private WebElement monitorsCategoryButton;

    public WebElement getMonitorsCategoryButton(){return monitorsCategoryButton;}

    @FindBy(xpath = "//*[@id='tbodyid']/div[1]")
    private WebElement firstElementInCategoryList;

    public WebElement getFirstElementInCategoryList(){return firstElementInCategoryList;}

    @FindBy(xpath = "/html/body/div[5]/div/div[2]/div[2]/div/a")
    private WebElement addToCartButton;

    public WebElement getAddToCartButton(){return addToCartButton;}

    @FindBy(xpath = "/html/body/nav/div/div/ul/li[1]/a")
    private WebElement homeButton;

    public WebElement getHomeButton(){return homeButton;}
}
