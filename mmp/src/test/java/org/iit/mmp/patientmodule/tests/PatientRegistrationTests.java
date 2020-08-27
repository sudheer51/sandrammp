package org.iit.mmp.patientmodule.tests;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.iit.mmp.helper.HelperClass;
import org.iit.mmp.patientmodule.pages.PateintRegistrationPage;
import org.iit.util.TestBase;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class PatientRegistrationTests extends TestBase {
	HelperClass hObj;
	PateintRegistrationPage regPage;
	@Parameters("url")
	@Test(priority = 1,description="TC_001 Validation of Registration Functionality",groups=("PatientRegistrationTests"))
	public void validateRegistration(String url) throws InterruptedException {
		hObj = new HelperClass(driver);
		regPage = new PateintRegistrationPage(driver);
		hObj.launchApplicationURL(url);
		hObj.clickOnRegisterLink();
		HashMap<String, String> hmap = regPage.fillregisterPatientForm();
		for (Map.Entry<String, String> mapElement : hmap.entrySet()) {
			String key = (String) mapElement.getKey();
			String value = (String) mapElement.getValue();
			System.out.println(key + " : " + value);
		}
		String expected = "Thank you for registering with MMP.";
		String actual = regPage.registrationCompleteAlertMessage();
		Assert.assertEquals(actual.trim(), expected, actual);
		System.out.println("The registration successful message is " + actual);
	}
	@Parameters("patientLoginUrl")
	@Test(priority = 2,description="TC_002 Validation of PatientLogin Functionality",groups=("PatientRegistrationTests"))
	public void validatePatientLoginAlertMessageBeforeApproval(String patientLoginUrl) throws InterruptedException {
		String expected = "Admin Approval is pending.";
		String actual = regPage.patientLoginAlertMessageBeforeApproval(patientLoginUrl);
		Assert.assertEquals(actual.trim(), expected, actual);
		System.out.println("The alert message when patient logs in before admin approves is  " + actual);
	}
	@Parameters({"patientLoginUrl","tc_Name"})
	@Test(priority = 4,dependsOnGroups = {"AdminTests"},description="TC_003 Validation of PatientLogin Functionality",groups=("PatientRegistration"))
	public void validatePatientLoginAlertMessageAfterApproval(String patientLoginUrl, String tc_Name) throws InterruptedException, IOException {
		String actual = "Patient Portal";
		String expected = regPage.validatePatientLoginAfterApproval(patientLoginUrl,tc_Name);
		Assert.assertEquals(actual, expected);
		System.out.println("The panel title when patient logs in after admin's approval is  " + expected);
	}
}