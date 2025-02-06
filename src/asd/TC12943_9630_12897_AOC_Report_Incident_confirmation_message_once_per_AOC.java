package asd;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC12943_9630_12897_AOC_Report_Incident_confirmation_message_once_per_AOC {
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
	@Test//TC12943_9630_12897_AOC_Report_Incident_confirmation_message_once_per_AOC
	public void CancelAocForm() throws InterruptedException {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	LoginMethod sp=new LoginMethod(driver);
	AocClearanaceToolMethod aoc=new AocClearanaceToolMethod(driver);
	sp.enterUserName("anna.christie@synergistix.com");
	sp.enterPassword("Imp0ssibl345");
	sp.clickOnLogin();
	aoc.OpenAocFromTheSidPanel();
	aoc.ClickOnReportAnIssue();
	//aoc.ReadMsgOnReportAnIssuePopUp();
	aoc.ClickOnMsgContinueBt();
	aoc.SelectReasonDropDown("Late delivery");
	aoc.CloseDropDown();
	aoc.AddCommentOnIncidentReport("Test");
	aoc.SubmitOnIncidentReport();
	aoc.ClickOnReportAnIssue();
	String ExpectedTitle=driver.findElement(By.cssSelector("div.x-unselectable.x-paneltitle.x-dialogtitle.x-dialogtitle.x-layout-box-item div.x-text-el")).getText();
	System.out.println(ExpectedTitle);
	String ActualTitle="Incident Report";
	Assert.assertEquals(ExpectedTitle,ActualTitle);
	}
}
    /*AOC-Report Incident - Display confirmation message once per AOC
	Given the user is logged into the HCP Portal  
	And the user opens the AOC Clearance Tool view  
	And the user has an issue that needs to be reported
	When the user clicks on the "Report An Issue " Button 
	And the warning message has not been displayed for the current AOC
	Then the warning message should be displayed
	And the user must acknowledge the message by clicking the "Continue" button

 	AOC-Report Incident - Do not display the warning message again for the same AOC
	Given the user is in the AOC Clearance Tool view  
	And the user still has a problem that needs to be reported
	And the user previously clicked on  "Report An Issue " and "Continue" at the time the message was displayed.
	When the user clicks again on the "Report An Issue " Button 
	Then the warning message should not appear
	And the user is allowed to proceed without interruption*/