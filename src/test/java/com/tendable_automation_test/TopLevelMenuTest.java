package com.tendable_automation_test;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tendable_automation_base.BaseTest;
import com.tendable_automation_pages.TopLevelMenuPage;

public class TopLevelMenuTest extends BaseTest {
	SoftAssert soft = new SoftAssert();

	@Test
	public void verifyTopLevelMenus() {
		// Initialize the page object
		TopLevelMenuPage menuPage = new TopLevelMenuPage(driver);

		// Define the expected menu items
		String[] expectedMenus = { "About", "Products", "Sectors", "Content Hub", "Contact" };

		// Get the menu elements from the page object
		List<WebElement> menuElements = menuPage.getMenuElements();

		// Validate each expected menu
		for (String expectedMenu : expectedMenus) {
			boolean menuFound = false;
			for (WebElement menuElement : menuElements) {
				if (menuElement.getText().equalsIgnoreCase(expectedMenu)) {
					menuFound = true;
					break;
				}
			}
			soft.assertTrue(menuFound, "Menu item not found: " + expectedMenu);
		}
		soft.assertAll();
	}
}
