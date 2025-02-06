package asd;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC11853_9630_11059_AOC_Incident_File_Manager_for_upload_doc {
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
	@Test//TC11853_9630_11059_AOC_Incident_File_Manager_for_upload_doc
	public void CancelAocForm() throws InterruptedException {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	LoginMethod sp=new LoginMethod(driver);
	AocClearanaceToolMethod aoc=new AocClearanaceToolMethod(driver);
	sp.enterUserName("Jon@gmail.com");
	sp.enterPassword("Newpassword123!");
	sp.clickOnLogin();
	aoc.OpenAocFromTheSidPanel();
	aoc.ClickYesAllItemRecived();
	//aoc.OpenDeliveryDateDropDown(23);
	aoc.ClickOnReportAnIssue();
	aoc.ReadMsgOnReportAnIssuePopUp();
	aoc.ClickOnMsgContinueBt();
	aoc.ReadIncidentReport();
	aoc.SelectReasonDropDown("Duplicate shipment");
	aoc.CloseDropDown();
	aoc.uploadFile();
	Thread.sleep(2000);
	aoc.AddCommentOnIncidentReport("Test");
    aoc.SubmitOnIncidentReport();
	aoc.SinatureOnSignPad();
	aoc.SinatureAccept();
	aoc.SaveAndNext();
	aoc.SampleIQ();
	aoc.SiqComplianceTool();
	aoc.SiqClickOnIncidentFolder();
	aoc.SiqClickOnAttachment();
	//aoc.SiqClickOnComments();
}
}

   /*Given the user is on the "Incident Report Form"  
	And the user uploads files or evidence to the File Manager list 
	When the "Report Incident" form is saved by clicking the submit button
	Then the IDs of documents are included in the incident report  
	And when the AOC is saved by clicking "Save "
	Then all doc are saved
	And the report is integrated into the SampleIQ compliance tool  
	And all uploaded documents should be listed in the Attachment section of the Incident   
	And in the incident folder action,  Attachment tab, all uploaded documents should be displayed */

