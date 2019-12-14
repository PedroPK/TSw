package tsw.teste.selenium;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
	
	private static ChromeDriver driver;
	private static final String		URL_G1 = "https://g1.globo.com";
	
	@BeforeClass
	public static void openChrome() {
		SeleniumUtils.setSystemPropertyChromeWebDriverOriginal();
		
		driver = new ChromeDriver();
		driver.get(URL_G1);
	}
	
	@Test
	public void doNothing() {
		
	}
	
	public void accessURL(String pURL) {
		driver.get(pURL);
	}
	
	@AfterClass
	public static void closeChrome() {
		if ( driver != null ) {
			driver.close();
		}
	}

}