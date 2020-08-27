package org.iit.mmp.adminmodule.pages;

import java.util.HashMap;

import org.iit.mmp.helper.HelperClass;
import org.iit.util.AppLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SearchBySsn {
	By patientTab = By.xpath("//span[contains(text(),'Patients')]");
	By searchValue = By.id("search");
	By clickSearch = By.xpath("//input[@class='tfbutton']");
	By patientName = By.xpath("//a[contains(text(),'Ria')]");
	By createVisit = By.xpath("//input[@value='Create Visit']");
	By datePicker = By.xpath("//input[@class='hasDatepicker']");
	By continueButton = By.id("ChangeHeatName");
	By symptxtbox = By.id("sym");
	By submitButton = By.xpath("//input[@value='Submit']");
	By providerNameDetails = By.xpath("//a[contains(text(),'Provider')]");
	By timeDetails = By.xpath("//a[contains(text(),'Time')]");
	By headerDetails = By.xpath("//h3[@class='panel-title'])[2]");
	By symDetails = By.xpath("//a[contains(text(),'Symptoms')]");
	
	
	WebDriver driver;
    HelperClass helperObj = new HelperClass(driver);
    public  SearchBySsn(WebDriver driver) {
  	  this.driver = driver;
  	  helperObj = new HelperClass(driver);
  	  
    }
    public HashMap<String,String>createVisit(String doctorName){
    	HashMap<String,String> hMapAdm = new HashMap<String,String>();
    	
    	String ssn = "887766554";
    	String time ="10Am";
		String dateofApp = AppLibrary.getFutureDate(20);
		String sym = "Booking an appointment for" + doctorName+ "on date"+dateofApp+"For Symptom Fever";
		
		driver.findElement(patientTab).click();
		driver.findElement(searchValue).sendKeys(ssn);
		driver.findElement(clickSearch).click();
//		driver.findElement(clickSearch).sendKeys(Keys.TAB);
		driver.findElement(patientName).click();
		driver.findElement(createVisit).click();
		driver.findElement(By.xpath("//h4[text()='"+doctorName+"']/ancestor::ul/following-sibling::button")).click();
		driver.switchTo().frame("myframe");
		driver.findElement(datePicker).sendKeys(dateofApp);
		driver.findElement(datePicker).sendKeys(Keys.TAB);
		Select timeSelector = new Select(driver.findElement(By.id("time")));
    	timeSelector.selectByVisibleText(time);
//		driver.findElement(By.id("time")).sendKeys(time);
		
		driver.findElement(continueButton).click();
		
		driver.findElement(symptxtbox).sendKeys("fever");
		driver.findElement(submitButton).click();
		 hMapAdm.put("time", "10Am");
		 hMapAdm.put("doctorName", doctorName);
		 hMapAdm.put("sym", sym);
		 hMapAdm.put("dateofApp", dateofApp);
		return  hMapAdm;
    }
   public boolean validateAppointmentDetailsinAdminPage(HashMap<String,String>hMapAdm) {
		
		boolean result = false;
		helperObj.navigateToAModule("Patients");
		String providerName[] = driver.findElement(providerNameDetails).getText().split(":");
		String timeArr[] = driver.findElement(timeDetails).getText().split(":");
		String appTime = driver.findElement(headerDetails).getText();
		String symArr[] = driver.findElement(symDetails).getText().split(":");
		if(hMapAdm.get("doctorName").contains(providerName[1]) && hMapAdm.get("time").contains(timeArr[1]) && 
				hMapAdm.get("dateofApp").contains(appTime) && hMapAdm.get("sym").contains(symArr[1])) {
					
			        result = true;
					System.out.println("Data for create visit is displayed successfully");
				}
				return result;

}
}
