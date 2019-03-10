package wysh.selenium.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import wysh.selenium.util.LogsInit;

public class SelectDriver extends LogsInit {
		public WebDriver driverName(String browser) {
			if(browser.equalsIgnoreCase("firefox")) {
				log.info("start browser ，and browser is firefox !!!");
				return new FirefoxDriver();
			}else
			{
				log.info("start browser ，and browser is chrome !!!");
				return new ChromeDriver();
			}
			
		}
	

}
