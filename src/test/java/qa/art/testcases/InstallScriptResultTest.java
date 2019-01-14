package qa.art.testcases;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import qa.art.Base.BaseClass;
import qa.art.UtilClass.FailureScreenShot;
import qa.art.UtilClass.Util;
import qa.art.pages.CustomerVerificationPage;
import qa.art.pages.InstallScriptData;
import qa.art.pages.InstallScriptResult;
import qa.art.pages.LaterIBRecordSelection;
import qa.art.pages.LaterProductListPage;
import qa.art.pages.LaterProductRecordCreationPage;
import qa.art.pages.LoginPage;
import qa.art.pages.ProductAdministrationPage;
import qa.art.pages.UserMenuPage;

public class InstallScriptResultTest extends BaseClass
{


	LoginPage loginpage;
	UserMenuPage usrmenu;
	ProductAdministrationPage pdp;
	CustomerVerificationPage cvp;
	LaterProductListPage lpp;
	LaterProductRecordCreationPage lprcp;
	LaterIBRecordSelection libp;
	InstallScriptData inst;
	InstallScriptResult itsr;
	FailureScreenShot fsst;
	
	
	public InstallScriptResultTest()
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
		itsr=new InstallScriptResult();
		fsst=new FailureScreenShot();
		//cvp=new CustomerVerificationPage();
	}
	@DataProvider
	public Object[][] getData()
	{
		return Util.connectionwithFile();
		
	}
	
	@Test(dataProvider="getData")
	public void FinalSEIDcreationTest(String FL,String productype,String templates,String pnickname,String materialcode,String ordernum )
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
		System.out.println("Waiting for Final Page");
		try {
			Thread.sleep(200000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		itsr.screenshot();
		System.out.println("Final Page dispalyed successfully and Screen shot taken...Please go to ScreenShots folder and check the screen shot ");
		
	}
	@AfterMethod
	public void teardown(ITestResult res)
	{
		if(ITestResult.FAILURE==res.getStatus())
		{
			fsst.FailedSS();
			
		}
		driver.quit();
	}
}
