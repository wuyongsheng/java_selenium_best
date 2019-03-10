package wysh.selenium.handle;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import wysh.selenium.base.DriverBase;
import wysh.selenium.page.HomePage;

public class HomePageHandle {
	public DriverBase driver;
	public HomePage hp;
	/**
	 * 构造方法
	 * @param DriverBase driver
	 */
	public HomePageHandle(DriverBase driver) {
		this.driver = driver;
		this.hp = new HomePage(driver);
	}
	/**
	 * 点击退出登录按钮
	 */
	public void clickLogout() {
		hp.click(hp.getLogoutElement());
	}
	/**
	 * 点击用户名，弹出用户信息详情弹窗
	 */
	public void clickNameInfo() {
		hp.click(hp.getNameInfoElement());
	}
	/**
	 * 获取用户详情中的用户名
	 * @return String
	 */
	public String getProfileName() {
	    return	hp.getText(hp.getProfileNameElement());
	}
	/**
	 * 获取用户名
	 * @return String
	 */
	public String getUserName() {
		return hp.getText(hp.getNameInfoElement());
	}
	/**
	 * 点击“测试”TAB元素
	 */
	public void clickTestTabElement() {
		hp.click(hp.getTestTabElement());
	}
	/**
	 * 点击产品下拉框按钮元素
	 */
	public void clickListProductElement() {
		hp.click(hp.getListProductElement());
	}
	/**
	 * 点击产品元素
	 */
	public void clickChooseProductElement() {
		hp.click(hp.getChooseProductElement());
	}
	/**
	 * 获取由我创建的bug数量（未提bug之前）
	 */
	public String getBugByMeCount() {
		return hp.getText(hp.getBugByMeCountElement());
	}
	/**
	 * 点击“提BUG”按钮元素
	 */
	public void clickBElement() {
		hp.click(hp.getBElement());
	}
	/**
	 * 点击所属产品输入框元素
	 */
	public void clickProElement() {
		hp.click(hp.getProElement());
	}
	/**
	 * 点击影响版本输入框元素
	 */
	public void clickEffectVersionElement() {
		hp.click(hp.getEffectVersionElement());
	}
	/**
	 * 点击版本元素
	 */
	public void clickVersionElement() {
		hp.click(hp.getVersionElement());
	}
	/**
	 * 点击产品名称元素
	 */
	public void clickProductElement() {
		hp.click(hp.getProductElement());
	}
	/**
	 * 输入bug的标题信息
	 */
	public void sendBugTitle(String bugTitle) {
		hp.sendkeys(hp.getTitleElement(), bugTitle);
	}
	/**
	 * 切换到bug详情编辑框frame
	 */
	public void switchToFrame() {
		hp.switchFrame(hp.getFrameEmlement());
	}
	public void switchToDedault() {
		hp.switchDefault();
	}
	/**
	 * 拖动页面右侧到滚动条到bug提交按钮处
	 */
	public void jsScroll() {
	((JavascriptExecutor) driver.driver).executeScript("arguments[0].scrollIntoView(true);",hp.getSubmitElement1() );
		
	}
	/**
	 * 输入bug的详细信息
	 */
	public void sendBugDetail(String bugDetail) {
		hp.sendkeys(hp.getBodyElement(), bugDetail);
	}
	/**
	 * 点击提交bug按钮
	 */
	public void clickSubmitElement1() {
		hp.click(hp.getSubmitElement1());
	}
	/**
	 * 点击“由我创建”TAB
	 */
	public void clickBugByMeElement2() {
		hp.click(hp.getBugByMeElement2());
	}
	/**
	 * 获取由我创建的bug数量（提了bug之后）
	 */
	public String getBugByMeCount2() {
	   return hp.getText(hp.getBugByMeCountElement2());
	}
	/**
	 * 强制等待 
	 * @param long time
	 */
	public void sleep(long time) {
		try {
			Thread.sleep(time);
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
		hp.impliWait(time);
	}
}
