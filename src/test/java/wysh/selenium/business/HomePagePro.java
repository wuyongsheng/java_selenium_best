package wysh.selenium.business;

import wysh.selenium.base.DriverBase;
import wysh.selenium.handle.HomePageHandle;

public class HomePagePro {
	public HomePageHandle hph;
	public HomePagePro(DriverBase driver) {
		hph = new HomePageHandle(driver);
	}
	public Boolean AssertLogin(String username) {
		if(hph.getProfileName().equals(username)) {
			return true;
		}
		return false;
	}
}
