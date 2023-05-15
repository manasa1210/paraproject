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

public class TransferFunds extends Baseclass_RegistrationPage {
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
//    //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//    js = (JavascriptExecutor) driver;
//  }

	@Test(priority = 2)
	public void testTransferFunds() throws Exception {
		driver.get("https://parabank.parasoft.com/parabank/register.htm");
		driver.findElement(By.linkText("Transfer Funds")).click();
		test=ext.extent.createTest("Transfer Funds");
		driver.get("https://parabank.parasoft.com/parabank/transfer.htm");
		driver.findElement(By.id("amount")).click();
		driver.findElement(By.id("amount")).clear();
		driver.findElement(By.id("amount")).sendKeys("1000");
		driver.findElement(By.id("fromAccountId")).click();
		driver.findElement(By.id("fromAccountId")).click();
		driver.findElement(By.id("toAccountId")).click();
		driver.findElement(By.xpath("//input[@value='Transfer']")).click();
		try {
			assertEquals(driver.findElement(By.id("amount")).getText(), "$1000.00");
			test.log(Status.INFO, "Transferred "+ driver.findElement(By.id("amount")).getText());
		      
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
