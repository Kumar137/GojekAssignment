package com.test;

import base.BaseClass;
import com.demo.pages.HomePage;
import com.demo.pages.OrderSummaryPage;
import com.demo.pages.PaymentMethodPage;
import com.demo.pages.ShoppingCartPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.Constants;
import utils.Driver;
import utils.GenericUtils;

public class CheckoutWithInvalidCard extends BaseClass {

    @Test
    public void checkoutWithInvalidCard()
    {
        logger=report.createTest("checkoutWithInvalidCard");
        homePage.clickBuyBtn();
        //This is test
        shoppingCartPage.checkout();
        orderSummaryPage.clickContinueBtn();
        paymentMethodPage.selectCreditCard();
        paymentMethodPage.enterCardNumber(Constants.INVALID_CREDIT_CARD);
        Boolean bool=paymentMethodPage.getInvalidCreditCardMsg();
        Assert.assertTrue(paymentMethodPage.getInvalidCreditCardMsg(),"Invalid message not as expected");
    }
}
