package utils;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import common.SeleniumTest;

public class ReportUtil {

	private static ExtentTest extentTest;
	private static SoftAssert sAssert;

	private static void setVariables(SeleniumTest test) {

		extentTest = test.returnExtentTest();
		sAssert = test.returnSoftAssert();
	}
	
	/**
	 * To report pass event in the logs & reports without aborting the execution
	 * @param test
	 * @param message
	 */

	public static void reportPassed(SeleniumTest test, String message) {

		setVariables(test);

		// Extent Reporting
		String imageFolderPath = test.takeScreenShot();
		String screenShot = extentTest.addScreenCapture(imageFolderPath);
		extentTest.log(LogStatus.PASS, message, screenShot);

		// TestNG Reporter & Allure report
		Reporter.log(message);
		sAssert.assertTrue(true, message);

	}
	
	/**
	 * To report fail event in the logs & reports without aborting the execution
	 * @param test
	 * @param message
	 */

	public static void reportFailed(SeleniumTest test, String message) {

		setVariables(test);

		// Extent Reporting
		String imageFolderPath = test.takeScreenShot();
		String screenShot = extentTest.addScreenCapture(imageFolderPath);
		extentTest.log(LogStatus.FAIL, message, screenShot);

		// TestNG Reporter & Allure report
		Reporter.log(message);
		sAssert.assertTrue(false, message);

	}
	
	/**
	 * To report fail event in the logs & reports and abort the execution
	 * @param test
	 * @param message
	 */

	public static void fail(SeleniumTest test, String message) {

		setVariables(test);

		// Extent Reporting
		String imageFolderPath = test.takeScreenShot();
		String screenShot = extentTest.addScreenCapture(imageFolderPath);
		extentTest.log(LogStatus.FAIL, message, screenShot);

		// TestNG Reporter & Allure report
		Reporter.log(message);
		Assert.fail(message);

	}
	
	/**
	 * To report info event in the logs & reports
	 * @param test
	 * @param message
	 */

	public static void report(SeleniumTest test, String message) {

		setVariables(test);

		// Extent Reporting
		String imageFolderPath = test.takeScreenShot();
		String screenShot = extentTest.addScreenCapture(imageFolderPath);
		extentTest.log(LogStatus.INFO, message, screenShot);

		// TestNG Reporter & Allure report
		Reporter.log(message);

	}

}
