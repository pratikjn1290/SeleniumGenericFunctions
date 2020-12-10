package seleniumGenericfunctions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Init_Browser {

	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		initBrowser("Chrome", "https://google.com");
		System.out.println(driver.getTitle());
		tearDown();
	}
	public static WebDriver initBrowser(String browserName, String URL)

	{
		switch (browserName) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "Firefox":
			System.out.println("------------------Launch Firefox------------------");
			WebDriverManager.firefoxdriver().setup();
			driver = new ChromeDriver();
			break;

		case "Edge":
			System.out.println("------------------Launch Edge------------------");
			WebDriverManager.edgedriver().setup();
			driver = new ChromeDriver();
			break;

		default:
			System.out.println("------------------Enter Valid Browser Name------------------");
			break;
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		return driver;

	}

	public static void tearDown() {
		driver.close();
	}
}
