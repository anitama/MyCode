
package qa.art.pages;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import qa.art.Base.BaseClass;

public class InstallScriptResult extends BaseClass 
{
	
	public void screenshot()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,750)");
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
		
		
	}
	
	

}
