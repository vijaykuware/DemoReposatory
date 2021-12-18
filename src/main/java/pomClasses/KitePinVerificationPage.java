package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KitePinVerificationPage 
{
	@FindBy(id="pin") private WebElement pin;
	@FindBy(xpath="//button[@type='submit']") private WebElement continueButton;
	
	public KitePinVerificationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterPin(String Pin)
	{
		pin.sendKeys(Pin);
	}
	
	public void clickContinueButton()
	{
		continueButton.click();
	}

}
