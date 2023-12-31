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
	 * @param elemName
	 */

	public static void waitForElementVisible(SeleniumTest test, By loc, int timeout, String elemName) {

		WebDriverWait wait = new WebDriverWait(test.returnDriver(), Duration.ofSeconds(timeout));

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(loc));
			ReportUtil.reportPassed(test, elemName + " is visible");
		} catch (Exception e) {
			ReportUtil.report(test,  elemName + " is not visible");
		}

	}
	
	/**
	 * To wait for the element present for a given timeout
	 * @param test
	 * @param loc
	 * @param timeout
	 * @param elemName -  To be printed in the logs in case of failure
	 */
	
	public static void waitForElementPresent(SeleniumTest test, By loc, int timeout, String elemName) {

		WebDriverWait wait = new WebDriverWait(test.returnDriver(), Duration.ofSeconds(timeout));

		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(loc));
			ReportUtil.reportPassed(test, elemName + " is present");
		} catch (Exception e) {
			ReportUtil.report(test, elemName + " is not present");
		}

	}
	
	/**
	 * To wait for the element not visible for a given timeout
	 * @param test
	 * @param loc
	 * @param timeout
	 * @param elemName -  To be printed in the logs in case of failure
	 */
	
	public static void waitForElementNotVisible(SeleniumTest test, By loc, int timeout, String elemName) {

		WebDriverWait wait = new WebDriverWait(test.returnDriver(), Duration.ofSeconds(timeout));

		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(loc));
			ReportUtil.reportPassed(test, elemName + " is invisible");
		} catch (Exception e) {
			ReportUtil.report(test, elemName + " is visible");
		}

	}
	
}
