package wysh.java_selenium_best;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Test1 {
	public WebDriver driver;
  @Test
  public void wysh() {
	  driver.get("http://wysh.site");
	  String title = driver.getTitle();
	  System.out.println("title  :"+title);
	  try {
		Thread.sleep(4000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
	  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("start test");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("after test");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("init browser");
	  driver = new ChromeDriver();
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("close browser");
	  driver.close();
  }

}
