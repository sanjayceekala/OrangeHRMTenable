package utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.SeleniumTest;

public class CheckUtil {

	private static WebDriver driver;

	public static void setDriver(SeleniumTest test) {
		driver = test.returnDriver();
	}

	/**
	 * To find the webelement
	 * 
	 * @param test
	 * @param loc
	 * @param message - failure message to print in the logs
	 * @return The webelement instance
	 */

	public static WebElement findWebElement(SeleniumTest test, By loc, String message) {

		setDriver(test);

		WebElement elem;

		try {
			elem = driver.findElement(loc);
			ReportUtil.reportPassed(test, "The desired element is clicked");
			return elem;
		} catch (Exception e) {
			ReportUtil.reportFailed(test, message);
			return null;
		}

	}

	/**
	 * To find the webelements
	 * 
	 * @param test
	 * @param loc
	 * @param message - failure message to print in the logs
	 * @return the list of webelements
	 */

	public static List<WebElement> findWebElements(SeleniumTest test, By loc, String message) {

		setDriver(test);

		List<WebElement> elems = driver.findElements(loc);

		if (elems.size() != 0) {
			ReportUtil.reportPassed(test, "The desired element is clicked");
			return elems;
		} else {
			ReportUtil.reportFailed(test, message);
			return null;
		}

	}

	/**
	 * To check if the webelement is present
	 * 
	 * @param test
	 * @param loc
	 * @param timeout
	 * @return
	 */

	public static boolean isElementPresent(SeleniumTest test, By loc) {

		setDriver(test);

		try {
			WebElement elem = driver.findElement(loc);
			return elem.isDisplayed();

		} catch (Exception e) {
			return false;
		}

	}

}
