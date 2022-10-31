package com.mytests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.mypages.LandingPage;
import com.mypages.ProductPage;

public class LandingTest extends BaseTest {
	ExtentTest test = extent.createTest("Verify page title");

	// @Test(priority = 1, enabled = false)
	public void verifyTempratureTest() throws IOException {
		System.out.println("executing verifyTempratureTest......");
		String currentTemperature = page.getInstance(LandingPage.class).tempartureCheck();
		if (Integer.parseInt(currentTemperature) < 19) {
			page.getInstance(LandingPage.class).clickBuyMoisturizers();
			String title = page.getInstance(LandingPage.class).getPageTite();
			String expectedTitle = "The Best Moisturizers in the World!";
			if (title.equals(expectedTitle)) {
				test.log(Status.PASS, "page title is verified",
						MediaEntityBuilder.createScreenCaptureFromPath(capture(driver)).build());
			} else {
				test.log(
						Status.FAIL, "failed to validate page header: " + " expected title is : " + expectedTitle
								+ " but found " + title,
						MediaEntityBuilder.createScreenCaptureFromPath(capture(driver)).build());
			}
		} else if (Integer.parseInt(currentTemperature) > 19) {
			page.getInstance(LandingPage.class).clickBuySunscreen();
			String title = page.getInstance(LandingPage.class).getPageTite();
			String expectedTitle = "The Best Sunscreens in the World!";
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

