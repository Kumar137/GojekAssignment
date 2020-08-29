package base;

import com.demo.pages.HomePage;
import com.demo.pages.OrderSummaryPage;
import com.demo.pages.PaymentMethodPage;
import com.demo.pages.ShoppingCartPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import utils.Constants;
import utils.Driver;
import utils.GenericUtils;

public class BaseClass {

    public HomePage homePage;
    public OrderSummaryPage orderSummaryPage;
    public PaymentMethodPage paymentMethodPage;
    public ShoppingCartPage shoppingCartPage;
    public GenericUtils genericUtils;
    public static WebDriver driver;

    /**
     *This function is written to initialize all the classes and also launch the browsee
     */

    @BeforeClass
    public void setUp()
    {
        driver= Driver.getWebDriverInstance();
        homePage=new HomePage(driver);
        shoppingCartPage=new ShoppingCartPage(driver);
        orderSummaryPage=new OrderSummaryPage(driver);
        paymentMethodPage=new PaymentMethodPage(driver);
        genericUtils=new GenericUtils(driver);
        driver.get(Constants.URL);
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }

}
