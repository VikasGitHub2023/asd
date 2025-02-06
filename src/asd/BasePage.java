package asd;

import java.io.File;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;


public class BasePage {

	WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver=driver;
	    PageFactory.initElements(driver,this);
	}
	
	public void takeScreenShot() {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File sourcefile=ts.getScreenshotAs(OutputType.FILE);
		File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\"+generateTimeStamp()+".png");
		sourcefile.renameTo(targetfile);
		}
	
	public String generateTimeStamp() {
		  Date date= new Date();
		return date.toString().replace("", "").replace(":", "_");
	}
	
	
}
