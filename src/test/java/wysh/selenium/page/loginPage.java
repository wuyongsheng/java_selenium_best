package wysh.selenium.page;

import org.openqa.selenium.WebElement;

import wysh.selenium.base.DriverBase;
import wysh.selenium.util.getByLocator;

public class loginPage extends BasePage {

	public loginPage(DriverBase driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	/**
	 * 获取用户名输入框元素
	 * @return WebElement
	 */
	public WebElement getUserNameElement() {
		return element(getByLocator.getLocator("username"));
	}
	/**
	 * 获取密码输入框元素
	 * @return WebElement
	 */
	public WebElement getPasswordElement() {
		return element(getByLocator.getLocator("userpass"));
	}
	/**
	 * 获取登录按钮元素
	 * @return WebElement
	 */
	public WebElement  getLoginButtonElement() {
		return element(getByLocator.getLocator("loginbutton"));
	}

}
