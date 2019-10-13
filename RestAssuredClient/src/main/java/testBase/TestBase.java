package testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import apiTestScript.UserTest;

/**
 * @author samarendra
 *
 */
public class TestBase {
	public static final int SUCCESS_RESPONSE_200 = 200;
	public static final int SUCCESS_RESPONSE_CREATED_201 = 201;
	public static final int SUCCESS_RESPONSE_NOCONTENT_204 = 204;
	public static Logger log;

	public static Properties prop;

	// Load properties file
	public TestBase(String className) throws IOException {
		log=LogManager.getLogger(className);
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/java/config/config.properties");
		prop.load(fis);

	}

}
