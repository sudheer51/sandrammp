package org.iit.mmp.adminmodule.pages;
import java.util.List;
import org.iit.mmp.helper.HelperClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
public class AdminApprovalPage{
	WebDriver driver;
	HelperClass helperObj;
	public AdminApprovalPage(WebDriver driver) {
		this.driver = driver;
		helperObj = new HelperClass(driver);
	}
	public String adminApprovalAlertMessage() throws InterruptedException {
		driver.findElement(By.xpath("//span[contains(text(),'Users')]")).click();
		// number of rows in the dynamic table
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id='show']/table/tbody/tr/td[1]"));
		int i = rows.size();
		driver.findElement(By.xpath("//*[@id='show']/table/tbody/tr[" + i + "]/td[1]/a")).click();
		Select status = new Select(driver.findElement(By.name("approval")));
		status.selectByVisibleText("Accepted");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		String patientStatusMsgAfterAdminAppr = helperObj.alertMessage();
		return patientStatusMsgAfterAdminAppr;
	}
}
