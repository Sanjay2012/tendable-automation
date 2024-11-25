package com.tendable_automation_test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tendable_automation_base.BaseTest;

public class TopLevelMenuTest extends BaseTest {
	SoftAssert soft=new SoftAssert();

	@Test
	public void verifyTopLevelMenus() {
		
		// Define the expected menu items
		String[] expectedMenus = { "About", "Products", "Sectors", "Content Hub", "Contact" };

		// Find all the menu elements
		List<WebElement> menuElements = driver.findElements(By.xpath("//div//a[@class=\"navbar7_link w-nav-link\"]"));

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
