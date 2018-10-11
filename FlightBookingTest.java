package Practise11.Practise11;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.sun.javafx.PlatformUtil;
import com.sun.jna.Platform;

public class FlightBookingTest
{
	WebDriver driver;
    @Test
    public void testThatResultsAppearForAOneWayJourney() throws InterruptedException {
        setDriverPath();
        
        driver.get("https://www.cleartrip.com/");
        driver.findElement(By.xpath("//input[@id='FromTag']")).sendKeys("Bang");
        WebDriverWait wait=new WebDriverWait(driver,30);
        List<WebElement>list=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@id='ui-id-1']//li/descendant::a[@tabindex ='-1']")));
        System.out.println(list.size());
        for(int i=0;i<list.size();i++)
        {
        	System.out.println(list.get(i).getText());
        	if(list.get(i).getText().contains("Bangalore, IN - Kempegowda International Airport (BLR)"))
        	{
        		list.get(i).click();
        		break;
        		
        	}    	
        }
        driver.findElement(By.xpath("//input[@id='ToTag']")).sendKeys("Del");
        List<WebElement>list1=  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@id='ui-id-2']//li/descendant::a[@tabindex='-1']")));
        for(int i=0;i<list1.size();i++)
        {
        	System.out.println(list1.get(i).getText());
        	if(list1.get(i).getText().contains("New Delhi, IN - Indira Gandhi Airport (DEL)"))
        	{
        		list1.get(i).click();
        		break;
        		
        	}   	
        }
        
        driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[3]/td[7]/a")).click();

        //all fields filled in. Now click on search
        driver.findElement(By.id("SearchBtn")).click();
        Assert.assertTrue(isElementPresent(By.className("searchSummary")));
       driver.quit();      
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    private void setDriverPath() {
        if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "D:/Drivers/chromedriver_win32/chromedriver.exe");
            driver=new ChromeDriver();
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
    }

}
