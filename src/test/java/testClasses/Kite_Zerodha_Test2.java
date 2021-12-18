package testClasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseclass.Base;
import pomClasses.KiteLoginPage;
import utility.Utility;

public class Kite_Zerodha_Test2 extends Base
{
	KiteLoginPage login;
	@BeforeClass
	public void launchBrowser()
	{
		initiateBrowser();
		
		login=new KiteLoginPage(driver);
		
	}
	@BeforeMethod
	public void enterCredentials() throws InterruptedException
	{
		login.clickContinueButton();
		Thread.sleep(3000);
	}
	
	
	 @Test
	public void validateWarningMessage1() throws EncryptedDocumentException, IOException, InterruptedException
	{
		 int TCID = 103;
		 Thread.sleep(3000);
		String actualWarning1 = login.getWarningMessage1();
		String expectedWarning1 = Utility.getExcelData(3, 0);
		
		Assert.assertEquals(actualWarning1, expectedWarning1,"Warning message is not matching tst case is failed");
		Reporter.log("warning message is displayed,test case is passed");
		Utility.captureScreenshot(driver, TCID);
	}
	
	 @Test
	public void validateWarningMessage2() throws EncryptedDocumentException, IOException, InterruptedException
	{
		 int TCID = 104;
		 Thread.sleep(3000);
		String actualWarning2 = login.getWarningMessage2();
		String expectedWarning2 = Utility.getExcelData(3, 1);
		
		Assert.assertEquals(actualWarning2, expectedWarning2,"Warning message is not matching tst case is failed");
		Reporter.log("warning message is displayed,test case is passed");
		Utility.captureScreenshot(driver, TCID);
		
	}
	
    @AfterClass
    public void closeBrowser()
    {
    	driver.close();
    }
}
