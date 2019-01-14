package qa.art.UtilClass;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import qa.art.Base.BaseClass;

public class FailureScreenShot extends BaseClass 

{
	
	
	public void FailedSS()
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File scrfile=ts.getScreenshotAs(OutputType.FILE);
		File destfile=new File(".//ScreenShots//failedss.png");
		try
		{FileUtils.copyFile(scrfile, destfile);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		
		}
		
		
	}

}
