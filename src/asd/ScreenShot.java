package asd;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot extends BasePage {

	public ScreenShot(WebDriver driver) {
		super(driver);
		}
	
	

	public void takeScreenShot() {
	TakesScreenshot ts=(TakesScreenshot)driver;
	File sourcefile=ts.getScreenshotAs(OutputType.FILE);
	File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\fullpage.png");
	sourcefile.renameTo(targetfile);
	}



	
}
