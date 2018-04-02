package usingdatadrive;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EnterData {
	
	@BeforeTest
	public void starting() throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "E:\\webdriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver 	=	new ChromeDriver();
		Browser brow=new Browser();
		brow.openBrowser(driver, "http://alpha-sb.appspot.com/InitialAccountAction/getAccountInfo.do?accountNumber=8772998833");
		
		Login log=new Login();
		log.openlogin(driver, "jayaram.raju@anywhere.co", "ysrcp6tdp");
		
		EnterData enterData	=	new EnterData();
	}
	
	@Test(dataProvider="formData")
	public void openEnterData(String name1, Double phone1, String lastName1, String address1, String city1)
	{ 
		try
		{
    
	WebDriver driver= new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	WebDriverWait wait=new WebDriverWait(driver, 20);
	

	//driver.findElement(By.xpath("/html/body/section/div[1]/div/i")).click();
	
    Thread.sleep(3000);
    WebElement name=driver.findElement(By.xpath("//*[@id='step_e83a223c-8479-4995-c582-8a34adc0fd71']/input"));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='step_e83a223c-8479-4995-c582-8a34adc0fd71']/input")));
	name.click();
	name.clear();
	name.sendKeys(name1);
	WebElement phone=driver.findElement(By.xpath("//*[@id='step_7e9af29b-6795-46e6-ba62-ab85378b0f1b']/input[1]"));
	phone.click();
	phone.clear();
	phone.sendKeys(String.valueOf(phone1));
	driver.findElement(By.xpath("//*[@id='verification_7e9af29b-6795-46e6-ba62-ab85378b0f1b']/input")).click();
    WebElement lastname=driver.findElement(By.xpath("//*[@id='step_1b87098a-7601-416c-8620-749343c3c49e']/input"));
	lastname.clear();
	lastname.click();
	lastname.sendKeys(lastName1); 
	//driver.findElement(By.xpath("//*[@id='verification_1b87098a-7601-416c-8620-749343c3c49e']/input")).click();
	WebElement address=driver.findElement(By.xpath("//*[@id='step_2c3ccda6-c3d9-4aec-b491-423f0840e8cc']/input"));
	address.clear();
	address.click();
	address.sendKeys(address1);
	//driver.findElement(By.xpath("//*[@id='verification_2c3ccda6-c3d9-4aec-b491-423f0840e8cc']/input")).click();
	WebElement city=driver.findElement(By.xpath("//*[@id='step_b7dd0e1e-05bb-493e-bbe6-4fc9126898b2']/input"));
	city.clear();
	city.click();
	city.sendKeys(city1);
	driver.findElement(By.xpath("//*[@id=\"radio_option_data_7b0c0967-e4ff-4140-8062-e1ac8c65b47b\"]")).click();
    driver.findElement(By.xpath("//*[@id='radio_option_data_333c3268-9708-4666-a449-06483106ca3f']")).click();
	List<WebElement> delivery= driver.findElements(By.xpath("//div[@id='step_8d183565-6c1e-4d1e-ac5f-f9060965bc07']/span/select"));
	System.out.println(delivery.size());
	delivery.get(2).sendKeys("sampletest");
	List<WebElement> finish=driver.findElements(By.xpath("//div[@id='step_8d183565-6c1e-4d1e-ac5f-f9060965bc07']/i"));
    finish.get(2).click();
		}
	catch(Exception e)
			{
	System.out.println(e);
			}
	}
	
	@DataProvider(name="formData")
	public Object[][] enterData()
	{
		System.out.println("enterData executing");
		Object[][] a=new Object[2][5];
		try
		{
			File src=new File("E:\\webdriver\\TestData.xlsx");
			FileInputStream fis= new FileInputStream(src);
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet sheet1=wb.getSheetAt(0);
			int rowcount=sheet1.getLastRowNum();
			System.out.println("count : " + rowcount);
			for (int i=1;i<=rowcount;i++)
			{
			    a[i-1][0]=sheet1.getRow(i).getCell(0).getStringCellValue();
			    a[i-1][1]=sheet1.getRow(i).getCell(1).getNumericCellValue();
			    a[i-1][2]=sheet1.getRow(i).getCell(2).getStringCellValue();
			    a[i-1][3]=sheet1.getRow(i).getCell(3).getStringCellValue();
			    a[i-1][4]=sheet1.getRow(i).getCell(4).getStringCellValue();

				System.out.println(a[i-1][0]);
				System.out.println(a[i-1][1]);
				System.out.println(a[i-1][2]);
				System.out.println(a[i-1][3]);
				System.out.println(a[i-1][4]);
			}
		}
		catch(Exception e)
		{
			System.out.println("Enter error message:"+e);
		}
		return a;
	}
}
	
