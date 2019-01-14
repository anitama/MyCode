package qa.art.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.art.Base.BaseClass;
import qa.art.pages.LoginPage;
import qa.art.pages.UserMenuPage;

public class UserMenuTest extends BaseClass

{
	
	LoginPage loginpage;
	UserMenuPage usrmenu;
	public UserMenuTest()
	{
		
		super();
	}
	
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginpage=new LoginPage();
		usrmenu=loginpage.clickonSubmitbtn(prop.getProperty("username"),prop.getProperty("password"));
	   	
	}
	
	@Test
	public void clickRegisterLinkTest()
	{
		
		usrmenu.clickRegisterProductLink();
		usrmenu.clickCheckbox();
		usrmenu.clickContinuebtn();
	}
	
	/*@Test
	public void clickCheckboxTest()
	{
		
		usrmenu.clickCheckbox();
	}
	
	@Test
	public void clickContinuebtnTest()
	{
		usrmenu.clickContinuebtn();
		
	}*/
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
		
	}
	

}
