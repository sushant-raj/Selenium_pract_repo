package Electronics;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import genericutility.BaseClass;
import objectrepository.HomePage;

public class TC_DWS_003_Test extends BaseClass{
	
	
	@Test
	public void clickOnElectronic() {
		ExtentTest test = extReport.createTest("clickOnElectronic");
		HomePage hp = new HomePage(driver);
		hp.getGetElectronicsLink().click();
		
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Electronics", "Electronics page is not displayed");
		test.log(Status.PASS, "Electronics page is displayed");
		
		
	}

}
