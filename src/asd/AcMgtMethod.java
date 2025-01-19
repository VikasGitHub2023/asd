package asd;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AcMgtMethod extends BasePage{

	public AcMgtMethod(WebDriver driver) {
		super(driver);
		
		//This page has all the locators and methods for Account Management Page
	}
	
	//WebDriverWait wait=new WebDriverWait(driver,10);
	 
	public void CloseAlert() throws InterruptedException {
		Alert alert=driver.switchTo().alert();
		String alertMsg=driver.switchTo().alert().getText();
		System.out.println(alertMsg);
		Thread.sleep(1000);
		alert.dismiss();
	}
	
	public void CloseErrorMsg() {
		driver.findElement(By.cssSelector(".x-layout-hbox-item.x-toast-text div.x-layout-box-item.x-layout-hbox-item")).click();
	}
	
	
	 public void PrintAccountInfo() {
		 List<WebElement>AccInforms= driver.findElements(By.cssSelector(".x-component-whitepanel-body-wrap-el"));
		 for(WebElement AccInfo:AccInforms) {
			 System.out.println(AccInfo.getText());
			 TakesScreenshot ts=(TakesScreenshot)driver;
				File sourcefile=ts.getScreenshotAs(OutputType.FILE);
				File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\AccInfoPage.png");
				sourcefile.renameTo(targetfile);
			 }
	 }
	 
	 public void ValidateAndPrintEditBt() {
		 List<WebElement>UpdatedBusInfos=driver.findElements(By.id("#ext-container-8"));
		 for(WebElement UpdatedBusInfo: UpdatedBusInfos) {
			 System.out.println(UpdatedBusInfo.getText());
		 }
	 }
		 
	    public void ClickBusinessInfoEditBt() {
	    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			 WebElement Edt=driver.findElement(By.xpath("//div[contains(@id,'ext-button-3')]"));
			 JavascriptExecutor js=(JavascriptExecutor)driver;
			 js.executeScript("arguments[0].click()", Edt);
			
			 }
		 
		 public void EnterBuisnessName(String BuisnessName) {
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			 driver.findElement(By.name("Name")).clear();
			 driver.findElement(By.name("Name")).sendKeys(BuisnessName);
		 }
		 
		 public void EnterCategoryName(String Category) {
			 driver.findElement(By.name("businessCategoryId")).sendKeys(Category);
		 }
		 
		 public void EnterTaxID(int taxId) {
			 driver.findElement(By.name("taxId")).clear();
			 driver.findElement(By.name("taxId")).sendKeys(String.valueOf(taxId));
		 }
		 
		 public void EnterNPI(int NPI) {
			 driver.findElement(By.name("npi")).sendKeys(String.valueOf(NPI));
		 }
		 
		 public void ClickOnCancel() {
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			 driver.findElement(By.xpath("//div[contains(@id,'ext-button-9')]")).click();
		 }
		 
		 public void ClickOnSave() {
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			 driver.findElement(By.xpath("//div[contains(@id,'ext-button-10')]")).click();
		 }
		 
		 public void ClickOnShippingAddManageBt() {
	    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			 WebElement Mng=driver.findElement(By.xpath("//div[contains(@id,'ext-button-4')]"));
			 JavascriptExecutor js=(JavascriptExecutor)driver;
			 js.executeScript("arguments[0].click()", Mng);
			}
		 
		 public void PrintShippingAddress() {
			 List<WebElement>ShippingAdds= driver.findElements(By.cssSelector(".x-component-toolonlywhite-body-wrap-el"));
			 for(WebElement ShippingAdd:ShippingAdds) {
				 System.out.println(ShippingAdd.getText());
		 }
	 }
		 
		 public void ClickOnAddNewAddress() {
			 driver.findElement(By.cssSelector(".x-button-buttongreen.x-component-buttongreen")).click();
		 }
		 
		 public void EnterAvailableShippingAddress(String EnterShippingAdd) {
			 driver.findElement(By.name("masterAddressId")).sendKeys(EnterShippingAdd);
        }
		 
		 public void EnterNameOfShippingPerson(String EnterName) {
			 driver.findElement(By.name("locationName")).sendKeys(EnterName);
        }
		 
		 public void EnterShippingAddress1(String EnterAddress1) {
			 driver.findElement(By.name("address1")).sendKeys(EnterAddress1);
        }
		 
		 public void EnterShippingAddress2(String EnterAddress2) {
			 driver.findElement(By.name("address2")).sendKeys(EnterAddress2);
        }
		 
		 public void EnterShippingCity(String Entercity) {
			 driver.findElement(By.name("city")).sendKeys(Entercity);
        }
		 
		 public void EnterShippingState(String EnterState) {
			 driver.findElement(By.name("state")).sendKeys(EnterState);
        }
		 
		 public void EnterZipCode(int zipCode) {
			 driver.findElement(By.name("postalCode")).clear();
			 driver.findElement(By.name("postalCode")).sendKeys(String.valueOf(zipCode));
		 }
		 
		 public void SaveShippingAddress() {
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			 driver.findElement(By.xpath("//div[contains(@id,'ext-button-33')]")).click();
		 }
   }
       
        





