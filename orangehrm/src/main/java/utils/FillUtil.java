package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import common.SeleniumTest;

public class FillUtil {
	
	/**
	 * To fill the input in the text field
	 * @param test
	 * @param loc
	 * @param value
	 * @param message - failure message to print in the logs
	 */

	public static void fillInputOrFail(SeleniumTest test, By loc, String value, String message) {

		WebElement elem = test.returnDriver().findElement(loc);
		

		if (elem != null) {
			elem.clear();
			elem.sendKeys(value);
			ReportUtil.reportPassed(test, "The value is filled in the element");
		} else {
			ReportUtil.reportFailed(test, message);
		}

	}
	
	/**
	 * To select the value in the dropdown using the visible text
	 * @param test
	 * @param loc
	 * @param text
	 * @param message - failure message to print in the logs
	 */

	public static void fillSelectByVisibleText(SeleniumTest test, By loc, String text, String message) {

		WebElement elem = test.returnDriver().findElement(loc);
		Select select = new Select(elem);
		
		try {
			select.selectByVisibleText(text);
			ReportUtil.reportPassed(test, "The dropdown value is selected");
		}catch(Exception e) {
			ReportUtil.reportFailed(test, message);
		}
		
	}

}
