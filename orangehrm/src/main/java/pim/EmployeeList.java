package pim;

import org.openqa.selenium.By;

import common.CommonPage;
import utils.CheckUtil;
import utils.ClickUtil;
import utils.ReportUtil;
import utils.WaitUtil;

public class EmployeeList {
	
	private static By LOC_BT_ADD = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
	private static By LOC_WL_EMPLOYEE_INFO_PANEL = By.xpath("//*[text()='Employee Information' or text()='Personal Details']//ancestor::*[@class='orangehrm-background-container']");
	
	
	private CommonPage test;
	public EmployeeList(CommonPage test) {

		this.test = test;
		
		WaitUtil.waitForElementPresent(test, LOC_WL_EMPLOYEE_INFO_PANEL, 15,  "The employee list tab is not loaded successfully");
		if(!CheckUtil.isElementPresent(test, LOC_WL_EMPLOYEE_INFO_PANEL)) {
			ReportUtil.fail(test, "The employee list tab is not loaded successfully");
		}
	
	}
	
	/**
	 * To click on the add button
	 */
	
	public void clickAddButton() {
		ClickUtil.clickButtonOrFail(test, LOC_BT_ADD, "Unable to click on the Add button");
		test.waitForPageLoading(20);
	}
	

}
