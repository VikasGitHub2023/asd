package asd;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

public class SIQ_Cats_Console_Regression {
  
	public WebDriver driver;
	Wait <WebDriver> wait;
   
	@Test(priority=1)
	public void RecordCountOnDTPtManager() throws InterruptedException {
		SampleIQ_Method siq=new SampleIQ_Method(driver);
		siq.OpenSampleIQ();
		siq.DTPManager();
		//siq.AOCimportQueueTab();
		//siq.ImportQueueTab();
		siq.ShipmentManagerTab();
		//siq.datesection("YTD");
		//siq.SelectDTPManagerTab("AOC Queue");
		siq.datesection("YTD");
		//siq.DTPManagerDate_Range("Last Month");
		//siq.MTDdatePicker();
		Thread.sleep(3000);
		siq.ApplyOnFilter("apply");
		siq.datesection("QTD");
		siq.ApplyOnFilter("apply");
		Thread.sleep(3000);
		siq.CountRecords("record");
		//siq.ResetOnFilter("reset");
	}
  
	//@Test(priority=2)
	public void RecordCountOnDTPManagerReset() throws InterruptedException {
		SampleIQ_Method siq=new SampleIQ_Method(driver);
		siq.OpenSampleIQ();
		siq.DTPManager();
		//siq.AOCimportQueueTab();
		//siq.ImportQueueTab();
		siq.ShipmentManagerTab();
		//siq.datesection("YTD");
		//siq.SelectDTPManagerTab("AOC Queue");
		siq.datesection("YTD");
		//siq.DTPManagerDate_Range("Last Month");
		//siq.MTDdatePicker();
		Thread.sleep(3000);
		siq.ApplyOnFilter("reset");
	}
}
