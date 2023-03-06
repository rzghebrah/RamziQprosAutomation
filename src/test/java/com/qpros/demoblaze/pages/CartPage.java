package com.qpros.demoblaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends PageBase {

    public CartPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "/html/body/nav/div/div/ul/li[4]/a")
    private WebElement cartButton;

    public WebElement getCartButton(){return cartButton;}

    @FindBy(xpath = "/html/body/div[6]/div/div[1]/div/table/tbody/tr/td[4]/a")
    private WebElement deleteItemButton;

    public WebElement getDeleteItemButton(){return deleteItemButton;}

    @FindBy(xpath = "/html/body/div[6]/div/div[1]/div/table/tbody")
    private WebElement itemsTable;

    public WebElement getItemsTable(){return itemsTable;}

    @FindBy(xpath = "/html/body/div[6]/div/div[2]/button")
    private WebElement placeOrderButton;

    public WebElement getPlaceOrderButton(){return placeOrderButton;}
}
