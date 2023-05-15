package com.parasoft.paraproject;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;

import com.aventstack.extentreports.Status;

import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import org.apache.commons.io.FileUtils;

public class UpdateContactInfo extends Baseclass_RegistrationPage {
	// private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	private JavascriptExecutor js;

//  @BeforeClass(alwaysRun = true)
//  public void setUp() throws Exception {
//    System.setProperty("webdriver.chrome.driver", "");
//    driver = new ChromeDriver();
//    baseUrl = "https://www.google.com/";
//    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//    js = (JavascriptExecutor) driver;
//  }

	@Test(priority = 2)
	public void testUpdateContactinfo() throws Exception {
		driver.get("https://parabank.parasoft.com/parabank/register.htm");
		driver.findElement(By.linkText("Update Contact Info")).click();
		test=ext.extent.createTest("Update Contact Info");
		driver.get("https://parabank.parasoft.com/parabank/updateprofile.htm");
		driver.findElement(By.id("customer.firstName")).click();
		driver.findElement(By.id("customer.firstName")).clear();
		driver.findElement(By.id("customer.firstName")).sendKeys("AA");
		driver.findElement(By.id("customer.lastName")).click();
		driver.findElement(By.id("customer.lastName")).clear();
		driver.findElement(By.id("customer.lastName")).sendKeys("BB");
		driver.findElement(By.id("customer.address.street")).click();
		driver.findElement(By.id("customer.address.street")).clear();
		driver.findElement(By.id("customer.address.street")).sendKeys("123");
		driver.findElement(By.id("customer.address.city")).click();
		driver.findElement(By.id("customer.address.city")).clear();
		driver.findElement(By.id("customer.address.city")).sendKeys("DD");
		driver.findElement(By.id("customer.address.state")).click();
		driver.findElement(By.id("customer.address.zipCode")).click();
		driver.findElement(By.id("customer.address.zipCode")).clear();
		driver.findElement(By.id("customer.address.zipCode")).sendKeys("234");
		driver.findElement(By.id("customer.phoneNumber")).click();
		driver.findElement(By.id("customer.phoneNumber")).clear();
		driver.findElement(By.id("customer.phoneNumber")).sendKeys("23457");
		driver.findElement(By.xpath("//input[@value='Update Profile']")).click();
		try {
			assertEquals(driver.findElement(By.xpath("//div[@id='rightPanel']/div/div/h1")).getText(),
					"Profile Updated");
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals(driver.findElement(By.xpath("//div[@id='rightPanel']/div/div/p")).getText(),
					"Your updated address and phone number have been added to the system.");
			test.log(Status.INFO, driver.findElement(By.xpath("//div[@id='rightPanel']/div/div/p")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
