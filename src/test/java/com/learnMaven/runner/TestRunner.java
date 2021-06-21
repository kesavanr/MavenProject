package com.learnMaven.runner;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.learnMaven.baseclass.BaseClass;
import com.learnMaven.utilities.FileReaderManager;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/learnMaven/feature/learnMaven.feature"
					, glue= { "com/learnMaven/stepDefinition" }
					, monochrome = true
					, dryRun = false
					, strict = true
					//, tags = { "~@AddUserScenario" }	
					//, plugin = { }
				)
public class TestRunner {
	public static WebDriver driver;
	
	@BeforeClass
	public static void setUp() throws IOException {
		String browser = FileReaderManager.getInstance().getCrInstance().getBrowser();
		driver = BaseClass.getBrowser(browser);
	}
	
	@AfterClass
	public static void tearDown() {
		BaseClass.quitBrowser();
	}
}
