package com.test.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.base.TestBase;

public class SignUpPage extends TestBase {
	@FindBy(xpath = "//a[@class='login']")
	WebElement loginBtn;

	@FindBy(id = "SubmitCreate")
	WebElement createAccountBtn;

	@FindBy(id = "email_create")
	WebElement emailTxtBox;

	@FindBy(xpath = "//*[@class='top']")
	WebElement mrTitle;

	@FindBy(id = "submitAccount")
	WebElement regBtn;

	@FindBy(id = "customer_firstname")
	WebElement fName;

	@FindBy(id = "customer_lastname")
	WebElement lName;

	@FindBy(id = "passwd")
	WebElement custPassword;

	@FindBy(id = "days")
	WebElement daysDd;

	@FindBy(id = "months")
	WebElement monthsDd;

	@FindBy(id = "years")
	WebElement yearsDd;

	@FindBy(id = "company")
	WebElement companyTxt;

	@FindBy(id = "address1")
	WebElement addressTxt;

	@FindBy(id = "city")
	WebElement cityTxt;

	@FindBy(id = "id_state")
	WebElement stateDd;

	@FindBy(id = "postcode")
	WebElement postCodeTxt;

	@FindBy(id = "id_country")
	WebElement countryDd;

	@FindBy(id = "phone_mobile")
	WebElement phoneNo;

	@FindBy(id = "alias")
	WebElement aliasAdd;

	@FindBy(xpath = "//a[@class='logout']")
	WebElement signOutBtn;

	@FindBy(xpath = "//*[@class='logo img-responsive']")
	WebElement homeImg;

	public SignUpPage() {
		PageFactory.initElements(driver, this);
	}

	public void signUp(String firstName, String lastName, String email, String password, String companyName,
			String address, String cityName, String stateName, String countryName, String aliasAddress)
			throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		loginBtn.click();
		emailTxtBox.sendKeys(email);
		wait.until(ExpectedConditions.elementToBeClickable(createAccountBtn)).click();
		// CheckValidations
//		js.executeScript("scroll(0,1150)");
//		wait.until(ExpectedConditions.elementToBeClickable(regBtn)).click();
		// Details
		List<WebElement> allOptions = driver.findElements(By.xpath("//*[@class='top']"));
		for (int i = 0; i < allOptions.size(); i++) {
			if (allOptions.get(i).getText().contains("Mr.")) {
				allOptions.get(i).click();
			}
		}
		fName.sendKeys(firstName);
		lName.sendKeys(lastName);
		custPassword.sendKeys(password);

		// Date
		daysDd.click();
		Thread.sleep(1000);
		WebElement day = driver.findElement(By.id("days"));
		Select sel = new Select(day);
		sel.selectByValue("26");
		daysDd.click();

		// Month
		monthsDd.click();
		Thread.sleep(1000);
		WebElement month = driver.findElement(By.id("months"));
		Select sel1 = new Select(month);
		sel1.selectByValue("6");
		monthsDd.click();

		// Year
		yearsDd.click();
		Thread.sleep(1000);
		WebElement year = driver.findElement(By.id("years"));
		Select sel3 = new Select(year);
		sel3.selectByValue("1997");
		yearsDd.click();

		js.executeScript("scroll(0,1000)");

		companyTxt.sendKeys(companyName);
		addressTxt.sendKeys(address);
		cityTxt.sendKeys(cityName);
		Select selState = new Select(stateDd);
		selState.selectByVisibleText(stateName);
		postCodeTxt.sendKeys("00000");
		Select selCountry = new Select(countryDd);
		selCountry.selectByVisibleText(countryName);
		phoneNo.sendKeys("7600768118");
		aliasAdd.sendKeys(aliasAddress);
		regBtn.click();
		homeImg.click();
		Thread.sleep(2000);
	}

	public void verifyLogin() {
		signOutBtn.isDisplayed();
		homeImg.click();
		System.out.println("Successfully logged in.");
	}

	public void logOut() {
		signOutBtn.click();
	}
}
