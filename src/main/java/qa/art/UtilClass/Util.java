package qa.art.UtilClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import qa.art.Base.BaseClass;

public class Util extends BaseClass
{
	public static Object[][] connectionwithFile()
	{
		XSSFWorkbook wb = null;	
		FileInputStream st = null;
		File file = new File("C://Users//anita.mahra//Desktop//BDD//ART_CMDeviceSEIDGeneration//src//main//java//qa//art//TestDeviceData//DeviceSEIDData.xlsx");
		try {
			 st = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wb = new XSSFWorkbook(st);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   XSSFSheet sh=wb.getSheetAt(0);
		
		Object [][]data=new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];
		
		for(int i=0;i<sh.getLastRowNum();i++)
		{
			
			for(int j=0;j<sh.getRow(0).getLastCellNum();j++)
			{
				
				data[i][j]=sh.getRow(i+1).getCell(j).toString();
				
			}
			
			
			
		}
		return data;
		
		
	}

	
}


