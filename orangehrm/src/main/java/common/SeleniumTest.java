package common;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import utils.FileUtil;
import utils.ReportUtil;

public class SeleniumTest {

	protected static String userDir = System.getProperty("user.dir");
	protected WebDriver driver;
	protected SoftAssert sAssert;
	protected ExtentReports extentReport;
	protected ExtentTest extentTest;
	protected String testName;
	private int screenShotNo;
	private static String allureResults = userDir + "/allure-results";

	public SeleniumTest() {

		testName = this.getClass().getName();
		System.out.println("testName : " + testName);

		sAssert = new SoftAssert();

		extentReport = new ExtentReports(userDir + "/extentreports/" + testName + ".html", true);
		extentTest = extentReport.startTest(testName);

		FileUtil.createDirectory(this, userDir + "/screenshots/" + testName);

	}
	
	/**
	 * To return the Webdriver instance
	 * @return
	 */

	public WebDriver returnDriver() {
		return driver;
	}
	
	/**
	 * To return the SoftAssert instance
	 * @return
	 */

	public SoftAssert returnSoftAssert() {

		return sAssert;
	}
	
	/**
	 * To return the ExtentTest instance
	 * @return
	 */

	public ExtentTest returnExtentTest() {
		return extentTest;
	}
	
	/**
	 * To capture the screenshot
	 * @return
	 */

	public String takeScreenShot() {

		TakesScreenshot screenShot = (TakesScreenshot) driver;
		File srcFile = screenShot.getScreenshotAs(OutputType.FILE);
		try {
			String destFile = userDir + "/screenshots/" + testName + "/" + screenShotNo + ".png";
			FileUtils.copyFile(srcFile, new File(destFile));
			screenShotNo++;
			return destFile;
		} catch (IOException e) {
			ReportUtil.fail(this, "Unable to take the screenshot");
			return "";
		}
	}
	

	@BeforeSuite
	public void suiteExecutionSetUp() {

		FileUtil.deleteDirectory(this, allureResults);
		FileUtil.createDirectory(this, userDir + "/screenshots");
		FileUtil.createDirectory(this, userDir + "/extentreports");

	}

}
