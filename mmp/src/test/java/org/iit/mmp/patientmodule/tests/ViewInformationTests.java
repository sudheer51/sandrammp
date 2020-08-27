package org.iit.mmp.patientmodule.tests;

import java.io.FileInputStream;
import java.util.Properties;

import org.iit.mmp.helper.HelperClass;
import org.iit.mmp.patientmodule.pages.ViewInformationPage;
import org.iit.util.TestBase;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ViewInformationTests extends TestBase {

	HelperClass helper;
	
   
//	String expFullText = "Manage My Patient (MMP) is a medical practice management solution that"
//			+ " boosts productivity by automating the day-to-day tasks that can slow an office "
//			+ "manager down. Central delivers much more than medical billing software. Sure, "
//			+ "it has the tools to help generate cleaner claims and reduce denials, but our "
//			+ "easy-to-use practice management software also streamlines your workflow to deliver "
//			+ "seamless handoffs across departments. "
//			+ "Manage My Patient (MMP) becomes your practice’s command center, delivering robust, "
//			+ "real-time analytics through customizable reports and dashboards to ensure you know "
//			+ "how your business is performing on the metrics that matter most.";

	ViewInformationPage viewInfoPageObj;

	@Parameters({ "url", "uname", "pword", "expText" })
	@Test(description = "US_004, View Information", groups = { "sanity", "regression", "UI", "patientmodule",
			"US_004" })
	public void viewInformation(String url, String uname, String pword, String expText) {
		try {
			FileInputStream input = new FileInputStream("/Users/pesalvk/eclipse-workspace/mmp/testcaseinfo.properties");
			Properties prop = new Properties();
			prop.load(input);
			String expFullText = prop.getProperty("expFullText");
			
			expFullText = expFullText.replaceAll("\"", "");
			helper = new HelperClass(driver);
			helper.launchApplicationURL(url);
			helper.login(uname, pword);
			helper.navigateToAModule("Information");
			viewInfoPageObj = new ViewInformationPage(driver);
			
			SoftAssert sAssert = new SoftAssert();

			log.info("Checking Information Link");
			boolean rflag = viewInfoPageObj.informationLink();
			sAssert.assertTrue(rflag, "Link not Found");

			log.info("Checking Information Text");
			rflag = viewInfoPageObj.informationText();
			sAssert.assertTrue(rflag, "Text Not Displayed");

			log.info("Looking for Username Display");
			rflag = viewInfoPageObj.usernameDisplay();
			sAssert.assertTrue(rflag, "Username Not Displayed");

			log.info("Comparing the Pagetext with expected Text");
			rflag = viewInfoPageObj.viewInfoPageText(expFullText);
			sAssert.assertTrue(rflag, "Expected text not matched with Actual Text");

			log.info("Looking for Actual Username Matched with Expected Username");
			rflag = viewInfoPageObj.isUserCorrect(uname);
			sAssert.assertTrue(rflag, "Actual UserName is not matching with Expexted");

			log.info("Looking in the Pagetext for expected Text Display");
			rflag = viewInfoPageObj.pageContains(expText);
			log.info(rflag ? "PASS" : "FAIL");

			sAssert.assertTrue(rflag, "Expected Text not displayed");
			
			sAssert.assertAll();
			
			input.close();
		} catch (Exception e) {
			log.severe(e.toString());
		}

	}

}
