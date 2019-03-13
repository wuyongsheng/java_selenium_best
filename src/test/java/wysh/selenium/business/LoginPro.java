package wysh.selenium.business;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	public boolean isAlertPersent(){
	    try {
	    	driver.driver.switchTo().alert();
	    	 System.out.println("有弹出框！！！");
	        return true;
	    }catch (NoAlertPresentException e){
	    	return false;}
	}



	public void closeAllALert(){
	    while (isAlertPersent()){
	    	driver.driver.switchTo().alert().accept();
	        try {
	            Thread.sleep(1000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	}
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
//			lph.switchToActive();
			/*
			 * 登录失败会弹出alert，closeAllALert()方法用来处理alert
			 * */
			closeAllALert();
		}
		else {
//			System.out.println("页面不存在或状态不正确");
			log.error("页面不存在或状态不正确");
		}
	}

}
