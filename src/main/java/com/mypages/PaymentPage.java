package com.mypages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage extends BasePage{
    Actions action = new Actions(driver);

	public PaymentPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
    private By payWithCard = By.xpath("//span[contains(text(),'Pay with Card')]");
	private By email = By.id("email");
	private By cardNumber = By.id("card_number");
	private By monthYear = By.id("cc-exp");
	private By cvc = By.id("cc-csc");
	private By zipCode = By.xpath("//*[@placeholder=\"ZIP Code\"]");
    private By payBtn = By.xpath("//span[@class='iconTick']");
	private By paymentSuccess = By.xpath("//*[text()='PAYMENT SUCCESS']");
	private By framexpath = By.xpath("//iframe[contains(@src,'https://js.stripe.com/v2/m/outer.html')]");

	
	public void payWithCard() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(payWithCard));
		System.out.println("inside pay with card");
		getElement(payWithCard).click();
		Thread.sleep(3000);

	}
	
	public void enterCardDetailsForPayment(String emailID,String cardNum,String mnthYr,String cvcVal,String zip) throws InterruptedException {
        driver.switchTo().frame(0);
        action.moveToElement(getElement(email)).sendKeys(emailID).build().perform();
		Thread.sleep(2000);
		getElement(cardNumber).click();
		Thread.sleep(3000);
        action.moveToElement(getElement(cardNumber)).sendKeys(cardNum).build().perform();
		Thread.sleep(3000);
		getElement(monthYear).click();
        action.moveToElement(getElement(monthYear)).sendKeys(mnthYr).build().perform();
		Thread.sleep(2000);
		getElement(cvc).click();
        action.moveToElement(getElement(cvc)).sendKeys(cvcVal).build().perform();
		Thread.sleep(2000);
		getElement(zipCode).click();
        action.moveToElement(getElement(zipCode)).sendKeys(zip).build().perform();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
	}
	
	public void clickPayINR() throws InterruptedException {
        System.out.println("outside frame");
        driver.switchTo().frame(0);
        System.out.println("got inside frame");
        action.moveToElement(getElement(payBtn)).click().build().perform();
		Thread.sleep(7000);
	}
	
	public boolean getPaymentConfirmation() {
		if (getElements(paymentSuccess).size() >= 1)
			return true;
		else 
			return false;
	}
}
