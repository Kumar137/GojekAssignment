package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.GenericUtils;

public class OrderSummaryPage {

    WebDriver driver;
    GenericUtils utils;
    public OrderSummaryPage(WebDriver driver)
    {
        this.driver=driver;
        utils=new GenericUtils(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath ="//span[text()='Continue']")
    WebElement ContinueBtn;

    @FindBy(xpath="//span[@class='item-name']")
    WebElement item;

    public void clickContinueBtn()
    {
        int size = driver.findElements(By.tagName("iframe")).size();
        driver.switchTo().frame(0);
        System.out.println("---------------------"+size);
        Boolean bool= utils.waitForElementPresent(ContinueBtn);
        System.out.println("--------"+bool);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", ContinueBtn);
    }

    public String getCartItemName()
    {
        utils.waitForElementPresent(item);
        return item.getText();
    }
}
