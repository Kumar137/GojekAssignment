package com.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.GenericUtils;

public class HomePage {

    WebDriver driver;
    GenericUtils utils;
    public HomePage(WebDriver driver)
    {
        this.driver=driver;
        utils=new GenericUtils(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//a[@class='btn buy']")
    WebElement BuyBtn;

    @FindBy(xpath="//div[@class='trans-status trans-success']")
    WebElement SuccessMsg;

    public void clickBuyBtn()
    {
        //Test Demo
        utils.waitForElementPresent(BuyBtn);
        BuyBtn.click();
    }

    /*
     *This function verifies the success message on Home page after successful order
     */
    public boolean verifySuccessMessage()
    {
        Boolean bool=utils.waitForElementPresent(SuccessMsg);
        return bool;
    }
}
