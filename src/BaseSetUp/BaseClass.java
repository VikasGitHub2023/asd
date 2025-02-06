package BaseSetUp;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import asd.LoginMethod;


public class BaseClass  {

	
	public WebDriver driver;
	
	@BeforeClass
	public void setup() {
		//driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//wait=new Wait<WebDriver>(driver, Duration.ofSeconds(60));
		driver.get("https://hcprdqc.syncrm.com/4.6.0-beta/index.html?companyCode=FrancescaPiper_PK&appCode=4039&roomId=1001544");
		driver.manage().window().maximize();
		LoginMethod sp=new LoginMethod(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		sp.enterUserName("anna.christie@synergistix.com");
		sp.enterPassword("Imp0ssibl345");
		sp.clickOnLogin();
}
 
		//@AfterClass
		public void tearDown()
		{
			driver.quit();
		}
}
	


