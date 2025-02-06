package asd;


import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Scanner;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;



public class ProductPageMethod extends BasePage{
	

	public ProductPageMethod(WebDriver driver) {
		super(driver);
		}
	@FindBy(css="button.x-button-el[data-componentid=\"ext-synbutton-2\"]")
	WebElement menuPanel;
	@FindBy(css="div.x-body-el.x-quantityspinner-body-el>div")
	WebElement addbutton;
	Wait<WebDriver> wait;
	BasePage ss=new BasePage(driver);
	
	
	//this method will click on the side menu panel>select Order Sample>add the desired product
	public void SelectProducts(String prod) throws InterruptedException {
		menuPanel.click();
	    WebElement option=driver.findElement(By.cssSelector("div.x-layout-vbox-item.x-flexed div.x-body-el.x-menu-body-el>div:nth-of-type(2)"));
		option.click();
		Thread.sleep(2000);	    
		List<WebElement>products=driver.findElements(By.cssSelector("div.x-innerhtml"));
		      for(WebElement product:products) {
		    	  String SingleProduct=(product.getText());
		    	  System.out.println(SingleProduct);
		    	  //Thread.sleep(2000);
		    	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		    	  if(SingleProduct.equalsIgnoreCase(prod)) {
		    		  Thread.sleep(1000);
		    		  product.click();
		    		  break;
		    	  }
		      }
		    	  TakesScreenshot ts=(TakesScreenshot)driver;
		  		File sourcefile=ts.getScreenshotAs(OutputType.FILE);
		  		File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\SelectProducts.png");
		  		sourcefile.renameTo(targetfile);
		      }
			
