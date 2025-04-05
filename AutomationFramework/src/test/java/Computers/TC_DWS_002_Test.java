package Computers;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import genericutility.BaseClass;
import objectrepository.HomePage;

public class TC_DWS_002_Test extends BaseClass {
	
	@Test
	public void clickOnComputer() {
		ExtentTest test = extReport.createTest("clickOnComputer");
		HomePage hp = new HomePage(driver);
		hp.getGetComputerLink().click();
		
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Computers", "Computer page is not displayed");
		test.log(Status.PASS, "Computer page is displayed");
		
	}

}
