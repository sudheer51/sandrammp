package org.iit.mmp.patientmodule.tests;

import org.iit.mmp.helper.*;
import org.iit.mmp.patientmodule.pages.*;
import org.iit.util.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class EditProfileTest  extends TestBase{
	WebDriver driver;
	HelperClass helperobj;
	EditProfilePage Editpage;
	String actual="your profile has been updated";
	String expected;
	boolean result;
	
	
	SoftAssert sassert;
	@Parameters({"url","uName","pWord"})
	@Test(description="US_003 EditProfile",groups= {"US_003","regression","sanity"})
	public void Editpatientprofile(String url,String uName,String pWord) {	
	instantiateDriver();
	helperobj=new HelperClass(driver);
	helperobj.launchApplicationURL(url);	
	Editpage=new EditProfilePage(driver);
	Editpage.logintogetHomepage(uName, pWord);	
	helperobj.navigateToAModule("Profile");
	Editpage.clickoneditbutton();
	Editpage.editallfields();
	expected=Editpage.readsuccessmsg();
	sassert= new SoftAssert();
	sassert.assertEquals(actual, expected);
	result=Editpage.validateprofile();
	sassert.assertTrue(result);
	Editpage.closedriver();
	
	
	
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
