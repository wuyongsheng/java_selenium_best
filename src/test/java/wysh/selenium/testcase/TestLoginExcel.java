package wysh.selenium.testcase;

import org.testng.annotations.Test;

import jxl.read.biff.BiffException;
import wysh.selenium.base.DriverBase;
import wysh.selenium.business.HomePagePro;
import wysh.selenium.business.LoginPro;
import wysh.selenium.util.ExcelData;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TestLoginExcel extends CaseBase{
	public DriverBase driver;
	public LoginPro loginpro;
	public HomePagePro homepagepro;
	
	@BeforeClass
	public void loginTest() {
		this.driver = InitDriver("browser");
		driver.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		loginpro = new LoginPro(driver);
	    homepagepro = new HomePagePro(driver);
	    String url = "http://127.0.0.1/zentao/user-login.html";
	    driver.get(url);
	}

//	@Test
//	@Parameters({"username","password"})
//	public void  testlogin(String username,String password) {
//		loginpro.login(username, password);
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
    @DataProvider(name="user_from_excel")
    public Object[][] Numbers() throws BiffException, IOException{
        ExcelData e=new ExcelData("users", "user");
        return e.getExcelData();
    }
    @Test(dataProvider="user_from_excel")
    public void testLogin(HashMap<String, String> data){
//	    String url = "http://127.0.0.1/zentao/user-login.html";
//	    String url = "http://wysh.site";
//	    driver.get(url);
	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(data.toString());
        String username=data.get("username");
        String password=data.get("password");
        String bugtitle=data.get("bugtitle");
        String bugdetail=data.get("bugdetail");
//        log.error("username is :"+username);
        log.info("username is :"+username);
//        System.out.println("username is :"+username);
//        log.error("password is :"+password);
        log.info("password is :"+password);
//        System.out.println("password is :"+password);
        log.info("bugtitle is :"+bugtitle);
        log.info("bugdetail is :"+bugdetail);
        loginpro.login(username, password);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		homepagepro.submitBug(bugtitle,bugdetail);
    }
    
//    @Test(dependsOnMethods={"testLogin"})
//    public void testBugSubmit() {
//    	log.info("提交bug开始了!!!!");
//    	homepagepro.submitBug();
//    }
    
//	@Test(dependsOnMethods=("testlogin"))
//	public void homepagetest() {
//		homepagepro.AssertLogin(username)
//		
//	}
  @AfterClass
  public void close(){
		driver.close();
	}


}
