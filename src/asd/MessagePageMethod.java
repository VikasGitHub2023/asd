package asd;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MessagePageMethod extends BasePage{

	public MessagePageMethod(WebDriver driver) {
		super(driver);
		}
    public void CloseMessagePopUp() {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    	driver.findElement(By.cssSelector(".x-layout-box-item.x-layout-hbox-item.x-end")).click();
    }
    
    public void ReadMessagePopup() {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    	List<WebElement>Messages=driver.findElements(By.cssSelector(".x-highpriorityalertmessagesreader"));
    	for(WebElement Message:Messages) {
    		System.out.println(Message.getText());
    	}
    }
    
    public void ClickOnUnreadMessages() {
    	driver.findElement(By.cssSelector(".x-component-alertmessagetoolbar-body-el>div:nth-of-type(1)")).click();
    }
    
    public void ClickOnHighPriorityMessages() {
    	driver.findElement(By.cssSelector(".x-component-alertmessagetoolbar-body-el>div:nth-of-type(2)")).click();
    }
}
