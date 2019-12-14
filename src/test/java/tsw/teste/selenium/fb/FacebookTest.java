package tsw.teste.selenium.fb;

import java.io.File;
import java.nio.file.Paths;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static tsw.teste.selenium.SeleniumUtils.*;

public class FacebookTest {
	
	//private static		WebDriver			aDriver;
	private static		FacebookSignUpPage	aFacebookPage;
	
	/**
	 * Values de WebElement Locators
	 */
	private static final String VALUE_OPTION_DIA_1				= "1";
	private static final String VALUE_OPTION_MES_02_FEVEREIRO	= "2";
	private static final String VALUE_RADIOBUTTON_MASCULINO		= "2";
	private static final String VALUE_OPTION_ANO_1983			= "1983";
	
	@Ignore
	//@BeforeClass
	public static void setSystemPropertyChromeWebDriver() {
		setSystemPropertyChromeWebDriverOriginal();
		
		//aDriver = new ChromeDriver();
		
		//aFacebookPage = new FacebookSignUpPage(aDriver);
		aFacebookPage = new FacebookSignUpPage();
		aFacebookPage.accessURL();
	}
	
	@BeforeClass
	public static void setSystemPropertyFirefoxWebDriver() {
		setSystemPropertyChromeWebDriverOriginal();
		
		//aDriver = new FirefoxDriver();
		
		//aFacebookPage = new FacebookSignUpPage(aDriver);
		aFacebookPage = new FacebookSignUpPage();
		aFacebookPage.accessURL();
	}
	
	@Test
	public void testSignUp() {
		aFacebookPage
			.preencherNome(				"SEU_NOME")
			.preencherSobrenome(		"SEU_SOBRENOME")
			.preencherEmail(			"INSIRA_AQUI_SEU_EMAIL")
			.preencherSenha(			"INSIRA_AQUI_SUA_SENHA")
			.selecionarDiaNascimento(	VALUE_OPTION_DIA_1)
			.selecionarMesNascimento(	VALUE_OPTION_MES_02_FEVEREIRO)
			.selecionarAnoNascimento(	VALUE_OPTION_ANO_1983)
			.selecionarGenero(			VALUE_RADIOBUTTON_MASCULINO);
		
		aFacebookPage.pressionarBotaoFormularioIncluirUsuario();
	}
	
	@Ignore
	@Test
	public void testLogIn() {
		aFacebookPage
			.preencherEmailLogin(FacebookSignUpPage.EMAIL)
			.preencherSenhaLogin(FacebookSignUpPage.SENHA);
		;
		
		aFacebookPage.pressionarBotaoEntrar();
	}
	
	@AfterClass
	public static void closeDriver() {
		closeWebDriver();
	}
}