package com.test.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.test.base.TestBase;
import com.test.pages.CheckoutPage;
import com.test.pages.HomePage;
import com.test.pages.LoginPage;
import com.test.pages.SignUpPage;

public class CheckoutPageTest extends TestBase {
	HomePage homePage;
	CheckoutPage checkoutPage;
	LoginPage loginPage;

	public CheckoutPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		homePage = new HomePage();
		checkoutPage = new CheckoutPage();
		loginPage = new LoginPage();
	}

	public void signUp() {

	}

	@Test
	public void addProduct() throws InterruptedException {
		loginPage.loginTest();
		homePage.productAdd();
		checkoutPage.checkout();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
