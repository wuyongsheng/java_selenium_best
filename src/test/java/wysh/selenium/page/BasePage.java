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
	public BasePage(DriverBase driver) {
		this.driver = driver ;
	}
	public WebElement element(By by) {
		WebElement  element = driver.findElement(by);
		return element;
	}
	
	public WebElement nodeElement( By by,By nodeby) {
		WebElement e1 = this.element(by);
		return e1.findElement(nodeby);
	}
	public WebElement nodeElement( WebElement e2,By nodeby) {
		return e2.findElement(nodeby);
	}
	
	public List<WebElement> elements(WebElement element,By by){
		return element.findElements(by);
	}
	 
	public void click(WebElement element) {
		if(element != null) {
			element.click();
		}else {
			System.out.println("元素没有定位到，点击失败！");
		}
	}
	
	public void sendkeys(WebElement element,String value) {
		if(element != null) {
			element.sendKeys(value);
		}else {
			System.out.println("元素没有定位到，输入失败"+value);
		}
	}
	
	public void clearKeys(WebElement element) {
		if(element != null) {
			element.clear();
		}
	}
	
	public boolean assertElementIs(WebElement element) {
		return  element.isDisplayed();
	}
	
	public String getText(WebElement element) {
		return element.getText();
	}
	
	public String getTitle() {
		return  driver.getTitle();
	}
	
	public void close() {
		driver.close();
	}
	
	public void maxwin() {
		driver.maxwin();
	}
	
	public List<String> getWindowsHandles(){
		List<String> handles = driver.getWindowsHandles();
		return handles;
	}
	
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
    
    public void action(WebElement element) {
    	driver.action(element);
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
