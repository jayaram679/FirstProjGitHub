package usingdatadrive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.google.common.annotations.VisibleForTesting;

public class Browser
{
	public void openBrowser(WebDriver driver, String url) 
	{		
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("/html/body/div/div[2]/nav/a")).click();
	}
}
