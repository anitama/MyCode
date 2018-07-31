package qa.testpack;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import org.apache.log4j.PropertyConfigurator;
import org.apache.maven.surefire.shade.org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.screentaker.ShootingStrategy;
import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;


public class Test1 

{
	WebDriver driver;
	
	@BeforeTest
	public void setup(){
		
		System.setProperty("webdriver.chrome.driver", "D://Drivers//chromedriver_win32//chromedriver.exe");
		driver= new ChromeDriver();
}
	
	@Test
	public void testdata() throws IOException{
		
		    
	     driver.get("http://facebook.com");
		 Xls_Reader reader=new Xls_Reader("D://Automation//New_Maven_01//src//test//java//qa//testpack//testdata.xlsx");
		 String username=	reader.getCellData("testdata", "username",2);
		 System.out.println(username);
		 String password=	reader.getCellData("testdata", "password",2);
		 System.out.println(password);
		 driver.findElement(By.xpath("//input[@name='email']")).sendKeys(username);
		 driver.findElement(By.xpath("//input[@name='pass']")).sendKeys(password);
		 driver.findElement(By.xpath("//input[@type='submit']")).click();
		 /*File file =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 System.out.println(file);
		 FileUtils.copyFile(file, new File("D://Automation//"+"firstSS.png"));
		 
		 Screenshot screenshot = new AShot().shootingStrategy(new ViewportPastingStrategy(1000)).takeScreenshot(driver);
	     //BufferedImage image = screenshot.getImage();
	     //ImageIO.write(image, "PNG", new File("D://Automation//"+ "Test.png"));
	     ImageIO.write(screenshot.getImage(),"PNG",new File("D://Automation//"+ "Test.png"));*/
	     //ImageIO.write(screenshot.getImage(),"PNG",new File(System.getProperty("user.dir")+"D://Automation//"+"test.png"));
	}

	
	@AfterTest
	public void teardown()
      {
		
		driver.close();
      }

}
