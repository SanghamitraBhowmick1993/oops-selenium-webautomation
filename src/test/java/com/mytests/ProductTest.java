package com.mytests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.mypages.LandingPage;
import com.mypages.ProductPage;

public class ProductTest extends LandingTest {
	//@Test(priority = 1, enabled = true)
	public void addProductsToCart() throws IOException, InterruptedException {
		verifyTempratureTest();
		System.out.println("executing addProductsToCart......");
		if (page.getInstance(ProductPage.class).moistDisplayed() == true) {
			page.getInstance(ProductPage.class).findCheapestSPF50();
			page.getInstance(ProductPage.class).findCheapestSPF30();
			page.getInstance(ProductPage.class).clickCartButton();
			String title = page.getInstance(ProductPage.class).getPageTite();
			String expectedTitle = "Cart Items";
			if (title.equals(expectedTitle)) {
				test.log(Status.PASS, "page title is verified",
						MediaEntityBuilder.createScreenCaptureFromPath(capture(driver)).build());
			} else {
				test.log(
						Status.FAIL, "failed to validate page title: " + " expected title is : " + expectedTitle
								+ " but found " + title,
						MediaEntityBuilder.createScreenCaptureFromPath(capture(driver)).build());
			}

		} else if (page.getInstance(ProductPage.class).sunscreenDisplayed() == true) {
			page.getInstance(ProductPage.class).findCheapestAlmond();
			page.getInstance(ProductPage.class).findCheapestAloe();
			page.getInstance(ProductPage.class).clickCartButton();
			String title = page.getInstance(LandingPage.class).getPageTite();
			String expectedTitle = "Cart Items";
			if (title.equals(expectedTitle)) {
				test.log(Status.PASS, "page title is verified",
						MediaEntityBuilder.createScreenCaptureFromPath(capture(driver)).build());
			} else {
				test.log(
						Status.FAIL, "failed to validate page title: " + " expected title is : " + expectedTitle
								+ " but found " + title,
						MediaEntityBuilder.createScreenCaptureFromPath(capture(driver)).build());
			}
		}

	}
}
