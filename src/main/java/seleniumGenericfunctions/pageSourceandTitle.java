package seleniumGenericfunctions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class pageSourceandTitle {
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(
				"https://app.hubspot.com/login?hubs_signup-url=www.hubspot.com/&hubs_signup-cta=homepage-nav-login&_ga=2.74920594.1878669262.1603352885-1311343212.1603352885&__cf_chl_jschl_tk__=cc41348278bc238467cab93493b969b01d0affcc-1603352895-0-AR87OxsPTuyXZ7hZh0t3yH10IIl_UtDiDFhY_tbDVPzz0h424hV6CBdPhCCq-s6ObZlR8KNqtsZkMWK7OmbROWcy1CNIe7Svk2VfldHuWXUgMpid2-PcsAy6ddYRaS3erC_GvKrLCyGaxH-eu3u8e2tatyVlDV3tuwcSn5bYZmZUGfwjU8gW55sT5R246PdgJgthz37_nOS453qV9FsjuHwFt837mXAeCRK3wFTE9ICU541Fur5G2RzI-ZrfbdRzbjL3Lcu_SQYVXGN_HBsbWhmcLfHC901--SmRbDacAO1_dG3y1CP7ZjMPIx8VnsjhSufp0-CHQ4lo5wpnPj_s5QmOtm1o9x3QqpvOgYKVmFfeQT6rNn2Hr50j5EwalJwzeWPVFsmTmNFOX1NKsf_jTCScBQXSczHnk5G2EEZSamEj3ujjv9LJMjmke4KirbD8fUkYw9kZMMPlYYxDq7lJz5YVAmBasF4_r8jqwyM5dyyxSfKWVtB8ZY_geoh1R_LlHg");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		String curr_url = doGetCurrentUrl();
		System.out.println(curr_url);
		String title = doGetPageTitle();
		System.out.println(title);
	}

	public static String doGetCurrentUrl() {

		return driver.getCurrentUrl();

	}

	public static String doGetPageTitle() {
		return driver.getTitle();
	}

}
