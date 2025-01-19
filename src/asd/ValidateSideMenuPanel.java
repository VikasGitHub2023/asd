package asd;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ValidateSideMenuPanel {
	
	

	public WebDriver driver;
	Wait <WebDriver> wait;
	
	@BeforeClass
	public void setup() {
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//wait=new Wait<WebDriver>(driver, Duration.ofSeconds(60));
		driver.get("https://hcprd.syncrm.com/4.4.0/index.html?companyCode=VikasSadasivan3_PK&appCode=4039&roomId=1001544");
		driver.manage().window().maximize();
	}
	 
	//@AfterClass
	public void logout() {
		driver.quit();
	}
	
	
	//@Test(priority=1)
	public void selectProductTest() throws InterruptedException {
		LoginMethod sp=new LoginMethod(driver);
		HomePageMethod hp=new HomePageMethod(driver);
		ProductPageMethod pp=new ProductPageMethod(driver);
		MessagePageMethod msg=new MessagePageMethod(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		sp.enterUserName("vikas@test.com");
		sp.enterPassword("Newpassword123!");
		sp.clickOnLogin();
		msg.CloseMessagePopUp();
		pp.SelectProducts("TYLENOL BROCHURE");
		pp.SelectProducts("ACETAMINOPHEN 50 MG TABLET");
		pp.ClickPlusButton();
		pp.ClickOnAddToCart();
		pp.ClickOnGoToCart();
		pp.CloseGreenPopUp();
		pp.ClickOnCheckOut();
		pp.ProceedToCheckOut();
		pp.SignInSignaturePad();
		pp.PlaceOrder();
		pp.ClickOnDone();
		
		
	}
	@Test(priority=2)//This test will login and will select the Order History from menu panel
	public void ValidateOrderHistory() throws InterruptedException {
		LoginMethod sp=new LoginMethod(driver);
		HomePageMethod hp=new HomePageMethod(driver);
		MessagePageMethod msg=new MessagePageMethod(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		sp.enterUserName("vikas@test.com");
		sp.enterPassword("Newpassword123!");
		sp.clickOnLogin();
		msg.CloseMessagePopUp();
		hp.optionMenu("order history");
		
		}
	@Test(priority=3)//This test will set the filter and print the order history to the console
	public void OrderHistoryApprovedTest() throws InterruptedException {
		OrderHistoryMethod oh=new OrderHistoryMethod(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		oh.OrderHistoryAllOrdersDropDown();
		oh.OrderHistoryAllOrdersDropDownMenu("Processing");
		oh.OrderHistoryOrderDateDropDown();
		oh.OrderHistoryOrderDateMenu("Last 30 Days");
		oh.ReadOrderHistory();
		}
	//@Test(priority=4)//This test will open the About page and print the content on the console
	public void AboutPageTest() throws InterruptedException {
		HomePageMethod hp=new HomePageMethod(driver);
		AboutPageMethod ab=new AboutPageMethod(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		hp.optionMenu("About");
		ab.ReadAboutPage();
		ab.CloseAboutPage();
		
	}
}
