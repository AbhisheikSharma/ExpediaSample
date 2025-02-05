package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReaderClass {
	
	static protected File file;
	static protected FileInputStream fis;
	static protected Properties prop;
	
	public ConfigReaderClass() {
		file = new File("./Configurations/config.properties");
		try {
			fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Issues with reading properties file"+ e.getMessage());
		}	
	}
	public String readProp() {
		String str = prop.getProperty("appUrl");
		return str;
	}

}
