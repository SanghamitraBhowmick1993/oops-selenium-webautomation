package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage extends BasePage{
	public LandingPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private By tempValue = By.id("temperature");
	private By moisturizersValue = By.xpath("//*[text()='Buy moisturizers']");
	private By sunscreenValue = By.xpath("//*[text()='Buy sunscreens']");

	
	public WebElement getTemprature() {
		return getElement(tempValue);
	}
	 public String tempartureCheck() {
		 System.out.println(getTemprature().getText().split(" ")[0]);
		return getTemprature().getText().split(" ")[0];
		
	 }
	 public WebElement getBuyMoisturizers() {
			return getElement(moisturizersValue);
		}
	 
	 public WebElement getSunScreen() {
			return getElement(sunscreenValue);
		}
	 public ProductPage clickBuyMoisturizers() {
		 getBuyMoisturizers().click();
		return getInstance(ProductPage.class);
	 }
	 
	 public ProductPage clickBuySunscreen() {
		 getSunScreen().click();
		return getInstance(ProductPage.class);
	 }
}