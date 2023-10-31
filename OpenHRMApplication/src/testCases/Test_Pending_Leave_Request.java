package testCases;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import commonFunctions.commonFunctions;
import pageObjects.Dashboard_Page_Objects;
import pageObjects.Login_Page_Objects;

public class Test_Pending_Leave_Request extends commonFunctions {

	String actualMessage =null;
	static Logger logger= Logger.getLogger(Test_Pending_Leave_Request.class);
	
	public void login()
	{
		logger.info("Logging into the application");
		PageFactory.initElements(driver,Login_Page_Objects.class);
		waitForUserNameFieldToBeClickable();
		Login_Page_Objects.userName.sendKeys(properties.getProperty("username"));
		waitForPasswordFieldToBeVisible();
		Login_Page_Objects.password.sendKeys(properties.getProperty("password"));
		waitForSubmitButtonToBeClickable();
		Login_Page_Objects.submitButton.click();
	}
	
	public void getPendingLeaverequests() {
		
		PageFactory.initElements(driver,Dashboard_Page_Objects.class);
		waitForEmployeesLeaveTableToBeVisible();
		actualMessage =Dashboard_Page_Objects.pendingLeaveRequests.getText();
	}
	
	public void waitForEmployeesLeaveTableToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(Dashboard_Page_Objects.pendingLeaveRequests));
    }
	
	@Test
	public void verifyPendingLeaveRequests() {
		
		login();
		logger.info("Getting the Pending Leave request Details");
		getPendingLeaverequests();
		logger.info("Verification Commencing");
		Assert.assertEquals(actualMessage, "No Employees are on Leave Today");
		logger.info("End of Test_Pending_Leave_Request Test Case");
	}
}
