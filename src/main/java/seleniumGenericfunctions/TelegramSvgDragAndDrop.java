package seleniumGenericfunctions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TelegramSvgDragAndDrop {

	public static void main(String args[]) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://jgraph.github.io/mxgraph/javascript/examples/editors/diagrameditor.html");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		WebElement src = driver.findElement(By.xpath("//img[@class = 'mxToolbarMode' and @title = 'Double Ellipse']"));
		src.click();
		WebElement trg = driver.findElement(By.xpath("//div[@id = 'graph']"));

		Actions act = new Actions(driver);
		act.dragAndDrop(src, trg).build().perform();

	}

}
