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
	driver.get("https://hcprd.syncrm.com/X9941/index.html?companyCode=QC23_PK&appCode=4039&roomId=1001544");
	driver.manage().window().maximize();
}
 
//@AfterClass
public void tearDown()
{
	driver.quit();
}
	@Test//TC12943_9630_12897_AOC_Report_Incident_confirmation_message_once_per_AOC
	public void CancelAocForm() throws InterruptedException {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	LoginMethod sp=new LoginMethod(driver);
	AocClearanaceToolMethod aoc=new AocClearanaceToolMethod(driver);
	sp.enterUserName("Jon@gmail.com");
	sp.enterPassword("Newpassword123!");
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
