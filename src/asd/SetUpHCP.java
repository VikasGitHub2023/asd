package asd;


import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class SetUpHCP extends BasePage {
	
	public SetUpHCP(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void OpenHCP() throws InterruptedException{
    driver=new ChromeDriver();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	driver.get("https://ecosystemqc.syncrm.com/460/index.html?companyCode=FrancescaPiper_PK");
	driver.manage().window().maximize();
	driver.findElement(By.id("username")).sendKeys("anna.christie@synergistix.com");
	driver.findElement(By.id("password")).sendKeys("Imp0ssibl345");
	driver.findElement(By.cssSelector("button[type='submit']")).click();
	}
}
