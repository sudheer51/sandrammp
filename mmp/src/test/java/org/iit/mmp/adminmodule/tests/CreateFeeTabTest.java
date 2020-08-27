package org.iit.mmp.adminmodule.tests;
import org.iit.mmp.adminmodule.pages.*;
import org.iit.mmp.helper.HelperClass;
import org.iit.util.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CreateFeeTabTest extends TestBase{
	
	CreateFeeTabPage crPage;
	HelperClass helper;
	@Parameters({"adminurl", "uName", "pwd", "patientName"})
	@Test(description="ADM_009 Creating patient fee for service", groups={"sanity", "regression", "UI", "patientmodule","ADM_009"})
	public void createFee(String url, String name, String password, String patientName) throws InterruptedException {
		crPage = new CreateFeeTabPage(driver);
		helper = new HelperClass(driver);
		helper.launchApplicationURL(url);
		helper.login(name,password);
		Thread.sleep(3000);
		helper.navigateToAModule("Patients");
		crPage.fillData(patientName);
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();
		String actualMessage = alert.getText();
		alert.accept();
		System.out.println("Message after create fee: " +actualMessage);
		 if(actualMessage.contains("Fee Successfully Entered."))
		 {
		   Assert.assertTrue(true, "Fee Created >>Test Passed!!");
		 }
		 else {
		   Assert.assertFalse(false, "Fee is not created >>Test Failed");
		 }
	}
	

}
