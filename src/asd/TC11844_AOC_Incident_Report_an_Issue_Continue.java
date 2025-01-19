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
	driver.get("https://hcprd.syncrm.com/X9941/index.html?companyCode=QC23_PK&appCode=4039&roomId=1001544");
	driver.manage().window().maximize();
}
 
@AfterClass
public void tearDown()
{
	driver.quit();
}
	@Test//TC11844_AOC_Incident_Report_an_Issue_Continue
	public void CancelAocForm() throws InterruptedException {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	LoginMethod sp=new LoginMethod(driver);
	AocClearanaceToolMethod aoc=new AocClearanaceToolMethod(driver);
	sp.enterUserName("Jon@gmail.com");
	sp.enterPassword("Newpassword123!");
	sp.clickOnLogin();
	aoc.OpenAocFromTheSidPanel();
	aoc.ClickOnReportAnIssue();
	aoc.ReadMsgOnReportAnIssuePopUp();
	aoc.ClickOnMsgContinueBt();
	aoc.ReadIncidentReport();
	aoc.SelectReasonDropDown("Duplicate shipment");
	aoc.CloseDropDown();
	aoc.AddCommentOnIncidentReport("Test");
	aoc.SubmitOnIncidentReport();
}
}