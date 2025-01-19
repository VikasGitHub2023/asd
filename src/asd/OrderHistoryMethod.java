package asd;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

public class OrderHistoryMethod extends BasePage{
	public OrderHistoryMethod(WebDriver driver) {
		super(driver);
}
	
	Wait<WebDriver> wait;
	public void OrderHistoryAllOrdersDropDown() {
		driver.findElement(By.cssSelector("div.x-oh-filter-status")).click();
	}
	
	
	public void OrderHistoryOrderDateDropDown() {
		driver.findElement(By.cssSelector("div.x-pickerfield:not(.x-oh-filter-status)")).click();
	}
	
	public void OrderHistoryAllOrdersDropDownMenu(String ord) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		List<WebElement>allorders=driver.findElements(By.cssSelector("div.x-boundlistitem.x-layout-auto-item>div:nth-of-type(n)"));
		Thread.sleep(20);
		for(WebElement allorder:allorders) {
			if(allorder.getText().equalsIgnoreCase(ord)) {
				allorder.click();
				break;
			}
		}
	}
	
		public void OrderHistoryOrderDateMenu(String Dt) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		List<WebElement>dates=driver.findElements(By.cssSelector("div.x-boundlistitem.x-layout-auto-item>div:nth-of-type(n)"));
		for(WebElement date:dates) {
			if(date.getText().equalsIgnoreCase(Dt)) {
				date.click();
				break;
			}
		}
	}
		
		public void ReadOrderHistory() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			System.out.print("The following are the details on the Order History Page: ");
			List<WebElement>orderhistories=driver.findElements(By.cssSelector("div.x-body-el.x-dataview-body-el.x-scroller.x-nativescroller.x-overflow-x-auto div.x-layout-auto-item.x-syn-transaction-cls"));
			for(WebElement orderhistory: orderhistories) {
				System.out.println(orderhistory.getText());
		        TakesScreenshot ts=(TakesScreenshot)driver;
				File sourcefile=ts.getScreenshotAs(OutputType.FILE);
				File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\orderHistory.png");
				sourcefile.renameTo(targetfile);
			}
		}
}	
		
		
     

