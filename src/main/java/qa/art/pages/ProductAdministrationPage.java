package qa.art.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import qa.art.Base.BaseClass;
import qa.art.UtilClass.Util;

public class ProductAdministrationPage extends BaseClass 
{

	@FindBy(xpath="//input[@name='sidOpt']")
	WebElement selectSystemId;
	
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement startSPProductAdmin;
	
	@FindBy(xpath="//tr[@valign='middle']//descendant::td/input[@type='text']")
	WebElement Fltext;
	
	@FindBy(xpath="//select[@id='pdtyp']")
	WebElement productype;
	
	public ProductAdministrationPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterFL(String flnum)
	{
		Fltext.sendKeys(flnum);
		
	}
	
	public void selectProductType(String pdtype)
	{
		Select sel= new Select(productype);
		sel.selectByVisibleText(pdtype);
		
	}
	
	public void SelectSystemIDRadioBtn()
	{
		selectSystemId.click();
		
	}
	
	public CustomerVerificationPage startSPProductAdmin()
	{
		startSPProductAdmin.click();
		return new CustomerVerificationPage();
		
	}
	
	
	
	
}
