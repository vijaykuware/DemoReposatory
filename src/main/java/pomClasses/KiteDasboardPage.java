package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteDasboardPage 
{
	@FindBy(xpath="//span[@class='user-id']")private WebElement userId;
	@FindBy(xpath="//a[@target='_self']") private WebElement logoutButton;
	
	public KiteDasboardPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String clickuserId()
	{
		String actualID = userId.getText();
		return actualID;
	}
	public void clickLogoutButton()
	{
		userId.click();
		logoutButton.click();
	}


}
