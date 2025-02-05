package browserFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import pageFactory.LandingPage;
import utilities.ConfigReaderClass;
import utilities.DataReaderClass;



public class BaseClassBrowserSetUp {
	private static final Logger log = LogManager.getLogger(BaseClassBrowserSetUp.class);
//String hubUrl="http://localhost:4444";
 //String BaseUrl = "https://www.expedia.com/";
 protected WebDriver driver;
 protected LandingPage landingpage;
 protected DataReaderClass datareader;
 ConfigReaderClass configreaderclass;
 @BeforeSuite
 public void dataReaderAndJDBC() {
	 datareader=new DataReaderClass();
	 configreaderclass = new ConfigReaderClass();
	 log.info("Connection with ExcelData File and Config File setup");
 }
 
 @Parameters({"browserName","appUrl"})
 @BeforeMethod
 public void launchAppInBrowser(String browserName,String appUrl) {
	 if(browserName.equalsIgnoreCase("chrome")) {
		 ChromeOptions options = new ChromeOptions();
		 options.addArguments("--incognito");
		// options.addArguments("--disablePopups");
		 // options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");
		 options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});	
	//	 try {
			driver = new ChromeDriver(options);
		//} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
	//	}
		// driver = new RemoteWebdriver(new URL(hubUrl),options);
	 }
		/*
		 * else if(browserName.equalsIgnoreCase("firefox")) { FirefoxOptions options =
		 * new FirefoxOptions(); // driver = new FirefoxDriver(options); try { driver =
		 * new RemoteWebDriver(new URL(hubUrl),options); } catch (MalformedURLException
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); } }
		 */
	 else {
		 throw new InvalidArgumentException("Invalid brower type provided");
	 }
	// driver.get(configreaderclass.readProp());------>Use this if you want to read appUrl from config properties file
	 driver.get(appUrl);
	 landingpage = new LandingPage(driver);
	// driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	 
 }
 @AfterMethod()
 public void killBrowser() {
	 driver.quit();
 }
 
}
