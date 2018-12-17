package qa.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class TestEx 
{
	@Test
	public void test()
	{
	/*System.setProperty("webdriver.ie.driver", "D://Drivers//IEDriverServer_x64_3.14.0//IEDriverServer.exe");
	WebDriver driver=new InternetExplorerDriver();*/
		
	System.setProperty("webdriver.gecko.driver","D://Drivers//geckodriver-v0.21.0-win64 (2)//geckodriver.exe");	
	WebDriver driver = new FirefoxDriver();
    driver.get("https://facebook.com");
	}

	

}
