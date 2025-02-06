package asd;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageLogInTest {
	public WebDriver driver;
	Wait <WebDriver> wait;
	
	@BeforeClass
	public void setup() {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver=new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//wait=new Wait<WebDriver>(driver, Duration.ofSeconds(60));
		driver.get("https://hcprd.syncrm.com/X9941/index.html?companyCode=QC23_PK&appCode=4039&roomId=1001544");
		driver.manage().window().maximize();
	}
	 
	//@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test(priority=1)
	public void VerifyAccountloginTest() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LoginMethod sp=new LoginMethod(driver);
		sp.enterUserName("Jon@gmail.com");
		sp.enterPassword("Newpassword123!");
		sp.clickOnLogin();
		Thread.sleep(4000);
		  WebElement MenuPanel=driver.findElement(By.cssSelector("button.x-button-el[data-componentid='ext-synbutton-2']"));
		  MenuPanel.click();
		  WebElement home=driver.findElement(By.cssSelector("div.x-layout-vbox-item.x-flexed div.x-body-el.x-menu-body-el>div:nth-of-type(1)"));
		  home.click();
		  //System.out.println(driver.getTitle());
		  String actualLogo=driver.findElement(By.cssSelector(".x-component-toptoolbar.x-dock-item.x-docked-top div.x-component.x-title.x-floating")).getText();
		  System.out.println(actualLogo);
		  String expectedLogo="Home";
		  Assert.assertEquals(actualLogo, expectedLogo);
		
	}
}

