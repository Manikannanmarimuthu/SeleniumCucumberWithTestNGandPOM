package com.mvitech.qa.base;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public interface WebDriverService {

	/**
	 * This method will locate the element using any given locator
	 * 
	 * @param locator  - The locator by which the element to be found
	 * @param locValue - The locator value by which the element to be found
	 * @throws NoSuchElementException
	 */
	public WebElement locateElement(String locator, String locValue);

	/**
	 * This method will enter the value in the given text field
	 * 
	 * @param ele  - The Webelement (text field) in which the data to be entered
	 * @param data - The data to be sent to the webelement
	 * @throws ElementNotVisibleException *
	 */
	public void type(WebElement ele, String data);

	/**
	 * This method will click the element and take snap
	 * 
	 * @param ele - The Webelement (button/link/element) to be clicked
	 */
	public void click(WebElement ele);

	/**
	 * This method will get the text of the element
	 * 
	 * @param ele - The Webelement (button/link/element) in which text to be
	 *            retrieved
	 */
	public String getText(WebElement ele);

	/**
	 * This method will select the drop down visible text
	 * 
	 * @param ele   - The Webelement (dropdown) to be selected
	 * @param value The value to be selected (visibletext) from the dropdown
	 */

	public boolean verifyExactTitle(String expectedTitle);

	/**
	 * This method will verify browser actual title with expected text using
	 * contains
	 * 
	 * @param title - The expected title of the browser
	 */
	public void closeActiveBrowser();

	/**
	 * This method will close all the browsers
	 * 
	 */
	public void closeAllBrowsers();

}
