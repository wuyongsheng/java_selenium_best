package wysh.selenium.util;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LogsInit {

	// protected final Log log = LogFactory.getLog(getClass());
	protected final Logger log = Logger.getLogger(getClass());
		

		public LogsInit() {
			try {
		        File directory = new File(".");
				PropertyConfigurator.configure(directory.getCanonicalPath()+"\\"+ "log4j.txt");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
//		public static void main(String[] args) {
//			LogsInit l = new LogsInit();
//			final Logger logger = Logger.getLogger(LogsInit.class.getName());
//			 logger.fatal("this is fatal!");
//		        // 错误
//		        logger.error("this is error!");
//		        // 警告
//		        logger.warn("this is warn!");
//		        // 信息
//		        logger.info("this is info!");
//		        // 调试
//		        logger.debug("this is debug!");
//		        // 追踪
//		        logger.trace("this is trace!");
//		}

}
