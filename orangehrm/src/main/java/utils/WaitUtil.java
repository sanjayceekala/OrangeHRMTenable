package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.SeleniumTest;

public class WaitUtil {
	
	/**
	 * To wait for the element visible for a given timeout
	 * @param test
	 * @param loc
	 * @param timeout
	 * @param message - To be printed in the logs in case of failure
	 */

	public static void waitForElementVisible(SeleniumTest test, By loc, int timeout, String message) {

		WebDriverWait wait = new WebDriverWait(test.returnDriver(), Duration.ofSeconds(timeout));

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(loc));
			ReportUtil.reportPassed(test, "The desired element is visible");
		} catch (Exception e) {
			ReportUtil.report(test, message);
		}

	}
	
	/**
	 * To wait for the element present for a given timeout
	 * @param test
	 * @param loc
	 * @param timeout
	 * @param message -  To be printed in the logs in case of failure
	 */
	
	public static void waitForElementPresent(SeleniumTest test, By loc, int timeout, String message) {

		WebDriverWait wait = new WebDriverWait(test.returnDriver(), Duration.ofSeconds(timeout));

		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(loc));
			ReportUtil.reportPassed(test, "The desired element is present");
		} catch (Exception e) {
			ReportUtil.report(test, message);
		}

	}
	
	/**
	 * To wait for the element not visible for a given timeout
	 * @param test
	 * @param loc
	 * @param timeout
	 * @param message -  To be printed in the logs in case of failure
	 */
	
	public static void waitForElementNotVisible(SeleniumTest test, By loc, int timeout, String message) {

		WebDriverWait wait = new WebDriverWait(test.returnDriver(), Duration.ofSeconds(timeout));

		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(loc));
			ReportUtil.reportPassed(test, "The desired element is not visible");
		} catch (Exception e) {
			ReportUtil.report(test, message);
		}

	}
	
}
