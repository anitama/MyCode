package qa.art.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.art.Base.BaseClass;

public class LoginPage extends BaseClass

{
	@FindBy(xpath="//input[@id='email']")
	WebElement username;
	
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@name='Submit']")
	WebElement submitbtn;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public UserMenuPage clickonSubmitbtn(String usrname,String passwrd)
	{
		
		username.sendKeys(usrname);
		password.sendKeys(passwrd);
		submitbtn.click();
		return new UserMenuPage();
		
	}

	
	
}
