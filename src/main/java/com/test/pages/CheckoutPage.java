package com.test.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.base.TestBase;

public class CheckoutPage extends TestBase {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	JavascriptExecutor js = (JavascriptExecutor) driver;
	Actions action = new Actions(driver);

	@FindBy(xpath = "//*[@class='logo img-responsive']")
	WebElement homeImg;

	@FindBy(xpath = "//a[@id='button_order_cart']")
	WebElement hoverCheckout;

	public CheckoutPage() {
		PageFactory.initElements(driver, this);
	}

	public void checkout() {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[@title='View my shopping cart']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='View my shopping cart']")));
		WebElement hover = driver.findElement(By.xpath("//a[@title='View my shopping cart']"));
		action.moveToElement(hover).build().perform();
		hoverCheckout.click();
		js.executeScript("scroll(0,320)");
	}

	public void verifyAmount() {

	}
}
