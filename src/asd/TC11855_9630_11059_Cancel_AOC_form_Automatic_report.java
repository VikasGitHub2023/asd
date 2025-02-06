package asd;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC11855_9630_11059_Cancel_AOC_form_Automatic_report {
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
	@Test//TC11855_9630_11059_Cancel_AOC_form_Automatic report
	public void CancelAocForm() throws InterruptedException {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	LoginMethod sp=new LoginMethod(driver);
	AocClearanaceToolMethod aoc=new AocClearanaceToolMethod(driver);
	sp.enterUserName("anna.christie@synergistix.com");
	sp.enterPassword("Imp0ssibl345");
	sp.clickOnLogin();
	aoc.OpenAocFromTheSidPanel();
	aoc.ClickNoDidNotReciveAllItem();
	aoc.SinatureOnSignPad();
	aoc.SinatureAccept();
	aoc.Skip();
	aoc.SampleIQ();
	aoc.SiqComplianceTool();
	aoc.SiqClickOnIncidentFolder();

}
}
			/*AOC form with a previously created automatic report  - Cancel 
			Given the user has logged into the HCP Portal  
			And an automatic AoC discrepancy report has been created  
			When the user cancels the AOC form  
			Then the system discards the automatic AoC report  
			And no record of the report should be available in the compliance tool */
