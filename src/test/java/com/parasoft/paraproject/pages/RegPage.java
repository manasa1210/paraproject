package com.parasoft.paraproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class RegPage {

	WebDriver driver = null;
	By textbox_search = By.name("_nkw");
	By button_search = By.id("gh-btn");
	By linktext_Register = By.linkText("Register");
	By textbox_firstName = By.id("customer.firstName");
	By textbox_lastName = By.id("customer.lastName");
	By textbox_repeatedPassword = By.id("repeatedPassword");
	By textbox_zipCode = By.id("customer.address.zipCode");
	By textbox_state = By.id("customer.address.state");
	By textbox_address_street = By.id("customer.address.street");
	By textbox_address_city = By.id("customer.address.city");
	By textbox_phoneNumber = By.id("customer.phoneNumber");
	By textbox_ssn = By.id("customer.ssn");
	By textbox_username = By.id("customer.username");
	By textbox_password = By.id("customer.password");
	By link_registration = By.xpath("//input[@value='Register']");
	
	

	public RegPage(WebDriver driver) {
		this.driver = driver;
	}

	public void setTextInSearchBox(String text) {
		driver.findElement(textbox_search).sendKeys(text);

	}

	public void settextbox_firstName(String text) {
		driver.findElement(textbox_firstName).click();
		driver.findElement(textbox_firstName).clear();
		driver.findElement(textbox_firstName).sendKeys(text);
	}

	public void settextbox_lastName(String text) {
		driver.findElement(textbox_lastName).sendKeys(text);
	}

	public void settextbox_repeatpassword(String text) {
		driver.findElement(textbox_repeatedPassword).sendKeys(text);
	}

	public void settextbox_zipcode(String text) {
		driver.findElement(textbox_zipCode).sendKeys(text);
	}

	public void settextbox_state(String text) {
		driver.findElement(textbox_state).sendKeys(text);
	}

	public void settextbox_street(String text) {
		driver.findElement(textbox_address_street).sendKeys(text);
	}

	public void settextbox_city(String text) {
		driver.findElement(textbox_address_city).sendKeys(text);
	}

	public void settextbox_phoneNumber(String text) {
		driver.findElement(textbox_phoneNumber).sendKeys(text);
	}

	public void settextbox_username(String text) {
		driver.findElement(textbox_username).sendKeys(text);
	}
	public void settextbox_password(String text) {
		driver.findElement(textbox_password).sendKeys(text);
	}
	public void settextbox_ssn(String text) {
		driver.findElement(textbox_ssn).sendKeys(text);
	}
	public void clicklinktext() {
		driver.findElement(linktext_Register).click();

	}
	public void link_Register_() {
		driver.findElement(link_registration).click();

	}

	public void clickSearchButton() {
		driver.findElement(button_search).sendKeys(Keys.RETURN);

	}

}
