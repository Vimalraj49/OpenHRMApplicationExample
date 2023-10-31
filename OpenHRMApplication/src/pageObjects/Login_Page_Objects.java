package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Login_Page_Objects {

	@FindBy(name = "username")
	public static WebElement userName;
	@FindBy(name = "password")
	public static WebElement password;
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
	public static WebElement submitButton;
	

}
