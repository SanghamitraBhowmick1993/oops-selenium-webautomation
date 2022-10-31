/**
 * 
 */
package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author sangb
 *
 */
public class LoginPage extends BasePage {
	// page locators:
	private By emailID = By.id("Email");
	private By password = By.id("Password");
	private By loginBtn = By.xpath("//*[text()='Log in']");
	private By header = By.className("title");

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	// public getters:

	/**
	 * @return the emailID
	 */
	public WebElement getEmailID() {
		return getElement(emailID);
	}

	/**
	 * @return the password
	 */
	public WebElement getPassword() {
		return getElement(password);
	}

	/**
	 * @return the loginBtn
	 */
	public WebElement getLoginBtn() {
		return getElement(loginBtn);

	}

	/**
	 * @return the header
	 */
	public WebElement getHeader() {
		return getElement(header);
	}

	public String getLoginPageTitle() {
		return getPageTite();
	}

	public String getLoginPageHeaader() {
		return getPageHeader(header);
	}
	
	public HomePage doLogin(String username, String pwd) throws InterruptedException {
		getEmailID().clear();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		getEmailID().sendKeys(username);
		getPassword().clear();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		getPassword().sendKeys(pwd);
		Thread.sleep(2000);
		getLoginBtn().click();
		return getInstance(HomePage.class);
	}
	
	public void doLogin() {
		getEmailID().clear();
		getEmailID().sendKeys("");
		getPassword().clear();
		getPassword().sendKeys("");
		getLoginBtn().click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
