package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import common.SeleniumTest;

public class ClickUtil {
	
	/**
	 * To click on the button webelement
	 * @param test
	 * @param loc - By locator
	 * @param elemName - failure message to print in the logs
	 */

	public static void clickButtonOrFail(SeleniumTest test, By loc, String elemName) {
		WebElement elem = test.returnDriver().findElement(loc);
		clickButtonOrFail(test, elem, elemName);

	}
	
	/**
	 * To click on the button webelement
	 * @param test
	 * @param elem - WebElement to click
	 * @param elemName - failure message to print in the logs
	 */

	public static void clickButtonOrFail(SeleniumTest test, WebElement elem, String elemName) {

		if (elem != null) {
			elem.click();
			ReportUtil.reportPassed(test, elemName + " is clicked");
		} else {
			ReportUtil.reportFailed(test, elemName + " is not clicked");
		}

	}

}
