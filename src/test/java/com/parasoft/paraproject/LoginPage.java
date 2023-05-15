package com.parasoft.paraproject;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;

import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import org.apache.commons.io.FileUtils;

public class LoginPage {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private JavascriptExecutor js;
  ExtentReportManager ext = new ExtentReportManager();
  ExtentTest	test;

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
//    System.setProperty("webdriver.chrome.driver", "");
	  WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    baseUrl = "https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    js = (JavascriptExecutor) driver;
    test=ext.extent.createTest("Login Page");
  }

  @Test
  public void testLoginscreen() throws Exception {
    driver.get("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("test131");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("test@131");
    driver.findElement(By.xpath("//input[@value='Log In']")).click();
    try {
        assertEquals(driver.findElement(By.xpath("//div[@id='rightPanel']/p")).getText(), "The username and password could not be verified.");
        test.log(Status.FAIL, driver.findElement(By.xpath("//div[@id='rightPanel']/p")).getText());
	 
    } catch (Error e) {
        verificationErrors.append(e.toString());
      }
//    driver.get("https://parabank.parasoft.com/parabank/overview.htm");
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
