package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericUtils {

    WebDriver driver;
    WebDriverWait webDriverWait;
    public GenericUtils(WebDriver driver)
    {
        this.driver=driver;
    }


    public boolean waitForElementPresent(WebElement webElement)
    {
        try{
            webDriverWait=new WebDriverWait(driver,30);
            webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
            return true;
        }
        catch (Exception ex)
        {
            return false;
        }
    }
}
