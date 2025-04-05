package books;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import genericutility.BaseClass;
import genericutility.ListenerUtility;
import objectrepository.HomePage;

@Listeners(ListenerUtility.class)
public class TC_DWS_001_Test extends BaseClass  {
	
	@Test
	public void clickOnBooks() throws IOException {
		ExtentTest test = extReport.createTest("clickOnBooks");
		HomePage hp = new HomePage(driver);
		hp.getGetBookLink().click();
		
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Books" , "Books page is not displayed" );
		test.log(Status.PASS,"Books page is displayed" );
		wUtil.getPhoto(driver);
	}
}
