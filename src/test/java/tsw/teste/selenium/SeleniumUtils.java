package tsw.teste.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumUtils {
	
	private static final String OS_NAME						= "os.name";
	private static final String RESOURCES					= "resources";
	private static final String TEST						= "test";
	private static final String SRC							= "src";
	private static final String FILE_SEPARATOR				= "file.separator";
	private static final String USER_DIR					= "user.dir";
	private static final String CHROME_DRIVER_WINDOWS		=	"chromedriver.exe";
	private static final String CHROME_DRIVER_MAC			=	"chromedriver";
	private static final String CHROME_DRIVER_MAC_77		=	"chromedriver_77";
	private static final String WEBDRIVER_CHROME_DRIVER		=	"webdriver.chrome.driver";
	private static final String OS_MAC_OS_X					=	"Mac OS X";
	
	private static WebDriver aDriver;
	
	public static WebDriver getWebDriver() {
		if ( aDriver == null ) {
			aDriver = new ChromeDriver();
		}
		
		return aDriver;
	}
	
	public static void setWebDriver( WebDriver pWebDriver ) {
		if ( aDriver != null ) {
			aDriver.close();
		}
		
		aDriver = pWebDriver;
	}
	
	public static void closeWebDriver() {
		if ( aDriver != null ) {
			aDriver.close();
		}
	}
	
	public static WebElement findElementById(String pId) {
		return aDriver.findElement(By.id(pId));
	}
	
	public static List<WebElement> getElementsByName(String pNomeRadioButtons) {
		return aDriver.findElements(By.name(pNomeRadioButtons));
	}
	
	public static WebElement getElementByCssSelector(String pCssSelector) {
		return aDriver.findElement(By.cssSelector(pCssSelector));
	}
	
	public static void setSystemPropertyChromeWebDriverOriginal() {
		// Get the Project Directory
		String path = System.getProperty(USER_DIR);
		
		String folderSeparator = System.getProperty(FILE_SEPARATOR);
		
		String relativePath = 
			folderSeparator + SRC + 
			folderSeparator + TEST + 
			folderSeparator + RESOURCES + folderSeparator;
		
		String chromeDriver = getChromeDriverByOS();
		
		System.setProperty(
			WEBDRIVER_CHROME_DRIVER, 
			path + relativePath + chromeDriver);
	}

	private static String getChromeDriverByOS() {
		String os = System.getProperty(OS_NAME);
		
		String chromeDriver = CHROME_DRIVER_WINDOWS;
		if ( os.equals(OS_MAC_OS_X) ) {
			chromeDriver = CHROME_DRIVER_MAC_77;
		}
		
		return chromeDriver;
	}
	
	public static WebElement findElementByName(String pNome) {
		return aDriver.findElement(By.name(pNome));
	}
	
	/*private static String getWebDriverPath() {
		Path path = Paths.get("." + File.separator + "libs" + File.separator + "chromedriver");
		String pathString = path.toString();
		return pathString;
	}*/
	
}