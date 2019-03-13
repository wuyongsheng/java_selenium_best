package wysh.selenium.handle;

import wysh.selenium.base.DriverBase;
import wysh.selenium.page.loginPage;

public class LoginPageHandle {
	public DriverBase driver;
	public loginPage lp;
	/**
	 * 构造方法
	 * @param DriverBase driver
	 */
	public LoginPageHandle(DriverBase driver){
		this.driver = driver;
		lp = new loginPage(driver);
	}
	/**
	 * 输入用户名信息
	 * @param String username
	 */
	public void sendKeysUserName(String username) {
		lp.sendkeys(lp.getUserNameElement(), username);
	}
	/**
	 * 清除输入框中的用户名信息
	 */
    public void clearKeysUserName() {
    	lp.clearKeys(lp.getUserNameElement());
    }
	/**
	 * 输入密码
	 * @param String password
	 */
	public void sendKeysPassword(String password) {
		lp.sendkeys(lp.getPasswordElement(), password);
	}
	/**
	 * 清除输入框中的密码
	 */
	public void clearKeysPassword() {
		lp.clearKeys(lp.getPasswordElement());
	}
	/**
	 * 点击登录按钮
	 */
	public void clickLoginButton() {
		lp.click(lp.getLoginButtonElement());
	}
	public void switchToActive() {
		if(driver.isAlertPresent()) {
			driver.switchToMode();
		}
	}
	/**
	 * 最大化窗口
	 */
	public void maxwin() {
		lp.maxwin();
	}
	/**
	 * 断言是否是登录页面
	 * @return boolean true 为是，false 为不是
	 */
	public boolean assertLoginPage() {
		return lp.assertElementIs(lp.getUserNameElement());
	}
	/**
	 * 强制等待 
	 * @param long time
	 */
	public void sleep(long d) {
		try {
			Thread.sleep(d);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 隐式等待
	 * @param time
	 */
	public void impliWait(int time) {
		lp.impliWait(time);
	}
}
