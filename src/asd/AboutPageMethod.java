package asd;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AboutPageMethod extends BasePage{
	
		public AboutPageMethod(WebDriver driver) {
			super(driver);
			
			}
		
		
		public void ReadAboutPage()
		{
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			List<WebElement>allElements=driver.findElements(By.cssSelector("div.WordSection1 p.MsoNormal"));
			for(WebElement allElement:allElements){
			        System.out.println(allElement.getText());
			        TakesScreenshot ts=(TakesScreenshot)driver;
					File sourcefile=ts.getScreenshotAs(OutputType.FILE);
					File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\AboutPage.png");
					sourcefile.renameTo(targetfile);
			}
		}
		
		public void CloseAboutPage() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		    WebElement Cancel=driver.findElement(By.cssSelector(".x-noborder-rbl div.x-layout-box-item.x-layout-hbox-item.x-has-text:not(.x-button-action)"));
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click()", Cancel);
		    
			
		}
}
