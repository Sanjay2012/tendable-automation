package com.tendable_automation_base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set up the ChromeDriver
    	WebDriverManager.chromedriver().setup();        
    	driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
     // Navigate to the Tendable website
        driver.get("https://www.tendable.com/");
    }

    @AfterClass
    public void tearDown() {
        // Quit the browser
        if (driver != null) {
            driver.quit();
        }
    }

}
