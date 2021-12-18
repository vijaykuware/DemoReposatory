package baseclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base 
{
	protected WebDriver driver;
	
	public void initiateBrowser()
	
		{
		System.setProperty("webdriver.chrome.driver", "C:\\velocity\\crome\\chromedriver.exe");
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications-");
		driver=new ChromeDriver(opt);
		
		driver.get("https://kite.zerodha.com/");
		driver.manage().window().maximize();
	}

}
