package asd;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class TC11843_9630_11059_AOC_Discrepancy_Automatic_Incident_Report_for_Quantity_Mismatch  {
	
	

	public WebDriver driver;
	Wait <WebDriver> wait;
	
    

@BeforeClass
	public void setup() {
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("https://hcprd.syncrm.com/X9941/index.html?companyCode=QC23_PK&roomId=1001544");
		driver.get("https://hcprdqc.syncrm.com/4.6.0-beta/index.html?companyCode=FrancescaPiper_PK&appCode=4039&roomId=1001544");
		driver.manage().window().maximize();
}
 //@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
    @Test()//TC11843_9630_11059_AOC_Discrepancy_Automatic_Incident_Report_for_Quantity_Mismatch
	public void CancelAocForm() throws InterruptedException {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	//SetUpHCP hcp=new SetUpHCP(driver);
	LoginMethod sp=new LoginMethod(driver);
	AocClearanaceToolMethod aoc=new AocClearanaceToolMethod(driver);
	//hcp.OpenHCP();
	//sp.enterUserName("Jon@gmail.com");
	//sp.enterPassword("Newpassword123!");
	sp.enterUserName("anna.christie@synergistix.com");
	sp.enterPassword("Imp0ssibl345");
	sp.clickOnLogin();
	aoc.OpenAocFromTheSidPanel();
	aoc.ClickNoDidNotReciveAllItem();
    aoc.UpdateQty();
    aoc.UpdateQtyOnProductReceived(7);
    //aoc.OpenDeliveryDateDropDown();
    aoc.SinatureOnSignPad();
    aoc.SinatureAccept();
	aoc.SaveAndNext();
	//Thread.sleep(2000);
	//aoc.SampleIQ();
	//aoc.SiqComplianceTool();
	//aoc.SiqClickOnAttachment();
	}
}

