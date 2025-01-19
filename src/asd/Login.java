package asd;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login extends BasePage{
	
	public Login(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public WebDriver driver;
	Wait <WebDriver> wait;
	
	@Beforeclass
	public void setup() {
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//wait=new Wait<WebDriver>(driver, Duration.ofSeconds(60));
		driver.get("https://hcprd.syncrm.com/4.4.0/index.html?companyCode=VikasSadasivan3_PK&appCode=4039&roomId=1001544");
		driver.manage().window().maximize();
		
	}
	 
	//@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test
	public void loginTest() {
		LoginMethod sp=new LoginMethod(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		sp.enterUserName("vikas@test.com");
		sp.enterPassword("Newpassword123!");
		sp.clickOnLogin();
		
		
		
	}
	
	

}
