package common;

import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import utils.SecurityUtil;
import utils.WaitUtil;

public class CommonPage extends SeleniumTest {

	private static String url = returnPropertyFileValue("url");
	public static String userName = returnPropertyFileValue("username");
	public static String password = SecurityUtil.decryptText(returnPropertyFileValue("password"));
	private static By LOC_WL_PAGE_LOAD_SPINNER = By.cssSelector(".oxd-lmeoading-spinner");

	/**
	 * Read default Property file
	 * 
	 * @return
	 */

	public Properties readPropertyFile() {
		return readPropertyFile(userDir + "/Selenium.properties");
	}

	/**
	 * Read a specific property file
	 * 
	 * @param filePath
	 * @return
	 */

	public static Properties readPropertyFile(String filePath) {

		try {
			FileReader reader = new FileReader(filePath);

			Properties prop = new Properties();
			prop.load(reader);

			return prop;
		} catch (Exception e) {
			System.out.println("Exception found : " + e.getMessage());
			return null;
		}

	}

	/**
	 * Return the default property file value corresponding to a key
	 * 
	 * @param key
	 * @return
	 */

	public static String returnPropertyFileValue(String key) {

		return returnPropertyFileValue(userDir + "/Selenium.properties", key);

	}

	/**
	 * Return the specific property file value corresponding to a key
	 * 
	 * @param filePath
	 * @param key
	 * @return
	 */

	public static String returnPropertyFileValue(String filePath, String key) {
		Properties prop = readPropertyFile(filePath);
		return prop.getProperty(key);

	}

	@BeforeClass
	public void setUp() {
		initializeDriver();
		launchApplication();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		extentReport.endTest(extentTest);
		extentReport.flush();
	}

	/**
	 * Initialise the driver
	 */

	public void initializeDriver() {
		String browser = returnPropertyFileValue("browser");
		if (browser.trim().equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.gecko.driver", userDir + "/src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
	}

	/**
	 * Launch the application
	 */

	public void launchApplication() {
		driver.get(url);
		driver.manage().window().maximize();

	}

	/**
	 * Wait for the page to load and until the spinner disappears
	 * 
	 * @param timeOut
	 */

	public void waitForPageLoading(int timeOut) {
		WaitUtil.waitForElementNotVisible(this, LOC_WL_PAGE_LOAD_SPINNER, timeOut,
				"The spinner is still present after the duration");

	}

}
