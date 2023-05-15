package com.parasoft.paraproject;

import java.util.regex.Pattern;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;

import com.aventstack.extentreports.Status;

import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import org.apache.commons.io.FileUtils;

public class AccountOverview extends Baseclass_RegistrationPage {
//  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private JavascriptExecutor js;

//  @BeforeClass(alwaysRun = true)
//  public void setUp() throws Exception {
////    System.setProperty("webdriver.chrome.driver", "");
//    driver = new ChromeDriver();
//    baseUrl = "https://www.google.com/";
////    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//    js = (JavascriptExecutor) driver;
//    
//  }

  @Test(priority=2)
  public void testAccountOverview() throws Exception {
//    driver.get("https://parabank.parasoft.com/parabank/register.htm");
//    driver.findElement(By.linkText("Accounts Overview")).click();
    driver.get("https://parabank.parasoft.com/parabank/overview.htm");
    test=ext.extent.createTest("AccountOverview");
    isElementPresent(By.xpath("//div[@id='rightPanel']/div/div/h1"));
//    try {
//      assertEquals(driver.findElement(By.linkText("15453")).getText(), "15453");
//    } catch (Error e) {
//      verificationErrors.append(e.toString());
//    }
    try {
      assertEquals(driver.findElement(By.xpath("//table[@id='accountTable']/tbody/tr/td[2]")).getText(), "$10000.00");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals(driver.findElement(By.xpath("//table[@id='accountTable']/tbody/tr/td[3]")).getText(), "$10000.00");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals(driver.findElement(By.xpath("//table[@id='accountTable']/tbody/tr[2]/td[2]/b")).getText(), "$10000.00");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertTrue(driver.findElement(By.xpath("//table[@id='accountTable']/tfoot/tr/td")).getText().matches("^[\\s\\S]*Balance includes deposits that may be subject to holds$"));
      test.log(Status.INFO, driver.findElement(By.xpath("//table[@id='accountTable']/tfoot/tr/td")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.xpath("//table[@id='accountTable']/tbody/tr/td/a")).click();
//    driver.get("https://parabank.parasoft.com/parabank/activity.htm?id=15453");
//    try {
//      assertEquals(driver.findElement(By.id("accountId")).getText(), "15453");
//    } catch (Error e) {
//      verificationErrors.append(e.toString());
//    }
    try {
      assertEquals(driver.findElement(By.id("accountType")).getText(), "CHECKING");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals(driver.findElement(By.id("balance")).getText(), "$10000.00");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals(driver.findElement(By.id("availableBalance")).getText(), "$10000.00");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.xpath("//input[@value='Go']")).click();
    try {
      assertEquals(driver.findElement(By.xpath("//div[@id='rightPanel']/div/div[2]/p/b")).getText(), "No transactions found.");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.id("month")).click();
    new Select(driver.findElement(By.id("month"))).selectByVisibleText("January");
    driver.findElement(By.id("transactionType")).click();
    new Select(driver.findElement(By.id("transactionType"))).selectByVisibleText("Credit");
    driver.findElement(By.xpath("//input[@value='Go']")).click();
    try {
      assertEquals(driver.findElement(By.xpath("//div[@id='rightPanel']/div/div[2]/p/b")).getText(), "No transactions found.");
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
