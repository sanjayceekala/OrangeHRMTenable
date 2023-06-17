package leftpanel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import common.CommonPage;
import utils.CheckUtil;
import utils.ClickUtil;
import utils.ReportUtil;
import utils.WaitUtil;

public class LeftPanel {

	private CommonPage test;
	
	private static By LOC_WL_SIDEPANEL = By.cssSelector(".oxd-sidepanel-body");
	private static By LOC_WL_SIDEPANEL_TABS = By.cssSelector(".oxd-sidepanel-body li span");
	private static By LOC_WL_SUBTABS = By.xpath("//a[@class='oxd-topbar-body-nav-tab-item']"); 
	
	
	public LeftPanel(CommonPage test) {
		this.test = test;
		
		WaitUtil.waitForElementPresent(test, LOC_WL_SIDEPANEL, 30, "Side Panel loaded successfully");
		if(!CheckUtil.isElementPresent(test, LOC_WL_SIDEPANEL))
			ReportUtil.fail(test, "Side Panel not loaded successfully");
	}
	
	/**
	 * Sidepanel tabs enum
	 * @author sanjay
	 *
	 */
	
	public enum SidePanelTabs{
		Admin,
		PIM
		
	}
	
	/**
	 * Sub tabs enum
	 * @author sanjay
	 *
	 */
	
	public enum SubTabs{
		EMPLOYEE_LIST("Employee List"),
		ADD_EMPLOYEE("Add Employee"),
		USER_MANAGEMENT("User Management");
		
		private String tabName;
		private SubTabs(String tabName) {
			this.tabName = tabName;
		}
		
		public String getName() {
			return tabName;
		}
		
	}
	
	/**
	 * To click on the sidetab
	 * @param tab
	 */
	
	public void clickSidePanelTab(SidePanelTabs tab) {
		WaitUtil.waitForElementVisible(test, LOC_WL_SIDEPANEL_TABS, 10, "The side panel tabs are not present");
		List<WebElement> sideTabs = CheckUtil.findWebElements(test, LOC_WL_SIDEPANEL_TABS, "The side panel tabs are not present");
		for(WebElement sTab : sideTabs) {
			if(sTab.getText().trim().equalsIgnoreCase(tab.toString())) {
				ClickUtil.clickButtonOrFail(test, sTab, "Unable to click on the tab");
				break;
			}
		}
				
	}
	
	/**
	 * To click on the subtab
	 * @param subTab
	 */
	
	public void clickSubTabs(SubTabs subTab) {
		WaitUtil.waitForElementVisible(test, LOC_WL_SUBTABS, 5, "Sub tabs not present");
		
		List<WebElement> subTabs = CheckUtil.findWebElements(test, LOC_WL_SUBTABS, "Sub tabs not present");
		for(WebElement tab : subTabs) {
			if(tab.getText().trim().equalsIgnoreCase(subTab.getName())) {
				ClickUtil.clickButtonOrFail(test, tab, "Unable to click on the tab");
				break;
			}
		}
	}
	
}
