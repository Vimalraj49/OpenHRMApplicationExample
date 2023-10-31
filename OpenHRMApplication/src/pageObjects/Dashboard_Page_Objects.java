package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Dashboard_Page_Objects {

	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[5]/div/div[2]/div/p")
	public static WebElement pendingLeaveRequests;	
	
}
