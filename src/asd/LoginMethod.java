package asd;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginMethod extends BasePage{
	
	public LoginMethod(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="username")
	WebElement logInUserName;
	@FindBy(id="password")
	WebElement logInPassword;
	@FindBy(css="button[type=\"submit\"]")
	WebElement logInSubmit;
	
	
	public void enterUserName(String usr)
	{
		logInUserName.sendKeys(usr);
	}
	
	public void enterPassword(String pws)
	{
		logInPassword.sendKeys(pws);
	}
	
	public void clickOnLogin()
	{
		logInSubmit.click();
		TakesScreenshot ts=(TakesScreenshot)driver;
		File sourcefile=ts.getScreenshotAs(OutputType.FILE);
		File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\ReadIncidentReport.png");
		sourcefile.renameTo(targetfile);
		
	}
	public String HomePageTitleIsPresent() {
		
		String title=driver.findElement(By.cssSelector("div.x-component.x-title.x-floating")).getText();
		
	    return title;
	    }
}
