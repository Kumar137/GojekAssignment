package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

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

    public  String captureScreenshot(String screenshotName) throws IOException {
        String lTimeStamp=ReportUtil.getTimeAsString();
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = new File(System.getProperty("user.dir")).getAbsolutePath() +"/report-output"+"/"+screenshotName+""+lTimeStamp+".jpg";
        File destination = new File(dest);
        FileUtils.copyFile(source,destination);
        return dest;
    }
}
