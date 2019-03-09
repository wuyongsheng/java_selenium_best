package wysh.selenium.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelectDriver {
		public WebDriver driverName(String browser) {
			if(browser.equalsIgnoreCase("firefox")) {
				return new FirefoxDriver();
			}else
			{
				return new ChromeDriver();
			}
			
		}
	

}
