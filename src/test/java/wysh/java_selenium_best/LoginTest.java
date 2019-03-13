package wysh.java_selenium_best;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LoginTest {
	public WebDriver driver = new ChromeDriver();


	public boolean isAlertPersent(){
	    try {
	    	driver.switchTo().alert();
	    	 System.out.println("有弹出框！！！");
	        return true;
	    }catch (NoAlertPresentException e){
	    	 System.out.println("没有弹出框！！！");
	    	return false;}
	}



	public void closeAllALert(){
	    while (isAlertPersent()){
	    	driver.switchTo().alert().accept();
	        try {
	            Thread.sleep(1000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	}

	  @Test
	  public void Login() {

//		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.get("http://127.0.0.1/zentao/user-login.html");
		  try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

//		  try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		  driver.manage().window().maximize();
		  WebElement  nameElement = driver.findElement(By.id("account"));
		  nameElement.clear();
		  nameElement.sendKeys("user7");
		  WebElement  passElement = driver.findElement(By.name("password"));
		  passElement.clear();
		  passElement.sendKeys("Gg1234");
		  WebElement  submitElement = driver.findElement(By.id("submit"));
		  submitElement.click();
		  closeAllALert();
//		//登录失败会弹出alert，下面的方法用来处理alert
////			lph.switchToActive();
//			boolean flag = false;
//	        Alert alert = null;
//	        try {
//
//	            new WebDriverWait(driver, 10).until(ExpectedConditions
//	                    .alertIsPresent());
//	            alert = driver.switchTo().alert();
//	            System.out.println("有弹出框！！！");
//	            flag = true;
//	            // alert.accept();
//	        } catch (NoAlertPresentException NofindAlert) {
//	            // TODO: handle exception
//	        System.out.println("没有弹出框！！！");
//	            NofindAlert.printStackTrace();
//	            // throw NofindAlert;
//	        }
//
//	        if (flag) {
//	            alert.accept();
//	        }
		  
//	        driver.close();
//	        WebDriver driver = new ChromeDriver();
//	        driver.get("http://127.0.0.1/zentao/user-login.html");
		  try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		  driver.manage().window().maximize();
//		  WebElement  nameElement = driver.findElement(By.id("account"));
		  nameElement.clear();
		  nameElement.sendKeys("user6");
//		  WebElement  passElement1 = driver.findElement(By.name("password"));
		  passElement.clear();
		  passElement.sendKeys("Ff1234");
//		  WebElement  submitElement1 = driver.findElement(By.id("submit"));
		  submitElement.click();
		  try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  driver.close();
	  }
}