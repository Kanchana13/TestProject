package com.qaa.testscripts;

import java.io.IOException;
import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qaa.utility.ExcelUtility;

public class CS6 extends TestBase
{
	@Test(dataProvider = "getData")
	public void searchItemsInAmazon(String type, String item) throws InterruptedException
	{
		amzn.getSearch().clear();
		amzn.getCategoryList().selectByVisibleText(type);
		amzn.getSearch().sendKeys(item);
		amzn.getSearchBtn().click();
		Thread.sleep(2000);
		if(driver.getCurrentUrl().contains(item))
		{
			for(int i=0;i<amzn.getTitles().size();i++)
			{
				System.out.print(amzn.getTitles().get(i).getText()+":   ");
				System.out.println("Rs: "+amzn.getPrice().get(i).getText());
			}
		}
	}
	/*@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[3][2];
		data[0][0]="Books";
		data[0][1]="DaVinciCode";
		data[1][0]="Electronics";
		data[1][1]="MobilePhone";
		data[2][0]="Furniture";
		data[2][1]="WoodenTable";
		return data;
	}*/
	@DataProvider
	public String[][] getData() throws IOException
	{
		String xlPath="C:\\Sellenium\\SeleniumProject\\src\\test\\java\\com\\qaa\\testdata\\TestData.xlsx";
		String xlSheet="Sheet1";
		
		int rowCount=ExcelUtility.getRowCount(xlPath, xlSheet);
		int cellCount=ExcelUtility.getCellCount(xlPath, xlSheet, rowCount);
		String[][] data=new String[rowCount][cellCount];
		for(int i=1;i<=rowCount;i++)
		{
			for(int j=0;j<cellCount;j++)
			{
				data[i-1][j]=ExcelUtility.getCellData(xlPath, xlSheet, i, j);
			}
		}
		
		return data;
}

@Test(priority = 2)
public void amazon()
{
 //amzn.getAlllink().click();
//amzn.getSignoutbutton().click();
	//amzn.getcreateacoount().click();
}
 @Test(priority = 1)
 public void amazonend()
 {
	 
 
 
 
amzn.getSigninlink().click();
amzn.getemailtextfield().sendKeys("kanchanagowdakanchu0921@gmail.com");
amzn.getcontinuebutton().click();
amzn.getpasswordfield().sendKeys("Kanchu@13");
amzn.getsigninbutton().click();
//WebElement ele = driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
//act.moveToElement(ele).perform();

//amzn.getreturnsorder().click();
//amzn.getsigninsecure().click();
}


}

