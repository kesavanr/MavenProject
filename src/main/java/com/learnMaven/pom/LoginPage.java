package com.learnMaven.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public static WebDriver driver;
	
	public LoginPage(WebDriver localDriver) {
		this.driver = localDriver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="txtUsername")
	private WebElement Username;
	
	@FindBy(id="txtPassword")
	private WebElement Password;
	
	@FindBy(id="btnLogin")
	private WebElement Login;

	public WebElement getUsername() {
		return Username;
	}

	public WebElement getPassword() {
		return Password;
	}

	public WebElement getLogin() {
		return Login;
	}
}
