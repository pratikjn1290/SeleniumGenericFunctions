package seleniumGenericfunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtils {

	public WebDriver driver;

	/**
	 * 
	 * @param browserName
	 * @return this returns driver
	 */

	public WebDriver init_Driver(String browserName, String url) {
		switch (browserName) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			System.out.println("Enter valid Browser Name" + browserName);
			break;
		}

		driver.manage().window().maximize();
		driver.get(url);
		return driver;

	}

	public String doGetCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public String doGetPageTitle() {
		return driver.getTitle();
	}

	public void quitBrowser() {
		driver.quit();
	}

	public void closeBrowser() {
		driver.close();
	}
}
