package com.learnMaven.stepDefinition;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.learnMaven.baseclass.BaseClass;
import com.learnMaven.runner.TestRunner;
import com.learnMaven.utilities.FileReaderManager;
import com.learnMaven.utilities.PageObjectManager;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition extends BaseClass {
	public static WebDriver driver = TestRunner.driver;
	PageObjectManager pom = new PageObjectManager(driver);
	
	static ExtentReports extent;
	static ExtentSparkReporter spark;
	ExtentTest testCase;
	
	static {
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("target/Spark.html");
		extent.attachReporter(spark);
	}
	/*@Before
	public void beforeHooks(Scenario sce) {
		String name = sce.getName();

	}*/
	@After
	public void afterHooks(Scenario sce) throws IOException {
		System.out.println("afterHooks");
		if(sce.isFailed()) {
			String fileName = sce.getName().replace(" ", "_");
			getScreenshot(fileName);			
			String filePath = System.getProperty("user.dir") + "\\Screenshot\\" + fileName + ".png";
			testCase.addScreenCaptureFromPath(filePath);
			//testCase.pass(MediaEntityBuilder.createScreenCaptureFromPath(filePath).build());
			testCase.log(Status.FAIL, sce.getName());
		}
		extent.flush();
	}
	@Before("@Login")
	public void beforeLoginTag(Scenario sce) {
		System.out.println("beforeLoginTag");
		//System.out.println("here");
		String name = sce.getName();				
		testCase = extent.createTest(name);

	}
	@Before("@AddUserScenario")
	public void beforeAddUserScenarioTag(Scenario sce) {
		System.out.println("beforeAddUserScenarioTag");
		String name = sce.getName();		
		testCase = extent.createTest(name);

	}
	
	@Before("@CheckAddedUser")
	public void beforeCheckAddedUserTag(Scenario sce) {
		System.out.println("beforeCheckAddedUserTag");
		String name = sce.getName();		
		testCase = extent.createTest(name);

	}	
	
	@Given("^Launch application$")
	public void launch_application() throws Throwable {
		System.out.println("launch  1.1");
	    String url = FileReaderManager.getInstance().getCrInstance().getUrl();
	    BaseClass.getURL(url);
	    testCase.log(Status.PASS, "Launch application and it passed!");
	}

	@When("^Enter username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void enter_username_and_password(String uname, String pwd) throws Throwable {
		System.out.println("launch  1.2");
		findInputElement(pom.getLp().getUsername(), uname);
	    findInputElement(pom.getLp().getPassword(), pwd);
	    testCase.log(Status.PASS, "Enter " + uname + " and " + pwd + " and it passed!");
	}

	@Then("^click the login button$")
	public void click_the_login_button() throws Throwable {
		System.out.println("launch  1.3");
		Click(pom.getLp().getLogin());
	    testCase.log(Status.PASS, "click the login button and it passed!");
	}
	//-----------------------------------------------
	
	@When("^User mouse move to admin menu$")
	public void user_mouse_move_to_admin_menu() throws Throwable {
		System.out.println("Add  2.1");
	    moveToElement(pom.getAup().getAdminLink());
	    testCase.log(Status.PASS, "User mouse move to admin menu and it passed!");
	}

	@When("^User mouse move to user management$")
	public void user_mouse_move_to_user_management() throws Throwable {
		System.out.println("Add  2.2");
		moveToElement(pom.getAup().getUserManagementLink());
		testCase.log(Status.PASS, "User mouse move to user management and it passed!");
	}

	@When("^User mouse move to user link$")
	public void user_mouse_move_to_user_link() throws Throwable {
		System.out.println("Add  2.3");
		moveToElement(pom.getAup().getUsersLink());
		testCase.log(Status.PASS, "User mouse move to user link and it passed!");
	}

	@When("^User click the user link$")
	public void user_click_the_user_link() throws Throwable {
		System.out.println("Add  2.4");
	    Click(pom.getAup().getUsersLink());
	    testCase.log(Status.PASS, "User click the user link and it passed!");
	}

	@When("^User move the mouse Add button and click the button$")
	public void user_move_the_mouse_Add_button_and_click_the_button() throws Throwable {
		System.out.println("Add  2.5");
		moveToElement(pom.getAup().getBtnAdd());
		Click(pom.getAup().getBtnAdd());
		testCase.log(Status.PASS, "User move the mouse Add button and click the button and it passed!");
	}

	@When("^User select user role \"([^\"]*)\" as \"([^\"]*)\" from dropdown$")
	public void user_select_user_role_as_from_dropdown(String value, String type) throws Throwable {
		System.out.println("Add  2.6");
	    selectDropDown(pom.getAup().getUserRole(), value, type);
	    testCase.log(Status.PASS, "User select user role " + value + " as " + type + " from dropdown and it passed!");
	}

	/*@When("^User enter employee name \"([^\"]*)\"$")
	public void user_enter_employee_name(String ename) throws Throwable {
		System.out.println("Add . 7");
	    findInputElement(pom.getAup().getEmployeeName(), ename);
	    testCase.log(Status.PASS, "User enter employee name " + ename + " and it passed!");
	}*/
	
	@When("^User enter employee name \"([^\"]*)\" and choose Alice Duval$")
	public void user_enter_employee_name_and_choose_Alice_Duval(String ename) throws Throwable {
		System.out.println("Add  2.7");
	    findInputElement(pom.getAup().getEmployeeName(), ename);
	    moveToElement(pom.getAup().getSelectEmployeeName());
	    clickOnElement(pom.getAup().getSelectEmployeeName());
	    testCase.log(Status.PASS, "User enter employee name " + ename + " and it passed!");
	}
	
	@When("^User enter username \"([^\"]*)\"$")
	public void user_enter_username(String uname) throws Throwable {
		System.out.println("Add  2.8");
		findInputElement(pom.getAup().getUsername(), uname);
		testCase.log(Status.PASS, "User enter username " + uname + " and it passed!");
	}

	@When("^User select status \"([^\"]*)\" as \"([^\"]*)\" from dropdown$")
	public void user_select_status_as_from_dropdown(String value, String type) throws Throwable {
		System.out.println("Add  2.9");
		selectDropDown(pom.getAup().getUserStatus(), value, type);
		testCase.log(Status.PASS, "User select status " + value + " as " + type + " and it passed!");
	}

	@When("^user enter password \"([^\"]*)\" and confirm password \"([^\"]*)\"$")
	public void user_enter_password_and_confirm_password(String pwd, String cpwd) throws Throwable {
		System.out.println("Add  2.10");
		findInputElement(pom.getAup().getPassword(), pwd);
		findInputElement(pom.getAup().getConfirmPassword(), cpwd);
		testCase.log(Status.PASS, "user enter password " + pwd + " and confirm password " + cpwd + " and it passed!");
	}

	@When("^User click the save button$")
	public void user_click_the_save_button() throws Throwable {
		System.out.println("Add  2.11");
	    Click(pom.getAup().getBtnSave());
	    boolean displayed = isDisplayedStatus(pom.getAup().getSpanAlreadyexists());
	    //Assert.assertEquals(false, displayed);
	    //testCase.log(Status.PASS, "User click the save button and create new user");
	    
	    if(displayed) {
	    	testCase.log(Status.WARNING, "User click the save button but Username " + pom.getAup().getUsername().getText() + " is already exists");
	    	moveToElement(pom.getAup().getCancel());
	    	clickOnElement(pom.getAup().getCancel());
	    }
	    else {
	    	testCase.log(Status.PASS, "User click the save button and create new user");
	    }
	    
	}
	//--------------------------------------------
	
	/*@When("^User enter username \"([^\"]*)\" to the below system user box$")
	public void user_enter_username_to_the_below_system_user_box(String uname) throws Throwable {
		findInputElement(pom.getUsp().getSearchUsername(), uname);
	}*/

	@When("^User click the search button$")
	public void user_click_the_search_button() throws Throwable {
		System.out.println("Search  3.1");
		Click(pom.getUsp().getSearchBtn());
		testCase.log(Status.PASS, "User click the search button and it passed!");
	}

	@Then("^User verify the username \"([^\"]*)\" in the search box$")
	public void user_verify_the_username_in_the_search_box(String expected) throws Throwable {
		System.out.println("Search  3.2");
	    WebElement usernamelink = pom.getUsp().getUsernamelink();
	    String actual = usernamelink.getText();
	    Assert.assertEquals(expected, actual);
	    testCase.log(Status.PASS, "User verify the username " + expected + "  in the search and it passed!");
	}
	//--------------------------------------------
	
	
	/*
	@Before
	public void beforeHooks() {
		// TODO Auto-generated method stub
		System.out.println("This is beforeHooks");
	}
	@After
	public void afterHooks() {
		// TODO Auto-generated method stub
		System.out.println("This is afterHooks");
	}
	
	@Before("@Tag1")
	public void beforeTag1() {
		// TODO Auto-generated method stub
		System.out.println("This is beforeTag - 1");
	}
	@After("@Tag1")
	public void afterTag1() {
		// TODO Auto-generated method stub
		System.out.println("This is afterTag - 1");
	}
	
	@Before("@Tag2")
	public void beforeTag2() {
		// TODO Auto-generated method stub
		System.out.println("This is beforeTag -- 2");
	}
	@After("@Tag2")
	public void afterTag2() {
		// TODO Auto-generated method stub
		System.out.println("This is afterTag -- 2");
	}
	
	@Before("@Tag3")
	public void beforeTag3() {
		// TODO Auto-generated method stub
		System.out.println("This is beforeTag --- 3");
	}
	@After("@Tag3")
	public void afterTag3() {
		// TODO Auto-generated method stub
		System.out.println("This is afterTag --- 3");
	}
	
	@Given("^This is first step$")
	public void this_is_first_step() throws Throwable {
	    System.out.println("This is first step");
	}

	@When("^This is second step$")
	public void this_is_second_step() throws Throwable {
		System.out.println("This is second step");
	}

	@Then("^This is third step$")
	public void this_is_third_step() throws Throwable {
		System.out.println("This is third step");
	}
	*/
}
