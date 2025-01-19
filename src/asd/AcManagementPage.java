package asd;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AcManagementPage {

	public WebDriver driver;
    //Wait <WebDriver> wait;
    //WebDriverWait wait=new WebDriverWait(driver,10);
	
	@BeforeClass
	public void setup() {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver=new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//wait=new Wait<WebDriver>(driver, Duration.ofSeconds(60));
		driver.get("https://hcprd.syncrm.com/4.4.0/index.html?companyCode=VikasSadasivan3_PK&appCode=4039&roomId=1001544");
		driver.manage().window().maximize();
	}
	 
	//@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test(priority=1)
	public void AccountInfoValidation() throws InterruptedException {
		LoginMethod sp=new LoginMethod(driver);
		ProductPageMethod pp=new ProductPageMethod(driver);
		MessagePageMethod msg=new MessagePageMethod(driver);
		HomePageMethod hp=new HomePageMethod(driver);
		AcMgtMethod am=new AcMgtMethod(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		sp.enterUserName("vikas@test.com");
		sp.enterPassword("Newpassword123!");
		sp.clickOnLogin();
		//msg.CloseMessagePopUp();
		hp.optionMenu("Account Management");
		am.PrintAccountInfo();
		}
	
	//@Test(priority=2)
	public void EditBuisnessInformation() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		AcMgtMethod am=new AcMgtMethod(driver);
		am.ClickBusinessInfoEditBt();
		am.EnterBuisnessName("SMITHS Pharmacy L & M Pharmacy");
		am.EnterCategoryName("Group Practice");
		am.EnterTaxID(02345);
		Thread.sleep(2000);
		am.ClickOnSave();
		am.ValidateAndPrintEditBt();
		}
	
	@Test(priority=3)
	public void ManageShippAddress() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		AcMgtMethod am=new AcMgtMethod(driver);
		am.ClickOnShippingAddManageBt();
		am.PrintShippingAddress();
		am.ClickOnAddNewAddress();
		
	}
	
	//@Test(priority=4)
	public void SaveUsingAvailableShippingAddress() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		AcMgtMethod am=new AcMgtMethod(driver);
		am.EnterAvailableShippingAddress("686 BEAR SWAMP RD, PERU, NY 12972");
		am.EnterNameOfShippingPerson("Smith");
		am.SaveShippingAddress();
	}
	
	@Test(priority=5)
	public void SaveUsingNewShippingAddress() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		AcMgtMethod am=new AcMgtMethod(driver);
		am.EnterNameOfShippingPerson("Tom");
		am.EnterShippingAddress1("10190 West Sample Rd");
		am.EnterShippingAddress2("Apt 2202");
		am.EnterShippingCity("Coral Spring");
		am.EnterShippingState("Florida");
		am.EnterZipCode(33065);
		am.SaveShippingAddress();
      }
	}
	
