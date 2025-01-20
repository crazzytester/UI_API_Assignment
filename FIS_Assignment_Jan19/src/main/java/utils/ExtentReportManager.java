package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static ExtentReports extent;
    private static ExtentTest test;

    public static void initializeReport() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(ConfigReader.getProperty("report.path"));
        //ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(ConfigReader.getProperty("report.path"));
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        sparkReporter.config().setReportName("Automation Test Report");
        sparkReporter.config().setDocumentTitle("Test Execution Report");
    }

    public static ExtentTest createTest(String testName) {
        test = extent.createTest(testName);
        return test;
    }

    public static void finalizeReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}
