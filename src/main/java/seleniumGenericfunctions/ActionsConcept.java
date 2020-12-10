package seleniumGenericfunctions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsConcept {

	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		WebElement source = driver.findElement(By.xpath("//a[@id = 'highlight-addons']"));
		doMoveToElement(driver, source);
		WebElement target = driver.findElement(By.xpath("//a[@id = 'MyFlexiPlan']"));
		target.click();
	}

	public static void doMoveToElement(WebDriver driver, WebElement element) {

		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
		act.sendKeys(Keys.CONTROL).sendKeys(Keys.SHIFT).sendKeys(Keys.DELETE).build().perform();
	}

}
