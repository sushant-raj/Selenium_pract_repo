package genericutility;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import objectrepository.HomePage;
import objectrepository.LoginPage;
import objectrepository.WelComePage;

public class BaseClass {
	
	public static WebDriver driver;
	public WebDriverUtility wUtil = new WebDriverUtility();
	public FileUtility fUtil = new FileUtility();
	public static ExtentTest test;
	public static ExtentReports extReport;
	public JavaUtility jUtil = new JavaUtility();
	
	@BeforeSuite
	public void reportConfig() {
		ExtentSparkReporter spark = new ExtentSparkReporter("./HTML_reports/extentReport_" + jUtil.getSystemTime()+ ".html");
		extReport = new ExtentReports();
		extReport.attachReporter(spark);
	}
	
	@BeforeClass
	public void openBrowser() throws IOException {
		driver = new ChromeDriver();
		wUtil.maximize(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get(fUtil.getDataFromProperty("url"));
	}
	
	@BeforeMethod
	public void login() throws IOException {
		WelComePage wp = new WelComePage(driver);
		wp.getLoginLink().click();
		
		LoginPage lp = new LoginPage(driver);
		lp.getEmailTextField().sendKeys(fUtil.getDataFromProperty("email"));
		lp.getPasswordTextField().sendKeys(fUtil.getDataFromProperty("password"));
		lp.getLoginButton().click();
	}
	
	@AfterMethod
	public void logout() {
		HomePage hp = new HomePage(driver);
		hp.getLogoutButton().click();
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
	@AfterSuite
	public void reportBackup() {
		extReport.flush();
	}


}
