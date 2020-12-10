package seleniumGenericfunctions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SingleToneClass {
	public static WebDriver driver = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// This method initialize the browser
	public static void initalizeBrowser() {

		// check driver is null
		if (driver == null) {

			if (Constants.browserName.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (Constants.browserName.equalsIgnoreCase("Firefox")) {
				WebDriverManager.chromedriver().setup();
				driver = new FirefoxDriver();
			} else {
				System.out.println("Enter valid browser name :" + Constants.browserName);
			}

			driver.get("https://corpository.com");
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Constants.pageLoadTime, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(Constants.implicitWait, TimeUnit.SECONDS);
		}

	}

	public static void closeBrowser() {
		driver.close();
		driver = null;
	}

	public static void quitBrowser() {
		driver.quit();
		driver = null;
	}
}
