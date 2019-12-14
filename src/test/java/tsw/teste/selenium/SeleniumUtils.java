package tsw.teste.selenium;

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
	
	/*private static String getWebDriverPath() {
		Path path = Paths.get("." + File.separator + "libs" + File.separator + "chromedriver");
		String pathString = path.toString();
		return pathString;
	}*/
	
}