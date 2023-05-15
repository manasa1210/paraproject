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

public class AccountServices extends Baseclass_RegistrationPage{
  //private WebDriver driver;
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

  @Test(priority=2)
  public void testAccountServices() throws Exception {
    //driver.get("https://parabank.parasoft.com/parabank/register.htm");
	  test=ext.extent.createTest("AccountServices");
    try {
      assertEquals(driver.findElement(By.xpath("//div[@id='leftPanel']/h2")).getText(), "Account Services");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals(driver.findElement(By.linkText("Open New Account")).getText(), "Open New Account");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals(driver.findElement(By.linkText("Accounts Overview")).getText(), "Accounts Overview");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals(driver.findElement(By.linkText("Transfer Funds")).getText(), "Transfer Funds");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals(driver.findElement(By.linkText("Bill Pay")).getText(), "Bill Pay");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals(driver.findElement(By.linkText("Find Transactions")).getText(), "Find Transactions");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals(driver.findElement(By.linkText("Update Contact Info")).getText(), "Update Contact Info");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals(driver.findElement(By.linkText("Request Loan")).getText(), "Request Loan");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals(driver.findElement(By.linkText("Log Out")).getText(), "Log Out");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    test.log(Status.INFO, "Account Services Validation");
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
