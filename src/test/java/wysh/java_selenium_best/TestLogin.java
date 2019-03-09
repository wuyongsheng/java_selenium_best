package wysh.java_selenium_best;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class TestLogin {
	public WebDriver driver;
  @Test
  public void Login() {
	  driver = new ChromeDriver();
	  driver.get("http://127.0.0.1/zentao/user-login.html");
	  try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  WebElement  nameElement = driver.findElement(By.id("account"));
	  nameElement.clear();
	  nameElement.sendKeys("user4");
	  WebElement  passElement = driver.findElement(By.name("password"));
	  passElement.clear();
	  passElement.sendKeys("Dd1234");
	  WebElement  submitElement = driver.findElement(By.id("submit"));
	  submitElement.click();
	  try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("start test !");
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
