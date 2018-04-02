package usingdatadrive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login
{
	  public void openlogin(WebDriver driver, String username, String password) throws InterruptedException 
	  {
		WebDriverWait wait=new WebDriverWait(driver,2000);
//		driver.findElement(By.xpath("/html/body/div/div[2]/nav/a")).click();
		WebElement email=driver.findElement(By.xpath("//*[@id='identifierId']"));
		email.clear();
		email.click();
		email.sendKeys(username);
		driver.findElement(By.xpath("//*[@id='identifierNext']/content")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='password']/div[1]/div/div[1]/input")));
		driver.findElement(By.xpath("//*[@id='password']/div[1]/div/div[1]/input")).click();
		   // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='password']/div[1]/div/div[1]/input")));
		driver.findElement(By.xpath("//*[@id='password']/div[1]/div/div[1]/input")).sendKeys(password);
		   // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='password']/div[1]/div/div[1]/input")));
		driver.findElement(By.xpath("//*[@id='passwordNext']/content")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/section/div[1]/div/i")).click();
	  }
          
}
