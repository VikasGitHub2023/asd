package asd;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC12167_9630_11059_AOC_Incident_Report_an_Issue_Message {

	
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

    @Test//TC12167_9630_11059_AOC_Incident_Report_an_Issue_Message
	public void ReportAnIssueMessage() throws InterruptedException {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	LoginMethod sp=new LoginMethod(driver);
	AocClearanaceToolMethod aoc=new AocClearanaceToolMethod(driver);
	sp.enterUserName("anna.christie@synergistix.com");
	sp.enterPassword("Imp0ssibl345");
    sp.clickOnLogin();
	aoc.OpenAocFromTheSidPanel();
	Thread.sleep(1000);
	aoc.ClickOnReportAnIssue();
    aoc.ReadMsgOnReportAnIssuePopUp();
	aoc.ClickOnMsgCancelBt();
}
}
             /*Given the user is logged into the HCP Portal  
				And the user opens the AOC Clearance Tool view  
				And the user has an issue that needs to be reported
				When the user clicks on the "Report An Issue " Button 
				Then the System pops up the message box explaining to the user what the feature is used for
				            
				Please note: This form is for order-related issues only. FDA reportable adverse reactions or product quality concerns must be reported by phone.  If you need to report and adverse event please call {phoneNumber}.
				
				If you didn’t receive the correct quantity, please make sure to select the "No, I did not receive all the items" option on the AOC screen.
				If you didn’t receive the correct product, or if there’s another issue, you can report it here. We’ll use this information to investigate and resolve the issue.
				Select the reason for the issue
				Add any comments or additional details
				Upload supporting documents or photos if necessary
				Click Continue to start your report, or Close the window to return.*/
