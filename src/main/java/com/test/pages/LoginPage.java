package com.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.base.TestBase;

public class LoginPage extends TestBase 
{
	@FindBy(xpath = "//a[@class='login']")
	WebElement loginBtn;
	
	@FindBy(id = "email")
	WebElement logEmail;
	
	@FindBy(id = "passwd")
	WebElement logPassword;
	
	@FindBy(id = "SubmitLogin")
	WebElement submitBtn;
	
	@FindBy(xpath = "//a[@class='logout']")
	WebElement signOutBtn;
	
	@FindBy(xpath = "//*[@class='logo img-responsive']")
	WebElement homeImg;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void loginTest()
	{
		loginBtn.click();
		logEmail.sendKeys("sunny+25@sunnny.com");
		logPassword.sendKeys("123456");
	
		submitBtn.click();
	}
	
	public void verifyLogin()
	{
		signOutBtn.isDisplayed();
		homeImg.click();
		System.out.println("Successfully logged in.");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
