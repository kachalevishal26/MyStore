package com.test.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.test.testutil.TestUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {
		FileInputStream file = null;
		try {
			file = new FileInputStream(
					"C:\\Users\\Asus\\eclipse-workspace\\MyStore\\src\\main\\java\\com\\test\\config\\config.properties");
			prop = new Properties();
			prop.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void initialization() {
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Integer> contentSettings = new HashMap<String, Integer>();
		HashMap<String, Object> profile = new HashMap<String, Object>();
		HashMap<String, Object> prefs = new HashMap<String, Object>();

		contentSettings.put("notifications", 1);
		profile.put("managed_default_content_settings", contentSettings);
		prefs.put("profile", profile);

		options.setExperimentalOption("prefs", prefs);

		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtils.EXPLICIT_WAIT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtils.IMPLICIT_WAIT));
		driver.get(prop.getProperty("url"));
	}

	public void getScreenshots(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destination));
	}
}
