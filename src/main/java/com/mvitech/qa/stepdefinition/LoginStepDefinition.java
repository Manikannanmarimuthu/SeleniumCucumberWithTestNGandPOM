package com.mvitech.qa.stepdefinition;

import com.mvitech.qa.base.BaseClass;
import com.mvitech.qa.pages.HomePage;
import com.mvitech.qa.pages.LoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefinition extends BaseClass {

	LoginPage loginPage;
	HomePage homePage;

	@Given("^user is already on Login Page$")
	public void user_is_already_on_Login_Page() {
		BaseClass.initialization();

	}

	@When("^title of login page is DIV$")
	public void title_of_login_page_is_DIV() {
		loginPage = new LoginPage();
		String title = loginPage.validateLoginPageTitle();
		if (title.equals("Web admin")) {
			System.out.println("DIV Web Admin Title Matched");
		} else {
			System.out.println("DIV Web Admin Title not Matched");
		}
	}

	@Then("^user enters username and password and click login button$")
	public void user_enters_username_and_password_and_click_login_button() {
		homePage = loginPage.login(prop.getString("username"), prop.getString("password"));
	}

	@Then("^Close the browser$")
	public void close_the_browser() {
		driver.close();
	}

}
