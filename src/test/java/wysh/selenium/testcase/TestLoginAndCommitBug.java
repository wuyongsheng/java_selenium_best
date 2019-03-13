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

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TestLoginAndCommitBug extends CaseBase{
	public DriverBase driver;
	public LoginPro loginpro;
	public HomePagePro homepagepro;
	
	@BeforeMethod
	public void loginTest() {
		log.info("初始化浏览器，开始一次新的 test ！！！");
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
 /*
     * 参数化，使用dataProvider读取excel数据，包括用户名、密码、Bug标题、Bug详细信息
     * */
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
        log.info("读取的 Excel数据信息为："+data.toString());
        String username=data.get("username");
        String password=data.get("password");
        String bugtitle=data.get("bugtitle");
        String bugdetail=data.get("bugdetail");
//        log.error("username is :"+username);
        log.info("登录用户名是 :"+username);
//        System.out.println("username is :"+username);
//        log.error("password is :"+password);
        log.info("登录密码是  :"+password);
//        System.out.println("password is :"+password);
        log.info("Bug的标题是 :"+bugtitle);
        log.info("Bug的详细信息是 :"+bugdetail);
        loginpro.login(username, password);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		homepagepro.submitBug(bugtitle,bugdetail);
		int beforecount1= Integer.parseInt(homepagepro.beforeCount);
		int aftercount1= Integer.parseInt(homepagepro.afterCount);
		/*
		 * 对测试用例执行之前的 Bug 数量以及测试用例执行之后的 Bug 数量进行断言
		 * */
		assertEquals(aftercount1, beforecount1+1);
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
  @AfterMethod
  public void close(){
	  log.info("关闭浏览器，本次 test 结束 ！！！");
		driver.close();
	}


}
