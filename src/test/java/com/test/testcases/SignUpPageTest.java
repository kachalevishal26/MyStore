package com.test.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.base.TestBase;
import com.test.pages.SignUpPage;
import com.test.testutil.TestUtils;

public class SignUpPageTest extends TestBase {
	SignUpPage signUp;

	public SignUpPageTest() {
		super();
	}

	@BeforeTest
	public void setup() {
		initialization();
		signUp = new SignUpPage();
	}

	@DataProvider
	public Object[][] dataProv() {
		Object data[][] = TestUtils.getData("register");

		return data;
	}

	@Test(dataProvider = "dataProv")
	public void register(String firstName, String lastName, String email, String password, String companyName,
			String address, String cityName, String stateName, String countryName, String aliasAddress)
			throws InterruptedException {
		signUp.signUp(firstName, lastName, email, password, companyName, address, cityName, stateName, countryName,
				aliasAddress);
		signUp.verifyLogin();
		signUp.logOut();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
