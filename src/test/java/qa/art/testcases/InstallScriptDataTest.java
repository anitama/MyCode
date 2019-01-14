package qa.art.testcases;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import qa.art.Base.BaseClass;
import qa.art.UtilClass.Util;
import qa.art.pages.CustomerVerificationPage;
import qa.art.pages.InstallScriptData;
import qa.art.pages.LaterIBRecordSelection;
import qa.art.pages.LaterProductListPage;
import qa.art.pages.LaterProductRecordCreationPage;
import qa.art.pages.LoginPage;
import qa.art.pages.ProductAdministrationPage;
import qa.art.pages.UserMenuPage;

public class InstallScriptDataTest extends BaseClass
{

	LoginPage loginpage;
	UserMenuPage usrmenu;
	ProductAdministrationPage pdp;
	CustomerVerificationPage cvp;
	LaterProductListPage lpp;
	LaterProductRecordCreationPage lprcp;
	LaterIBRecordSelection libp;
	InstallScriptData inst;
	
	
	public InstallScriptDataTest()
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
		libp=new LaterIBRecordSelection();
		inst=new InstallScriptData();
		//cvp=new CustomerVerificationPage();
	}
	@DataProvider
	public Object[][] getData()
	{
		return Util.connectionwithFile();
		
	}
	
	@Test(dataProvider="getData")
	public void InstallScriptTest(String FL,String productype,String templates,String pnickname,String materialcode,String ordernum )
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
		libp.clickContinueBtn(materialcode);
		inst.selRelNum();
		inst.selSPRelNum();
		inst.supportAdOffer();
		inst.OrderNum(ordernum);
		inst.ContinueSPbtnClick();
		
		
	}
	@AfterMethod
	public void teardown()
	{/*
		TakesScreenshot ts=(TakesScreenshot)driver;
		File scrfile=ts.getScreenshotAs(OutputType.FILE);
		File destfile=new File(".//ScreenShots//deviceseid.png");
		try
		{FileUtils.copyFile(scrfile, destfile);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		
		}
		
		driver.quit();
		}*/
	  
		driver.quit();
	
	}
}
	




