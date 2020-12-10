package seleniumGenericfunctions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebtableHandle {

	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void launchBrowser()

	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

	}

	public static void closeBrowser() {

		driver.close();
		
	}
	
	public static void doGetElement()

	{
		
	}
	
	
	

	public static void handleWebTable() {

		
		
		
	}

}
