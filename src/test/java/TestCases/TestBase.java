package TestCases;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.restassured.RestAssured;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;

public class TestBase {
    public static ExtentReports report ;
    public static ExtentTest logger;


    @BeforeSuite
    public void setup () {
        RestAssured.baseURI="https://petstore.swagger.io/v2/pet";

        //Extent Report Setup
        ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir") + "/src/test/java/TestReports/Technical-Assessment "+GetCurrentTime()+".html"));
        extent.config().setTheme(Theme.DARK);
        report=new ExtentReports();
        report.attachReporter(extent);
        report.setSystemInfo("Project Name","Hunger Station Task");
        report.setSystemInfo("Host name","Hossam Eldin Local Machine");
        report.setSystemInfo("Environemnt","Testing Environment");
        report.setSystemInfo("OS","MacOs Mojave");

    }


    @AfterMethod
    public void getResult(ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE) {
            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
            logger.fail(result.getThrowable());
            logger.info("Test Description: " + result.getMethod().getDescription());
        }
        else if(result.getStatus() == ITestResult.SUCCESS) {
            logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED " , ExtentColor.GREEN));
            logger.info("Test Description: " + result.getMethod().getDescription());

        }
        else {
            logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
            logger.skip(result.getThrowable());
            logger.info("Test Description: " + result.getMethod().getDescription());

        }
        report.flush();

    }


// This Method for getting current date&time to use it for naming the report
    private static String GetCurrentTime() {
        DateFormat format = new SimpleDateFormat("dd MMMM YYYY hh:mm:ss");
        Date date=new Date();
        return  format.format(date);
    }
}

