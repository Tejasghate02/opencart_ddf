package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadData {

	//method to read data from config.properties file
	public static String readPropertyFile(String value) throws IOException {
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("/Users/kalyanighate/eclipse-workspace/opencart/testData/config.properties");
		prop.load(file);
		return prop.getProperty(value);
	}
	
	//method to read exel data 
}
