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
	 * @param elemName
	 */

	public static void fillInputOrFail(SeleniumTest test, By loc, String value, String elemName) {

		WebElement elem = test.returnDriver().findElement(loc);
		

		if (elem != null) {
			elem.clear();
			elem.sendKeys(value);
			ReportUtil.reportPassed(test, "The value is filled in the textbox :" + elemName);
		} else {
			ReportUtil.reportFailed(test, "The value is not filled in the textbox :" + elemName);
		}

	}
	
	/**
	 * To select the value in the dropdown using the visible text
	 * @param test
	 * @param loc
	 * @param text
	 * @param elemName
	 */

	public static void fillSelectByVisibleText(SeleniumTest test, By loc, String text, String elemName) {

		WebElement elem = test.returnDriver().findElement(loc);
		Select select = new Select(elem);
		
		try {
			select.selectByVisibleText(text);
			ReportUtil.reportPassed(test, "The dropdown value is selected in the field : " + elemName);
		}catch(Exception e) {
			ReportUtil.reportFailed(test,  "The dropdown value is not selected in the field : " + elemName);
		}
		
	}

}
