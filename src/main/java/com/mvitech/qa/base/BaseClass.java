package com.mvitech.qa.base;

import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mvitech.qa.util.TestUtil;

public class BaseClass implements WebDriverService {

	public static ResourceBundle prop;
	public static WebDriver driver;

	public BaseClass() {
		prop = ResourceBundle.getBundle("config");
	}

	public static void initialization() {
		String browserName = prop.getString("browser");
		if (browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getString("url"));

	}

	public WebElement locateElement(String locator, String locValue) {
		try {
			if (locator.equals("id"))
				return driver.findElement(By.id(locValue));
			else if (locator.equals("name"))
				return driver.findElement(By.name(locValue));
			else if (locator.equals("class"))
				return driver.findElement(By.className(locValue));
			else if (locator.equals("link"))
				return driver.findElement(By.linkText(locValue));
			else if (locator.equals("xpath"))
				return driver.findElement(By.xpath(locValue));
			else
				System.out.println("i is not present");
		} catch (NoSuchElementException e) {
		} catch (WebDriverException e) {
		}
		return null;
	}

	public void type(WebElement ele, String data) {
		try {
			ele.clear();
			ele.sendKeys(data);
		} catch (InvalidElementStateException e) {
		} catch (WebDriverException e) {
		}
	}

	public void click(WebElement ele) {
		String text = "";
		try {
			WebDriverWait wait = new WebDriverWait(driver, 90);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			text = ele.getText();
			ele.click();
		} catch (InvalidElementStateException e) {
		} catch (WebDriverException e) {
		}

	}

	public String getText(WebElement ele) {
		String bReturn = "";
		try {
			bReturn = ele.getText();
		} catch (WebDriverException e) {
		}
		return bReturn;
	}

	public String getTitle() {
		String bReturn = "";
		try {
			bReturn = driver.getTitle();
		} catch (WebDriverException e) {
		}
		return bReturn;
	}

	public boolean verifyExactTitle(String expectedTitle) {
		boolean bReturn = false;
		try {
			if (getTitle().equals(expectedTitle)) {
				bReturn = true;
			} else {
			}
		} catch (WebDriverException e) {
		}
		return bReturn;
	}

	public void closeActiveBrowser() {
		try {
			driver.close();
		} catch (Exception e) {
		}
	}

	public void closeAllBrowsers() {
		try {
			driver.quit();
		} catch (Exception e) {
		}
	}
}