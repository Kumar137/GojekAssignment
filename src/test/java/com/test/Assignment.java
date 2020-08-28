package com.test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.demo.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.Constants;
import utils.Driver;


import java.io.IOException;

public class Assignment {

    HomePage homePage;
    WebDriver driver;
    /**
     *This function is written to initialize all the classes and also launch the browser
     */

    @BeforeClass
    public void setUp()
    {
        driver= Driver.getWebDriverInstance();
        homePage=new HomePage(driver);
    }

    @BeforeMethod
    public void launchURL()
    {
        driver.get(Constants.URL);
    }

    /**
     *This function is written to checkout item with valid credit card
     */
    @Test(priority = 1)
    public void checkoutWithValidCard()
    {
        homePage.clickBuyBtn();
    }


    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}