	// this method is used to select product from order sample page
	public void SelectProductOnOrderSample(String prod) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		List<WebElement>products=driver.findElements(By.cssSelector("div.x-container-views-browser.x-component-views-browser div.x-prod-name"));
		System.out.print("The following are the list of products in the Order Sample page !");
		      for(WebElement product:products) {
		    	  String SingleProduct=(product.getText());
		    	  System.out.println(SingleProduct);
		    	  //Thread.sleep(2000);
		    	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		    	  if(SingleProduct.equalsIgnoreCase(prod)) {
		    		  Thread.sleep(1000);
		    		  product.click();
		    		  break;
		    	  }
		      }
		      TakesScreenshot ts=(TakesScreenshot)driver;
		  		File sourcefile=ts.getScreenshotAs(OutputType.FILE);
		  		File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\SelectProductOnOrderSample.png");
		  		sourcefile.renameTo(targetfile);
			}
			
	public void ClickMinusButton() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement addbutton=driver.findElement(By.cssSelector("div.x-quantityspinner-body-el.x-container-body-el div.x-component.x-button-spindown"));
		//ss.takeScreenShot();
		addbutton.click();
		TakesScreenshot ts=(TakesScreenshot)driver;
		File sourcefile=ts.getScreenshotAs(OutputType.FILE);
		File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\fullpage1.png");
		sourcefile.renameTo(targetfile);
	    }
	
	
	public void ClickPlusButton() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement addbutton=driver.findElement(By.cssSelector("div.x-quantityspinner-body-el.x-container-body-el div.x-component.x-button-spinup"));
		addbutton.click();
		Thread.sleep(30);
		TakesScreenshot ts=(TakesScreenshot)driver;
		File sourcefile=ts.getScreenshotAs(OutputType.FILE);
		File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\fullpage2.png");
		sourcefile.renameTo(targetfile);
		}
	
	
	public void MultiClickPlusButton(int enternumber) throws InterruptedException {
		
		Scanner sc=new Scanner(System.in);
		int ch=sc.nextInt();
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		switch(ch)
		{
		case 1:
		for(int i=0;i<1;i++) {
			driver.findElement(By.cssSelector("div.x-quantityspinner-body-el.x-container-body-el div.x-component.x-button-spinup")).click();
			break;
		}
		case 2:
			for(int i=1;i<2;i++) {
				driver.findElement(By.cssSelector("div.x-quantityspinner-body-el.x-container-body-el div.x-component.x-button-spinup")).click();
				break;
			}
		case 3:
			for(int i=1;i<3;i++) {
				driver.findElement(By.cssSelector("div.x-quantityspinner-body-el.x-container-body-el div.x-component.x-button-spinup")).click();
				break;
			}
		case 4:
			for(int i=1;i<4;i++) {
				driver.findElement(By.cssSelector("div.x-quantityspinner-body-el.x-container-body-el div.x-component.x-button-spinup")).click();
				break;
			}
		case 5:
			for(int i=1;i<5;i++) {
				driver.findElement(By.cssSelector("div.x-quantityspinner-body-el.x-container-body-el div.x-component.x-button-spinup")).click();
				break;
			}
		case 6:
			for(int i=1;i<6;i++) {
				driver.findElement(By.cssSelector("div.x-quantityspinner-body-el.x-container-body-el div.x-component.x-button-spinup")).click();
				break;
			}
		case 7:
			for(int i=1;i<7;i++) {
				driver.findElement(By.cssSelector("div.x-quantityspinner-body-el.x-container-body-el div.x-component.x-button-spinup")).click();
				break;
			}
		}
		Thread.sleep(30);
		TakesScreenshot ts=(TakesScreenshot)driver;
		File sourcefile=ts.getScreenshotAs(OutputType.FILE);
		File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\fullpage2.png");
		sourcefile.renameTo(targetfile);
		}
	
	public void ClickOnAddToCart() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement addtocart=driver.findElement(By.cssSelector("div.x-component.x-button.x-heighted.x-has-text:not(.x-disabled)"));
		addtocart.click();
		Thread.sleep(30);
		TakesScreenshot ts=(TakesScreenshot)driver;
		File sourcefile=ts.getScreenshotAs(OutputType.FILE);
		File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\fullpage3.png");
		sourcefile.renameTo(targetfile);
	    }
	
	public void ClickOnCheckOut() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement checkout=driver.findElement(By.cssSelector("div.x-button-fullgreen.x-component-fullgreen"));
		checkout.click();
		Thread.sleep(50);
		TakesScreenshot ts=(TakesScreenshot)driver;
		File sourcefile=ts.getScreenshotAs(OutputType.FILE);
		File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\fullpage4.png");
		sourcefile.renameTo(targetfile);
	}
	
	public void ClickOnGoToCart() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement gotocart=driver.findElement(By.cssSelector("div.x-button-outlined-gray"));
		gotocart.click();
		{
		List<WebElement> shoppingCartItems = driver.findElements(By.cssSelector("div.x-prod-sku-name"));
		for(WebElement shoppingcart: shoppingCartItems) {
			System.out.println("Your shoppingcart has :"  +shoppingcart.getText());
		}
		Thread.sleep(50);
		TakesScreenshot ts=(TakesScreenshot)driver;
		File sourcefile=ts.getScreenshotAs(OutputType.FILE);
		File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\fullpage5.png");
		sourcefile.renameTo(targetfile);
		
	}
	}
	
	public void ShoppingCartContent() throws InterruptedException {
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    String expectedPopUp="Item(s) added to cart.";
	    String actualPopUp=driver.findElement(By.cssSelector("div.x-panel-info-body-el.x-container-info-body-el.x-component-info-body-el")).getText();
		List<WebElement> shoppingCartItems = driver.findElements(By.cssSelector("div.x-prod-sku-name"));
		for(WebElement shoppingcart: shoppingCartItems) {
			System.out.println("Your shoppingcart has :"  +shoppingcart.getText());
		    Thread.sleep(1000);
		    Assert.assertEquals(actualPopUp, expectedPopUp);
		    System.out.println("The green popup reads :" + actualPopUp);
			//Alert alert=driver.switchTo().alert();
			//String textOnAlert= alert.getText();
			//System.out.println(textOnAlert);
		    Thread.sleep(30);
		    TakesScreenshot ts=(TakesScreenshot)driver;
			File sourcefile=ts.getScreenshotAs(OutputType.FILE);
			File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\fullpage6.png");
			sourcefile.renameTo(targetfile);
		}
			}
	public void CloseGreenPopUp() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement closegreenpopup=driver.findElement(By.cssSelector("div.x-panel-info-body-el.x-container-info-body-el.x-component-info-body-el div.x-component.x-button.x-has-icon"));
		closegreenpopup.click();
		Thread.sleep(30);
		TakesScreenshot ts=(TakesScreenshot)driver;
		File sourcefile=ts.getScreenshotAs(OutputType.FILE);
		File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\fullpage7.png");
		sourcefile.renameTo(targetfile);
	}
		
		public void ProceedToCheckOut() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			WebElement checkOut=driver.findElement(By.cssSelector("div.x-button-fullgreen.x-component-fullgreen"));
			WebElement signature= driver.findElement(By.cssSelector("div.x-component.x-button.x-icon-align-left.x-arrow-align-right.x-button-outlined-base.x-layout-box-item.x-layout-hbox-item.x-has-text  "));
			//checkOut.click();
			JavascriptExecutor js=(JavascriptExecutor)driver;
		    js.executeScript("arguments[0].click()", checkOut);
		    Thread.sleep(2000);
			js.executeScript("arguments[0].scrollIntoView(true);",signature);
			//js.executeScript("window.scrollBy(0,3000)", "");
			//js.executeScript("window.scrollBy(0,document.body.scrollheight)");
			Thread.sleep(30);
			TakesScreenshot ts=(TakesScreenshot)driver;
			File sourcefile=ts.getScreenshotAs(OutputType.FILE);
			File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\fullpage8.png");
			sourcefile.renameTo(targetfile);
			
		}
		
		public void SignInSignaturePad() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			//JavascriptExecutor js=(JavascriptExecutor)driver;
			WebElement signaturePad= driver.findElement(By.cssSelector("canvas.signature-pad"));
			WebElement accept= driver.findElement(By.cssSelector("div.x-component.x-button.x-icon-align-left.x-arrow-align-right.x-button-outlined-base.x-layout-box-item.x-layout-hbox-item.x-has-text  "));
			//wait.until(d -> signaturePad.isDisplayed());
			//js.executeScript("arguments[0].scrollInView(true);", signature);
			//js.executeScript("window.scrollBy(0,document.body.scrollheight)");
			//js.executeScript("window.scrollBy(0,3000)", "");
			//System.out.println(js.executeScript("return window.pageYoffset;"));
			Thread.sleep(1000);
			Actions act= new Actions(driver);
			act.moveToElement(signaturePad, 17, 25).clickAndHold().moveByOffset(15, -55)
			.moveByOffset(-78, 15).moveByOffset(10, 15).release().build().perform();
			//action.dragAndDropBy(signaturePad, 200, 105).build().perform();
			//sign.perform();
			//js.executeScript("arguments[0].setAttribute()",signaturePad);
			//Thread.sleep(1000);
			//ss.takeScreenShot();
			accept.click();
			//driver.getTitle();
			TakesScreenshot ts=(TakesScreenshot)driver;
			File sourcefile=ts.getScreenshotAs(OutputType.FILE);
			File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\fullpage9.png");
			sourcefile.renameTo(targetfile);
		
		}
		
		public void PlaceOrder() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			WebElement placeOrder=driver.findElement(By.cssSelector("div.x-button-fullgreen.x-component-fullgreen"));
			placeOrder.click();
			//ss.takeScreenShot();
			//JavascriptExecutor js=(JavascriptExecutor)driver;
		    //js.executeScript("arguments[0].click()", placeOrder);
			//String actualTitle=driver.findElement(By.cssSelector("div.x-success")).getText();
			//String expectedTitle="Thank you! Your order has been placed.";
			//Assert.assertEquals(actualTitle, expectedTitle);
		    //System.out.println("The page title reads :" + actualTitle);
			//String PageTitle=driver.getTitle();
			//System.out.println(PageTitle);
			TakesScreenshot ts=(TakesScreenshot)driver;
			File sourcefile=ts.getScreenshotAs(OutputType.FILE);
			File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\fullpage10.png");
			sourcefile.renameTo(targetfile);
			}
		
		public void ClickOnDone() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Thread.sleep(60);
			WebElement done=driver.findElement(By.cssSelector("div.x-button-action.x-component-action.x-layout-box-item.x-layout-hbox-item.x-has-text"));
			done.click();
			//JavascriptExecutor js=(JavascriptExecutor)driver;
		    //js.executeScript("arguments[0].click()", done);
			//TakesScreenshot ts=(TakesScreenshot)driver;
			//File sourcefile=ts.getScreenshotAs(OutputType.FILE);
			//File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\fullpage.png");
			//sourcefile.renameTo(targetfile);
			TakesScreenshot ts=(TakesScreenshot)driver;
			File sourcefile=ts.getScreenshotAs(OutputType.FILE);
			File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\fullpage11.png");
			sourcefile.renameTo(targetfile);
		}
	}

			
		
	
	

