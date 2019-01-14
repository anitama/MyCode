package qa.art.Base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass 
{
	public static Properties prop;
	public static WebDriver driver;

public BaseClass()
{
	prop=new Properties();
	File fl=new File("C://Users//anita.mahra//Desktop//BDD//ART_CMDeviceSEIDGeneration//src//main//java//qa//art//config//config.properties");
	FileReader fr = null;
	try {
		fr = new FileReader(fl);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		prop.load(fr);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
}
public static void initialization()
{
	if(prop.getProperty("browser").equals("chrome"))	
	{
	  System.setProperty("webdriver.chrome.driver", "D://Drivers//New folder//chromedriver_win32 (1)//chromedriver.exe");
	  driver=new ChromeDriver();	
	}
	driver.manage().window().maximize();//here i was getting NPE becuase the control was not going inside the if stament and when we try to access object properties with initialization then in that case we get the NPE
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
}


}
