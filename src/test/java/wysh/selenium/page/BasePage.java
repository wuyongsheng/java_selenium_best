package wysh.selenium.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import wysh.selenium.base.DriverBase;
import wysh.selenium.util.getByLocator;

public class BasePage {
	public DriverBase driver;
   /**
           * 构造函数
    * @param driver
    */
	public BasePage(DriverBase driver) {
		this.driver = driver ;
	}
	/**
	 * 定位元素
	 * @param  By
	 * @return WebElement
	 */
	public WebElement element(By by) {
		WebElement  element = driver.findElement(by);
		return element;
	}
	/**
	 * 层级定位，通过父节点定位到子节点
	 * 需要传入父节点和子节点的by
	 * @param By by
	 * @param By nodeby
	 * @return
	 */
	public WebElement nodeElement( By by,By nodeby) {
		WebElement e1 = this.element(by);
		return e1.findElement(nodeby);
	}
	/**
	 * 层级定位，通过父节点定位到子节点
	 * 需要传入父元素和子节点的by 
	 * @param WebElement e2
	 * @param By nodeby
	 * @return
	 */
	public WebElement nodeElement( WebElement e2,By nodeby) {
		return e2.findElement(nodeby);
	}
	/**
	 * 通过父元素定位一组元素
	 * @param WebElement element
	 * @param By by
	 * @return List<WebElement> 
	 */
	public List<WebElement> elements(WebElement element,By by){
		return element.findElements(by);
	}
	 /**
	  * 封装点击
	  * @param WebElement element
	  */
	public void click(WebElement element) {
		if(element != null) {
			element.click();
		}else {
			System.out.println("元素没有定位到，点击失败！");
		}
	}
	/**
	 * 封装输入
	 * @param WebElement element
	 * @param String value
	 */
	public void sendkeys(WebElement element,String value) {
		if(element != null) {
			element.sendKeys(value);
		}else {
			System.out.println("元素没有定位到，输入失败"+value);
		}
	}
	/**
	 * 清除输入的元素
	 * @param WebElement element
	 */
	public void clearKeys(WebElement element) {
		if(element != null) {
			element.clear();
		}
	}
	/**
	 * 判断元素是否显示
	 * @param WebElement element
	 * @return boolean
	 */
	public boolean assertElementIs(WebElement element) {
		return  element.isDisplayed();
	}
	/**
	 * 获取文本信息
	 * @param WebElement element
	 * @return String
	 */
	public String getText(WebElement element) {
		return element.getText();
	}
	/**
	 * 获取网页title
	 * @return String
	 */
	public String getTitle() {
		return  driver.getTitle();
	}
	/**
	 * 关闭浏览器
	 */
	public void close() {
		driver.close();
	}
	/**
	 * 切换到指定的 frame
	 * @param WebElement frame
	 */
	public void switchFrame(WebElement frame) {
		driver.switchFrame(frame);
	}
	/**
	 * 切换回默认的区域
	 * @param WebElement frame
	 */
	public void switchDefault() {
		driver.switchDefault();
	}
	
	public void jsScroll(WebElement e) {
		
	}
	/**
	 * 窗口最大化
	 */
	public void maxwin() {
		driver.maxwin();
	}
	/**
	 * 获取所以的窗口句柄
	 * @return List<String>
	 */
	public List<String> getWindowsHandles(){
		List<String> handles = driver.getWindowsHandles();
		return handles;
	}
	/**
	 * 根据网页标题切换到指定的窗口
	 * @param String windowTitle
	 * @return boolean true表示切换成功，false表示切换失败
	 */
    public boolean switchToWindow_Title(String windowTitle) {
    	boolean flag = false ;
    	try {
			String currentHandle = driver.getWindowhandle();
			List<String> handles = driver.getWindowsHandles();
			for(String s : handles) {
				if(s.equals(currentHandle)) {
					continue;
				}else {
					driver.switchWindows(s);
				if(driver.getTitle().contains(windowTitle)) {
					flag = true;
					System.out.println("切换window成功"+windowTitle);
					break;
				}else {
					continue;
				}
				}
			}
		} catch (NoSuchWindowException e) {
			// TODO Auto-generated catch block
			System.out.println("Window : "+ windowTitle+"没有找到"+e.fillInStackTrace());
			flag = false;
		}
    	return flag;
    }
    /**
     * action 事件
     * @param element
     */
    public void action(WebElement element) {
    	driver.action(element);
    }
    /**
     * 隐式等待
     * @param time
     */
	public void impliWait(int time) {
		driver.impliWait(time);
	}
}
