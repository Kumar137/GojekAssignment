package base;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.demo.pages.HomePage;
import com.demo.pages.OrderSummaryPage;
import com.demo.pages.PaymentMethodPage;
import com.demo.pages.ShoppingCartPage;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.Constants;
import utils.Driver;
import utils.GenericUtils;
import utils.ReportUtil;

import java.io.IOException;

public class BaseClass extends ReportUtil {

    public HomePage homePage;
    public OrderSummaryPage orderSummaryPage;
    public PaymentMethodPage paymentMethodPage;
    public ShoppingCartPage shoppingCartPage;
    public GenericUtils genericUtils;
    public WebDriver driver;

    /**
     *This function is written to initialize all the classes and also launch the browsee
     */

    @BeforeClass
    public void setUp()
    {

        driver= new Driver().getWebDriverInstance();
        homePage=new HomePage(driver);
        shoppingCartPage=new ShoppingCartPage(driver);
        orderSummaryPage=new OrderSummaryPage(driver);
        paymentMethodPage=new PaymentMethodPage(driver);
        genericUtils=new GenericUtils(driver);
        driver.get(Constants.URL);
    }

    @AfterMethod
    public void getResult(ITestResult result) throws IOException {
        if(result.getStatus() == ITestResult.FAILURE)
        {
            String path= genericUtils.captureScreenshot(result.getName());
            System.out.println("path to screenshot "+path);
            logger.fail(MarkupHelper.createLabel(result.getName()+ "Failed", ExtentColor.RED));
            logger.fail(result.getThrowable());
            logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(path).build());
        }
        else if(result.getStatus() == ITestResult.SUCCESS)
        {
            logger.pass(MarkupHelper.createLabel(result.getName()+ "Passes", ExtentColor.GREEN));
        }
        else
        {
            logger.log(Status.SKIP, result.getName()+" Test Case SKIPPED");
            logger.skip(result.getThrowable());
        }
    }

    @AfterClass
    public void tearDown()
    {
        ReportUtil.endReporter();
        driver.quit();
    }
}
