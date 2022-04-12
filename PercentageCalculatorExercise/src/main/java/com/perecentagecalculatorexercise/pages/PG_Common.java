package com.perecentagecalculatorexercise.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PG_Common {

	WebDriver driver;

	public PG_Common(WebDriver ldriver) {

		this.driver = ldriver;
	}

	@FindBy(xpath = "//a[text()='Percentage Calculator']")
	WebElement PerecentageCalculatorBtn;

	@FindBy(name = "cpar1")
	WebElement tf_Value1;

	@FindBy(name = "cpar2")
	WebElement tf_Value2;

	@FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/input[2]")
	WebElement btn_Calculate;

	public void ClickOnPercentageCalBtn() {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PerecentageCalculatorBtn.click();

	}

	public void CalculateValue(String Value1, String Value2) {

		tf_Value1.sendKeys(Value1);
		tf_Value2.sendKeys(Value2);
		btn_Calculate.click();
		tf_Value1.sendKeys(Keys.CONTROL, "a");
		tf_Value1.sendKeys(Keys.BACK_SPACE);
		tf_Value2.sendKeys(Keys.CONTROL, "a");
		tf_Value2.sendKeys(Keys.BACK_SPACE);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void VerifyResult() {

		if (driver.getPageSource().contains("Result: 10")) {

			System.out.println("Verify the Result From Calculation");
		} else {

			System.out.println("Something Went Wrong Verifiaction Failed");
		}

	}

}
