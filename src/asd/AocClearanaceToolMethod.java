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

public class AocClearanaceToolMethod extends BasePage {

	public AocClearanaceToolMethod(WebDriver driver) {
		super(driver);
		
	}
	
	//This method will click open the side menu panel and click on AOC to open.
  public void OpenAocFromTheSidPanel() throws InterruptedException {
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		  WebElement MenuPanel=driver.findElement(By.cssSelector("button.x-button-el[data-componentid='ext-synbutton-2']"));
		  MenuPanel.click();
		  WebElement AOC=driver.findElement(By.cssSelector("div.x-layout-vbox-item.x-flexed div.x-body-el.x-menu-body-el>div:nth-of-type(5)"));
		  AOC.click();
		  TakesScreenshot ts=(TakesScreenshot)driver;
			File sourcefile=ts.getScreenshotAs(OutputType.FILE);
			File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\OpenAocFromTheSidPanel.png");
			sourcefile.renameTo(targetfile);
  }
		  
	
	
  public void ClickOnReportAnIssue() throws InterruptedException {
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  WebElement rpt=driver.findElement(By.xpath("//button[contains(@data-componentid,'ext-synbutton-7')]"));
	  Thread.sleep(3000);
	  Actions act= new Actions(driver);
	  act.moveToElement(rpt, 25, 0).click().build().perform();
	  TakesScreenshot ts=(TakesScreenshot)driver;
		File sourcefile=ts.getScreenshotAs(OutputType.FILE);
		File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\ClickOnReportAnIssue.png");
		sourcefile.renameTo(targetfile);
  }
  
  public void ReadMsgOnReportAnIssuePopUp() {
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  List<WebElement>Popups=driver.findElements(By.cssSelector(".x-managed-borders.x-layout-fit-item div.x-component-body-el.x-layout-fit.x-noborder-rl"));
	  for(WebElement popup: Popups) {
		 if(popup.isDisplayed()) {
				 System.out.println(popup.getText());
		 } 
		 else{
			 System.out.println("Message is not dispalying"); 
			 }
	  
            TakesScreenshot ts=(TakesScreenshot)driver;
			File sourcefile=ts.getScreenshotAs(OutputType.FILE);
			File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\ReportAnIssuePopUpMsg.png");
			sourcefile.renameTo(targetfile);
  }
  
  }
	  
  
  public void ClickOnMsgCancelBt() throws InterruptedException {
	  WebElement Cancel=driver.findElement(By.cssSelector(".x-container-transtoolbar-body-el.x-component-transtoolbar-body-el div.x-component-buttongrayborder"));
	  Thread.sleep(3000);
	  Actions act= new Actions(driver);
	  act.moveToElement(Cancel, 25, 0).click().build().perform();
	  TakesScreenshot ts=(TakesScreenshot)driver;
		File sourcefile=ts.getScreenshotAs(OutputType.FILE);
		File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\ClickOnMsgCancelBt.png");
		sourcefile.renameTo(targetfile);
  }
  
  public void ClickOnMsgContinueBt() throws InterruptedException {
	  WebElement Continue=driver.findElement(By.cssSelector(".x-pack-end div.x-component-buttondarkblue"));
	  Thread.sleep(3000);
	  Actions act= new Actions(driver);
	  act.moveToElement(Continue, 20, 0).click().build().perform();
	  TakesScreenshot ts=(TakesScreenshot)driver;
		File sourcefile=ts.getScreenshotAs(OutputType.FILE);
		File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\ClickOnMsgContinueBt.png");
		sourcefile.renameTo(targetfile);
  }
  
  public void ExpectedAocPageTile() {
	  driver.findElement(By.xpath("//div[contains(@data-title,'ACKNOWLEDGEMENT OF CONTENTS')]"));
	  TakesScreenshot ts=(TakesScreenshot)driver;
		File sourcefile=ts.getScreenshotAs(OutputType.FILE);
		File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\ExpectedAocPageTile.png");
		sourcefile.renameTo(targetfile);
  }
  
  public void ClickYesAllItemRecived() {
	 WebElement yes= driver.findElement(By.xpath("//input[contains(@data-componentid,'ext-radio-1')]"));
	 JavascriptExecutor js=(JavascriptExecutor)driver;
	 js.executeScript("arguments[0].click()", yes);
	 TakesScreenshot ts=(TakesScreenshot)driver;
		File sourcefile=ts.getScreenshotAs(OutputType.FILE);
		File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\ClickYesAllItemRecived.png");
		sourcefile.renameTo(targetfile);
  }
  
