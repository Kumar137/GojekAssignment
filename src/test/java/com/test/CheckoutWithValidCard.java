package com.test;

import base.BaseClass;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.demo.pages.HomePage;
import com.demo.pages.OrderSummaryPage;
import com.demo.pages.PaymentMethodPage;
import com.demo.pages.ShoppingCartPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.Constants;
import utils.Driver;
import utils.GenericUtils;


import java.io.IOException;

public class CheckoutWithValidCard extends BaseClass {

    /**
     *This function is written to checkout item with valid credit card
     */
    @Test
    public void checkoutWithValidCard()
    {
        homePage.clickBuyBtn();
        shoppingCartPage.checkout();
        orderSummaryPage.clickContinueBtn();
        paymentMethodPage.selectCreditCard();
        paymentMethodPage.enterCardNumber(Constants.VALID_CREDIT_CARD);
        paymentMethodPage.enterExpiryDate(Constants.VALID_EXP_DATE);
        paymentMethodPage.enterCVVNumber(Constants.VALID_CVV);
        paymentMethodPage.clickPaynowBtn();
        paymentMethodPage.submitOTP(Constants.VALID_OTP);
        Assert.assertTrue(homePage.verifySuccessMessage(),"Message not verified");
    }



}
