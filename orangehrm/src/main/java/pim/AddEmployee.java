package pim;

import org.openqa.selenium.By;

import common.CommonPage;
import utils.CheckUtil;
import utils.ClickUtil;
import utils.FillUtil;
import utils.ReportUtil;
import utils.WaitUtil;

public class AddEmployee {

	private static By LOC_WL_ADD_EMPLOYEE_SECTION = By
			.xpath("//*[text()='Add Employee']//parent::*[@class='orangehrm-card-container']");
	private static By LOC_IN_FIRST_NAME = By.cssSelector("[name=firstName]");
	private static By LOC_IN_MIDDLE_NAME = By.cssSelector("[name=middleName]");
	private static By LOC_IN_LAST_NAME = By.cssSelector("[name=lastName]");
	private static By LOC_BT_CREATE_LOGIN_DETAILS_TOGGLER = By.xpath("//*[@class='oxd-switch-wrapper']");
	private static By LOC_IN_USERNAME = By
			.xpath("//*[text()='Username']//parent::div//following-sibling::div//input");
	private static By LOC_WL_PASSWORD_SECTION = By.xpath("//*[@class='oxd-form-row user-password-row']");
	private static By LOC_IN_PASSWORD = By.xpath("//*[text()='Password']//parent::div//following-sibling::div//input");
	private static By LOC_IN_CONFIRM_PASSWORD = By.xpath("//*[text()='Confirm Password']//parent::div//following-sibling::div//input");
	private static By LOC_BT_SAVE_BUTTON = By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");
	

	private CommonPage test;

	public AddEmployee(CommonPage test) {

		this.test = test;

		WaitUtil.waitForElementPresent(test, LOC_WL_ADD_EMPLOYEE_SECTION, 15, "The Add employee tab is not loaded successfully");
		if (!CheckUtil.isElementPresent(test, LOC_WL_ADD_EMPLOYEE_SECTION)) {
			ReportUtil.fail(test, "The Add employee tab is not loaded successfully");
		}

	}

	/**
	 * To fill the employee full name
	 * 
	 * @param firstName
	 * @param lastName
	 * @param middleName - Optional field. Enter if needs to be added
	 */

	public void fillEmployeeFullName(String firstName, String lastName, String... middleName) {

		FillUtil.fillInputOrFail(test, LOC_IN_FIRST_NAME, firstName, "Unable to fill the firstname");
		FillUtil.fillInputOrFail(test, LOC_IN_LAST_NAME, lastName, "Unable to fill the lastname");

		if (middleName.length == 1)
			FillUtil.fillInputOrFail(test, LOC_IN_MIDDLE_NAME, middleName[0], "Unable to fill the middlename");

	}
	
	/**
	 * To click on the Create login details button to appear/disappear the login details
	 * 
	 * @param createLoginDetails - true if login details to be entered / false if the details are not to be entered
	 */

	public void toggleCreateLoginDetails(boolean createLoginDetails) {

		boolean isPasswordSectionPresent = CheckUtil.isElementPresent(test, LOC_WL_PASSWORD_SECTION);

		if (createLoginDetails && isPasswordSectionPresent) {
			ReportUtil.reportPassed(test, "The toggler is already on");
		} else {
			if (createLoginDetails || isPasswordSectionPresent) {
				ClickUtil.clickButtonOrFail(test, LOC_BT_CREATE_LOGIN_DETAILS_TOGGLER,
						"Unable to click on the crean login details toggler");
				ReportUtil.reportPassed(test, "The toggle button is clicked");
			} else {
				ReportUtil.reportPassed(test, "The toggler is already on");
			}

		}
		
		WaitUtil.waitForElementPresent(test, LOC_IN_USERNAME, 2, "Username field is not present");

	}
	
	/**
	 * To Enter the username
	 * @param username
	 */
	
	public void fillUsername(String username) {
		FillUtil.fillInputOrFail(test, LOC_IN_USERNAME, username, "Unable to enter the username field");
	}
	
	/**
	 * To enter the password and confirm password
	 * @param password
	 */
	
	public void fillPassword(String password) {
		FillUtil.fillInputOrFail(test, LOC_IN_PASSWORD, password, "Unable to enter the password");
		FillUtil.fillInputOrFail(test, LOC_IN_CONFIRM_PASSWORD, password, "Unable to enter the confirm password");
	}
	
	/**
	 * To click on the save button
	 */
	
	public void clickSaveButton() {
		ClickUtil.clickButtonOrFail(test, LOC_BT_SAVE_BUTTON, "Unable to click on the save button");
		test.waitForPageLoading(10);
	}

}
