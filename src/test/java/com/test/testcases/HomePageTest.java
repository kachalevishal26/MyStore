package com.test.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.base.TestBase;
import com.test.pages.HomePage;
import com.test.pages.LoginPage;
import com.test.testutil.TestUtils;

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
