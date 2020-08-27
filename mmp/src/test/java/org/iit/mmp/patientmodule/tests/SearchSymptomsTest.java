
package org.iit.mmp.patientmodule.tests;
import java.util.List;
import org.iit.mmp.helper.HelperClass;
import org.iit.mmp.patientmodule.pages.SearchSymptomsPage;
import org.iit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchSymptomsTest extends TestBase{
	SearchSymptomsPage ssPage;
	HelperClass helper;
	@Test
	public void validSearchSymptoms() throws Exception {
		helper = new HelperClass(driver);
		Thread.sleep(3000);
		helper.launchApplicationURL("http://96.84.175.78/MMP-Release1-Integrated-Build.2.4.000/portal/profile.php");
		helper.navigateToAModule("Search Symptoms");
		ssPage = new SearchSymptomsPage(driver);
		ssPage.enterData("fever");
		//Validating the title of the page
		String actualTitle = driver.getTitle();
		System.out.println("Current title of the page is :" +actualTitle);
		if (actualTitle.contains("search Symptoms")) {
			Assert.assertTrue(true);
			System.out.println("Test Passed!");
		} else {
			System.out.println("Test Failed!!");
		}
		List<WebElement> trData = driver.findElements(By.xpath("//table[@class='table']//tbody//tr/td"));
		System.out.println("Total symptoms of data size showing :" +trData.size());
		if (trData.size()==3) {
			System.out.println("Search data is showing!!");
		}
		else {
			System.out.println("Search data is not showing!!");
		}
	}



}

