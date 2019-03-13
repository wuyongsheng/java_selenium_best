package wysh.selenium.business;

import wysh.selenium.base.DriverBase;
import wysh.selenium.handle.HomePageHandle;
import wysh.selenium.util.LogsInit;

public class HomePagePro extends LogsInit{
	public HomePageHandle hph;
	public String beforeCount;
	public String afterCount; 
	public HomePagePro(DriverBase driver) {
		hph = new HomePageHandle(driver);
	}
	/**
	 * 判断是否登录成功
	 * @param username
	 * @return
	 */
	public Boolean AssertLogin(String username) {
		if(hph.getProfileName().equals(username)) {
			return true;
		}
		return false;
	}
	public void submitBug(String bugtitle,String bugdetail){{
		log.info("提交bug开始了!!!!");
		hph.sleep(1000);
		hph.clickTestTabElement();
		hph.sleep(1000);
		hph.clickListProductElement();
		hph.sleep(2000);
		hph.clickChooseProductElement();
		hph.sleep(1000);
		hph.clickBugByMeElement2();
		hph.sleep(100);
		beforeCount = hph.getBugByMeCount();
		log.info("bug before count is :"+beforeCount);
		hph.sleep(1000);
		hph.clickBElement();
		hph.sleep(2000);
		hph.clickProElement();
		hph.sleep(2000);
		hph.clickProductElement();
		hph.sleep(1000);
		hph.clickEffectVersionElement();
		hph.sleep(2000);
		hph.clickVersionElement();
		hph.sendBugTitle(bugtitle);
		hph.sleep(1000);
		hph.switchToFrame();
		hph.sendBugDetail(bugdetail);
		hph.switchToDedault();
		hph.sleep(1000);
		hph.jsScroll();
		hph.sleep(1000);
		hph.clickSubmitElement1();
		hph.sleep(1000);
		hph.clickBugByMeElement2();
		afterCount = hph.getBugByMeCount2();
		log.info("bug after count is :"+afterCount);
		hph.sleep(2000);
		hph.clickNameInfo();
		hph.sleep(2000);
		hph.clickLogout();
		hph.sleep(2000);
	}
}
}
