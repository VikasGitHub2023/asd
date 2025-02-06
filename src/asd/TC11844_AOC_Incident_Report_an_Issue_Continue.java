package asd;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC11844_AOC_Incident_Report_an_Issue_Continue {
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
 
//@AfterClass
public void tearDown()
{
	driver.quit();
}
	@Test//TC11844_AOC_Incident_Report_an_Issue_Continue
	public void CancelAocForm() throws InterruptedException {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	LoginMethod sp=new LoginMethod(driver);
	AocClearanaceToolMethod aoc=new AocClearanaceToolMethod(driver);
	sp.enterUserName("anna.christie@synergistix.com");
	sp.enterPassword("Imp0ssibl345");
	sp.clickOnLogin();
	aoc.OpenAocFromTheSidPanel();
	aoc.ClickYesAllItemRecived();
	//aoc.OpenDeliveryDateDropDown("January", 2025, 29);
	aoc.ClickOnReportAnIssue();
	aoc.ReadMsgOnReportAnIssuePopUp();
	aoc.ClickOnMsgContinueBt();
	aoc.ReadIncidentReport();
	aoc.SelectReasonDropDown("Duplicate shipment");
	aoc.CloseDropDown();
	aoc.uploadFile();
	aoc.AddCommentOnIncidentReport("Test");
	aoc.SubmitOnIncidentReport();
	aoc.SinatureOnSignPad();
	aoc.SinatureAccept();
	aoc.SaveAndNext();
	aoc.SampleIQ();
	aoc.SiqComplianceTool();
	aoc.SiqClickOnIncidentFolder();
	aoc.SiqClickOnAttachment();
}
}

		/*Given the user has an issue that needs to be reported
		When the user clicks on the "Report An Issue " button 
		And the System pops up the message box explaining to the user what the feature is used for
		When the user clicks on the Continue button   
		Then the "Incident Report Form" should open  
		And the following fields should be available to capture information:  
		  - Reason  
		  - Attachment  
		  - Comments  
		When the "Report Incident" form is saved by clicking the "Submit" button
		And AOC is saved by clicking "Save"
		Then the new incident report should appear in the SampleIQ - Compliance Tool - Incidents tab under the Edit action  
		And all uploaded documents should be listed in the Attachment section of the Incident   
		And in the incident folder action,  Attachment tab, all uploaded documents should be displayed  
		And in the incident folder action,  Link tab, all notifications and activity logs should be listed  */