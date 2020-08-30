package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.net.InetAddress;
import java.sql.Timestamp;

public class ReportUtil  {
    public static ExtentReports report;
    public static ExtentTest logger;
    public static ExtentHtmlReporter htmlReporter;


    @BeforeSuite
    public static void startReporting()
    {

        InetAddress localhost = null;

        String testCaseName="TestNG";
        String currDir = System.getProperty("user.dir");
        String lTimeStamp = getTimeAsString();
        String reportPath = currDir + "/report-output"+
                "/" + testCaseName + "_" + lTimeStamp + ".html";
        htmlReporter=new ExtentHtmlReporter(reportPath);
        report = new ExtentReports();
        report.attachReporter(htmlReporter);

        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Extent report");
        htmlReporter.config().setReportName("Final Report");

        System.out.println("Path is"+reportPath);


    }


    public static String getTimeAsString(){
        java.util.Date date= new java.util.Date();
        Timestamp currentTimestamp= new Timestamp(date.getTime());
        String currentTimeStampAsString = currentTimestamp.toString();
        currentTimeStampAsString = currentTimeStampAsString.replace("-", "");
        currentTimeStampAsString = currentTimeStampAsString.replace(":", "");
        currentTimeStampAsString = currentTimeStampAsString.replace(".", "");
        currentTimeStampAsString = currentTimeStampAsString.replace(" ", "");
        return currentTimeStampAsString;
    }




    public static void reporterEvent(String status, String description){
        if(status.equals("info"))
            logger.log(Status.INFO, description);
        else if(status.equals("fail"))
            logger.log(Status.FAIL, description);
        else if(status.equals("pass"))
            logger.log(Status.PASS, description);
        else if(status.equals("error"))
            logger.log(Status.ERROR, description);
        else if(status.equals("fatal"))
            logger.log(Status.FATAL, description);
        else if(status.equals("warning"))
            logger.log(Status.WARNING, description);
        else if(status.equals("skip"))
            logger.log(Status.SKIP, description);
        else if(status.equals("unknown"))
            logger.log(Status.ERROR, description);

    }

    public static ExtentTest  addScreenshot(String path) throws IOException {
        return logger.addScreenCaptureFromPath(path);

    }

    @AfterSuite
    public static void endReporter(){
        report.flush();
    }
}

