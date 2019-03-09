package wysh.selenium.testcase;

import org.testng.annotations.Test;



import okio.Timeout;
import wysh.selenium.base.DriverBase;
import wysh.selenium.business.HomePagePro;
import wysh.selenium.business.LoginPro;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;

public class TestLogin extends CaseBase{
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
//	    String url = "http://wysh.site";
	    driver.get(url);
	    try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	@Parameters({"username","password"})
	public void  testlogin(String username,String password) {
		loginpro.login(username, password);
	}
    
//	@Test(dependsOnMethods=("testlogin"))
//	public void homepagetest() {
//		homepagepro.AssertLogin(username)
//		
//	}


  @AfterClass
  public void clodse(){
		driver.close();
	}


}
