package com.learnMaven.utilities;

import org.openqa.selenium.WebDriver;

import com.learnMaven.pom.AddUserPage;
import com.learnMaven.pom.LoginPage;
import com.learnMaven.pom.UserSearchPage;

public class PageObjectManager {

	public static WebDriver driver;
	
	public PageObjectManager(WebDriver localDriver) {
		this.driver = localDriver;
	}
	
	private LoginPage lp;
	private AddUserPage aup;
	private UserSearchPage usp;
	
	public LoginPage getLp() {
		if(lp == null)
			lp = new LoginPage(driver);
		return lp;
	}

	public AddUserPage getAup() {
		if(aup == null)
			aup = new AddUserPage(driver);
		return aup;
	}

	public UserSearchPage getUsp() {
		if(usp == null)
			usp = new UserSearchPage(driver);
		return usp;
	}

	
}
