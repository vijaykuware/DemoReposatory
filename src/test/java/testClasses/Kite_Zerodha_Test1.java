package testClasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseclass.Base;
import pomClasses.KiteLoginPage;
import utility.Utility;

public class Kite_Zerodha_Test1 extends Base
{
	KiteLoginPage login;
	
	@BeforeClass
	public void launchBrowser() 
	{
		initiateBrowser();
		
		login=new KiteLoginPage(driver);
		
	}
	@BeforeMethod
	public void enterCredentials() throws EncryptedDocumentException, IOException, InterruptedException
	{
		
		login.enterUserId(Utility.getExcelData(1, 0));
		login.enterPassword(Utility.getExcelData(1, 1));
		Thread.sleep(2000);
		login.clickContinueButton();
		
	}
  @Test
  public void validateErrorMessage() throws EncryptedDocumentException, IOException, InterruptedException 
  {
	  int TCID = 102;
	  Thread.sleep(2000);
	  String actualErrorMsg = login.getErrorMessage();
	  Reporter.log(actualErrorMsg,true);
	  Thread.sleep(2000);
	  String expectedErrorMessage = Utility.getExcelData(1, 3);
	  
	  Assert.assertEquals(actualErrorMsg, expectedErrorMessage,"Error msg not shown Test case is failed");
	  Reporter.log("Error msg is shown and matching, Test case is passed", true);
	  Utility.captureScreenshot(driver, TCID);
  }
  @AfterMethod
  public void closingBrowser() throws InterruptedException
  {
	  Thread.sleep(2000);
	 driver.close();
  }
  
}
