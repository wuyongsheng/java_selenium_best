package wysh.java_selenium_best;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class TestLogin {
	public WebDriver driver;
  @Test
  public void Login() {
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("http://127.0.0.1/zentao/user-login.html");
//	  try {
//		Thread.sleep(3000);
//	} catch (InterruptedException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	  driver.manage().window().maximize();
	  WebElement  nameElement = driver.findElement(By.id("account"));
	  nameElement.clear();
	  nameElement.sendKeys("user7");
	  WebElement  passElement = driver.findElement(By.name("password"));
	  passElement.clear();
	  passElement.sendKeys("Gg1234");
	  WebElement  submitElement = driver.findElement(By.id("submit"));
	  submitElement.click();
//	  try {
//		Thread.sleep(3000);
//	} catch (InterruptedException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	WebElement testTabElement = driver.findElement(By.xpath("//*[@id=\"navbar\"]/ul/li[4]/a"));
	testTabElement.click();
	 try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//	 WebElement bugElement = driver.findElement(By.xpath("//*[@id=\"subNavbar\"]/ul/li[1]/a"));
//	 bugElement.click();
	 WebElement listProductElement = driver.findElement(By.xpath("//*[@id=\"currentItem\"]/span"));
	 listProductElement.click();
	 try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	WebElement chooseProductElement = driver.findElement(By.xpath("//*[@id=\"dropMenu\"]/div[2]/div/div[1]/div[1]/a[3]"));
	chooseProductElement.click();
	 try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	 WebElement bugByMeElement = driver.findElement(By.xpath("//*[@id=\"mainMenu\"]/div[2]/a[3]/span[1]"));
	 bugByMeElement.click();
	 try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 WebElement bugByMeCountElement = driver.findElement(By.xpath("//*[@id=\"mainMenu\"]/div[2]/a[3]/span[2]"));
	 try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	String bugByMeCount= bugByMeCountElement.getText();
	System.out.println("bug count is "+ bugByMeCount);

	 WebElement bElement = driver.findElement(By.linkText("提Bug"));
	 bElement.click();
//	 try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	 
	 WebElement  proElement = driver.findElement(By.xpath("//*[@id=\"product_chosen\"]/a/span"));
	 proElement.click();
//	 try {
//		 Thread.sleep(2000);
//	 } catch (InterruptedException e) {
//		 // TODO Auto-generated catch block
//		 e.printStackTrace();
//	 }
	 WebElement  productElement = driver.findElement(By.xpath("//*[@id=\"product_chosen\"]/div/ul/li[2]"));
	 productElement.click();
//	 try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	 
//	 WebElement  allVersionElement = driver.findElement(By.xpath("//*[@id=\"all\"]"));
//	 allVersionElement.click();
//	 try {
//		 Thread.sleep(2000);
//	 } catch (InterruptedException e) {
//		 // TODO Auto-generated catch block
//		 e.printStackTrace();
//	 }
	 WebElement  effectVersionElement = driver.findElement(By.xpath("//*[@id=\"openedBuild_chosen\"]/ul"));
	 effectVersionElement.click();
//	 try {
//		 Thread.sleep(3000);
//	 } catch (InterruptedException e) {
//		 // TODO Auto-generated catch block
//		 e.printStackTrace();
//	 }
	 WebElement  eVersionElement = driver.findElement(By.xpath("//*[@id=\"openedBuild_chosen\"]/div/ul/li"));
	 eVersionElement.click(); 
	 WebElement   titleElement  = driver.findElement(By.id("title"));
	 titleElement.sendKeys("这是标题777，by user7");
	 WebElement frameEmlement = driver.findElement(By.className("ke-edit-iframe"));
	 driver.switchTo().frame(frameEmlement);
	 WebElement bodyElement = driver.findElement(By.tagName("body"));
	 bodyElement.sendKeys("这是bug 的详细信息，by user7");
	 driver.switchTo().defaultContent();
	 
	 WebElement submitElement1 = driver.findElement(By.id("submit"));
     ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",submitElement1 );

	 try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 submitElement1.click();
	 try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//	 System.out.println("get new  url !!!!");
//	 driver.quit();
//	 driver.get("http://127.0.0.1/zentao/bug-browse-2-0-openedbyme.html");
	//*[@id="product_chosen"]/div/ul/li[3]	 
	 
//	 WebElement  productElement = driver.findElement(By.id("product"));
//	 Select productSelect = new Select(productElement);
//	 System.out.println(productSelect.isMultiple());
//	 productSelect.selectByValue("2");
//	 driver.navigate().refresh();
//	 System.out.println("title is :"+driver.getTitle());
	 WebElement bugByMeElement2 = driver.findElement(By.xpath("//*[@id=\"mainMenu\"]/div[2]/a[3]/span[1]"));
	   bugByMeElement2.click();
		 try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 WebElement bugByMeCountElement2 = driver.findElement(By.xpath("//*[@id=\"mainMenu\"]/div[2]/a[3]/span[2]"));
		String bugByMeCount2= bugByMeCountElement2.getText();
		System.out.println("after bug count is "+ bugByMeCount2);
		int beforecount= Integer.parseInt(bugByMeCount);
		int aftercount= Integer.parseInt(bugByMeCount2);
		assertEquals(aftercount, beforecount+1);
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
