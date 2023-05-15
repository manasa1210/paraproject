package com.parasoft.paraproject;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import org.apache.commons.io.FileUtils;

public class BillPay extends Baseclass_RegistrationPage{
//  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private JavascriptExecutor js;
//  ExtentReportManager ext = new ExtentReportManager();
//  ExtentTest	test;
  

  @Test(priority=2)
  public void testBillPay() throws Exception {
	  test=ext.extent.createTest("BillPay");
//    driver.get("https://parabank.parasoft.com/parabank/billpay.htm");
    driver.findElement(By.linkText("Bill Pay")).click();
    test.log(Status.INFO, "Click the BillPay");
    driver.findElement(By.name("payee.name")).click();
    driver.findElement(By.name("payee.name")).clear();
    driver.findElement(By.name("payee.name")).sendKeys("ABC");
    driver.findElement(By.name("payee.address.street")).click();
    driver.findElement(By.name("payee.address.street")).clear();
    driver.findElement(By.name("payee.address.street")).sendKeys("AA");
    driver.findElement(By.name("payee.address.city")).click();
    driver.findElement(By.name("payee.address.city")).clear();
    driver.findElement(By.name("payee.address.city")).sendKeys("BB");
    driver.findElement(By.name("payee.address.state")).click();
    driver.findElement(By.name("payee.address.state")).clear();
    driver.findElement(By.name("payee.address.state")).sendKeys("Holl");
    driver.findElement(By.name("payee.address.zipCode")).click();
    driver.findElement(By.name("payee.address.zipCode")).clear();
    driver.findElement(By.name("payee.address.zipCode")).sendKeys("123");
    driver.findElement(By.name("payee.phoneNumber")).click();
    driver.findElement(By.name("payee.phoneNumber")).clear();
    driver.findElement(By.name("payee.phoneNumber")).sendKeys("3456");
    driver.findElement(By.name("payee.accountNumber")).click();
    driver.findElement(By.name("payee.accountNumber")).clear();
    driver.findElement(By.name("payee.accountNumber")).sendKeys("16563");
    driver.findElement(By.name("verifyAccount")).click();
    driver.findElement(By.name("verifyAccount")).clear();
    driver.findElement(By.name("verifyAccount")).sendKeys("16563");
    driver.findElement(By.name("amount")).click();
    driver.findElement(By.name("amount")).clear();
    driver.findElement(By.name("amount")).sendKeys("100");
    driver.findElement(By.name("fromAccountId")).click();
    driver.findElement(By.xpath("//input[@value='Send Payment']")).click();
    try {
      assertEquals(driver.findElement(By.xpath("//div[@id='rightPanel']/div/div[2]/h1")).getText(), "Bill Payment Complete");
      test.log(Status.INFO, driver.findElement(By.xpath("//div[@id='rightPanel']/div/div[2]/h1")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals(driver.findElement(By.id("amount")).getText(), "$100.00");
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
