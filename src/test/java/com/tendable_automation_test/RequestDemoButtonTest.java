package com.tendable_automation_test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tendable_automation_base.BaseTest;

public class RequestDemoButtonTest extends BaseTest {
	SoftAssert soft = new SoftAssert();

	@Test
	public void verifyRequestDemoButtonOnAllPages() {
		// Define the top level menu items
		String[] topLevelMenus = { "About", "Products", "Sectors", "Content Hub", "Contact" };

		// Validate each expected menu
		for (String menu : topLevelMenus) {
			navigateToMenu(menu);

			// Validate the presence and activity of the "Book a Demo" button
			WebElement requestDemoButton = driver.findElement(By.cssSelector("div a.button.is-small.w-button[href=\"/book-a-demo\"]"));
			
			soft.assertTrue(requestDemoButton.isDisplayed(),
					"Request a Demo button is not visible on " + menu + " page.");
			
			soft.assertTrue(requestDemoButton.isEnabled(), "Request a Demo button is not active on " + menu + " page.");

		}
		soft.assertAll();

	}

	private void navigateToMenu(String menuName) {
		// Find all the menu elements
		List<WebElement> menuElements = driver.findElements(By.xpath("//div//a[@class=\"navbar7_link w-nav-link\"]"));

		for (WebElement menuElement : menuElements) {
			if (menuElement.getText().equalsIgnoreCase(menuName)) {
				menuElement.click();
				return;
			}
		}
		throw new AssertionError("Menu not found: " + menuName);
	}

}
