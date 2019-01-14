package qa.art.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.art.Base.BaseClass;

public class UserMenuPage extends BaseClass
{
	
	@FindBy(xpath="//a[contains(text(),'Register a mult-SE(Avaya Aura) product')]")
	WebElement registerProduct;
	
	
	@FindBy(xpath="//input[@name='SALRegWarn']")
	WebElement checkbox;
	
	@FindBy(xpath="//input[@id='continueSPReg']")
	WebElement continuebtn;
	
	
	public UserMenuPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickRegisterProductLink()
	{
		registerProduct.click();
		
	}
	
	public void clickCheckbox()
	{
		checkbox.click();
		
	}
	public ProductAdministrationPage clickContinuebtn()
	{
		continuebtn.click();
		return new ProductAdministrationPage();
		
	}

}