  public void ClickNoDidNotReciveAllItem() throws InterruptedException {
		 WebElement yes= driver.findElement(By.xpath("//input[contains(@data-componentid,'ext-radio-2')]"));
		 Thread.sleep(1000);
			Actions act= new Actions(driver);
			act.click(yes).build().perform();
		 //JavascriptExecutor js=(JavascriptExecutor)driver;
		 //js.executeScript("arguments[0].click()", yes);
		 TakesScreenshot ts=(TakesScreenshot)driver;
			File sourcefile=ts.getScreenshotAs(OutputType.FILE);
			File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\DidNotRecive.png");
			sourcefile.renameTo(targetfile);
	  }
  
  public void SinatureOnSignPad() throws InterruptedException {
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  WebElement sign=driver.findElement(By.xpath("//canvas[contains(@class,'signature-pad')]"));
	  Thread.sleep(1000);
		Actions act= new Actions(driver);
		act.moveToElement(sign, 17, 25).clickAndHold().moveByOffset(15, -55)
		.moveByOffset(-78, 15).moveByOffset(10, 15).release().build().perform();
		TakesScreenshot ts=(TakesScreenshot)driver;
		File sourcefile=ts.getScreenshotAs(OutputType.FILE);
		File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\SignaturePad.png");
		sourcefile.renameTo(targetfile);
		
  }
  
  public void SinatureAccept() throws InterruptedException {
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  WebElement accept=driver.findElement(By.cssSelector(".x-button-outlined-base:not(.x-disabled)"));
	  accept.click();
	  TakesScreenshot ts=(TakesScreenshot)driver;
		File sourcefile=ts.getScreenshotAs(OutputType.FILE);
		File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\SignatureAccept.png");
		sourcefile.renameTo(targetfile);
}
  
  public void SinatureClear() throws InterruptedException {
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  WebElement clear=driver.findElement(By.cssSelector(".x-button-outlined-gray:not(.x-disabled)"));
	  clear.click();
	  TakesScreenshot ts=(TakesScreenshot)driver;
		File sourcefile=ts.getScreenshotAs(OutputType.FILE);
		File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\SignatureClear.png");
		sourcefile.renameTo(targetfile);
}
  
  public void UpdateQty() throws InterruptedException {
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  WebElement Update=driver.findElement(By.cssSelector("button[data-tabindex-value='none']"));
	  Thread.sleep(1000);
		Actions act= new Actions(driver);
		act.click(Update).build().perform();
	  TakesScreenshot ts=(TakesScreenshot)driver;
		File sourcefile=ts.getScreenshotAs(OutputType.FILE);
		File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\UpdateQty.png");
		sourcefile.renameTo(targetfile);
  }
  
  public void UpdateQtyOnProductReceived(int Qty) {
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  driver.findElement(By.xpath("//input[contains(@inputmode,'numeric')]")).clear();
	  driver.findElement(By.xpath("//input[contains(@inputmode,'numeric')]")).sendKeys(String.valueOf(Qty));
	  driver.findElement(By.cssSelector("div.x-button-action.x-component-action")).click();
	  TakesScreenshot ts=(TakesScreenshot)driver;
		File sourcefile=ts.getScreenshotAs(OutputType.FILE);
		File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\UpdateQtyOnProductReceived.png");
		sourcefile.renameTo(targetfile);
  }
  
  public void EnrollmentContinueBt() throws InterruptedException {
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  driver.findElement(By.xpath("//button[@data-componentid='ext-button-1']")).click();
	  TakesScreenshot ts=(TakesScreenshot)driver;
		File sourcefile=ts.getScreenshotAs(OutputType.FILE);
		File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\EnrollmentContinue.png");
		sourcefile.renameTo(targetfile);
  }
  
  public void SaveAndNext() throws InterruptedException {
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  WebElement save=driver.findElement(By.xpath("//button[contains(@data-componentid,'ext-button-134')]"));
	  Thread.sleep(3000);
	  Actions act= new Actions(driver);
	  act.click(save).build().perform();
	  TakesScreenshot ts=(TakesScreenshot)driver;
		File sourcefile=ts.getScreenshotAs(OutputType.FILE);
		File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\SaveAndNext.png");
		sourcefile.renameTo(targetfile);
  }
  
