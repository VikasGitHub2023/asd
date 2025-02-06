package asd;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC12516_111778_12147_AOC_Confirmation_Popup_No_button_functionality_on_mobile_devices {
	public WebDriver driver;
	Wait <WebDriver> wait;


@BeforeClass
public void setup() {
	driver=new ChromeDriver();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	//wait=new Wait<WebDriver>(driver, Duration.ofSeconds(60));
	driver.get("https://hcprdqc.syncrm.com/4.6.0-beta/index.html?companyCode=FrancescaPiper_PK&appCode=4039&roomId=1001544");
	driver.manage().window().maximize();
}
 
@AfterClass
public void tearDown()
{
	driver.quit();
}
	@Test//TC12516_111778_12147_AOC_Confirmation_Popup_No_button_functionality_on_mobile_devices
	public void CancelAocForm() throws InterruptedException {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	LoginMethod sp=new LoginMethod(driver);
	AocClearanaceToolMethod aoc=new AocClearanaceToolMethod(driver);
	sp.enterUserName("anna.christie@synergistix.com");
	sp.enterPassword("Imp0ssibl345");
	sp.clickOnLogin();
	aoc.OpenAocFromTheSidPanel();
	aoc.ClickOnReportAnIssue();
	aoc.ClickOnMsgContinueBt();
	aoc.CancelOnIncidentReport();
	String expectedMessage=driver.findElement(By.cssSelector("div.x-body-el.x-msgbox-body-el.x-dialog-body-el p")).getText();
	System.out.println(expectedMessage);
	Assert.assertEquals(expectedMessage, "Your changes have not been saved. Would you like to continue?");
  }
}
                          /*Given the user is logged into the RD Applications on mobile device
							And the user navigates to the AOC Clearance Tool screen
							And modifies data to make the screen dirty
							When the user clicks on "Go Back" or "Close"
							Then a confirmation message should appear with the text:
  							"Your changes have not been saved. Do you like to continue? Yes or No"
							And the user clicks on the "No" button
							Then the confirmation message should close
							And the application should navigate to the previous screen, e.g "Contacts"*/
