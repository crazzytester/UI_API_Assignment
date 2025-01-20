package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import utils.ConfigReader;
import utils.ExtentReportManager;

import java.io.File;

public class BaseTest {
    protected WebDriver driver;
    protected static ExtentReports extentReports; // Static to share across tests
    protected static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @BeforeSuite
    public void setupExtentReports() {
        // Define the Extent Report file location
        if (extentReports == null) {
            System.out.println("Initializing ExtentReports...");
            String reportPath = System.getProperty("user.dir") + "/test-output/ExtentReport.html";
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(new File(reportPath));
            sparkReporter.config().setReportName("Automation Test Report");
            sparkReporter.config().setDocumentTitle("Test Execution Report");

            // Initialize ExtentReports and attach the SparkReporter
            extentReports = new ExtentReports();
            extentReports.attachReporter(sparkReporter);

            // Add system info (optional)
            extentReports.setSystemInfo("OS", System.getProperty("Windows 11"));
            extentReports.setSystemInfo("Tester", "Raman Kumar");
            extentReports.setSystemInfo("Browser", "Chrome");
        }
    }
    public ExtentTest createTest(String testName) {
        // Create a new test in ExtentReports
        ExtentTest test = extentReports.createTest(testName);
        extentTest.set(test);
        return test;
    }
    public ExtentTest getTest() {
        // Retrieve the current test for the executing thread
        return extentTest.get();
    }

    @AfterSuite
    public void flushExtentReports() {
        if (extentReports != null) {
            extentReports.flush(); // Write the test results to the report
            System.out.println("ExtentReports flushed. Report available at /test-output/ExtentReport.html");
        }
    }

    @BeforeClass
    public void setup() {
        String browser = ConfigReader.getProperty("browser");
        if ("chrome".equalsIgnoreCase(browser)) {
            //System.setProperty("webdriver.chrome.driver", ConfigReader.getProperty("webdriver.chrome.path"));
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
