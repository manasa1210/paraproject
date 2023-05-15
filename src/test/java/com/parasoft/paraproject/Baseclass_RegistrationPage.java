package com.parasoft.paraproject;

import java.util.regex.Pattern;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.parasoft.paraproject.pages.RegPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import org.apache.commons.io.FileUtils;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import com.aventstack.extentreports.ExtentTest;

public class Baseclass_RegistrationPage {
	public WebDriver driver;
//	private static WebDriver driver = null;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	private JavascriptExecutor js;
	ExtentReportManager ext = new ExtentReportManager();
	ExtentTest test;

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		// initializing and starting the browser
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		baseUrl = "https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		js = (JavascriptExecutor) driver;
		test = ext.extent.createTest("RegistrationPage");
	}

	@Test(priority = 1)
//  @Test(dataProvider="RegistrationData")
	public void testRegistration() throws Exception {

		RegPage RegPageObj = new RegPage(driver);
		driver.get("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");
		RegPageObj.clicklinktext();
		test.log(Status.INFO, "Click the link");
		driver.get("https://parabank.parasoft.com/parabank/register.htm");
		isElementPresent(By.xpath("//div[@id='rightPanel']/h1"));
		// Elements defined in Page Class
		RegPageObj.settextbox_firstName("Test");
		RegPageObj.settextbox_lastName("LName");
		RegPageObj.settextbox_street("12345");
		RegPageObj.settextbox_city("Gouda");
		RegPageObj.settextbox_state("Holland");
		RegPageObj.settextbox_zipcode("2807MV");
		RegPageObj.settextbox_phoneNumber("6795353637");
		RegPageObj.settextbox_ssn("12312341243");
		String userid = "Randomuserval" + Integer.toString(((new Random().nextInt(10)) + 1))
				+ Integer.toString(((new Random().nextInt(10)) + 1))
				+ Integer.toString(((new Random().nextInt(10)) + 1));
		System.out.println(userid);
		RegPageObj.settextbox_username(userid);
		RegPageObj.settextbox_password(userid);
		RegPageObj.settextbox_repeatpassword(userid);
		RegPageObj.link_Register_();
		

		test.log(Status.INFO, "Registration Completed for " + userid);
		System.out.println("Registration completed");
//		Thread.sleep(5000);
//		try {
////			WebElement element = (new WebDriverWait(driver, 10))
////		            .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\\'customer.username.errors\\']")));
//			assertEquals(driver.findElement(By.xpath("//*[@id=\\'customer.username.errors\\']")).getText(),"This username already exists.");
//			System.out.println("User already exists, so creating with other user");
////			  Thread.sleep(2000);
//			userid = "Randomidxyz" + Integer.toString(((new Random().nextInt(10)) + 1));
////			driver.findElement(By.id("customer.username")).click();
//			driver.findElement(By.id("customer.username")).clear();
//			driver.findElement(By.id("customer.username")).sendKeys(userid);
//			driver.findElement(By.id("customer.password")).click();
//			driver.findElement(By.id("customer.password")).clear();
//			driver.findElement(By.id("customer.password")).sendKeys(userid);
//			driver.findElement(By.id("repeatedPassword")).click();
//			driver.findElement(By.id("repeatedPassword")).clear();
//			driver.findElement(By.id("repeatedPassword")).sendKeys(userid);
//			driver.findElement(By.xpath("//input[@value='Register']")).click();
//		} catch (Exception e) {
//
//		}

		try {
			assertEquals(driver.findElement(By.xpath("//div[@id='rightPanel']/h1")).getText(), "Welcome " + userid);
			System.out.println(driver.findElement(By.xpath("//div[@id='rightPanel']/h1")).getText());
			test.log(Status.INFO, driver.findElement(By.xpath("//div[@id='rightPanel']/h1")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals(driver.findElement(By.xpath("//div[@id='rightPanel']/p")).getText(),
					"Your account was created successfully. You are now logged in.");
			System.out.println(driver.findElement(By.xpath("//div[@id='rightPanel']/p")).getText());
			test.log(Status.INFO, driver.findElement(By.xpath("//div[@id='rightPanel']/p")).getText());
//      driver.findElement(By.xpath("//a[normalize-space()='Log Out']")).click();
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}

//	@AfterClass(alwaysRun = true)
//	public void tearDown() throws Exception {
//    driver.quit();
////	extent.flush();
//		String verificationErrorString = verificationErrors.toString();
//		if (!"".equals(verificationErrorString)) {
//			fail(verificationErrorString);
//		}
//	}
	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
//  @DataProvider(name="RegistrationData", indices= {0,1,4})
//	String [][] loginData()
//	{
//		String data[][]= {  
//							{ "tester12", "tester@12" } 
////							{ "test132", "test@132" }
//						};
//		
//		return data;
//	}

}
