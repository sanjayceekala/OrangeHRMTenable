package admin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import common.CommonPage;
import utils.CheckUtil;
import utils.ClickUtil;
import utils.FillUtil;
import utils.ReportUtil;
import utils.WaitUtil;

public class UserManagement {
	
	private static By LOC_WL_SYSTEM_USERS_SECTION = By.xpath("//*[text()='System Users']//ancestor::div[@class='orangehrm-background-container']");
	private static By LOC_IN_USERNAME = By.xpath("//label[text()='Username']//parent::div//following-sibling::div//input");
	private static By LOC_DD_USERROLE = By.xpath("//label[text()='User Role']//parent::div//following-sibling::div//div[@class='oxd-select-text-input']");
	private static By LOC_IN_EMPLOYEE_NAME = By.xpath("//label[text()='Employee Name']//parent::div//following-sibling::div//input");
	private static By LOC_DD_STATUS = By.xpath("//label[text()='Status']//parent::div//following-sibling::div//div[@class='oxd-select-text-input']");
	private static By LOC_BT_SEARCH_BUTTON = By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");
	private static By LOC_WL_USER_SEARCH_RESULTS = By.cssSelector(".oxd-table-body div");
	
	private CommonPage test;
	public UserManagement(CommonPage test) {
		this.test = test;
		
		WaitUtil.waitForElementPresent(test, LOC_WL_SYSTEM_USERS_SECTION, 30, "User Management");
		if(!CheckUtil.isElementPresent(test, LOC_WL_SYSTEM_USERS_SECTION))
			ReportUtil.fail(test, "User Management page loaded successfully");
	}
	
	/**
	 * To fill the username to search
	 * @param username
	 */
	
	public void fillUsername(String username) {
		FillUtil.fillInputOrFail(test, LOC_IN_USERNAME, username, "Username");
	}
	
	/**
	 * To select the user role to search
	 * @param userRole
	 */
	
	public void selectUserRole(String userRole) {
		FillUtil.fillInputOrFail(test, LOC_DD_USERROLE, userRole, "User role");
	}
	
	/**
	 * To enter the employee name to search
	 * @param employeeName
	 */
	
	public void fillEmployeeName(String employeeName) {
		FillUtil.fillInputOrFail(test, LOC_IN_EMPLOYEE_NAME, employeeName, "Employee name");
	}
	
	/**
	 * To select the status to search
	 * @param status
	 */

	public void selectStatus(String status) {
		FillUtil.fillInputOrFail(test, LOC_DD_STATUS, status, "Status");
	}
	
	/**
	 * To fill the system users details to search
	 * @param username
	 * @param userRole
	 * @param employeeName
	 * @param status
	 */
	
	public void fillSystemUsersDetails(String username, String userRole, String employeeName, String status) {
		fillUsername(username);
		selectUserRole(userRole);
		fillEmployeeName(employeeName);
		selectStatus(status);
	}
	
	/**
	 * To click on the search button
	 */
	
	public void clickSearchButton() {
		ClickUtil.clickButtonOrFail(test, LOC_BT_SEARCH_BUTTON, "Search button");
		test.waitForPageLoading(10);
	}
	
	/**
	 * To validate whether the user is present
	 * @param userNameOrEmployeeName
	 */
	
	public void validateUserSearchResults(String userNameOrEmployeeName) {
		WaitUtil.waitForElementVisible(test, LOC_WL_USER_SEARCH_RESULTS, 10, "User search results");
		List<WebElement> users = CheckUtil.findWebElements(test, LOC_WL_USER_SEARCH_RESULTS, "User search results");
		if(users.size() == 0) {
			ReportUtil.reportFailed(test, "No users are found");
			return;
		}
		
		boolean isUserPresent = false;
		for(WebElement user : users) {
			List<WebElement> userNameFields = user.findElements(By.cssSelector("div div"));
			if(userNameFields.get(1).getText().trim().equalsIgnoreCase(userNameOrEmployeeName) || 
					userNameFields.get(3).getText().trim().equalsIgnoreCase(userNameOrEmployeeName)) {
				ReportUtil.reportPassed(test, "The desired user is present in the result");
				isUserPresent = true;
				break;
			}
		}
		
		if(!isUserPresent)
			ReportUtil.reportFailed(test, "The user is not present in the list");
	}
}
