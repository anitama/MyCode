package qa.art.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import qa.art.Base.BaseClass;
import qa.art.UtilClass.Util;
import qa.art.pages.CustomerVerificationPage;
import qa.art.pages.LoginPage;
import qa.art.pages.ProductAdministrationPage;
import qa.art.pages.UserMenuPage;

public class CustomerVerificationPageTest extends BaseClass
{
	
	LoginPage loginpage;
	UserMenuPage usrmenu;
	ProductAdministrationPage pdp;
	CustomerVerificationPage cvp;

	public CustomerVerificationPageTest()
	{
		
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginpage=new LoginPage();
		usrmenu=loginpage.clickonSubmitbtn(prop.getProperty("username"),prop.getProperty("password"));
		usrmenu.clickRegisterProductLink();
		usrmenu.clickCheckbox();
		usrmenu.clickContinuebtn();
		pdp=new ProductAdministrationPage();
		//cvp=new CustomerVerificationPage();
	}
	@DataProvider
	public Object[][] getData()
	{
		return Util.connectionwithFile();
		
	}
	
	@Test(dataProvider="getData")
	public void custVerificationTest(String FL,String productype,String templates,String pnickname,String materialcode,String ordernum)
	{
		pdp.enterFL(FL);
		pdp.selectProductType(productype);
		pdp.SelectSystemIDRadioBtn();
		cvp=pdp.startSPProductAdmin();
		cvp.clickCustomerType();
		cvp.clickContinueSPbtn();
	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
		
	}
	
	

}
