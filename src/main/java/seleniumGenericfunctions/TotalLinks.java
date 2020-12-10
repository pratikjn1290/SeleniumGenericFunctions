package seleniumGenericfunctions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalLinks {

	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		System.out.println(getElementCount("a"));
		System.out.println(getElementCount("img"));
		List<String> s = doGetAttributes("img", "src");
		for (String src : s) {
			System.out.println(src);
		}
		
		driver.close();

	}

	public static int getElementCount(String tagName) {
		return driver.findElements(By.tagName(tagName)).size();
	}

	public static List<String> doGetAttributes(String tagName, String attributeName) {

		List<WebElement> allElements = driver.findElements(By.tagName(tagName));
		List<String> attirbuteList = new ArrayList<String>();

		for (WebElement elem : allElements) {
			String attributes = elem.getAttribute(attributeName);
			attirbuteList.add(attributes);
		}

		return attirbuteList;
	}

}
