package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import common.SeleniumTest;

public class ClickUtil {
	
	/**
	 * To click on the button webelement
	 * @param test
	 * @param loc - By locator
	 * @param message - failure message to print in the logs
	 */

	public static void clickButtonOrFail(SeleniumTest test, By loc, String message) {

		WebElement elem = test.returnDriver().findElement(loc);
		clickButtonOrFail(test, elem, message);

	}
	
	/**
	 * To click on the button webelement
	 * @param test
	 * @param elem - WebElement to click
	 * @param message - failure message to print in the logs
	 */

	public static void clickButtonOrFail(SeleniumTest test, WebElement elem, String message) {

		if (elem != null) {
			elem.click();
			ReportUtil.reportPassed(test, "The desired element is clicked");
		} else {
			ReportUtil.reportFailed(test, message);
		}

	}

}
