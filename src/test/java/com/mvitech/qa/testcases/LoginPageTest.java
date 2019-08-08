package com.mvitech.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mvitech.qa.base.BaseClass;
import com.mvitech.qa.pages.HomePage;
import com.mvitech.qa.pages.LoginPage;

public class LoginPageTest extends BaseClass {

	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		if (title.equals("Web admin")) {
			System.out.println("Title Matched");
		} else {
			System.out.println("Title not matches");
		}
	}

	@Test(priority = 2)
	public void loginTest() {
		homePage = loginPage.login(prop.getString("username"), prop.getString("password"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
