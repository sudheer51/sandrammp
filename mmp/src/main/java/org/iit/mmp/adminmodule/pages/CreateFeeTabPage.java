package org.iit.mmp.adminmodule.pages;
import org.iit.mmp.helper.HelperClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateFeeTabPage {

	public WebDriver driver;
	 By searchTab = By.id("search");
	 By searchBtn = By.xpath("//input[@class='tfbutton']");
	 By createFeeTab = By.xpath("//input[@value='Create Fee']");
	 By selectAppService = By.id("service");
	 By feeTB = By.xpath("//div[@id='show']//input[@class='form-control']");
	 By submitBtn = By.xpath("//input[@value='submit']");
	 HelperClass helper;
	 
	 public CreateFeeTabPage(WebDriver driver)
	 {
		this.driver= driver; 
	 }
	 
	 public void enterPatientSearch(String entPatName)
	 {
		 driver.findElement(searchTab).sendKeys(entPatName);
	 }
	 public void clickOnSearchBtn()
	 {
		 driver.findElement(searchBtn).click();
	 }
	 public void clickPatName(String patientName)
	 {
		 driver.findElement(By.xpath("//a[contains(text(),'"+patientName+"')]"));
	 }
	 public void clickCreateFee()
	 {
		 driver.findElement(createFeeTab).click();
	 }
	 
	 public void selService()
	 {
		 Select selServ = new Select(driver.findElement(selectAppService));
		 selServ.selectByValue("vaccination");
	 }
  
	 public void clkSubmit()
	 {
		 driver.findElement(submitBtn).click();
	 }

	
	 public void fillData(String pName)
	 {
		 enterPatientSearch(pName);
		 clickOnSearchBtn();
		 clickPatName(pName);
		 clickCreateFee();
		 selService();
		 clkSubmit();
	  }
	 
	 
	 

}
