package com.learnMaven.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddUserPage {
	
	public static WebDriver driver;
	
	public AddUserPage(WebDriver localDriver) {
		this.driver = localDriver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Admin")
	private WebElement AdminLink;
	
	@FindBy(linkText="User Management")
	private WebElement UserManagementLink;
	
	@FindBy(linkText="Users")
	private WebElement UsersLink;

	@FindBy(id="btnAdd")
	private WebElement btnAdd;
		
	private By UserRole = By.id("systemUser_userType");
	
	@FindBy(id="systemUser_employeeName_empName")
	private WebElement EmployeeName;
	
	@FindBy(xpath="//div[@class='ac_results']/ul/li[2]")
	private WebElement SelectEmployeeName;
	
	@FindBy(id="systemUser_userName")
	private WebElement Username;
	
	private By UserStatus = By.id("systemUser_status");
		
	@FindBy(id="systemUser_password")
	private WebElement Password;
	
	@FindBy(id="systemUser_confirmPassword")
	private WebElement ConfirmPassword;
	
	@FindBy(id="btnSave")
	private WebElement btnSave;

	@FindBy(id="btnCancel")
	private WebElement Cancel;
	
	public WebElement getCancel() {
		return Cancel;
	}

	@FindBy(xpath="//span[text()='Already exists']")
	private WebElement spanAlreadyexists;
	
	public WebElement getAdminLink() {
		return AdminLink;
	}

	public WebElement getUserManagementLink() {
		return UserManagementLink;
	}

	public WebElement getUsersLink() {
		return UsersLink;
	}
	
	public WebElement getBtnAdd() {
		return btnAdd;
	}

	public By getUserRole() {
		return UserRole;
	}

	public WebElement getEmployeeName() {
		return EmployeeName;
	}

	public WebElement getSelectEmployeeName() {
		return SelectEmployeeName;
	}

	public WebElement getUsername() {
		return Username;
	}

	public By getUserStatus() {
		return UserStatus;
	}

	public WebElement getPassword() {
		return Password;
	}

	public WebElement getConfirmPassword() {
		return ConfirmPassword;
	}

	public WebElement getBtnSave() {
		return btnSave;
	}

	public WebElement getSpanAlreadyexists() {
		return spanAlreadyexists;
	}
	
}
