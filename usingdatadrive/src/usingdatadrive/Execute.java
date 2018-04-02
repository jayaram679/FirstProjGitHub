package usingdatadrive;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Execute 
{
	public static void main(String args[]) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "E:\\webdriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver 	=	new ChromeDriver();
		Browser brow=new Browser();
		brow.openBrowser(driver, "http://alpha-sb.appspot.com/InitialAccountAction/getAccountInfo.do?accountNumber=8772998833");
		
		Login log=new Login();
		log.openlogin(driver, "jayaram.raju@anywhere.co", "ysrcp6tdp");
		
		EnterData enterData	=	new EnterData();
	}
}
