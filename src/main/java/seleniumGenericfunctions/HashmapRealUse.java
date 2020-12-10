package seleniumGenericfunctions;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HashmapRealUse {

	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://classic.freecrm.com/index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		WebElement username = driver.findElement(By.xpath("//input[@name = 'username']"));
		username.sendKeys(doGetUser("Distributor"));
		WebElement password = driver.findElement(By.xpath("//input[@name = 'password']"));
		password.sendKeys(doGetpassword("Distributor"));
		WebElement loginbutton = driver.findElement(By.xpath("//input[@type = 'submit']"));
		loginbutton.click();

	}

	public static String doGetUser(String role) {

		String credential = userRoleBaseCredential().get(role);
		return credential.split(":")[0];

	}

	public static String doGetpassword(String role) {

		String credential = userRoleBaseCredential().get(role);
		return credential.split(":")[1];

	}

	public static HashMap<String, String> userRoleBaseCredential() {

		HashMap<String, String> users = new HashMap<String, String>();
		users.put("Seller", "batchautomation:test@12345");
		users.put("Buyer", "batchautomation:test@12345");
		users.put("User", "batchautomation:test@12345");
		users.put("Distributor", "batchautomation:test@12345");
		users.put("Delivery", "batchautomation:test@12345");

		return users;
	}

}
