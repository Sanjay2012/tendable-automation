package com.tendable_automation_test;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tendable_automation_base.BaseTest;
import com.tendable_automation_pages.TopLevelMenuPage;

public class RequestDemoButtonTest extends BaseTest {
	SoftAssert soft = new SoftAssert();

	@Test
	public void verifyRequestDemoButtonOnAllPages() {
		// Initialize the page object
		TopLevelMenuPage menuPage = new TopLevelMenuPage(driver);

		// Define the top-level menu items
		String[] topLevelMenus = { "About", "Products", "Sectors", "Content Hub", "Contact" };

		// Validate "Book a Demo" button on each menu page
		for (String menu : topLevelMenus) {
			menuPage.navigateToMenu(menu);

			WebElement requestDemoButton = menuPage.getRequestDemoButton();

			// Validate the button's visibility and activity
			soft.assertTrue(requestDemoButton.isDisplayed(),
					"Request a Demo button is not visible on " + menu + " page.");
			
			soft.assertTrue(requestDemoButton.isEnabled(), "Request a Demo button is not active on " + menu + " page.");
		}
		soft.assertAll();
	}
}
