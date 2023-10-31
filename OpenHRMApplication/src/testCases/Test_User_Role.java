package testCases;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import commonFunctions.commonFunctions;
import pageObjects.User_role_Page_Objects;


public class Test_User_Role extends commonFunctions {
	
	Logger logger = Logger.getLogger(Test_User_Role.class);
	
	public void waitForUserNameFieldToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(User_role_Page_Objects.Username));
    }
	public void waitForStatusDropDownToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(User_role_Page_Objects.StatusDropDown));
    }
	public void waitForEnableOptionToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(User_role_Page_Objects.EnabledOption));
    }
	public void waitForUserRoleToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(User_role_Page_Objects.UserRole));
    }
	public void waitForEmployeeNameToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(User_role_Page_Objects.EmployeeName));
    }
	public void waitForStatusValueToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(User_role_Page_Objects.StatusValue));
    }
	

	
	@Test
	public void checkUserStatus() {
	
	PageFactory.initElements(driver,User_role_Page_Objects.class);
	logger.info("Navigating to Admin/User Page");
	User_role_Page_Objects.Admin.click();
	logger.info("Sending Username");
	waitForUserNameFieldToBeVisible();
	User_role_Page_Objects.Username.sendKeys("Admin");
	waitForStatusDropDownToBeVisible();
	User_role_Page_Objects.StatusDropDown.click();
	logger.info("Selecting Enabled Status");
	waitForEnableOptionToBeVisible();
	User_role_Page_Objects.EnabledOption.click();
	logger.info("Clicking Search");
	User_role_Page_Objects.SearchButton.click();
	
	
	
	logger.info("Getting UserRole");
	waitForUserRoleToBeVisible();
	String actualRole = User_role_Page_Objects.UserRole.getText();
	logger.info("Getting EmployeeName");
	waitForEmployeeNameToBeVisible();
	String actualEmployeeName = User_role_Page_Objects.EmployeeName.getText();
	logger.info("Getting Status");
	waitForStatusValueToBeVisible();
	String actualStatus = User_role_Page_Objects.StatusValue.getText();
	
	logger.info("Verifying UserRole");
	Assert.assertEquals(actualRole, "Admin");
	System.out.println("EmployeeName: "+actualEmployeeName);
	logger.info("Verifying Status");
	Assert.assertEquals(actualStatus, "Enabled");
	logger.info("End of Test_User_Role Test Case");
	}

}