  public void Skip() throws InterruptedException {
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  WebElement skip=driver.findElement(By.cssSelector(".x-component-buttongrayborder:not(.x-hidden.x-hidden-display)>div:nth-of-type(1)"));
	  Thread.sleep(3000);
	  Actions act= new Actions(driver);
	  act.click(skip).build().perform();
	  TakesScreenshot ts=(TakesScreenshot)driver;
		File sourcefile=ts.getScreenshotAs(OutputType.FILE);
		File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\skip.png");
		sourcefile.renameTo(targetfile);
  }
  
  public void SelectReasonDropDown(String DropDownValue) {
	  driver.findElement(By.xpath("//div[contains(@data-componentid,'ext-expandtrigger-1')]")).click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  List<WebElement>dropDowns=driver.findElements(By.cssSelector("div.x-listitem.x-component.x-boundlistitem.x-layout-auto-item"));
	  for(WebElement dropDown:dropDowns) {
		  if(dropDown.getText().equalsIgnoreCase(DropDownValue)) {
			  dropDown.click();
			  break;
		  }
		  TakesScreenshot ts=(TakesScreenshot)driver;
			File sourcefile=ts.getScreenshotAs(OutputType.FILE);
			File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\SelectReasonDropDown.png");
			sourcefile.renameTo(targetfile);
		  }
	  }
  public void CloseDropDown() {
	  driver.findElement(By.xpath("//div[contains(@data-title,'Incident Report')]")).click();
  }
  
  public void AddCommentOnIncidentReport(String AddComment) throws InterruptedException {
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  WebElement Comment=driver.findElement(By.xpath("//textarea[contains(@name,'comment')]"));
	  Thread.sleep(1000);
	  Actions act= new Actions(driver);
	  act.sendKeys(Comment, AddComment).build().perform();
	  TakesScreenshot ts=(TakesScreenshot)driver;
		File sourcefile=ts.getScreenshotAs(OutputType.FILE);
		File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\AddCommentOnIncidentReport.png");
		sourcefile.renameTo(targetfile);
	 
    }
  
  public void SubmitOnIncidentReport() throws InterruptedException {
	  WebElement submit=driver.findElement(By.cssSelector(".x-container-outer-border-rbl.x-component-outer-border-rbl div.x-component-buttondarkblue"));
	  Thread.sleep(3000);
	  Actions act= new Actions(driver);
	  act.moveToElement(submit, 20, 0).click().build().perform();
	  TakesScreenshot ts=(TakesScreenshot)driver;
		File sourcefile=ts.getScreenshotAs(OutputType.FILE);
		File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\SubmitOnIncidentReport.png");
		sourcefile.renameTo(targetfile);
  }
  
  public void CancelOnIncidentReport() throws InterruptedException {
	  WebElement cancel=driver.findElement(By.cssSelector(".x-container-outer-border-rbl.x-component-outer-border-rbl div.x-component-buttongrayborder"));
	  Thread.sleep(3000);
	  Actions act= new Actions(driver);
	  act.moveToElement(cancel, 20, 0).click().build().perform();
	  TakesScreenshot ts=(TakesScreenshot)driver;
		File sourcefile=ts.getScreenshotAs(OutputType.FILE);
		File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\CancelOnIncidentReport.png");
		sourcefile.renameTo(targetfile);
  }
  
  public void ReadIncidentReport() throws InterruptedException {
	 List<WebElement>irs=driver.findElements(By.cssSelector("div.x-noborder-trbl.x-layout-box-item.x-layout-vbox-item.x-flexed"));
		for(WebElement ir:irs ) {
			System.out.println(ir.getText());
			TakesScreenshot ts=(TakesScreenshot)driver;
			File sourcefile=ts.getScreenshotAs(OutputType.FILE);
			File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\ReadIncidentReport.png");
			sourcefile.renameTo(targetfile);
		}
	 }
	 
  public void SampleIQ() {
	  driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://ecosystem.syncrm.com/450/index.html?companyCode=QC23_PK");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("shane.moore");
		driver.findElement(By.id("password")).sendKeys("Imp0ssibl345");
		driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
		driver.findElement(By.id("combo-1022-trigger-picker")).click();
		driver.findElement(By.xpath("//li[contains(@data-recordindex,'0')]")).click();
		driver.findElement(By.cssSelector("div.x-toolbar-footer.x-box-layout-ct a.x-toolbar-item.x-btn-default-small.x-btn-over")).click();
		driver.findElement(By.id("container-1088")).click();
  }
}
  

