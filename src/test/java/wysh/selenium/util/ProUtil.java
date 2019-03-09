package wysh.selenium.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ProUtil {
	
	private Properties prop;
	private String filepath;
	
	/*
	 * 构造方法
	 * */
	public ProUtil(String filepath) {
		this.filepath = filepath;
		this.prop = readProperties();
	}
	
	/*
	 * 读取配置文件
	 * */
	private Properties readProperties() {
		Properties properties = new Properties();
		try {
			InputStream inputstream = new FileInputStream(filepath);
			BufferedInputStream in = new BufferedInputStream(inputstream);
			properties.load(in);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return properties;
	}

	/*
	 * 根据key读取关键字内容
	 * */
	public String getPro(String key) {
		if(prop.containsKey(key)) {
			String username = prop.getProperty(key);
			return username;
		}else {
			System.out.println("你输入的key不对");
			return "";
		}
	}
	
	/*
	 * 写入内容
	 * */
	
	public void writePro(String key,String value) {
		Properties pro = new Properties();
		try {
			FileOutputStream file = new FileOutputStream(filepath);
			pro.setProperty(key, value);
			pro.store(file, key);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      ProUtil p = new ProUtil("element.properties");
      String s = p.getPro("addCart");
      System.out.println(s);
	}

}
