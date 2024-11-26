package com.tendable_automation_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactUsFormPage {
	WebDriver driver;

    // Locators for form elements
    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "firstname")
    private WebElement firstNameField;

    @FindBy(id = "lastname")
    private WebElement lastNameField;

    @FindBy(id = "company")
    private WebElement companyField;

    @FindBy(id = "message_type")
    private WebElement messageTypeDropdown;

    @FindBy(xpath = "//input[@class=\"hubspot-checkbox\"]")
    private WebElement agreeCheckbox;

    @FindBy(css = "div.margin-top> button.button")
    private WebElement submitButton;

    @FindBy(xpath = "//div[text()='Form Submission Failed']")
    private WebElement errorMessage;

    // Constructor to initialize elements
    public ContactUsFormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Methods to interact with elements
    public void fillEmail(String email) {
        emailField.sendKeys(email);
    }

    public void fillFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void fillLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public void fillCompany(String company) {
        companyField.sendKeys(company);
    }

    public void selectMessageType(String messageType) {
        Select select = new Select(messageTypeDropdown);
        select.selectByVisibleText(messageType);
    }

    public void checkAgreeCheckbox() {
        agreeCheckbox.click();
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public boolean isErrorMessageDisplayed(String expectedMessage) {
        return errorMessage.getText().equals(expectedMessage);
    }

}
