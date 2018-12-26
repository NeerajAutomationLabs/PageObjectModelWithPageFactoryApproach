package com.website.ezmall.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.website.ezmall.qa.utils.TestUtil;
import com.website.ezmall.qa.utils.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver objEventFiringWebDriver;
	public static WebEventListener objWebEventListener;
	

	public TestBase() {
		try {

			prop = new Properties();
			FileInputStream file = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com/website/ezmall/qa/config/config.properties");
			prop.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void initialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/src/main/java/Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("FF")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "/src/main/java/Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		objEventFiringWebDriver= new EventFiringWebDriver(driver);
		objWebEventListener = new WebEventListener();
		objEventFiringWebDriver.register(objWebEventListener);
		driver=objEventFiringWebDriver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

	}

	
	
	
	
	

}
