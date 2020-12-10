package seleniumGenericfunctions;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVGFileHandling {

	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://debeissat.nicolas.free.fr/svg3d.php");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(3000, TimeUnit.SECONDS);

		driver.switchTo().frame("svg_result");
		List<WebElement> svgImage = driver.findElements(By.xpath(
				"//*[name() = 'svg']//*[local-name() = 'g' and @id = 'g2']//*[local-name() = 'path' and contains(@id, 'face')]"));

		// Using for each loop

		System.out.println("Using normal for");
		for (int i = 0; i < svgImage.size(); i++) {
			String text = svgImage.get(i).getAttribute("d");
			System.out.println(text);
		}

		System.out.println("Using For each");
		for (WebElement elem : svgImage) {

			System.out.println(elem.getAttribute("d"));
		}

		// Using Streams
		System.out.println("Using stream");
		svgImage.stream().forEach(elem -> System.out.println(elem.getText()));

		System.out.println("Using iterator");
		Iterator<WebElement> itr = svgImage.iterator();
		while (itr.hasNext()) {
			WebElement value = itr.next();
			System.out.println(value.getAttribute("d"));
		}

		System.out.println("Using List iterator");
		ListIterator<WebElement> listitr = svgImage.listIterator();
		while (listitr.hasNext()) {
			WebElement values = listitr.next();
			System.out.println(values.getAttribute("d"));
		}
	}
}
