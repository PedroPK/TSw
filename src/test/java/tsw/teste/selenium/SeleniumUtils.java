package tsw.teste.selenium;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SeleniumUtils {
	
	private static final String CHROME_DRIVER_WINDOWS		=	"chromedriver.exe";
	private static final String CHROME_DRIVER_MAC			=	"chromedriver";
	
	private static final String WEBDRIVER_CHROME_DRIVER		=	"webdriver.chrome.driver";
	
	private static final String OS_MAC_OS_X					=	"Mac OS X";
	
	public static void setSystemPropertyChromeWebDriverOriginal() {
		// Get the Project Directory
		String path = System.getProperty("user.dir");
		
		String folderSeparator = System.getProperty("file.separator");
		
		String relativePath = 
			folderSeparator + "src" + 
			folderSeparator + "test" + 
			folderSeparator + "resources" + folderSeparator;
		
		String os = System.getProperty("os.name");
		
		String chromeDriver = CHROME_DRIVER_WINDOWS;
		if ( os.equals(OS_MAC_OS_X) ) {
			chromeDriver = CHROME_DRIVER_MAC;
		}
		
		System.setProperty(
			WEBDRIVER_CHROME_DRIVER, 
			path + relativePath + chromeDriver);
	}
	
	private static String getWebDriverPath() {
		Path path = Paths.get("." + File.separator + "libs" + File.separator + "chromedriver");
		String pathString = path.toString();
		return pathString;
	}
	
}