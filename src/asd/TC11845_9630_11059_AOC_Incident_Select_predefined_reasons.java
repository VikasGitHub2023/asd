package asd;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC11845_9630_11059_AOC_Incident_Select_predefined_reasons {
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
	@Test//TC11845_9630_11059_AOC_Incident_Select_predefined_reasons
	public void CancelAocForm() throws InterruptedException {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	LoginMethod sp=new LoginMethod(driver);
	AocClearanaceToolMethod aoc=new AocClearanaceToolMethod(driver);
	sp.enterUserName("anna.christie@synergistix.com");
	sp.enterPassword("Imp0ssibl345");
	sp.clickOnLogin();
	aoc.OpenAocFromTheSidPanel();
	//aoc.OpenDeliveryDateDropDown("January", 2025, 29);
	aoc.ClickYesAllItemRecived();
	aoc.ClickOnReportAnIssue();
	aoc.ClickOnMsgContinueBt();
	Thread.sleep(2000);
	aoc.SelectReasonDropDown("Duplicate shipment");
	aoc.SelectReasonDropDown("Late delivery");
	aoc.CloseDropDown();
	aoc.AddCommentOnIncidentReport("Test");
	aoc.SubmitOnIncidentReport();
	aoc.SinatureOnSignPad();
	aoc.SinatureAccept();
	aoc.SaveAndNext();
	Thread.sleep(2000);
	aoc.SampleIQ();
	aoc.SiqComplianceTool();
	}
}

	/*Given the user is on the "Incident Report Form"  
	When the user opens the "Reason" dropdown  
	Then the user can select one or more predefined reasons from the list  
	And all selected reasons should be displayed in the form    
	And the reason should be saved when the "Report Incident" form is submitted
	And AOC is saved*/