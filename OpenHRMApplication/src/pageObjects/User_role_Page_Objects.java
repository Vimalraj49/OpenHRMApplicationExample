package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class User_role_Page_Objects {
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a")
	public static WebElement Admin;

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")
	public static WebElement Username;
	
	@FindBy(xpath = "(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]")
	public static WebElement StatusDropDown; 
	
	@FindBy(xpath= "(//div[@role='listbox']//child::div)[2]")
	public static WebElement EnabledOption;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")
	public static WebElement SearchButton;

	@FindBy(xpath = "(//div[@role='cell'])[3]//child::div")
	public static WebElement UserRole;
	
	@FindBy(xpath = "(//div[@role='cell'])[4]//child::div")
	public static WebElement EmployeeName;
	
	@FindBy(xpath = "(//div[@role='cell'])[5]//child::div")
	public static WebElement StatusValue;
}
