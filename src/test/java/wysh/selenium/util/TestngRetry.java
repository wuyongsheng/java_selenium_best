package wysh.selenium.util;


import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;

public class TestngRetry extends LogsInit  implements IRetryAnalyzer{
	private static int maxRetryCount = 3;
    private int retryCount = 1;
    public boolean retry(ITestResult result) {
//    	System.out.println(result);
    	log.info(result);
        if (retryCount <= maxRetryCount) {
        	log.info("重试第："+retryCount+"次！");
            String message = "Running retry for '" + result.getName()
                    + "' on class " + this.getClass().getName() + " Retrying "
                    + retryCount + " times";
            Reporter.setCurrentTestResult(result);
            Reporter.log("RunCount=" + (retryCount + 1));
            retryCount++;
            return true;
        }
        return false;
    }
}
