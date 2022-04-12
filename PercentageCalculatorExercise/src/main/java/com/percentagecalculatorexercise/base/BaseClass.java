package com.percentagecalculatorexercise.base;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.percentagecalculatorexercise.utility.BrowserFactory;
import com.percentagecalculatorexercise.utility.ConfigDataProvider;
import com.percentagecalculatorexercise.utility.ExcelDataProvider;
import com.percentagecalculatorexercise.utility.Helper;

public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;

	@BeforeSuite
	public void setUpSuite() {

		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
	}

	@BeforeClass
	public void setup() {

		driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getStagingURL());
	}

	@AfterClass
	public void tearDown() {

		BrowserFactory.quitBrowser(driver);

	}

	@AfterMethod
	public void tearDownMethod(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {

			Helper.captureScreenshot(driver);
		}
	}

}
