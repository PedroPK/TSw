package tsw.teste.selenium;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
	
	private static ChromeDriver driver;
	private static final String		URL_G1 = "https://g1.globo.com";
	
	/**
	 * Driver Configurations
	 *  - Caminho para onde o Driver foi baixado
	 *  - Nome do Driver a ser executado
	 */
	private static final String PATH_CHROME_DRIVER = 
			"/Users/pedropk/git/TSw/src/main/resources/chromedriver_77"; 

	private static final String WEBDRIVER_CHROME_DRIVER = 
			"webdriver.chrome.driver"; 

	
	@BeforeClass
	public static void openChrome() {
		System.setProperty(
			WEBDRIVER_CHROME_DRIVER, 
			PATH_CHROME_DRIVER);
		
		driver = new ChromeDriver();
		driver.get(URL_G1);
	}
	
	@Test
	public void doNothing() {
		
		
		
		
		
		
	}
	
	@AfterClass
	public static void closeChrome() {
		if ( driver != null ) {
			driver.close();
		}
	}

}