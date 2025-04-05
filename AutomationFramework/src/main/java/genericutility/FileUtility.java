package genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author sushant.raj
 */
public class FileUtility {
	/**
	 * This method will read the data from property file and return the value in string format
	 * @param key
	 * @return value
	 * @throws IOException
	 */
	
	public String getDataFromProperty(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData/commonadata.properties");
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(key);
	}


}
