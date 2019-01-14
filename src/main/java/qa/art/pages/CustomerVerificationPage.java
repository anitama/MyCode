package qa.art.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.art.Base.BaseClass;

public class CustomerVerificationPage extends BaseClass
{
	@FindBy(xpath="//tr[@valign='middle']//descendant::td//input[@value='O']")
	WebElement custType;
	
	@FindBy(xpath="//input[@value='Continue SP Product Install Script']")
	WebElement continueSPBtn;
	
	
	public CustomerVerificationPage()
	{
		
		PageFactory.initElements(driver, this);
	}
	
	public void clickCustomerType()
	{
		custType.click();
		
	}
	
	public LaterProductListPage clickContinueSPbtn()
	{
		continueSPBtn.click();
		return new LaterProductListPage();
		
		
	}
	

}
