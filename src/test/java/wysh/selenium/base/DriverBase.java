package wysh.selenium.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import wysh.selenium.base.DriverBase;

public class DriverBase {
    public WebDriver driver;
	public DriverBase(String browser) {
       SelectDriver select = new SelectDriver();
       driver = select.driverName(browser);
	}
	
	/*
	 * 获取driver
	 * */
	public WebDriver getDriver() {
		return driver;
	}
	
	public void close() {
		System.out.println("stop webdriver");
		driver.close();
	}
	
	/*
	 * 封装element
	 * */
	public WebElement findElement(By by) {
		WebElement element = driver.findElement(by);
		return element;
	}
	
	/*
	 * 封装定位一组元素的方法
	 * */
	public List<WebElement> findElements(By by){
		return driver.findElements(by);
	}
	
	/*
	 * 自动截图
	 * */
	public void takeScreenShot() {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		System.out.println(date);
		String dateStr = sf.format(date);
		System.out.println(dateStr);
		String path = this.getClass().getSimpleName()+"_"+dateStr+".png";
		System.out.println(path);
		takeScreenShot((TakesScreenshot) this.getDriver(), path);
	}
	
   /*
    * 传入参数截图
    * */
	public void takeScreenShot(TakesScreenshot drivername ,String path) {
		String currentPath = System.getProperty("user.dir");
		System.out.println(currentPath);
		File scrFile = drivername.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(currentPath+"\\"+path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			System.out.println("截图成功了！");
		}
	}
	
	/*
	 * get封装
	 * */
	public void get(String url) {
		driver.get(url);
	}
	
	/*
	 * 返回
	 * */
	public void back() {
		driver.navigate().back();
	}
	
	/*
	 * 点击
	 * */
	public void click(WebElement element) {
		element.click();
	}

	/*
	 * 返回当前url
	 * */
   public String getUrl() {
	   return driver.getCurrentUrl();
   }
   
   /*
    * 关闭浏览器
    * */
   public void close(WebDriver driver) {
	   driver.close();
   }
   
   /*
    * 获取当前窗口list
    * */
   public List<String> getWindowsHandles(){
	   Set<String> winHandles = driver.getWindowHandles();
	   List<String> handles = new ArrayList<String>(winHandles);
	   return handles;
   }
   
   /*
    * 获取当前窗口
    * */
   public String getWindowhandle() {
	   return driver.getWindowHandle();
   }
   
   /*
    * 切换Window窗口
    * */
  public void switchWindows(String name) {
	  driver.switchTo().window(name);
  }

  /*
   * 模态框切换
   * */
   public void switchToMode(){
	   driver.switchTo().activeElement();
   }
   
   /*
    * actionMoveElement
    * */
   public void action(WebElement element) {
	   Actions action = new Actions(driver);
	   action.moveToElement(element);
   }

   /*
    * 获取cookie
    * */
   public Set<Cookie> getCookie(){
	   Set<Cookie>  cookies = driver.manage().getCookies();
	   return cookies;
   }
   
   /*
    * 删除cookies
    * */
   public void deleteCookie() {
	   driver.manage().deleteAllCookies();
   }
   
   /*
    * 设置cookie
    * */
   public void setCookie(Cookie cookie) {
	   driver.manage().addCookie(cookie);
   }
   
   /*
    * 获取title
    * */
   public String getTitle() {
	   return driver.getTitle();
   }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        DriverBase db = new DriverBase("ddf");
        WebDriver dr = db.driver;
        dr.get("http://wysh.site");
//       db.takeScreenShot();
		db.takeScreenShot((TakesScreenshot) dr, "shot"+"//"+"123.png");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   dr.close();

	}

}
