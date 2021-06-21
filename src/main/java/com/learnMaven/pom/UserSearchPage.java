package com.learnMaven.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserSearchPage {
	
	public static WebDriver driver;
	
	public UserSearchPage(WebDriver localDriver) {
		this.driver = localDriver;
		PageFactory.initElements(driver, this);
	}
	
	/*@FindBy(id="searchSystemUser_userName")
	private WebElement SearchUsername;*/
	
	@FindBy(id="searchBtn")
	private WebElement searchBtn;
	
	@FindBy(linkText="abirami7")
	private WebElement Usernamelink;

	/*public WebElement getSearchUsername() {
		return SearchUsername;
	}*/

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getUsernamelink() {
		return Usernamelink;
	}
}
