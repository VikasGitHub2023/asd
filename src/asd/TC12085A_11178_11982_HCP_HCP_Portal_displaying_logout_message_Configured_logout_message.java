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

public class TC12085A_11178_11982_HCP_HCP_Portal_displaying_logout_message_Configured_logout_message {
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

	@Test//TC12085_11178_11982_HCP_HCP_Portal_displaying_logout_message_Configured_logout_message 
	public void ConfiguredLogoutMessage() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			LoginMethod sp=new LoginMethod(driver);
			HomePageMethod hp=new HomePageMethod(driver);
			sp.enterUserName("anna.christie@synergistix.com");
			sp.enterPassword("Imp0ssibl345");
			sp.clickOnLogin();
			hp.optionMenu("Log Out");
			hp.LogOutAlert();
			String expectedMessage=driver.findElement(By.cssSelector("div.x-body-el.x-container-body-el.x-component-body-el.x-layout-auto div.x-logout-success-text")).getText();
			System.out.println(expectedMessage);
			String actualMessage=("You are now logged out of Test HCP Portal");
			Assert.assertEquals(actualMessage, expectedMessage);
}
}
