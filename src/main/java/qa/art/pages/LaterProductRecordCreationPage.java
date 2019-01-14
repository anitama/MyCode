


package qa.art.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import qa.art.Base.BaseClass;

public class LaterProductRecordCreationPage extends BaseClass
{
	@FindBy(xpath="//select[@name='scode']")
	WebElement template;
	
	/*@FindBy(xpath="//input[@name='materialCode']")
	WebElement materialcode;*/
	
	@FindBy(xpath="//input[@name='snick']")
	WebElement productnickname;
	
	@FindBy(xpath="//input[@value='Continue to Create System Manager/Session Manager Product Record(s)']")
	WebElement continuebtn;

	
	public LaterProductRecordCreationPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void templateCode(String temp)
	{
		Select sel=new Select(template);
		sel.selectByVisibleText(temp);
		
		
	}
	/*public void materialCode(String mtc)
	{
		materialcode.sendKeys(mtc);
		
	}*/
	public void productNick(String pnick)
	{
		productnickname.sendKeys(pnick);
		
	}
	public void continueBtn()
	{
		continuebtn.click();
		
	}
	public LaterIBRecordSelection clickOKbtnonNextPage()
	{
		
		try {
			System.out.println("Waiting for Robot class to click ok Button");
			Robot rb = new Robot();
			//rb.delay(60000);
			Thread.sleep(500000);//500000
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
			System.out.println("Ok button Clicked successfully");
			/*WebElement element = driver.findElement(By.xpath("//select[@id='materialCode']"));
			Select sel=new Select(element);
			sel.selectByVisibleText("303516 [R620 SERVER CM SIMPLEX & MID DUPLEX] (P1)");*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Taking more than 5 minute to click ok button..Please Close the browser and rerun the script : "+e.getMessage());
		}
		
		return new LaterIBRecordSelection();
	}
	
	
}

