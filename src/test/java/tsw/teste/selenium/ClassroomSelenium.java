package tsw.teste.selenium;

public class ClassroomSelenium {
	
	private SeleniumTest selenium;
	
	private static final String		URL_CLASSROOM_PSC_2019_2 = "https://classroom.google.com/u/1/c/Mzc0NDMzMjk4MTha";
	
	public ClassroomSelenium() {
		this.selenium = new SeleniumTest();
		this.selenium.doNothing();
		this.selenium.accessURL(URL_CLASSROOM_PSC_2019_2);
	}
	
}