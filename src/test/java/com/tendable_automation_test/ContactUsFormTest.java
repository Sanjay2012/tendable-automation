package com.tendable_automation_test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tendable_automation_base.BaseTest;
import com.tendable_automation_pages.ContactUsFormPage;
import com.tendable_automation_pages.TopLevelMenuPage;

public class ContactUsFormTest extends BaseTest{
	SoftAssert soft=new SoftAssert();
	
	@Test
    public void verifyContactUsFormValidation() {
        SoftAssert soft = new SoftAssert();

        // Initialize page objects
        TopLevelMenuPage menuPage = new TopLevelMenuPage(driver);
        ContactUsFormPage contactFormPage = new ContactUsFormPage(driver);

        // Navigate to the Contact page
        menuPage.clickOnContactMenu();

        // Fill in the form details
        contactFormPage.fillEmail("sanjaywaware04@gmail.com");
        contactFormPage.fillFirstName("Sanjay");
        contactFormPage.fillLastName("Waware");
        contactFormPage.fillCompany("Zensar Technologies, Ltd");
        contactFormPage.selectMessageType("Marketing");
        contactFormPage.checkAgreeCheckbox();

        // Submit the form
        contactFormPage.clickSubmit();

        // Validate the error message
        String expectedErrorMessage = "Form Submission Failed";
        soft.assertTrue(contactFormPage.isErrorMessageDisplayed(expectedErrorMessage), 
                "Error message not displayed as expected.");

        if (contactFormPage.isErrorMessageDisplayed(expectedErrorMessage)) {
            System.out.println("Test Passed: Error message is displayed for the missing 'Message' field.");
        } else {
            System.out.println("Test Failed: Error message is NOT displayed for the missing 'Message' field.");
        }

        soft.assertAll();
    
    }

}
