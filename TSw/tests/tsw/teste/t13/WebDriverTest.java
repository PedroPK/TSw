package tsw.teste.t13;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverTest {
	
	private static final String NM_PROPRIEDADE_GECKO_DRIVER = "webdriver.gecko.driver";
	private static final String CAMINHO_GECKO_DRIVER = "/Users/pedropk/Downloads/Applications/Development/geckodriver";
	
	private static final String NM_PROPRIEDADE_CHROME_DRIVER = "webdriver.chrome.driver";
	private static final String CAMINHO_CHROME_DRIVER = "/Users/pedropk/Downloads/Applications/Development/chromedriver";
	
	private static final String URL_HTTPS_GOOGLE = "https://google.com.br";
	private static final String NM_CAMPO_TEXTO_BUSCA_GOOGLE = "q";
	
	private static final String URL_HTTPS_YAHOO = "https://yahoo.com.br";
	private static final String NM_CAMPO_TEXTO_BUSCA_YAHOO = "p";
	
	WebDriver aNavegador = null;
	
	@Before
	public void inicializarChrome() {
		// Pode ser Necessário configurar o Build Path para acessar o Chrome Driver
		// Veja Referências no final desta classe
		System.setProperty(NM_PROPRIEDADE_CHROME_DRIVER, CAMINHO_CHROME_DRIVER); 
		
		this.aNavegador = new ChromeDriver();
	}
	
	@After
	@Ignore // Ignore não funciona com o @Before nem @After
	public void finalizarChrome() {
		if ( this.aNavegador != null ) {
			this.aNavegador.close();
		}
	}
	
	@Test
	@Ignore
	public void testeBuscaUnibratecGoogleFirefox() {
		// Pode ser Necessário configurar o Build Path para acessar o Gecko Driver
		// Veja Referências no final desta classe
		System.setProperty(NM_PROPRIEDADE_GECKO_DRIVER, CAMINHO_GECKO_DRIVER); 
		
		WebDriver fireFox = new FirefoxDriver();
		fireFox.get(URL_HTTPS_GOOGLE);
		
		WebElement campoBuscaGoogle = fireFox.findElement(By.name(NM_CAMPO_TEXTO_BUSCA_GOOGLE));
		campoBuscaGoogle.sendKeys("Unibratec");
		campoBuscaGoogle.submit();
		
		fireFox.close();
	}
	
	@Test
	@Ignore
	public void testeBuscaUnibratecGoogleChrome() {
		WebDriver chrome = this.aNavegador;
		chrome.get(URL_HTTPS_GOOGLE);
		
		WebElement campoBuscaGoogle = chrome.findElement(By.name(NM_CAMPO_TEXTO_BUSCA_GOOGLE));
		campoBuscaGoogle.sendKeys("Unibratec");
		campoBuscaGoogle.submit();
		
		String codigoFonte = chrome.getPageSource();
		//System.out.println(codigoFonte);
		
		boolean achouSiteOficialUnibratec = codigoFonte.contains("www.unibratec.edu.br");
		
		assertTrue(achouSiteOficialUnibratec);
	}
	
	@Test
	public void testeBuscaUnibratecYahooChrome() {
		WebDriver chrome = this.aNavegador;
		chrome.get(URL_HTTPS_YAHOO);
		
		WebElement campoBuscaYahoo = chrome.findElement(By.name(NM_CAMPO_TEXTO_BUSCA_YAHOO));
		campoBuscaYahoo.sendKeys("Unibratec");
		campoBuscaYahoo.submit();
		
		String codigoFonte = chrome.getPageSource();
		//System.out.println(codigoFonte);
		
		boolean achouSiteOficialUnibratec = codigoFonte.contains("www.unibratec.edu.br");
		
		assertTrue(achouSiteOficialUnibratec);
	}
	
	@Test
	public void testarINSSachandoPrevidenciaSocial() {
		this.aNavegador.get(URL_HTTPS_YAHOO);
		WebElement campoBusca = this.aNavegador.findElement(By.name(NM_CAMPO_TEXTO_BUSCA_YAHOO));
		campoBusca.sendKeys("INSS");
		campoBusca.submit();
		
		this.aNavegador.findElement(By.linkText("Previdência Social - Previdência Social"));
	}
	
	/**
	 * Referências
	 */
	
	/*
	 * Onde Baixar o Selenium:
	 * 
	 * http://www.seleniumhq.org/download/
	 * 
	 * Selenium Standalone Server 3.3.1
	 * https://goo.gl/uTXEJ1
	 */
	
	/*
	 * API do Selenium
	 * 
	 * http://seleniumhq.github.io/selenium/docs/api/java/index.html
	 */
	
	/*
	 * Exceção lançada em caso de faltar configurar o Path para o Gecko Driver:
	 * 
	 * Exception in thread "main" java.lang.IllegalStateException: 
	 * 		The path to the driver executable must be set by the webdriver.gecko.driver system property; 
	 * 		for more information, see https://github.com/mozilla/geckodriver. 
	 * 		The latest version can be downloaded from https://github.com/mozilla/geckodriver/releases 
	 * at com.google.common.base.Preconditions.checkState(Preconditions.java:199) 
	 * at org.openqa.selenium.remote.service.DriverService.findExecutable(DriverService.java:109)  
	 */
	
	/*
	 * Onde Baixar o Gecko Driver:
	 * https://github.com/mozilla/geckodriver/releases
	 */
	
	/*
	 * Como configurar o Path para executar o Gecko Driver:
	 * http://stackoverflow.com/questions/38676719/selenium-using-java-the-path-to-the-driver-executable-must-be-set-by-the-webdr
	 * http://stackoverflow.com/questions/37785686/how-to-use-the-gecko-executable-with-selenium
	 * http://toolsqa.com/selenium-webdriver/how-to-use-geckodriver/ 
	 * 
	 * http://stackoverflow.com/questions/37785686/how-to-use-the-gecko-executable-with-selenium
	 */
	
	/*
	 * Onde baixar o Chrome Driver
	 * 
	 * https://chromedriver.storage.googleapis.com/index.html?path=2.29/
	 */
}