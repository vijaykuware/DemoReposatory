package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteLoginPage 
{
	@FindBy(id="userid") private WebElement userID;
	@FindBy(id="password") private WebElement password;
	@FindBy(xpath="//button[@type='submit']") private WebElement continueButton;
	@FindBy(xpath="//p[@class='error text-center']") private WebElement errorMsg;
	@FindBy(xpath="//span[@class='su-message'][1]") private WebElement warningMsg1;
	@FindBy(xpath="(//span[@class='su-message'])[2]") private WebElement warningMsg2;
	
	public KiteLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserId(String UserId)
	{
		userID.sendKeys(UserId);
	}
	
	public void enterPassword(String PWD)
	{
		password.sendKeys(PWD);
	}
	
	public void clickContinueButton()
	{
		continueButton.click();
	}
	public String getErrorMessage()
	{
		String actualErrorMsg = errorMsg.getText();
		return actualErrorMsg;
	}
	
	public String getWarningMessage1()
	{
		String warningMessage1 = warningMsg1.getText();
		return warningMessage1;
		
	}
   public String getWarningMessage2()
   {
	String warningMessage2 = warningMsg2.getText();
	return warningMessage2;
   }
	
}
