package com.mypages;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BasePage {
//	List<WebElement> listProductsName;
//	List<WebElement> listProductsPrice;
//	String price[];
//	ArrayList<String> spf30Price = new ArrayList<String>();
//	ArrayList<String> spf50Price = new ArrayList<String>();
//	int minspf30Price;
//	int minspf50Price;
//
//	List<WebElement> listMoisturizersProductsName;
//	List<WebElement> listMoisturizersProductsPrice;
//	ArrayList<String> aloePrice = new ArrayList<String>();
//	ArrayList<String> almondPrice = new ArrayList<String>();
//	int minAloePrice;
//	int minAlmondPrice;

	public ProductPage(WebDriver driver) {
		super(driver);
	}

	private By heading = By.xpath("//h2");
	private By productList = By.xpath("//div[@class='container']/div");
	private By productPrice = By.xpath("//p[contains(text(),'Price')]");
	private By cartButtonText = By.xpath("//button[@onclick='goToCart()']/span");
	private By cartButton = By.xpath("//button[@onclick='goToCart()']");
	private String dynamicCheapXPath = "";
	// Moist
	private By aleoPrice = By.xpath(
			"//p[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'aloe')]//following-sibling::p");
	private By almondPrice = By.xpath(
			"//p[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'almond')]//following-sibling::p");
	// Sunscreens
	private By spf50Price = By.xpath(
			"//p[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'spf-50')]//following-sibling::p");
	private By spf30Price = By.xpath(
			"//p[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'spf-30')]//following-sibling::p");
	private By moistDisplayed = By.xpath("//*[text()='Sunscreens']");
	private By sunscreenDisplayed = By.xpath("//*[text()='Moisturizers']");

	public List<WebElement> getAllProductName() {
		return getElements(productList);
	}

	public List<WebElement> getAllProductPrice() {
		return getElements(productPrice);
	}

	// Sunscreen:
	public void findCheapestSPF50() throws InterruptedException {
		WebElement elem = null;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productList));
		List<WebElement> sPF50PriceList = driver.findElements(spf50Price);
		Map<WebElement, Integer> mapSPF50 = new HashMap<>();
		for (WebElement ele : sPF50PriceList) {
			String price = ele.getText();
			String priceSplit[] = price.split(" ");
			int priceInInt = Integer.parseInt(priceSplit[priceSplit.length - 1]);
			mapSPF50.put(ele, priceInInt);
		}
		int min = Collections.min(mapSPF50.values());
		for (Map.Entry<WebElement, Integer> entry : mapSPF50.entrySet()) {
			if (entry.getValue() == min) {
				elem = entry.getKey();
				break;
			}
		}

		dynamicCheapXPath = "//" + elem.getTagName() + "[contains(text(),'" + min + "')]//following-sibling::button";
		System.out.println("Cheapest sunscreen " + driver.findElement(heading).getText()
				+ " with SPF-50 xpath created: " + dynamicCheapXPath);
		driver.findElement(By.xpath(dynamicCheapXPath)).click();
		Thread.sleep(3000);

	}

	public void findCheapestSPF30() throws InterruptedException {
		WebElement elem = null;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productList));
		List<WebElement> sPF30PriceList = driver.findElements(spf30Price);
		Map<WebElement, Integer> mapSPF30 = new HashMap<>();
		for (WebElement ele : sPF30PriceList) {
			String price = ele.getText();
			String priceSplit[] = price.split(" ");
			int priceInInt = Integer.parseInt(priceSplit[priceSplit.length - 1]);
			mapSPF30.put(ele, priceInInt);
		}
		int min = Collections.min(mapSPF30.values());
		for (Map.Entry<WebElement, Integer> entry : mapSPF30.entrySet()) {
			if (entry.getValue() == min) {
				elem = entry.getKey();
				break;
			}
		}

		dynamicCheapXPath = "//" + elem.getTagName() + "[contains(text(),'" + min + "')]//following-sibling::button";
		System.out.println("Cheapest sunscreen " + driver.findElement(heading).getText()
				+ " with SPF-30 xpath created: " + dynamicCheapXPath);
		driver.findElement(By.xpath(dynamicCheapXPath)).click();
		Thread.sleep(3000);

	}

	public void findCheapestAlmond() throws InterruptedException {
		WebElement elem = null;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productList));
		List<WebElement> almondPriceList = driver.findElements(almondPrice);
		Map<WebElement, Integer> mapAlmond = new HashMap<>();
		for (WebElement ele : almondPriceList) {
			String price = ele.getText();
			String priceSplit[] = price.split(" ");
			int priceInInt = Integer.parseInt(priceSplit[priceSplit.length - 1]);
			mapAlmond.put(ele, priceInInt);
		}
		int min = Collections.min(mapAlmond.values());
		for (Map.Entry<WebElement, Integer> entry : mapAlmond.entrySet()) {
			if (entry.getValue() == min) {
				elem = entry.getKey();
				break;
			}
		}

		dynamicCheapXPath = "//" + elem.getTagName() + "[contains(text(),'" + min + "')]//following-sibling::button";
		System.out.println("Cheapest sunscreen " + driver.findElement(heading).getText()
				+ " with Almond xpath created: " + dynamicCheapXPath);
		driver.findElement(By.xpath(dynamicCheapXPath)).click();
		Thread.sleep(3000);

	}

	public void findCheapestAloe() throws InterruptedException {
		WebElement elem = null;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productList));
		List<WebElement> aloePriceList = driver.findElements(aleoPrice);
		Map<WebElement, Integer> mapAloe = new HashMap<>();
		for (WebElement ele : aloePriceList) {
			String price = ele.getText();
			String priceSplit[] = price.split(" ");
			int priceInInt = Integer.parseInt(priceSplit[priceSplit.length - 1]);
			mapAloe.put(ele, priceInInt);
		}
		int min = Collections.min(mapAloe.values());
		for (Map.Entry<WebElement, Integer> entry : mapAloe.entrySet()) {
			if (entry.getValue() == min) {
				elem = entry.getKey();
				break;
			}
		}

		dynamicCheapXPath = "//" + elem.getTagName() + "[contains(text(),'" + min + "')]//following-sibling::button";
		System.out.println("Cheapest sunscreen " + driver.findElement(heading).getText() + " with Aloe xpath created: "
				+ dynamicCheapXPath);
		driver.findElement(By.xpath(dynamicCheapXPath)).click();
		Thread.sleep(3000);

	}

	public PaymentPage clickCartButton() throws InterruptedException {
		driver.findElement(cartButton).click();
		Thread.sleep(3000);
		return getInstance(PaymentPage.class);

	}

	public boolean moistDisplayed() {
		if (getElements(moistDisplayed).size() >= 1)
			return true;
		else 
			return false;
	}

	public boolean sunscreenDisplayed() {
		if (getElements(sunscreenDisplayed).size() >= 1)
			return true;
		else 
			return false;
	}

}

//Utility::	
//	List<WebElement> name = getAllProductName();
//	List<String> lst1 = new ArrayList<>();
//	List<WebElement> price = getAllProductPrice();
//	List<String> lst2 = new ArrayList<>();	
//
//	name.stream()
//			.map(WebElement::getText).forEach(lst1::add);
//	price.stream()
//	.map(WebElement::getText).forEach(lst2::add);
//	
//	Map<String, String> mappedValue = zipToMap(lst1,lst2);
//	for (Map.Entry<String, String> entry : mappedValue.entrySet()) {
//	    System.out.println(entry.getKey() + "/" + entry.getValue());
//	}
//	}
//	public static <K, V> Map<K, V> zipToMap(List<K> keys, List<V> values) {
//	    Iterator<K> keyIter = keys.iterator();
//	    Iterator<V> valIter = values.iterator();
//	    return IntStream.range(0, keys.size()).boxed()
//	            .collect(Collectors.toMap(i -> keyIter.next(), i -> valIter.next()));
//	}
