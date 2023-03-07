package com.test.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.base.TestBase;
import com.test.pages.CheckoutPage;
import com.test.pages.HomePage;
import com.test.pages.LoginPage;
import com.test.pages.SignUpPage;
import com.test.testutil.TestUtils;

public class LoginPageTest extends TestBase {
	HomePage homePage;
	CheckoutPage checkoutPage;
	SignUpPage signUpPage;
	LoginPage loginPage;

	public LoginPageTest() {
		super();
	}

	@BeforeTest
	public void setup() {
		initialization();
		homePage = new HomePage();
		loginPage = new LoginPage();
		checkoutPage = new CheckoutPage();
	}
	
	@DataProvider
	public Object[][] excelData() {
		Object data[][] = TestUtils.getData("login");
		
		return data;
	}

	@Test(dataProvider = "excelData")
	public void loginTest(String uName, String uPwd) {
		loginPage.loginTest(uName, uPwd);
		loginPage.verifyLogin();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}