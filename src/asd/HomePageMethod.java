package asd;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.nio.file.OpenOption;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

//Methods

public class HomePageMethod extends BasePage {
	
	public HomePageMethod(WebDriver driver) {
		super(driver);
		
		}
			@FindBy(css="button.x-button-el[data-componentid=\"ext-synbutton-2\"]")
			WebElement menuPanel;
			@FindBy(css="button.x-button-el[type='button']")
			WebElement button;
			
			//BasePage ss=new BasePage(driver);
			Wait<WebDriver>wait;
			
			/*public void clickOnMenuPanel()
			{
			   menuPanel.click();
			}*/
			
			public void optionMenu(String opt) throws InterruptedException {
				
				menuPanel.click();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				List<WebElement>options=driver.findElements(By.cssSelector("div.x-body-el.x-menu-body-el>div:nth-of-type(n)"));
				Thread.sleep(40);
				for(WebElement option:options) {
					if(option.getText().equalsIgnoreCase(opt)) {
						option.click();
						break;
					}
					TakesScreenshot ts=(TakesScreenshot)driver;
					File sourcefile=ts.getScreenshotAs(OutputType.FILE);
					File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\optionMenu.png");
					sourcefile.renameTo(targetfile);
				}
			}
			
			
			
			public void LogOutAlert() throws InterruptedException {
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
				Thread.sleep(1000);
				WebElement logOutPopUp=driver.findElement(By.cssSelector("div.x-component-alt.x-button-warning.x-component-warning.x-layout-box-item"));
				//logOutPopUp.click();
				TakesScreenshot ts=(TakesScreenshot)driver;
				File sourcefile=ts.getScreenshotAs(OutputType.FILE);
				File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\logOutAlert.png");
				sourcefile.renameTo(targetfile);
				logOutPopUp.click();
				//Alert alert=driver.switchTo().alert();
				//alert.accept();
			}
			
			public void HcpInfoOnOredrSamplePage() {
				
				boolean HcpInfo=driver.findElement(By.cssSelector("div.x-has-icon.x-has-text div.x-text-el")).isDisplayed();
				Assert.assertTrue(HcpInfo, "The element is not displayed on Order Sample Page");
				String ReadHcpInfo=driver.findElement(By.cssSelector("div.x-has-icon.x-has-text div.x-text-el")).getText();
				System.out.println("HCP detail :" +ReadHcpInfo);
				
				
			}
}
				
			
			
				
				
				   	
			
				
			
				 
			
			
			
		



