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

public class TC12168_9630_11059_AOC_Incident_Report_an_Issue_Cancel {
   
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

       @Test//TC12168_9630_11059_AOC_Incident_Report_an_Issue_Cancel
       public void ReportAnIssueMessage() throws InterruptedException {
    	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    	   LoginMethod sp=new LoginMethod(driver);
    	   AocClearanaceToolMethod aoc=new AocClearanaceToolMethod(driver);
    	   sp.enterUserName("anna.christie@synergistix.com");
    	   sp.enterPassword("Imp0ssibl345");
    	   sp.clickOnLogin();
    	   aoc.OpenAocFromTheSidPanel();
    	   aoc.ClickOnReportAnIssue();
    	   aoc.ReadMsgOnReportAnIssuePopUp();
   		   aoc.ClickOnMsgCancelBt();
    	   String ActualAocPageTitle="ACKNOWLEDGEMENT OF CONTENTS";
    	   String ExpectedAocPageTitle=driver.findElement(By.xpath("//div[contains(@data-title,'ACKNOWLEDGEMENT OF CONTENTS')]")).getText();
    	   System.out.println(ExpectedAocPageTitle);
    	   Assert.assertEquals(ActualAocPageTitle, ExpectedAocPageTitle);
}
}
		/*Given the user has an issue that needs to be reported
		When the user clicks on the "Report An Issue " button 
		And the System pops up the message box explaining to the user what the feature is used for
		When the user click on Cancel button 
		Then the app returns to the AOC screen.*/

