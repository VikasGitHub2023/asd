package asd;

import java.awt.Desktop.Action;
import java.io.File;
import org.openqa.selenium.WebDriver;
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
import org.openqa.selenium.support.FindBy;

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
		  Thread.sleep(4000);
		    TakesScreenshot ts=(TakesScreenshot)driver;
			File sourcefile=ts.getScreenshotAs(OutputType.FILE);
			File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\OpenAocFromTheSidPanel.png");
			sourcefile.renameTo(targetfile);
  }
		  
	
	
  public void ClickOnReportAnIssue() throws InterruptedException {
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  WebElement rpt=driver.findElement(By.cssSelector(".x-toolbar-transtoolbar-body-el div.x-component-buttondarkblue:not(.x-hidden.x-hidden-display) "));
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
	  Thread.sleep(1000);
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
	  WebElement accept=driver.findElement(By.cssSelector(".x-toolbar-synsignature div.x-button-outlined-base"));
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
	  WebElement Update=driver.findElement(By.xpath("//div[3]/div/div/div[2]/button"));
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
	  WebElement save=driver.findElement(By.cssSelector(".x-toolbar-signaoctoolbar div.x-component-buttondarkblue.x-layout-hbox-item.x-has-text:not(.x-hidden.x-hidden-display)"));
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
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
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
  
  public void uploadFile() {
	  driver.findElement(By.cssSelector("input.x-button-el[type='file']")).sendKeys("C:\\Users\\Vikas.Sadasivan\\Downloads\\Automation Screenshots 12168 (2).docx");
	  TakesScreenshot ts=(TakesScreenshot)driver;
		File sourcefile=ts.getScreenshotAs(OutputType.FILE);
		File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\AddCommentOnIncidentReport.png");
		sourcefile.renameTo(targetfile);
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
	  Thread.sleep(1000);
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
  
 
public void OpenDeliveryDateDropDown() throws InterruptedException {
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  driver.findElement(By.cssSelector(".x-after-input-el div.x-expandtrigger-infodatepickerfield.x-trigger-infodatepickerfield")).click();//Opens date picker//String month, String year, String date 
	  WebElement Currentdate=driver.findElement(By.xpath("//div[@id='ext-dateview-2']//tbody//tr/tr//td//td"));
	  System.out.println(Currentdate);
	  Actions act= new Actions(driver);
 	  Thread.sleep(1000);
 	   act.click(Currentdate).build().perform();
}
	  //String month = "February";
      //String year  = "2025";
      //String date  = "3";	  
	 /* while(true)
	  {
	    String monthyear=driver.findElement(By.xpath("//div[@id=\"ext-dateview-2\"]//table//caption")).getText();
	    System.out.println(monthyear);
	      //WebElement previousmonth=driver.findElement(By.cssSelector(".x-container.x-component.x-navigation-tools.x-floating div.x-tool.x-component.x-left-year-tool.x-paneltool-.x-datepaneltool-"));
		  //WebElement nextmonth=driver.findElement(By.cssSelector(".x-container.x-component.x-navigation-tools.x-floating div.x-tool.x-component.x-right-year-tool.x-paneltool-.x-datepaneltool-"));
		  String arr[]=monthyear.split(""); 
		  String mon=arr[0]; 
		  String yr=arr[1];
	  
		  if(mon.equalsIgnoreCase(month) && yr.equals(year)) {
			  break;
		  }
         else
		  {
		    driver.findElement(By.cssSelector(".x-container.x-component.x-navigation-tools.x-floating div.x-tool.x-component.x-left-year-tool.x-paneltool-.x-datepaneltool-")).click();
		  }
		  }*/
      // List<WebElement> allDates=driver.findElement(By.xpath("//div[@id='ext-dateview-2']//tbody//tr/tr//td//td"));  //For selecting the date
	 
		/*for(WebElement allDate:allDates) {
			String dt=allDate.getText();
			  if(dt.equals(date)) {
		    	 Actions act= new Actions(driver);
		    	 Thread.sleep(1000);
		    	 act.moveToElement(allDate).build().perform();
		    	 break;
		    	 }
		    	 }
		}*/

	
		
  public void SampleIQ() throws InterruptedException {
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
		driver.findElement(By.cssSelector(".x-container.x-main-home-item-container span.x-fa.fa-exclamation-triangle")).click();
		driver.findElement(By.cssSelector("a.x-segmented-button-first span.x-btn-inner.x-btn-inner-default-small")).click();
		driver.findElement(By.cssSelector("a.x-btn-dirtyBtn-small span.x-btn-inner.x-btn-inner-dirtyBtn-small")).click();
		Thread.sleep(1000);
		TakesScreenshot ts=(TakesScreenshot)driver;
		File sourcefile=ts.getScreenshotAs(OutputType.FILE);
		File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\SampleIqComplainceTool.png");
		sourcefile.renameTo(targetfile);
  }
  
  public void SiqComplianceTool() {
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  List<WebElement>compliancelists=driver.findElements(By.cssSelector(".x-panel-body-default.x-noborder-rbl table.x-grid-item"));
	  int totalcompliancelists=compliancelists.size();
	  for(int i=totalcompliancelists-1; i<totalcompliancelists;i++)
	  {
		  compliancelists.get(i).click();
	  }
	  TakesScreenshot ts=(TakesScreenshot)driver;
		File sourcefile=ts.getScreenshotAs(OutputType.FILE);
		File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\ComplianceTool.png");
		sourcefile.renameTo(targetfile);
  }
  
  public void SiqClickOnIncidentFolder() throws InterruptedException {
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  WebElement IncidentFolder=driver.findElement(By.cssSelector("a.x-btn-default-toolbar-small span.x-btn-icon-el-default-toolbar-small.mdi.mdi-briefcase-variant-outline"));
	  IncidentFolder.click();
	  Thread.sleep(1000);
	  //driver.findElement(By.cssSelector(".x-box-scroller-body-horizontal.x-scroller a.x-tab-default-top.x-tab-active")).click();
	  //WebElement attachment=driver.findElement(By.cssSelector(".x-box-scroller-body-horizontal.x-scroller a.x-tab-default-top.x-tab-active"));
	  //Actions act= new Actions(driver);
	  //act.click(attachment).build().perform();
	  TakesScreenshot ts=(TakesScreenshot)driver;
		File sourcefile=ts.getScreenshotAs(OutputType.FILE);
		File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\ClickOnIncidentFolder.png");
		sourcefile.renameTo(targetfile);
	  }
  
  public void SiqClickOnAttachment() {
	  driver.findElement(By.xpath("//span[contains(text(),'Attachment')]")).click();
	  TakesScreenshot ts=(TakesScreenshot)driver;
		File sourcefile=ts.getScreenshotAs(OutputType.FILE);
		File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\SiqClickOnAttachment.png");
		sourcefile.renameTo(targetfile); 
  }
  
  public void SiqClickOnComments() {
	  driver.findElement(By.cssSelector("//span[contains(text(),'Comments')]")).click();
  }
  public void SiqPrintIncidentComments() {
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  List<WebElement>reasons=driver.findElements(By.cssSelector(".x-grid-item.x-grid-item-selected td.x-grid-cell-gridcolumn-1380"));
	  for (WebElement reason:reasons) {
		System.out.println(reason.getText());
		}
	  TakesScreenshot ts=(TakesScreenshot)driver;
		File sourcefile=ts.getScreenshotAs(OutputType.FILE);
		File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\PrintIncidentComments.png");
		sourcefile.renameTo(targetfile); 
  }
 }
  

