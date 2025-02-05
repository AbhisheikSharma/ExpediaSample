package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	WebDriver driver;
	public LandingPage(WebDriver ldriver) {
	this.driver=ldriver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='Flights']")
	WebElement flightstab;
	
	@FindBy(xpath="//span[text()='Economy']")
	WebElement seattype;
	
	@FindBy(xpath="//button[@aria-label='Leaving from']")
	WebElement sourcebox;
	
	@FindBy(id="origin_select")
	WebElement sourcestation;
	
	@FindBy(xpath="//button[@aria-label='Delhi (DEL - Indira Gandhi Intl.) Near New Delhi, National Capital Territory of Delhi, India']")
	WebElement delhi;
	
	@FindBy(xpath="//button[@aria-label='Going to']")
	WebElement destbox;
	
	@FindBy(id="destination_select")
	WebElement deststation;
	
	@FindBy(xpath="//button[contains(@aria-label,'Chicago (ORD')]")
	WebElement chicago;
	
	@FindBy(xpath="//div[contains(text(),'Business class')]//preceding-sibling::button")
	WebElement businessclass;
	
	@FindBy(css="#search_button")
	WebElement searchbutton;
	
	
public void enterFlightInfo(String startpoint, String destination) throws InterruptedException {
	flightstab.click();
	sourcebox.click();
	Thread.sleep(3000);
	System.out.println("Source box clicked");
	sourcestation.sendKeys(startpoint);
	System.out.println("Source entered");
	delhi.click();
	Thread.sleep(3000);
	destbox.click();
	Thread.sleep(3000);
	deststation.sendKeys(destination);
	Thread.sleep(3000);
	chicago.click();
	
	
	seattype.click();
	
	businessclass.click();
	searchbutton.click();
}
}
