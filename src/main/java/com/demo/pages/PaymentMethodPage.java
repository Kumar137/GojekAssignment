package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Constants;
import utils.GenericUtils;

public class PaymentMethodPage {

    WebDriver driver;
    GenericUtils utils;
    public PaymentMethodPage(WebDriver driver)
    {
        this.driver=driver;
        utils=new GenericUtils(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='list-title text-actionable-bold'][text()='Credit/Debit Card']")
    WebElement CreditCard;

    @FindBy(xpath="//p[@class='text-page-title-content']")
    WebElement pageTitle;

    @FindBy(xpath = "//input[@name='cardnumber']")
    WebElement CardNumber;

    @FindBy(xpath = "//input[@placeholder='MM / YY']")
    WebElement ExpiryDate;

    @FindBy(xpath = "//input[@placeholder='123']")
    WebElement CVV;

    @FindBy(xpath="//input[@type='password']")
    WebElement OTP;

    @FindBy(xpath="//button[@type='submit']")
    WebElement SubmitBtn;

    @FindBy(xpath="//i[@class='icon checkmark']")
    WebElement SuccessMsg;

    @FindBy(xpath="//div[@class='text-button-main']")
    WebElement PaynowBtn;

    @FindBy(xpath="//div[@class='notice danger']/div/span")
    WebElement invalidCardMsg;

    public void selectCreditCard()
    {
        utils.waitForElementPresent(CreditCard);
        CreditCard.click();
    }

    public String getPaymentMethod()
    {
        utils.waitForElementPresent(pageTitle);
        return pageTitle.getText();
    }

    public void enterCardNumber(String cardNumber)
    {
        utils.waitForElementPresent(CardNumber);
        CardNumber.sendKeys(cardNumber);
    }

    public void enterExpiryDate(String date)
    {
        utils.waitForElementPresent(ExpiryDate);
        ExpiryDate.sendKeys(date);
    }

    public void enterCVVNumber(String CVV)
    {
        utils.waitForElementPresent(this.CVV);
        this.CVV.sendKeys(CVV);

    }
    public void clickPaynowBtn()
    {
        utils.waitForElementPresent(PaynowBtn);
        Actions act=new Actions(driver);
        // act.moveToElement(PaynowBtn).click().build().perform();
        //   PaynowBtn.click();
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", PaynowBtn);
    }

    public void submitOTP(String otp)
    {
        int size = driver.findElements(By.tagName("iframe")).size();
        driver.switchTo().frame(0);
        System.out.println("---------------------"+size);
        utils.waitForElementPresent(OTP);
        OTP.sendKeys(otp);
        SubmitBtn.click();
        driver.switchTo().defaultContent();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean getInvalidCreditCardMsg()
    {
        utils.waitForElementPresent(invalidCardMsg);
        String actualInvalMsg=invalidCardMsg.getText();
        if(actualInvalMsg.equals(Constants.INVALID_TEXT)) {
            return true;
        }
        else
            return false;
    }

}
