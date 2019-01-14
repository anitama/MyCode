package qa.art.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.art.Base.BaseClass;

public class LaterProductListPage extends BaseClass
{
	
	@FindBy(xpath="//input[@value='Create System Manager/Session Manager Product Records']")
	WebElement CreateCMR6btn;
	
	
	public LaterProductListPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public LaterProductRecordCreationPage clickCreateCMR6btn()
	{
		
		CreateCMR6btn.click();
		return new LaterProductRecordCreationPage();
	}
	

}
