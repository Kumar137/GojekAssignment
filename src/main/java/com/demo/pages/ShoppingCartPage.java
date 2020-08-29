package com.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.GenericUtils;

public class ShoppingCartPage {

    WebDriver driver;
    GenericUtils utils;
    public ShoppingCartPage(WebDriver driver)
    {
        this.driver=driver;
        utils=new GenericUtils(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//div[@class='cart-checkout']")
    WebElement CheckoutBtn;

    public void checkout()
    {
        utils.waitForElementPresent(CheckoutBtn);
        CheckoutBtn.click();
    }
}
