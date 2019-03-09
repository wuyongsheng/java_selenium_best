package wysh.selenium.util;

import org.openqa.selenium.By;

public class getByLocator {

	public static By getLocator(String key) {
		ProUtil pro = new ProUtil("element.properties");
		String Locator = pro.getPro(key);
		String LocatorType = Locator.split(">")[0];
		String LocatorValue = Locator.split(">")[1];
		
		if(LocatorType.equals("id")) {
			return By.id(LocatorValue);
		}else if (LocatorType.equals("name")) {
			return By.name(LocatorValue);
		}else if (LocatorType.equals("tagName")) {
			return By.tagName(LocatorValue);
		}else if (LocatorType.equals("linkTest")) {
			return By.linkText(LocatorValue);
		}else if (LocatorType.equals("className")) {
			return By.className(LocatorValue);
		}else {
			return By.xpath(LocatorValue);
		}
		
		
	}
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		getByLocator gy = new getByLocator();
//		
//
//	}

}
