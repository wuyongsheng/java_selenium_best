package wysh.selenium.page;

import org.openqa.selenium.WebElement;

import wysh.selenium.base.DriverBase;
import wysh.selenium.util.getByLocator;

public class loginPage extends BasePage {

	public loginPage(DriverBase driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public WebElement getUserNameElement() {
		return element(getByLocator.getLocator("username"));
	}
	public WebElement getPasswordElement() {
		return element(getByLocator.getLocator("userpass"));
	}
	public WebElement  getLoginButtonElement() {
		return element(getByLocator.getLocator("loginbutton"));
	}

}
