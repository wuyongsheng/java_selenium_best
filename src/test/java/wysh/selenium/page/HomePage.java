package wysh.selenium.page;

import org.openqa.selenium.WebElement;

import wysh.selenium.base.DriverBase;
import wysh.selenium.util.getByLocator;

public class HomePage extends BasePage{
	public HomePage(DriverBase driver) {
		super(driver);
	}
	/**
	 * 获取用户信息
	 * @return WebElement
	 */
	public WebElement getNameInfoElement() {
		return element(getByLocator.getLocator("nameinfo"));
	}
	/**
	 * 获取用户详细信息中用户名元素
	 * @return WebElement
	 */
    public WebElement getProfileNameElement() {
    	return element(getByLocator.getLocator("profilename"));
    }
	/**
	 * 获取退出按钮元素
	 * @return WebElement
	 */
	public WebElement getLogoutElement() {
		return element(getByLocator.getLocator("logout"));
	}
    /**
     * 获取“测试”TAB元素
     * @return WebElement
     */
    public WebElement getTestTabElement() {
    	return element(getByLocator.getLocator("testTabElement"));
    }
    /**
     * 获取产品下拉框按钮元素
     * @return WebElement
     */
    public WebElement getListProductElement() {
    	return element(getByLocator.getLocator("listProductElement"));
    }
    /**
     * 获取产品元素
     * @return WebElement
     */
    public WebElement getChooseProductElement() {
    	return element(getByLocator.getLocator("chooseProductElement"));
    }
    /**
     * 获取“由我创建”TAB元素
     * @return WebElement
     */
    public WebElement getBugByMeElement() {
    	return element(getByLocator.getLocator("bugByMeElement"));
    }
    /**
     * 获取由我创建的bug数量元素
     * @return WebElement
     */
    public WebElement getBugByMeCountElement() {
    	return element(getByLocator.getLocator("bugByMeCountElement"));
    }
    /**
     * 获取“提BUG”按钮元素
     * @return WebElement
     */
    public WebElement getBElement() {
    	return element(getByLocator.getLocator("bElement"));
    }
    /**
     * 获取所属产品输入框元素
     * @return WebElement
     */
    public WebElement getProElement() {
    	return element(getByLocator.getLocator("proElement"));
    }
    /**
     * 获取产品名称元素
     * @return WebElement
     */
    public WebElement getProductElement() {
    	return element(getByLocator.getLocator("productElement"));
    }
    /**
     * 获取影响版本元素
     * @return WebElement
     */
    public WebElement getEffectVersionElement() {
    	return element(getByLocator.getLocator("effectVersionElement"));
    }
    /**
     * 获取版本元素
     * @return WebElement
     */
    public WebElement getVersionElement() {
    	return element(getByLocator.getLocator("versionElement"));
    }
    /**
     * 获取Bug标题输入框元素
     * @return WebElement
     */
    public WebElement getTitleElement() {
    	return element(getByLocator.getLocator("titleElement"));
    }
    /**
     * 获取Bug详细信息输入框fragment元素
     * @return WebElement
     */
    public WebElement getFrameEmlement() {
    	return element(getByLocator.getLocator("frameEmlement"));
    }
    /**
     * 获取Bug详细信息输入框元素
     * @return WebElement
     */
    public WebElement getBodyElement() {
    	return element(getByLocator.getLocator("bodyElement"));
    }
    /**
     * 获取提交Bug按钮元素
     * @return WebElement
     */
    public WebElement getSubmitElement1() {
    	return element(getByLocator.getLocator("submitElement1"));
    }
    /**
     * 获取“由我创建”TAB元素
     * @return WebElement
     */
    public WebElement getBugByMeElement2() {
    	return element(getByLocator.getLocator("bugByMeElement2"));
    }
    /**
     * 获取由我创建的Bug数量元素
     * @return WebElement
     */
    public WebElement getBugByMeCountElement2() {
    	return element(getByLocator.getLocator("bugByMeCountElement2"));
    }
}
