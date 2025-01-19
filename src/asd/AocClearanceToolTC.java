package asd;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AocClearanceToolTC {
	
		public WebDriver driver;
		Wait <WebDriver> wait;
   
	
	@BeforeClass
	public void setup() {
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//wait=new Wait<WebDriver>(driver, Duration.ofSeconds(60));
		driver.get("https://hcprd.syncrm.com/X9941/index.html?companyCode=QC23_PK&appCode=4039&roomId=1001544");
		driver.manage().window().maximize();
	}
	 
	//@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test(priority=1)
	public void AccountInfoValidation() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		LoginMethod sp=new LoginMethod(driver);
		AocClearanaceToolMethod aoc=new AocClearanaceToolMethod(driver);
		sp.enterUserName("Jon@gmail.com");
		sp.enterPassword("Newpassword123!");
	    sp.clickOnLogin();
		aoc.OpenAocFromTheSidPanel();
	}
	
	@Test(priority=2)
	public void ReportAnIssueButton() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		AocClearanaceToolMethod aoc=new AocClearanaceToolMethod(driver);
		Thread.sleep(2000);
		aoc.ClickOnReportAnIssue();
		}
	
	@Test(priority=3)//TC12167_9630_11059_AOC_Incident_Report_an_Issue_Message
        public void ReportAnIssueMessage() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		AocClearanaceToolMethod aoc=new AocClearanaceToolMethod(driver);
		aoc.ReadMsgOnReportAnIssuePopUp();
		aoc.ClickOnMsgCancelBt();
	}
	
	@Test(priority=4)//TC12168_9630_11059_AOC_Incident_Report_an_Issue_Cancel
	public void ReportAnIssueCancelButton() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String ActualAocPageTitle="ACKNOWLEDGEMENT OF CONTENTS";
		String ExpectedAocPageTitle=driver.findElement(By.xpath("//div[contains(@data-title,'ACKNOWLEDGEMENT OF CONTENTS')]")).getText();
		Assert.assertEquals(ActualAocPageTitle, ExpectedAocPageTitle);
	}
	
	@Test(priority=5)//TC11855_9630_11059_Cancel_AOC_form_Automatic report
	public void CancelAocForm() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		AocClearanaceToolMethod aoc=new AocClearanaceToolMethod(driver);
		aoc.ClickNoDidNotReciveAllItem();
		aoc.SinatureOnSignPad();
		aoc.SinatureAccept();
		aoc.Skip();
		}
	
	@Test(priority=6)//TC11855_9630_11059_Cancel_AOC_form_manually_created_report
	public void CancelAocFormManually() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		AocClearanaceToolMethod aoc=new AocClearanaceToolMethod(driver);
		aoc.ClickOnReportAnIssue();
		aoc.ClickOnMsgContinueBt();
		aoc.SelectReasonDropDown("Late delivery");
		aoc.CloseDropDown();
		aoc.AddCommentOnIncidentReport("Test");
		aoc.SubmitOnIncidentReport();
		Thread.sleep(3000);
		aoc.SampleIQ();
		}
	
	@Test(priority=7)//TC11845_9630_11059_AOC_Incident_Select_predefined_reasons
	public void PredefinedReasons() throws InterruptedException {
		AocClearanaceToolMethod aoc=new AocClearanaceToolMethod(driver);
		aoc.ClickOnReportAnIssue();
		aoc.ClickOnMsgContinueBt();
		aoc.SelectReasonDropDown("Late delivery");
		aoc.SelectReasonDropDown("Product was expired");
		aoc.SelectReasonDropDown("Duplicate shipment");
		aoc.CloseDropDown();
		aoc.AddCommentOnIncidentReport("Test");
		aoc.SubmitOnIncidentReport();
		}
	
	@Test(priority=8)//TC11844_AOC_Incident_Report_an_Issue_Continue
	public void ReportAnIssueContinue() throws InterruptedException {
		AocClearanaceToolMethod aoc=new AocClearanaceToolMethod(driver);
		aoc.ClickOnReportAnIssue();
		aoc.ReadMsgOnReportAnIssuePopUp();
		aoc.ClickOnMsgContinueBt();
		aoc.ReadIncidentReport();
		aoc.SelectReasonDropDown("Duplicate shipment");
		aoc.CloseDropDown();
		aoc.AddCommentOnIncidentReport("Test");
		aoc.SubmitOnIncidentReport();
	
}
	@Test(priority=9)//TC11843_9630_11059_AOC_Discrepancy_Automatic_Incident_Report_for_Quantity_Mismatch
	public void AutomaticIncidentReportforQtyMismatch() throws InterruptedException {
		AocClearanaceToolMethod aoc=new AocClearanaceToolMethod(driver);
		aoc.ClickNoDidNotReciveAllItem();
		aoc.UpdateQty();
		aoc.UpdateQtyOnProductReceived(2);
	}
}
