package qa.art.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import qa.art.Base.BaseClass;

public class LaterIBRecordSelection extends BaseClass 
{
	
	@FindBy(xpath="//select[@id='materialCode']")
	WebElement materialcode;
	
	@FindBy(xpath="//input[@value='Continue to Create System Manager/Session Manager Product Records']")
	WebElement continueBtn;

	
	
	public LaterIBRecordSelection()
	{	
		PageFactory.initElements(driver, this);
	}


	public InstallScriptData clickContinueBtn(String mtcode)
	{
		Select sel=new Select(materialcode);
		
		sel.selectByVisibleText(mtcode);
		continueBtn.click();
		return new InstallScriptData();
	}
}
