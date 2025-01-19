package asd;

import java.io.File;
import java.time.Duration;
import java.util.List;

import javax.swing.text.AbstractDocument.Content;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OrderProduct {
	
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
	
	//@Test(priority=1)
    public void LogoPresentTest() {
    	boolean status=driver.findElement(By.cssSelector("div.MuiBox-root.css-9hfmsn")).isDisplayed();
    	Assert.assertEquals(status, true);
	}
    
    //@Test(priority=2)
    public void ClientLogoTest() {
    	String client=driver.findElement(By.cssSelector("p.MuiTypography-root.MuiTypography-body1.css-uq8v4k-MuiTypography-root")).getText();
    	System.out.println(client);
    	Assert.assertEquals(client, "Sales Demo");
    	TakesScreenshot ts=(TakesScreenshot)driver;
		File sourcefile=ts.getScreenshotAs(OutputType.FILE);
		File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\ClientLogoTest.png");
		sourcefile.renameTo(targetfile);
	}
    
    @Test(priority=3)//not ready
    public void TitleTest() {
    	Assert.assertEquals(driver.getTitle(), "For Healthcare Practitioners only");
    	
    	}
    
    
   //@Test(priority=4)
    public void ReadLoginBlock() {
    	List<WebElement>Contents=driver.findElements(By.cssSelector("div.MuiCard-root.css-1842se1-MuiPaper-root-MuiCard-root"));
        for(WebElement Content: Contents) {
        	System.out.println(Content.getText());
        }
    	
    }
	
	//@Test(priority=3)
	public void HcpPortalLogin() {
		LoginMethod sp=new LoginMethod(driver);
		ProductPageMethod pp=new ProductPageMethod(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		sp.enterUserName("Jon@gmail.com");
		sp.enterPassword("Newpassword123!");
		sp.clickOnLogin();
		}
	
	//@Test(priority=4)
	public void ProductOnOrderSamplePage() throws InterruptedException {
		HomePageMethod hp=new HomePageMethod(driver);
	    hp.optionMenu("Order Samples");
	    hp.HcpInfoOnOredrSamplePage();
		}
	
	
	//@Test(priority=5)
	public void selectProductTest() throws InterruptedException {
		ProductPageMethod pp=new ProductPageMethod(driver);
		pp.SelectProductOnOrderSample("MOTRIN 500 MG TABLET");
		pp.ClickPlusButton();
		pp.ClickOnAddToCart();
	}
	
	//@Test(priority=6)
	public void readCartTest() throws InterruptedException {
		ProductPageMethod pp=new ProductPageMethod(driver);
		pp.ClickOnGoToCart();
		pp.CloseGreenPopUp();
		pp.ClickOnCheckOut();
		}
	
	//@Test(priority=7)
	public void orderSampleTest() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		ProductPageMethod pp=new ProductPageMethod(driver);
		pp.ProceedToCheckOut();
		pp.SignInSignaturePad();
		pp.PlaceOrder();
		pp.ClickOnDone();
		HomePageMethod hp=new HomePageMethod(driver);
		hp.optionMenu("Log Out");
		hp.LogOutAlert();
		}
	
	@Test(priority=8)
	public void orderHistoryTest() throws InterruptedException {
		LoginMethod sp=new LoginMethod(driver);
		ProductPageMethod pp=new ProductPageMethod(driver);
		HomePageMethod hp=new HomePageMethod(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		sp.enterUserName("Jon@gmail.com");
		sp.enterPassword("Newpassword123!");
		sp.clickOnLogin();
		pp.SelectProducts("ACETAMINOPHEN 50 MG TABLET");
		pp.ClickPlusButton();
		pp.ClickOnAddToCart();
		pp.ClickOnGoToCart();
		//pp.ShoppingCartContent();
		pp.CloseGreenPopUp();
		pp.ClickOnCheckOut();
		pp.ProceedToCheckOut();
		pp.SignInSignaturePad();
		pp.PlaceOrder();
		pp.ClickOnDone();
		hp.optionMenu("Log Out");
		hp.LogOutAlert();
	}
}

	
