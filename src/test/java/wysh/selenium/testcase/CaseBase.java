package wysh.selenium.testcase;

import wysh.selenium.base.DriverBase;
import wysh.selenium.util.LogsInit;

public class CaseBase extends LogsInit{
	public DriverBase InitDriver(String browser) {
		return new DriverBase(browser);
	}

}
