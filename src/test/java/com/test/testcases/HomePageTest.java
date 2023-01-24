package com.test.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.base.TestBase;
import com.test.pages.HomePage;
import com.test.pages.LoginPage;

public class HomePageTest extends TestBase {
	HomePage homePage;
	LoginPage loginPage;

	public HomePageTest() {
		super();
	}

	@BeforeTest
	public void setup() {
		initialization();
		homePage = new HomePage();
		loginPage = new LoginPage();
	}

	@Test
	public void loginTest() {
		loginPage.loginTest();
	}

	@Test
	public void addProduct() {
		homePage.productAdd();
	}

	@Test
	public void addDress() {
		homePage.shoppingCart();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
