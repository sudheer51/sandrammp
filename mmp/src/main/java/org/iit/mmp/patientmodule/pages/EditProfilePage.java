package org.iit.mmp.patientmodule.pages;

import java.util.HashMap;
import java.util.Random;

import org.iit.mmp.helper.HelperClass;
import org.iit.util.AppLibrary;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;




public class EditProfilePage {
	
	WebDriver driver;
	 HelperClass helperobj;
	 int noofchar=7;
	 String actual="Your Profile has been updated";
	 String expected;
	 
	 HashMap<String,String>hmap= new HashMap<String,String>();
	 Random rd;
	 
	    By userNameTB=By.id("username");
	    By passwordTB=By.id("password");
	    By submitBtn=By.className("submit");
	    By fNameTB=By.id("firstname");
		By lNameTB=By.id("lastname");
		By dobTB=By.id("datepicker");
		By licenseTB=By.id("licence");
		By ssnTB=By.id("ssn");
		By stateTB=By.id("state");
		By cityTB=By.id("city");
		By addressTB=By.id("address");
		By zipCodeTB=By.id("zipcode");
		By ageTB=By.id("age");
		By heightTB=By.id("height");
		By weightTB=By.id("weight");
		By providerinfoTB=By.id("proinfo");
		By insuranceinfoTB=By.id("Insinfo");


public EditProfilePage(WebDriver driver) {
	 this.driver=driver;
	 helperobj= new HelperClass(driver);
	rd = new Random();
}

public void logintogetHomepage(String uName,String pWord) {

	driver.findElement(userNameTB).sendKeys(uName );
	driver.findElement(passwordTB).sendKeys(pWord );
	driver.findElement(submitBtn).click();	
}


//edit button
public void clickoneditbutton() {
WebElement edit= driver.findElement(By.xpath("//input[@id='Ebtn']"));
	edit.click();
}

public void editallfields() {
	
	editfirstname();
	editlastname();
	editLicense();
	editSSN();
	editAddress();
	editAge();
	editWeight();
	editHeight();
	editState();
	editCity();
	editZipcode();
	editProviderinfo();
	editInsuranceinfo();
	
}

//storing the value in hashmap to validate
	public HashMap<String,String> updatepage() {
	
		hmap.put("FirstName",driver.findElement(fNameTB) .getAttribute("value"));
		hmap.put("LastName",driver.findElement(lNameTB) .getAttribute("value"));
		hmap.put("license",driver.findElement(licenseTB) .getAttribute("value"));
		hmap.put("ssn",driver.findElement(ssnTB) .getAttribute("value"));
		hmap.put("address",driver.findElement(addressTB) .getAttribute("value"));
		hmap.put("age",driver.findElement(ageTB) .getAttribute("value"));
		hmap.put("weight",driver.findElement(weightTB) .getAttribute("value"));
		hmap.put("height",driver.findElement(heightTB) .getAttribute("value"));
		hmap.put("state",driver.findElement(stateTB) .getAttribute("value"));
		hmap.put("city",driver.findElement(cityTB) .getAttribute("value"));
		hmap.put("zipcode",driver.findElement(zipCodeTB) .getAttribute("value"));
		
return hmap ;
	}
	
	
	public boolean validateprofile() {
		boolean result= false;
	if(updatepage().equals(hmap))
		result = true;
	System.out.println("Validate profile : " +result);
	return result;
	}

public void editfirstname() {
	  String fnamevalue=AppLibrary.getRandomChars(noofchar);
	  driver.findElement(fNameTB).sendKeys(fnamevalue);
	  hmap.clear();
	  hmap.put("Firstname","fnamevalue");
		
}
//lastname
public void editlastname() {
	 String lnamevalue=AppLibrary.getRandomChars(noofchar);
	 driver.findElement(lNameTB).sendKeys(lnamevalue);
	 hmap.clear();
	 hmap.put("Lastname","lnamevalue");
			 
}
//License

public void editLicense() { 
	 Long licensevalue=AppLibrary.getRandomDigits(8);
	 driver.findElement(licenseTB).sendKeys(licensevalue.toString());
	 hmap.clear();
     hmap.put("license",licensevalue.toString());
}

public void editSSN() {
	 Long ssnvalue=AppLibrary.getRandomDigits(9);
	 driver.findElement(ssnTB).sendKeys(ssnvalue.toString());
	 hmap.clear();
     hmap.put("ssn",ssnvalue.toString());
}

public void editAddress() {
	 String addressvalue=AppLibrary.getRandomChars(noofchar);
	 driver.findElement(addressTB).sendKeys(addressvalue);
	 hmap.clear();
     hmap.put("address",addressvalue);
}

  public void editAge() {
	 Long agevalue=AppLibrary.getRandomDigits(5);
	 driver.findElement(ageTB).sendKeys(agevalue.toString());
	hmap.clear();
	hmap.put("age",agevalue.toString());
		}
			
	public void editWeight() {
		Long weightvalue=AppLibrary.getRandomDigits(5);
		driver.findElement(weightTB).sendKeys(weightvalue.toString());
		hmap.clear();
		hmap.put("weight",weightvalue.toString());
		}
			
		public void editHeight() {
		Long heightvalue=AppLibrary.getRandomDigits(5);
		driver.findElement(heightTB).sendKeys(heightvalue.toString());
		hmap.clear();
		hmap.put("height",heightvalue.toString());
		}
		
		public void editState() {
		String statevalue=AppLibrary.getRandomChars(noofchar);
		driver.findElement(stateTB).sendKeys(statevalue);
		hmap.clear();
		hmap.put("state",statevalue);
		}

		public void editCity() {
		String cityvalue=AppLibrary.getRandomChars(noofchar);
		driver.findElement(cityTB).sendKeys(cityvalue);
		hmap.clear();
		hmap.put("city",cityvalue);
		}
		
		public void editZipcode() {
		Long zipcodevalue=AppLibrary.getRandomDigits(5);
		driver.findElement(zipCodeTB).sendKeys(zipcodevalue.toString());
		hmap.clear();
		hmap.put("zipcode",zipcodevalue.toString());
		}
					
		public void editProviderinfo() {
		String Providerinfovalue=AppLibrary.getRandomChars(noofchar);
		driver.findElement(providerinfoTB).sendKeys(Providerinfovalue.toString());
		hmap.clear();
		hmap.put("ProviderInfo",Providerinfovalue.toString());
		}
				
	    public void editInsuranceinfo() {
		String insuranceinfovalue=AppLibrary.getRandomChars(noofchar);
		driver.findElement(insuranceinfoTB).sendKeys(insuranceinfovalue.toString());
		hmap.clear();
		hmap.put("InsuranceInfo",insuranceinfovalue.toString());
		}
				
		
	
//save button	
public void clickonSavebutton() {
	
	WebElement save= driver.findElement(By.xpath("//input[@id='sbtn']"));
	save.click();
	
}

public String readsuccessmsg() {
	Alert alrt=driver.switchTo().alert();
	String actual=alrt.getText();
	alrt.accept();			
   return actual;
}


public void closedriver() {
	driver.close();
}














}