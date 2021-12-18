package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility 
{
	
	public static String getExcelData(int rowNo,int colNo) throws EncryptedDocumentException, IOException 
	{
		
		FileInputStream myfile=new FileInputStream("C:\\java projects\\myexelsheet.xlsx");
		Sheet mySheet = WorkbookFactory.create(myfile).getSheet("Sheet5");
		String value = mySheet.getRow(rowNo).getCell(colNo).getStringCellValue();
		return value;
	}
	
	public static void captureScreenshot(WebDriver driver,int TCID) throws IOException
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("D:\\Captures\\TestCase"+TCID+".png");
		FileHandler.copy(source, dest);
	}

}
