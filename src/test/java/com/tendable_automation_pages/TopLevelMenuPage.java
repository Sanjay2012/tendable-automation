package com.tendable_automation_pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopLevelMenuPage {

	WebDriver driver;

	// Locators using @FindBy annotation
	@FindBy(xpath = "//div//a[@class=\"navbar7_link w-nav-link\"]")
	private List<WebElement> menuElements;

	@FindBy(css = "div a.button.is-small.w-button[href=\"/book-a-demo\"]")
	private WebElement requestDemoButton;
	
	@FindBy(linkText = "Contact")
    private WebElement contactMenu;

	// Constructor to initialize elements
	public TopLevelMenuPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Method to get all menu elements
	public List<WebElement> getMenuElements() {
		return menuElements;
	}

	// Method to get the "Book a Demo" button
	public WebElement getRequestDemoButton() {
		return requestDemoButton;
	}

	// Method to navigate to a menu by its name
	public void navigateToMenu(String menuName) {
		for (WebElement menuElement : menuElements) {
			if (menuElement.getText().equalsIgnoreCase(menuName)) {
				menuElement.click();
				return;
			}
		}
		throw new AssertionError("Menu not found: " + menuName);
	}
	
	// Method to click on the Contact menu
    public void clickOnContactMenu() {
        contactMenu.click();
    }

}
