package org.iit.mmp.adminmodule.tests;

import java.util.HashMap;

import org.iit.mmp.adminmodule.pages.SearchBySsn;
import org.iit.mmp.helper.HelperClass;
import org.iit.util.TestBase;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AdminModuleTest extends TestBase {
	HelperClass helper;
	@Parameters({"uRl","uName","pWord","doctorName"})
	@Test(description="US_006, Validate Search Using SSN ",groups= {"sanity","regression","UI","adminmodule","US_006"})
	public void validateSearchUsingSsn(String uRl,String uName, String pWord,String doctorName) {
		
		helper = new HelperClass(driver);
		helper.launchApplicationURL(uRl);
		helper.login(uName, pWord);
		helper.navigateToAModule("Patients");
		SearchBySsn ssn = new org.iit.mmp.adminmodule.pages.SearchBySsn(driver);
		HashMap<String,String> hMapAdm = ssn.createVisit(doctorName);
		helper.navigateToAModule("Patients");
		boolean result = ssn.validateAppointmentDetailsinAdminPage(hMapAdm);
		Assert.assertTrue(result);
		
		
		
	}

}


