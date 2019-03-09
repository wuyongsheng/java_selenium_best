package wysh.selenium.handle;

import wysh.selenium.base.DriverBase;
import wysh.selenium.page.HomePage;

public class HomePageHandle {
	public DriverBase driver;
	public HomePage hp;
	public HomePageHandle(DriverBase driver) {
		this.driver = driver;
		this.hp = new HomePage(driver);
	}
	
	public void clickLogout() {
		hp.click(hp.getLogoutElement());
	}

	public void clickNameInfo() {
		hp.click(hp.getNameInfoElement());
	}
	public String getProfileName() {
	return	hp.getText(hp.getProfileNameElement());
	}
}
