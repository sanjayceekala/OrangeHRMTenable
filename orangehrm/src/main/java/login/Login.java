package login;

import org.openqa.selenium.By;

import common.CommonPage;
import utils.CheckUtil;
import utils.ClickUtil;
import utils.FillUtil;
import utils.ReportUtil;
import utils.WaitUtil;

public class Login {

	private CommonPage test;

	private static By LOC_IN_USERNAME = By.cssSelector("[name=username]");
	private static By LOC_IN_PASSWORD = By.cssSelector("[name=password]");
	private static By LOC_BT_LOGIN = By.cssSelector("[type=submit]");

	public Login(CommonPage test) {
		this.test = test;

		WaitUtil.waitForElementPresent(test, LOC_BT_LOGIN, 30, "Login Page is not loaded");
		if (!CheckUtil.isElementPresent(test, LOC_BT_LOGIN))
			ReportUtil.fail(test, "Login Page is not loaded");

	}
	
	/**
	 * To enter the username
	 */

	public void enterUserName() {
		FillUtil.fillInputOrFail(test, LOC_IN_USERNAME, CommonPage.userName, "Unable to enter the username");
	}
	
	/**
	 * To enter the password
	 */

	public void enterPassword() {
		FillUtil.fillInputOrFail(test, LOC_IN_PASSWORD, CommonPage.password, "Unable to enter the password");
	}
	
	/**
	 * To click on the login button
	 */

	public void clickLoginButton() {
		ClickUtil.clickButtonOrFail(test, LOC_BT_LOGIN, "Unable to click on the Login Button");
	}
	
	/**
	 * To perform login operation
	 */

	public void actionLogin() {
		enterUserName();
		enterPassword();
		clickLoginButton();
	}
}
