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

public class OpenAccount extends Baseclass_RegistrationPage {
//  private WebDriver driver;
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
  public void testOpenNewAccount() throws Exception {
//    driver.get("https://parabank.parasoft.com/parabank/register.htm");
	  test=ext.extent.createTest("Open New Account");
    driver.findElement(By.linkText("Open New Account")).click();
    
//    driver.get("https://parabank.parasoft.com/parabank/openaccount.htm");
    try {
      assertEquals(driver.findElement(By.xpath("//div[@id='rightPanel']/div/div/h1")).getText(), "Open New Account");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.id("type")).click();
    driver.findElement(By.id("fromAccountId")).click();
    driver.findElement(By.xpath("//input[@value='Open New Account']")).click();
    driver.findElement(By.xpath("//div[@id='rightPanel']/div/div/h1")).click();
    Thread.sleep(5000);
    try {
      assertEquals(driver.findElement(By.xpath("//div[@id='rightPanel']/div/div/h1")).getText(), "Account Opened!");
      test.log(Status.INFO, driver.findElement(By.xpath("//div[@id='rightPanel']/div/div/h1")).getText());
      
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.xpath("//div[@id='rightPanel']/div/div/p[2]/b")).click();
    try {
      assertEquals(driver.findElement(By.xpath("//div[@id='rightPanel']/div/div/p[2]/b")).getText(), "Your new account number:");
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
