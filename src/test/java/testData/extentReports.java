package testData;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class extentReports {

    public static ExtentReports getReportObject(){
        String path = System.getProperty("user.dir")+"//reports//Text Report.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Test Results");

       ExtentReports extent = new ExtentReports();
       extent.attachReporter(reporter);
        //  extent.setSystemInfo("Tester","Ibrahim Arafa");
        return extent;
    }


}
