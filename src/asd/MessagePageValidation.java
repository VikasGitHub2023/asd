package asd;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MessagePageValidation {

	public WebDriver driver;
    Wait <WebDriver> wait;
	
	@BeforeClass
	public void setup() {
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//wait=new Wait<WebDriver>(driver, Duration.ofSeconds(60));
		driver.get("https://hcprdqc.syncrm.com/4.5.0-beta/index.html?companyCode=QC23_PK&roomId=1001544");
		driver.manage().window().maximize();
	}
	 
	//@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test(priority=2)
	public void MessagePopUp() throws InterruptedException {
		LoginMethod sp=new LoginMethod(driver);
		HomePageMethod hp=new HomePageMethod(driver);
		MessagePageMethod msg=new MessagePageMethod(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		sp.enterUserName("vikassadasivan@test.com");
		sp.enterPassword("Newpassword123!");
		sp.clickOnLogin();
		msg.ReadMessagePopup();
		msg.CloseMessagePopUp();
}
}
