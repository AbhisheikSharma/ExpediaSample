package browserFactory;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import pageFactory.LandingPage;
import utilities.DataReaderClass;



public class BaseClassBrowserSetUp {
	private static final Logger log = LogManager.getLogger(BaseClassBrowserSetUp.class);
	
 String BaseUrl = "https://www.expedia.com/";
 protected WebDriver driver;
 protected LandingPage landingpage;
 
 @BeforeSuite
 public void dataReaderAndJDBC() {
	 DataReaderClass.initializeDataReaderClass();
	 log.info("Connection with ExcelData File setup");
 }
 
 @Parameters({"browserName"})
 @BeforeTest
 public void launchAppInBrowser(String browserName) {
	 if(browserName.equalsIgnoreCase("chrome")) {
		 ChromeOptions options = new ChromeOptions();
		 options.addArguments("--incognito");
		// options.addArguments("--disablePopups");
		 // options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");
		 options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});	
		 driver = new ChromeDriver(options);
	 }
	 else if(browserName.equalsIgnoreCase("firefox")) {
		 FirefoxOptions options = new FirefoxOptions();
		 driver = new FirefoxDriver(options);
	 }
	 else {
		 throw new InvalidArgumentException("Invalid brower type provided");
	 }
	 driver.get(BaseUrl);
	 landingpage = PageFactory.initElements(driver, LandingPage.class);
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	 
 }
 @AfterMethod()
 public void killBrowser() {
	 driver.quit();
 }
 
}
