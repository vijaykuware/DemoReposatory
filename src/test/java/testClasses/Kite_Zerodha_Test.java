package testClasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseclass.Base;
import pomClasses.KiteDasboardPage;
import pomClasses.KiteLoginPage;
import pomClasses.KitePinVerificationPage;
import utility.Utility;

public class Kite_Zerodha_Test extends Base
{
	KiteLoginPage login;
	KitePinVerificationPage pin;
	KiteDasboardPage dashboard;
	
	@BeforeClass
	public void launchBrowser()
	{
		initiateBrowser();
		
		login=new KiteLoginPage(driver);
		pin= new KitePinVerificationPage(driver);
		dashboard=new KiteDasboardPage(driver);
		
	}
	@BeforeMethod
	public void enterCredentials() throws EncryptedDocumentException, IOException, InterruptedException
	{
		Thread.sleep(2000);
		login.enterUserId(Utility.getExcelData(0, 0));
		login.enterPassword(Utility.getExcelData(0, 1));
		login.clickContinueButton();
		
		Thread.sleep(2000);
		pin.enterPin(Utility.getExcelData(0, 2));
		pin.clickContinueButton();
		Thread.sleep(2000);
	}
	
	
  @Test
  public void validate_UserID() throws EncryptedDocumentException, IOException, InterruptedException 
  {
	  int TCID = 101;
	  Thread.sleep(2000);
	  String actualUserID = dashboard.clickuserId();
	  Thread.sleep(2000);
	  String expectedUserID = Utility.getExcelData(0, 0);
	  
	  Assert.assertEquals(actualUserID, expectedUserID,"UserID is NOT Matching, Test Case is Failed");
	  Reporter.log("UserID is Matching , test case is passed", true);
	  
	  Utility.captureScreenshot(driver, TCID);
	  
  }
  
  @AfterMethod
  public void loggingOut()
  {
	  dashboard.clickuserId();
	  dashboard.clickLogoutButton();
  }
  
  @AfterClass
  public void closingBrowser()
  {
	  driver.close();
  }
}
