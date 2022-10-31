package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	private By header = By.className("content-header");
	
	public WebElement getHeader() {
		return getElement(header);
	}
	
	//page actions:
	public String getHomePageTitle() {
		return getPageTite();
	}

	public String getHomePageHeader() {
		return getPageHeader(header);
	}

}
