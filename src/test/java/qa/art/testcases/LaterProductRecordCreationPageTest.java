package qa.art.testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import qa.art.Base.BaseClass;
import qa.art.UtilClass.Util;
import qa.art.pages.CustomerVerificationPage;
import qa.art.pages.LaterProductListPage;
import qa.art.pages.LaterProductRecordCreationPage;
import qa.art.pages.LoginPage;
import qa.art.pages.ProductAdministrationPage;
import qa.art.pages.UserMenuPage;

public class LaterProductRecordCreationPageTest extends BaseClass
{
	
	LoginPage loginpage;
	UserMenuPage usrmenu;
	ProductAdministrationPage pdp;
	CustomerVerificationPage cvp;
	LaterProductListPage lpp;
	LaterProductRecordCreationPage lprcp;
	
	public LaterProductRecordCreationPageTest()
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
	public void laterProductRecordTest(String FL,String productype,String templates,String pnickname,String materialcode,String ordernum)
	{
		pdp.enterFL(FL);
		pdp.selectProductType(productype);
		pdp.SelectSystemIDRadioBtn();
		cvp=pdp.startSPProductAdmin();
		cvp.clickCustomerType();
		lpp=cvp.clickContinueSPbtn();
		lprcp=lpp.clickCreateCMR6btn();
		lprcp.templateCode(templates);
		//lprcp.materialCode(materialcode);
		lprcp.productNick(pnickname);
		lprcp.continueBtn();
		lprcp.clickOKbtnonNextPage();
		
		
	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
		
	}
	
	

}
