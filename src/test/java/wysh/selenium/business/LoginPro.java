package wysh.selenium.business;

import wysh.selenium.base.DriverBase;
import wysh.selenium.handle.LoginPageHandle;
import wysh.selenium.util.LogsInit;

public class LoginPro extends LogsInit{
	public DriverBase driver;
	public LoginPageHandle lph;
	public LoginPro(DriverBase driver) {
		this.driver = driver;
		lph = new LoginPageHandle(driver);
	}
	/**
	 * 登录操作
	 * @param String username
	 * @param String password
	 */
	public void login(String username ,String password) {
		lph.impliWait(10);
		if(lph.assertLoginPage()) {
			log.info("开始登录操作！！！");
			lph.maxwin();
			lph.sleep(1);
			lph.clearKeysUserName();
			lph.sendKeysUserName(username);
			lph.clearKeysPassword();
			lph.sendKeysPassword(password);
			lph.clickLoginButton();
		}
		else {
//			System.out.println("页面不存在或状态不正确");
			log.error("页面不存在或状态不正确");
		}
	}

}
