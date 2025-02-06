package asd;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC13005_11178_12206_HCP_Portal_Product_Detail_and_Prescriber_Info_remain_responsive_after_using_the_browser_back_arrow {
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
	@Test//TC13005_11178_12206_HCP_Portal_Product_Detail_and_Prescriber_Info_remain_responsive_after_using_the_browser_back_arrow 
	public void CancelAocForm() throws InterruptedException {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	LoginMethod sp=new LoginMethod(driver);
	ProductPageMethod pp=new ProductPageMethod(driver);
	AocClearanaceToolMethod aoc=new AocClearanaceToolMethod(driver);
	sp.enterUserName("anna.christie@synergistix.com");
	sp.enterPassword("Imp0ssibl345");
	sp.clickOnLogin();
	pp.SelectProducts("ACETAMINOPHEN 50 MG TABLET");
	Thread.sleep(3000);
	driver.navigate().back();
	pp.SelectProductOnOrderSample("TYLENOL 10 MG CAPSULE.");
	
	}
}

