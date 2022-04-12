package com.percentagecalculatorexercise.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.percentagecalculatorexercise.base.BaseClass;
import com.percentagecalculatorexercise.utility.ExcelDataProvider;
import com.percentagecalculatorexercise.utility.Helper;
import com.perecentagecalculatorexercise.pages.PG_Common;

public class TestCase extends BaseClass {

	@Test
	public void OpenApp() {

		ExcelDataProvider excel = new ExcelDataProvider();

		PG_Common pg_common = PageFactory.initElements(driver, PG_Common.class);

		pg_common.ClickOnPercentageCalBtn();

		for (int i = 1; i < 5; i++) {

			pg_common.CalculateValue(excel.getStringData("Sheet1", 0, 0), excel.getStringData("Sheet1", 0, 1));

			System.out.println("Iteration" + " " + i + " " + "Run");

		}

		System.out.println("");

		pg_common.VerifyResult();

		pg_common.CalculateValue(excel.getStringData("Sheet2", 0, 0), excel.getStringData("Sheet2", 0, 1));

		System.out.println("Iteration 5 Run");

		System.out.println("");

		Helper.captureScreenshot(driver);

	}

}
