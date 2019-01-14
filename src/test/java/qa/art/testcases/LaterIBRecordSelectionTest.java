package qa.art.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import qa.art.Base.BaseClass;
import qa.art.UtilClass.Util;
import qa.art.pages.CustomerVerificationPage;
import qa.art.pages.LaterIBRecordSelection;
import qa.art.pages.LaterProductListPage;
import qa.art.pages.LaterProductRecordCreationPage;
import qa.art.pages.LoginPage;
import qa.art.pages.ProductAdministrationPage;
import qa.art.pages.UserMenuPage;

public class LaterIBRecordSelectionTest extends BaseClass
{
	LoginPage loginpage;
	UserMenuPage usrmenu;
	ProductAdministrationPage pdp;
	CustomerVerificationPage cvp;
	LaterProductListPage lpp;
	LaterProductRecordCreationPage lprcp;
	LaterIBRecordSelection libp;
	
	
	public LaterIBRecordSelectionTest()
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
		//libp=new LaterIBRecordSelection();
		//cvp=new CustomerVerificationPage();
	}
	@DataProvider
	public Object[][] getData()
	{
		return Util.connectionwithFile();
		
	}
	
	@Test(dataProvider="getData")
	public void laterIBRecordTest(String FL,String productype,String templates,String pnickname,String materialcode,String ordernum)
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
		libp=lprcp.clickOKbtnonNextPage();
		libp.clickContinueBtn(materialcode);
		
		
	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
		
	}
	

}
