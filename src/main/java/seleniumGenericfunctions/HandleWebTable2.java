package seleniumGenericfunctions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleWebTable2 {
	static WebDriver driver;

	public static void main(String args[]) {

		try {
			launchBrowser();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doCheckContact();
		closeBrowser();

	}
	// a[contains(text(),'abhishek')]//parent::td//preceding-sibling::td/input[@type
	// = 'checkbox']
	// a[contains(text(), 'abhishek')]//parent::td//following-sibling::td//a

	public static void launchBrowser() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://classic.freecrm.com/index.html");
		WebElement username = driver.findElement(By.xpath("//input[@name = 'username']"));
		username.sendKeys("batchautomation");
		WebElement password = driver.findElement(By.xpath("//input[@name = 'password']"));
		password.sendKeys("Test@12345");
		WebElement loginbtn = driver.findElement(By.xpath("//input[@value = 'Login']"));
		loginbtn.click();
		Thread.sleep(5000);
		driver.switchTo().frame("mainpanel");
		WebElement contact = driver.findElement(By.xpath("//a[@title = 'Contacts']"));
		Actions act = new Actions(driver);
		act.click(contact).build().perform();
	}

	public static void closeBrowser() {
		driver. close();
	}

	public static void doCheckContact() {
		WebElement elem = driver.findElement(
				By.xpath("//a[contains(text(),'abhishek')]//parent::td//preceding-sibling::td/input[@type= 'checkbox']"));
		elem.click();
	}

}
 