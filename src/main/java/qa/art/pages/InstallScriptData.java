package qa.art.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import qa.art.Base.BaseClass;

public class InstallScriptData extends BaseClass
{

	@FindBy(xpath="//td//input[@value='6.3.8']")
	WebElement relNum;
	
	@FindBy(xpath="//td//input[@value='R6.3.8']")
	WebElement spRelNum;
	
	@FindBy(xpath="//select[@name='SAOfferTypes']")
	WebElement suppAdOffer;
	
	@FindBy(xpath="//input[@name='aorig'and @value='Y']")
	WebElement AlarmOrg;
	
	@FindBy(xpath="//input[@name='ordno']")
	WebElement ordernum;
	
	@FindBy(xpath="//input[@value='Continue SP Product Install Script']")
	WebElement ContinueSP;
	
	public InstallScriptData()
	{	
		PageFactory.initElements(driver, this);
	}
	
	
	public void selRelNum()
	{
		relNum.click();
	}
	public void selSPRelNum()
	{
		spRelNum.click();
		
	}
	public void supportAdOffer()
	{
		
		Select sel = new Select(suppAdOffer);
		sel.selectByVisibleText("OTHER");
		AlarmOrg.click();
	}
	public void OrderNum(String orderNum)
	{
		ordernum.sendKeys(orderNum);
		
	}
	
	public InstallScriptResult ContinueSPbtnClick()
	{
		ContinueSP.click();
		Alert al= driver.switchTo().alert();
		al.accept();
		return new InstallScriptResult();
	}
	

	
}
