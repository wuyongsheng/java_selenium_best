package wysh.selenium.business;

import wysh.selenium.base.DriverBase;
import wysh.selenium.handle.LoginPageHandle;

public class LoginPro {
	public DriverBase driver;
	public LoginPageHandle lph;
	public LoginPro(DriverBase driver) {
		this.driver = driver;
		lph = new LoginPageHandle(driver);
	}
	public void login(String username ,String password) {
		if(lph.assertLoginPage()) {
			lph.maxwin();
			lph.clearKeysUserName();
			lph.sendKeysUserName(username);
			lph.clearKeysPassword();
			lph.sendKeysPassword(password);
			lph.clickLoginButton();
		}
		else {
			System.out.println("页面不存在或状态不正确");
		}
	}

}
