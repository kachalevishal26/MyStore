package com.test.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.base.TestBase;

public class HomePage extends TestBase {
	Actions action = new Actions(driver);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));

	@FindBy(xpath = "//ul[@id='homefeatured']/li")
	WebElement productsList;

	@FindBy(xpath = "//*[contains(text(),'Quick view')]")
	WebElement qView;

	@FindBy(xpath = "//*[@title='Close']")
	WebElement closeBtn;

	@FindBy(xpath = "//span[@class='cross']")
	WebElement closeBtn2;

	@FindBy(xpath = "//*[contains(text(),'Add to cart')]")
	WebElement addToCartBtn;

	@FindBy(xpath = "//a[@class='sf-with-ul' and contains(text(),'Women')]")
	WebElement womenBtn;

	@FindBy(xpath = "//a[contains(text(),'Summer Dresses')]")
	WebElement summerDressBtn;

	@FindBy(id = "selectProductSort")
	WebElement sortByDd;

	@FindBy(xpath = "//*[@class='logo img-responsive']")
	WebElement homeImg;

	@FindBy(xpath = "//*[@class='add_to_compare']")
	WebElement addCompare;

	@FindBy(xpath = "//button[@class='exclusive']")
	WebElement addToCartFrame;

	@FindBy(xpath = "//a[@id='button_order_cart']")
	WebElement hoverCheckout;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public void productAdd() {
		js.executeScript("scroll(0,850)");
		List<WebElement> productsList = driver.findElements(By.xpath("//ul[@id='homefeatured']/li"));
		for (int i = 0; i < productsList.size(); i++) {
			if (productsList.get(i).getText().contains("Faded Short Sleeve T-shirts")) {
				// productsList.get(i).click();
				WebElement hover = productsList.get(i);
				action.moveToElement(hover).build().perform();
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Quick view')]")));
				wait.until(ExpectedConditions.elementToBeClickable(qView)).click();
				closeBtn.click();
				action.moveToElement(hover).build().perform();
				wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
				closeBtn2.click();
				js.executeScript("scroll(0,-850)");
			}
		}
	}

	public void shoppingCart() {
//		js.executeScript("scroll(0,-850)");
		action.moveToElement(womenBtn).build().perform();
		summerDressBtn.click();
		js.executeScript("scroll(0,420)");
		// WebElement priceDd = sortByDd;
		// Select priceSort = new Select(priceDd);
		// priceSort.selectByValue("price:asc");
		List<WebElement> productsList = driver.findElements(By.xpath("//ul[@class='product_list grid row']/li"));
		for (int i = 0; i < productsList.size(); i++) {
			if (productsList.get(i).getText().contains("Printed Summer Dress")) {
				// productsList.get(i).click();
				WebElement hover = productsList.get(i);
				action.moveToElement(hover).build().perform();
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Quick view')]")));
				wait.until(ExpectedConditions.elementToBeClickable(qView)).click();
				// closeBtn.click();

				WebElement prodFrame = driver.findElement(By.xpath("//iframe[@class='fancybox-iframe']"));
				driver.switchTo().frame((prodFrame));
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//button[@class='exclusive']")));
				wait.until(ExpectedConditions.elementToBeClickable(addToCartFrame));
				addToCartFrame.click();

				driver.switchTo().defaultContent();
				closeBtn2.click();
				js.executeScript("scroll(0,-420)");
				homeImg.click();

			}
		}
	}

}
