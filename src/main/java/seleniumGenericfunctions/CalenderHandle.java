package seleniumGenericfunctions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderHandle {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

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
		driver.switchTo().frame("mainpanel");
		Thread.sleep(3000L);
		WebElement calender = driver.findElement(By.xpath("//a[@title = 'Calendar' and text() = 'Calendar']"));

		WebElement dayByEvents = driver.findElement(By.xpath("//a[@title = 'View Today']"));

		Actions act = new Actions(driver);
		act.moveToElement(calender).moveToElement(dayByEvents).click().build().perform();

		String date = "09-10-2019";
		String[] arr = date.split("-");

		String day = arr[0];
		String month = arr[1];
		String year = arr[2];

		WebElement months = driver.findElement(By.xpath("//select[@name = 'slctMonth']"));
		Select oselect = new Select(months);
		oselect.selectByValue(month);

		WebElement years = driver.findElement(By.xpath("//select[@name = 'slctYear']"));
		oselect.selectByValue(year);

		String BeforeXpath = "//*[@id= 'crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[";
		String AfterXpath = "]/td[";

		boolean flag = false;

		for (int drow = 2; drow < 7; drow++)
			for (int dcol = 1; dcol < 7; drow++) {

				String dayValue = driver.findElement(By.xpath(BeforeXpath + drow + AfterXpath + dcol + "]")).getText();
				if (dayValue.equalsIgnoreCase(day)) {
					driver.findElement(By.xpath(BeforeXpath + drow + AfterXpath + dcol + "]")).click();
					flag = true;
					break;
				}
				if (flag) {
					break;
				}

			}
	}

}
