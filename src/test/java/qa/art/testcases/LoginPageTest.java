package qa.art.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.art.Base.BaseClass;
import qa.art.pages.LoginPage;

public class LoginPageTest extends BaseClass

{
	LoginPage loginpage;
	public LoginPageTest()
	{
		
		super();
	}
		
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginpage=new LoginPage();
				
	}
	
	@Test
	public void clickonSubmitbtnTest()
	{
		
		loginpage.clickonSubmitbtn(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
		
	}
	

	
}
