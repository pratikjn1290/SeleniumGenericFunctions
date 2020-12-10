package seleniumGenericfunctions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleWebTable {

	static WebDriver driver;

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		setup();
		System.out.println(getWicketDetails("Rohit"));
		System.out.println(getBatsManDetails("Rohit"));
		closeBrowser();

	}

	public static void setup() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(
				"https://www.cricbuzz.com/live-cricket-scorecard/30539/srh-vs-mi-56th-match-indian-premier-league-2020");
	}

	public static String getWicketDetails(String playername) {
		WebElement wicketDetails = driver.findElement(By.xpath("//a[contains(text(), '" + playername
				+ "')]//parent::div//following-sibling::div//span[@class = 'text-gray']"));
		String wicketTaker = wicketDetails.getText();
		return wicketTaker;
	}

	public static ArrayList<Object> getBatsManDetails(String playername) {

		ArrayList<Object> scoreDetails = new ArrayList<Object>();
		List<WebElement> Batsmandetails = driver.findElements(By.xpath("//a[contains(text(), '" + playername
				+ "')]//parent::div//following-sibling::div//span[@class = 'text-gray']//parent::div//following-sibling::div"));
		for (WebElement alldetails : Batsmandetails) {
			String otherdetail = alldetails.getText();
			scoreDetails.add(otherdetail);
		}

		return scoreDetails;
	}

	public static void closeBrowser() {

		driver.close();
	}
}
