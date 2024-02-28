package tsw.teste.selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumWebDriverTest {

	private static final String VALUE = "value";

	private static final String GOOGLE_SEARCH		= "Google Search";
	private static final String PESQUISA_GOOGLE		= "Pesquisa Google";

	private static final String GOOGLE_URL = "https://www.google.com.br";
	
	private static final String GOOGLE_LOGO_XPATH			= "/html/body/div[1]/div[2]/div/img";
	private static final String GOOGLE_SEACH_BUTTON_XPATH	= "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]";
	
	private static final String GOOGLE_SEACH_INPUT_XPATH = "//*[@id=\"input\"]";
	private static final String GOOGLE_SEACH_EDGE_INPUT_XPATH = "//*[@id=\"APjFqb\"]";
	private static final String GOOGLE_SEACH_INPUT_FULL_XPATH = "/html/body/ntp-app//div/div[2]/ntp-realbox//div/input";

	private WebDriver driver;

	private void setupChromeDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		options();
	}

	private void setupGeckoDriver() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		options();
	}

	private void setupEdgeDriver(boolean pHeadLess) {
		WebDriverManager.edgedriver().setup();

		EdgeOptions edgeOptions = new EdgeOptions();
		if ( pHeadLess ) {
			edgeOptions.addArguments("--headless");
		}
		
		driver = new EdgeDriver(edgeOptions);
		options();
	}

	private void options() {
		driver.manage().window().maximize();
	}
	
	@Ignore
	@Test
	public void givenChromeDriver_whenNavigateToGoogle_thenFindSeachButtonIsSuccessful() {
		setupChromeDriver();
		driver.get(GOOGLE_URL);
		final WebElement title = driver.findElement(By.xpath(GOOGLE_SEACH_BUTTON_XPATH));

		assertEquals(GOOGLE_SEARCH, title.getAttribute(VALUE));
	}
	
	@Ignore
	@Test
	public void givenGeckoDriver_whenNavigateToGoogle_thenFindTitleIsSuccessful() {
		setupGeckoDriver();
		driver.get(GOOGLE_URL);
		final WebElement title = driver.findElement(By.xpath(GOOGLE_LOGO_XPATH));

		assertEquals(GOOGLE_SEARCH, title.getAttribute(VALUE));
	}
	
	@Test
	public void givenEdgeDriver_whenNavigateToGoogle_thenFindSeachButton_IsSuccessful() {
		setupEdgeDriver(false);
		driver.get(GOOGLE_URL);
		final WebElement title = driver.findElement(By.xpath(GOOGLE_SEACH_BUTTON_XPATH));

		assertTrue(
			title.getAttribute(VALUE).equals(GOOGLE_SEARCH)
			||
			title.getAttribute(VALUE).equals(PESQUISA_GOOGLE)
		);
	}
	
	@Test
	public void givenEdgeDriver_whenNavigateToGoogle_thenFindSearchInput_thenFillAccentureBrasil_thenSubmitSearch_IsSuccessful() {
		setupEdgeDriver(false);
		driver.get(GOOGLE_URL);
		final WebElement searchInput = driver.findElement(By.xpath(GOOGLE_SEACH_EDGE_INPUT_XPATH));
		searchInput.sendKeys("Accenture Brasil");
		searchInput.submit();
	}

	@After
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
