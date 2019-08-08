package com.mvitech.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mvitech.qa.base.BaseClass;

public class LoginPage extends BaseClass {

	// Page Factory - OR:
	@FindBy(name = "j_username")
	private WebElement eleUserName;

	@FindBy(name = "j_password")
	private WebElement elePassword;

	@FindBy(xpath = "//button[contains(text(),'Sign In')]")
	private WebElement eleSignIn;

	// Initializing the Page Objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public HomePage login(String un, String pwd) {
		type(eleUserName, un);
		type(elePassword, pwd);
		click(eleSignIn);
		return new HomePage();
	}

}
