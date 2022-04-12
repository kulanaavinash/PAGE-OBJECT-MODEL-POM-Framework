package com.percentagecalculatorexercise.utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {

	public static WebDriver startApplication(WebDriver driver, String browserName, String appURL) {

		if (browserName.equalsIgnoreCase("Chrome")) {

			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("Firefox")) {

			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("IE")) {

			System.setProperty("webdriver.msedge.driver", "./Drivers/msedgedriver.exe");

			driver = new InternetExplorerDriver();

		} else {

			System.out.println("Selected Browser Platform Not Supporetd");

		}

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(appURL);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		return driver;

	}

	public static void quitBrowser(WebDriver driver) {
		driver.quit();
	}

}
