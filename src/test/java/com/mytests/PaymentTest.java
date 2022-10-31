package com.mytests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.mypages.LandingPage;
import com.mypages.PaymentPage;
import com.mypages.ProductPage;
import com.utils.ConfigReader;

public class PaymentTest extends ProductTest {
	@Test(priority = 1, enabled = true)
	public void enterCardDetailsandMakePayment() throws IOException, InterruptedException {
		addProductsToCart();
		System.out.println("executing enterCardDetailsandMakePayment......");
		page.getInstance(PaymentPage.class).payWithCard();
		page.getInstance(PaymentPage.class).
		enterCardDetailsForPayment(ConfigReader.emailDetails(), ConfigReader.cardDetails(), 
				ConfigReader.monthYrDetails(), ConfigReader.cvcDetails(),ConfigReader.zipDetails());

		page.getInstance(PaymentPage.class).clickPayINR();	
			
			String title = page.getInstance(PaymentPage.class).getPageTite();
			String expectedTitle = "Confirmation";
			if (title.equals(expectedTitle)) {
				test.log(Status.PASS, "page title is verified",
						MediaEntityBuilder.createScreenCaptureFromPath(capture(driver)).build());
			} else {
				test.log(
						Status.FAIL, "failed to validate page title: " + " expected title is : " + expectedTitle
								+ " but found " + title,
						MediaEntityBuilder.createScreenCaptureFromPath(capture(driver)).build());
			}
			if (page.getInstance(PaymentPage.class).getPaymentConfirmation() == true) {
				test.log(Status.PASS, "Payment is successful",
						MediaEntityBuilder.createScreenCaptureFromPath(capture(driver)).build());
		}else {
			test.log(
					Status.FAIL, "Payment has failed",
					MediaEntityBuilder.createScreenCaptureFromPath(capture(driver)).build());
		}

	}
}

