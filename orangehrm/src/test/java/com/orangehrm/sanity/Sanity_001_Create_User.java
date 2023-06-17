package com.orangehrm.sanity;

import java.util.Random;

import org.testng.annotations.Test;

import admin.UserManagement;
import common.CommonPage;
import leftpanel.LeftPanel;
import leftpanel.LeftPanel.SidePanelTabs;
import leftpanel.LeftPanel.SubTabs;
import login.Login;
import pim.AddEmployee;
import pim.EmployeeList;

/**
Launch the application (URL : https://opensource-demo.orangehrmlive.com/)
Login to the Application (Admin/admin123)
Click on PIM tab
Click on Add button in the Employee list tab
Enter the Employee FirstName and Lastname
Click on Create Login Details toggle button
Enter the Login details
Click on Save button
Donot Enter Personal Details
Click on the admin tab
Click on the user management tab
Enter the username used to create the employee and Validate the employee is created successfully
@author sanjay
 *
 */

public class Sanity_001_Create_User extends CommonPage {
	
	@Test
	public void test() throws InterruptedException {
		
		Login login = new Login(this);
		login.actionLogin();
		
		LeftPanel leftPanel = new LeftPanel(this);
		leftPanel.clickSidePanelTab(SidePanelTabs.PIM);
		leftPanel.clickSubTabs(SubTabs.EMPLOYEE_LIST);
		
		EmployeeList eList = new EmployeeList(this);
		eList.clickAddButton();
		
		AddEmployee aEmployee = new AddEmployee(this);
		
		Random rand = new Random();
		String firstName = "Sanjay";
		String lastName = "Ceekala" + rand.nextInt(99999);
		String userName = firstName + lastName;
		
		aEmployee.fillEmployeeFullName(firstName, lastName);
		aEmployee.toggleCreateLoginDetails(true);
		aEmployee.fillUsername(userName);
		aEmployee.fillPassword(password);
		aEmployee.clickSaveButton();
		
		leftPanel.clickSidePanelTab(SidePanelTabs.Admin);
		
		UserManagement uManagement = new UserManagement(this);
		uManagement.fillUsername(userName);
		uManagement.clickSearchButton();
		uManagement.validateUserSearchResults(userName);
		
		
		
	}

}
