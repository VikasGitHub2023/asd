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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SampleIQ_Method extends BasePage{

	public SampleIQ_Method(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	 public void OpenSampleIQ() throws InterruptedException {
		    driver=new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://ecosystemqc.syncrm.com/460/index.html?companyCode=FrancescaPiper_PK");
			driver.manage().window().maximize();
			driver.findElement(By.id("username")).sendKeys("shane.moore");
			driver.findElement(By.id("password")).sendKeys("Imp0ssibl345");
			driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
			driver.findElement(By.id("combo-1022-trigger-picker")).click();
			driver.findElement(By.xpath("//li[contains(@data-recordindex,'0')]")).click();
			//driver.findElement(By.cssSelector("div.x-toolbar-footer.x-box-layout-ct a.x-toolbar-item.x-btn-default-small.x-btn-over")).click();
			driver.findElement(By.cssSelector("span[id='button-1032-btnEl']")).click();
			
			TakesScreenshot ts=(TakesScreenshot)driver;
			File sourcefile=ts.getScreenshotAs(OutputType.FILE);
			File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\SampleIqComplainceTool.png");
			sourcefile.renameTo(targetfile);
	  }
	 
	 public void ConatctManager() throws InterruptedException {
	    	driver.findElement(By.cssSelector(".x-container.x-main-home-item-container span.synos.synos-contacts")).click();//clicks on ConatctManager
			//driver.findElement(By.cssSelector("a.x-segmented-button-first span.x-btn-inner.x-btn-inner-default-small")).click();
			//driver.findElement(By.cssSelector("a.x-btn-dirtyBtn-small span.x-btn-inner.x-btn-inner-dirtyBtn-small")).click();
			Thread.sleep(1000);
			TakesScreenshot ts=(TakesScreenshot)driver;
			File sourcefile=ts.getScreenshotAs(OutputType.FILE);
			File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\SampleIqComplainceTool.png");
			sourcefile.renameTo(targetfile);
	    }
	 
	 public void DTPManager() throws InterruptedException {
	    	driver.findElement(By.cssSelector(".x-container.x-main-home-item-container span.synos.synos-transfer_request")).click(); //clicks on DTPManager
	 }
	 
	 public void DTPManagerDate_Range(String DateRange) throws InterruptedException {
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    	driver.findElement(By.xpath("//span[contains(text(),'DateRange:')]")).click();//clicks on DTPManager
			//driver.findElement(By.xpath("//span[contains(text(),'QTD')]")).click();//click on date dropdown
			List<WebElement>DtRanges=driver.findElements(By.xpath("//div[@class='x-boundlist x-boundlist-floating x-layer x-boundlist-default x-border-box']//div//ul//li"));
			for(WebElement DtRange: DtRanges) {
				String dtr=DtRange.getText();
						System.out.println(dtr);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				if(dtr.equalsIgnoreCase(DateRange))	{
					DtRange.click();
					break;
			
			}
			}
			Thread.sleep(1000);
			TakesScreenshot ts=(TakesScreenshot)driver;
			File sourcefile=ts.getScreenshotAs(OutputType.FILE);
			File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\SampleIqComplainceTool.png");
			sourcefile.renameTo(targetfile);
	    }
	 
	 public void SelectDTPManagerTab(String TabName) throws InterruptedException {
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));//To select tabs inside DTP Mgr
		 //List<WebElement>Tabs=driver.findElements(By.cssSelector(".x-box-scroller-body-horizontal.x-scroller a.x-tab-nav.x-top.x-tab-top.x-tab-nav-top"));
		 //List<WebElement>Tabs=driver.findElements(By.xpath("//span[@data-ref='btnInnerEl'] [@class='x-tab-inner x-tab-inner-nav']")); 
		 List<WebElement>Tabs=driver.findElements(By.tagName("br"));
		 {
			for(WebElement Tab: Tabs) {
				String tb=Tab.getText();
						System.out.println(tb);
			  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				if(tb.equalsIgnoreCase(TabName))	
				{
					Actions act= new Actions(driver);
					act.click(Tab).build().perform();
					break;
			    }
			}
			}
			Thread.sleep(1000);
			TakesScreenshot ts=(TakesScreenshot)driver;
			File sourcefile=ts.getScreenshotAs(OutputType.FILE);
			File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\SampleIqComplainceTool.png");
			sourcefile.renameTo(targetfile);
	    }
	 
	 public void daterange() throws InterruptedException {
			List<WebElement>drs=driver.findElements(By.xpath("//span[contains(text(),'DateRange:')]"));//To select tabs inside DTP Mgr
			{
			for(WebElement dr: drs) {
				String tb=dr.getText();
						System.out.println(tb);
			}
			}
	 }
	 
	 public void datesection(String PickOneFromMTD_QTD_YDT) throws InterruptedException {
			List<WebElement>drs=driver.findElements(By.xpath("//div[2]/a/span/span/span[2]"));//To select tabs inside DTP Mgr
			for(WebElement dr: drs) {
				String tb=dr.getText();
						System.out.println(tb);
							if(tb.equalsIgnoreCase(PickOneFromMTD_QTD_YDT)) {
								Thread.sleep(1000);
								dr.click();
								break;
						}
						}
			}
	 
	 
	 public void OrderManagerTab() throws InterruptedException //clicks open OrderManagerTab
	 {
		 driver.findElement(By.xpath("//div[@class='x-tab-bar-body x-tab-bar-body-nav  x-box-layout-ct']//a[1]")).click();
		 Thread.sleep(1000);
			TakesScreenshot ts=(TakesScreenshot)driver;
			File sourcefile=ts.getScreenshotAs(OutputType.FILE);
			File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\YTDdatePicker.png");
			sourcefile.renameTo(targetfile);
	 }
	 
	 public void ShipmentManagerTab() throws InterruptedException //clicks open ShipmentManager Tab
	 {
		 driver.findElement(By.xpath("//div[@class='x-tab-bar-body x-tab-bar-body-nav  x-box-layout-ct']//a[2]")).click();
		 Thread.sleep(1000);
			TakesScreenshot ts=(TakesScreenshot)driver;
			File sourcefile=ts.getScreenshotAs(OutputType.FILE);
			File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\YTDdatePicker.png");
			sourcefile.renameTo(targetfile);
	 }
	 
	 public void ExceptionQueueTab() throws InterruptedException //clicks open ExceptionQueueTab
	 {
		 driver.findElement(By.xpath("//div[@class='x-tab-bar-body x-tab-bar-body-nav  x-box-layout-ct']//a[3]")).click();
		 Thread.sleep(1000);
			TakesScreenshot ts=(TakesScreenshot)driver;
			File sourcefile=ts.getScreenshotAs(OutputType.FILE);
			File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\YTDdatePicker.png");
			sourcefile.renameTo(targetfile);
	 }
	 
	 public void ImportQueueTab() throws InterruptedException //clicks open ImportQueue Tab
	 {
		 driver.findElement(By.xpath("//div[@class='x-tab-bar-body x-tab-bar-body-nav  x-box-layout-ct']//a[4]")).click();
		 Thread.sleep(1000);
			TakesScreenshot ts=(TakesScreenshot)driver;
			File sourcefile=ts.getScreenshotAs(OutputType.FILE);
			File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\YTDdatePicker.png");
			sourcefile.renameTo(targetfile);
	 }
	 
	 public void AOCQueueTab() throws InterruptedException //clicks open AOCQueueTab
	 {
		 driver.findElement(By.xpath("//div[@class='x-tab-bar-body x-tab-bar-body-nav  x-box-layout-ct']//a[5]")).click();
		 Thread.sleep(1000);
			TakesScreenshot ts=(TakesScreenshot)driver;
			File sourcefile=ts.getScreenshotAs(OutputType.FILE);
			File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\YTDdatePicker.png");
			sourcefile.renameTo(targetfile);
	 }
	 
	 public void AOCimportQueueTab() throws InterruptedException //clicks open AOCimportQueue Tab
	 {
		 driver.findElement(By.xpath("//div[@class='x-tab-bar-body x-tab-bar-body-nav  x-box-layout-ct']//a[6]")).click();
		 Thread.sleep(1000);
			TakesScreenshot ts=(TakesScreenshot)driver;
			File sourcefile=ts.getScreenshotAs(OutputType.FILE);
			File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\YTDdatePicker.png");
			sourcefile.renameTo(targetfile);
	 }
	 
	 public void HcpExclusionTab() throws InterruptedException //clicks open  HcpExclusionTab Tab
	 {
		 driver.findElement(By.xpath("//div[@class='x-tab-bar-body x-tab-bar-body-nav  x-box-layout-ct']//a[7]")).click();
		 Thread.sleep(1000);
			TakesScreenshot ts=(TakesScreenshot)driver;
			File sourcefile=ts.getScreenshotAs(OutputType.FILE);
			File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\YTDdatePicker.png");
			sourcefile.renameTo(targetfile);
	 }
	 
	 public void ApplyOnFilter(String Enter_Apply) throws InterruptedException {
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		  List <WebElement> clk=driver.findElements(By.xpath("//div/div/a[2]/span/span/span[2]"));
		  for(WebElement ck: clk) {
				String apply=ck.getText();
						System.out.println(apply);
							if(apply.equalsIgnoreCase(Enter_Apply)) {
								Thread.sleep(1000);
								ck.click();
								break;
								}
						}
		    Thread.sleep(1000);
			TakesScreenshot ts=(TakesScreenshot)driver;
			File sourcefile=ts.getScreenshotAs(OutputType.FILE);
			File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\ApplyOnFilter.png");
			sourcefile.renameTo(targetfile);
	 } 
	 
	 public void ResetOnFilter(String Enter_Reset) throws InterruptedException {
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		  List <WebElement> reset=driver.findElements(By.xpath("//div/div/a[1]/span/span/span[2]"));
		  for(WebElement rst: reset) {
				String rt=rst.getText();
						System.out.println(rt);
							if(rt.equalsIgnoreCase(Enter_Reset)) {
								Thread.sleep(1000);
								rst.click();
								break;
								}
						}
		    Thread.sleep(1000);
			TakesScreenshot ts=(TakesScreenshot)driver;
			File sourcefile=ts.getScreenshotAs(OutputType.FILE);
			File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\ApplyOnFilter.png");
			sourcefile.renameTo(targetfile);
	 } 
	 
	 public void CountRecords(String Enter_Record) throws InterruptedException {
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		  List <WebElement> records=driver.findElements(By.xpath("//div[4]/div/div[2]/div/div/div"));
		  for(WebElement record: records) {
				String rd=record.getText();
						System.out.println(rd);
							if(rd.equalsIgnoreCase(Enter_Record)) {
								Thread.sleep(1000);
								record.click();
								break;
								}
						}
		    Thread.sleep(1000);
			TakesScreenshot ts=(TakesScreenshot)driver;
			File sourcefile=ts.getScreenshotAs(OutputType.FILE);
			File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\ApplyOnFilter.png");
			sourcefile.renameTo(targetfile);
	 } 
	  
	 public void ResetOnFilter() throws InterruptedException {
		 driver.findElement(By.xpath("//span[contains(text(),'Reset')]")).click();
		 Thread.sleep(1000);
			TakesScreenshot ts=(TakesScreenshot)driver;
			File sourcefile=ts.getScreenshotAs(OutputType.FILE);
			File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\ResetOnFilter.png");
			sourcefile.renameTo(targetfile);
	 } 
	 
	 public void ComplainceTool() throws InterruptedException {
    	driver.findElement(By.cssSelector(".x-container.x-main-home-item-container span.x-fa.fa-exclamation-triangle")).click();//clicks on Compliance tool
		driver.findElement(By.cssSelector("a.x-segmented-button-first span.x-btn-inner.x-btn-inner-default-small")).click();//clicks on the latest incident
		driver.findElement(By.cssSelector("a.x-btn-dirtyBtn-small span.x-btn-inner.x-btn-inner-dirtyBtn-small")).click();//clicks on Incident Folder
		Thread.sleep(1000);
		TakesScreenshot ts=(TakesScreenshot)driver;
		File sourcefile=ts.getScreenshotAs(OutputType.FILE);
		File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\SampleIqComplainceTool.png");
		sourcefile.renameTo(targetfile);
    }
}
