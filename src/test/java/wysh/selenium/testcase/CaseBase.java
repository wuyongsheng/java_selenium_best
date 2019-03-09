package wysh.selenium.testcase;

import wysh.selenium.base.DriverBase;

public class CaseBase {
	public DriverBase InitDriver(String browser) {
		return new DriverBase(browser);
	}

}
