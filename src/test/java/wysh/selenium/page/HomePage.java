package wysh.selenium.page;

import org.openqa.selenium.WebElement;

import wysh.selenium.base.DriverBase;
import wysh.selenium.util.getByLocator;

public class HomePage extends BasePage{
	public HomePage(DriverBase driver) {
		super(driver);
	}
	public WebElement getNameInfoElement() {
		return element(getByLocator.getLocator("nameinfo"));
	}
    public WebElement getProfileNameElement() {
    	return element(getByLocator.getLocator("profilename"));
    }
    public WebElement getLogoutElement() {
    	return element(getByLocator.getLocator("logout"));
    }
}
