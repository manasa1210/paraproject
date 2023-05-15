package com.parasoft.paraproject;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;

import com.aventstack.extentreports.Status;

import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import org.apache.commons.io.FileUtils;

public class RequestLoan extends Baseclass_RegistrationPage {
	// private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	private JavascriptExecutor js;

//  @BeforeClass(alwaysRun = true)
//  public void setUp() throws Exception {
	// System.setProperty("webdriver.chrome.driver", "");
	// driver = new ChromeDriver();
	// baseUrl = "https://www.google.com/";
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	// js = (JavascriptExecutor) driver;
	// }

	@Test(priority = 2)
	public void testRequestLoan1() throws Exception {
		driver.get("https://parabank.parasoft.com/parabank/requestloan.htm");
		driver.findElement(By.linkText("Request Loan")).click();
		 test=ext.extent.createTest("Request Loan");
		driver.findElement(By.id("amount")).click();
		driver.findElement(By.id("amount")).clear();
		driver.findElement(By.id("amount")).sendKeys("8000");
		driver.findElement(By.id("downPayment")).click();
		driver.findElement(By.id("downPayment")).clear();
		driver.findElement(By.id("downPayment")).sendKeys("5000");
		driver.findElement(By.id("fromAccountId")).click();
		driver.findElement(By.xpath("//input[@value='Apply Now']")).click();
//    try {
//      assertEquals(driver.findElement(By.xpath("//h1[normalize-space()='Error!']")).getText(), "Error!");
//    } catch (Error e) {
//      verificationErrors.append(e.toString());
//    }
//    try {
//      assertEquals(driver.findElement(By.xpath("//p[@class='error']")).getText(), "An internal error has occurred and has been logged");
//    } catch (Error e) {
//      verificationErrors.append(e.toString());
//   }
		try {
			assertEquals(driver.findElement(By.id("loanStatus")).getText(), "Approved");
			 
			 test.log(Status.INFO, "Loan Status " + driver.findElement(By.id("loanStatus")).getText());
		      
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals(driver.findElement(By.xpath("//div[@id='rightPanel']/div/div/div/p")).getText(),
					"Congratulations, your loan has been approved.");
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}

		try {
			assertEquals(driver.findElement(By.xpath("//div[@id='rightPanel']/div/div/div/p[2]/b")).getText(),
					"Your new account number:");
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
//    driver.findElement(By.xpath("//div[@id='rightPanel']/div/div/div/p")).click();
//  
//  
//  try {
//      assertEquals(driver.findElement(By.xpath("//h1[normalize-space()='Error!']")).getText(), "Error!");
//    } catch (Error e) {
//      verificationErrors.append(e.toString());
//   }
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
