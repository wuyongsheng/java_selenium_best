package wysh.selenium.handle;

import wysh.selenium.base.DriverBase;
import wysh.selenium.page.loginPage;

public class LoginPageHandle {
	public DriverBase driver;
	public loginPage lp;
	public LoginPageHandle(DriverBase driver){
		this.driver = driver;
		lp = new loginPage(driver);
	}
	public void sendKeysUserName(String username) {
		lp.sendkeys(lp.getUserNameElement(), username);
	}
    public void clearKeysUserName() {
    	lp.clearKeys(lp.getUserNameElement());
    }
	
	public void sendKeysPassword(String password) {
		lp.sendkeys(lp.getPasswordElement(), password);
	}
	
	public void clearKeysPassword() {
		lp.clearKeys(lp.getPasswordElement());
	}
	public void clickLoginButton() {
		lp.click(lp.getLoginButtonElement());
	}
	
	public boolean assertLoginPage() {
		return lp.assertElementIs(lp.getUserNameElement());
	}
}
