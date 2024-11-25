package com.tendable_automation_test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tendable_automation_base.BaseTest;

public class ContactUsFormTest extends BaseTest{
	SoftAssert soft=new SoftAssert();
	
	@Test
    public void verifyContactUsFormValidation() {
		
        // click on contact menu
        WebElement contactUsLink = driver.findElement(By.linkText("Contact")); 
        contactUsLink.click();
        
        // enter required details in form
        WebElement emailAddress = driver.findElement(By.id("email")); 
        emailAddress.sendKeys("sanjaywaware04@gmail.com");
        
        WebElement firstName = driver.findElement(By.id("firstname")); 
        firstName.sendKeys("Sanjay");
        
        WebElement lastName = driver.findElement(By.id("firstname")); 
        lastName.sendKeys("Waware");
        
        WebElement companyName = driver.findElement(By.id("company")); 
        companyName.sendKeys("Zensar Technologies, Ltd");
        

        // Choose "Marketing" in the drop-down using select class
        WebElement dropdown = driver.findElement(By.id("message_type"));         
        Select select=new Select(dropdown);
        select.selectByVisibleText("Marketing");
        
        // click on I agree check-box
        WebElement checkbox=driver.findElement(By.xpath("//input[@class=\"hubspot-checkbox\"]"));
        checkbox.click();

        // Submit the form (Update the selector for the Submit button)
        WebElement submitButton = driver.findElement(By.cssSelector("div.margin-top> button.button")); 
        submitButton.click();

        // wait & verify the error message displayed
        String expectedErrorMessage = "Form Submission Failed";
        
       // boolean isErrorDisplayed = driver.getPageSource().contains(expectedErrorMessage);
        
        // Wait for the error message to be displayed 
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
        boolean isErrorDisplayed = wait.until(ExpectedConditions.textToBePresentInElementLocated(
            By.xpath("//div[text()=\"Form Submission Failed\"]"), expectedErrorMessage ));

        // Assert and log test result
        soft.assertTrue(isErrorDisplayed, "Error message not displayed as expected.");
        if (isErrorDisplayed) {
            System.out.println("Test Passed: Error message is displayed for the missing 'Message' field.");
        } else {
            System.out.println("Test Failed: Error message is NOT displayed for the missing 'Message' field.");
        }
        
        soft.assertAll();
    }

}
