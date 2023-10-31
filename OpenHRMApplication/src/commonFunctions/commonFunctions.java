package commonFunctions;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pageObjects.Login_Page_Objects;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class commonFunctions {

	public static WebDriver driver=null;
	public static Properties properties=null;
	
	
	static Logger logger = Logger.getLogger(commonFunctions.class);

	public Properties loadPropertfile() throws IOException {

		//property file load and return

		//to fetch config.properties file
		FileInputStream fileInputStream = new FileInputStream("config.properties");

		//to load config.properties file
		properties = new Properties();
		properties.load(fileInputStream);

		return properties;
	}


	// Wait for the "UserName" element to become clickable
	public void waitForUserNameFieldToBeClickable() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(Login_Page_Objects.userName));
    }
	 // Wait for the "password" element to become visible
    public void waitForPasswordFieldToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(Login_Page_Objects.password));
    }
    // Wait for the "submitButton" element to become clickable
    public void waitForSubmitButtonToBeClickable() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(Login_Page_Objects.submitButton));
    }
	
	@BeforeSuite
	public void launchBrowser() throws IOException, InterruptedException {
		PropertyConfigurator.configure("log4j.properties");
		logger.info("Orange HRM Test has begun");
		logger.info("Loading the property file");
		loadPropertfile();
		String browser= properties.getProperty("browser");
		String url = properties.getProperty("url");
		String driverLocation = properties.getProperty("driverLocation");

		if(browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver",driverLocation);
			logger.info("Launching Chrome Browser");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",driverLocation);
			logger.info("Launching Firefox Browser");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		logger.info("Navigating to Application");
		driver.get(url);
		
		//Thread.sleep(5000);//wait needs to be implemented-pls work on that!!
		
	}

	@AfterSuite
	public void tearDown() {

		logger.info("Execution done. Closing the Browser");
		driver.quit();
	}
}
