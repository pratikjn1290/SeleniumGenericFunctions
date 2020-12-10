package seleniumGenericfunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

	public WebDriver driver;
	
	public WebElement dowaitforElementPresent(By locator, int duration)
	{
	WebDriverWait wait = new WebDriverWait(driver, duration);
	return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	
	}
	
	public void doWaitforTitlePresent(String title, int timeout, int sleep)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeout, sleep);
		wait.until(ExpectedConditions.titleIs(title));
	}
	
}
