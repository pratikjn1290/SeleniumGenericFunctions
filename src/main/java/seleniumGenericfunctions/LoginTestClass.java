package seleniumGenericfunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginTestClass {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		BrowserUtils bu = new BrowserUtils();
		WebDriver driver = bu.init_Driver("Chrome", "https://app.hubspot.com/login");
		Thread.sleep(6000L);
		driver.manage().window().maximize();

		By username = By.xpath("//input[@id = 'username']");
		By password = By.xpath("//input[@id = 'password']");
		By login = By.xpath("//button[@id ='loginBtn']");

		ElementUtils eu = new ElementUtils(driver);
		eu.doSendKeys(username, "test@123");
		eu.doSendKeys(password, "qa@12334");
		eu.doClick(login);

		bu.closeBrowser();

	}

}
