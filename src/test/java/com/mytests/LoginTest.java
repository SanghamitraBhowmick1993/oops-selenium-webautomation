package com.mytests;

import java.io.IOException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.mypages.HomePage;
import com.mypages.LoginPage;
import com.utils.ConfigReader;

public class LoginTest extends BaseTest {
	ExtentTest test = extent.createTest("Verify page title");

	@Test(priority = 1, enabled = false)
	public void verifyLoginPageTitleTest() throws IOException {
        System.out.println("verifyLoginPageTitleTest() thread name: " + Thread.currentThread().getId());
		String title = page.getInstance(LoginPage.class).getLoginPageTitle();
		System.out.println(title);
		String expectedTitle = "Your store. Login";
		if (title.equals(expectedTitle)) {
			// Assert.assertEquals(title, "Your store. Login");
			test.log(Status.PASS, "page title is verified",
					MediaEntityBuilder.createScreenCaptureFromPath(capture(driver)).build());
		} else {
			test.log(Status.FAIL,
					"failed to validate page title: " + " expected title is : " + expectedTitle + " but found " + title,
					MediaEntityBuilder.createScreenCaptureFromPath(capture(driver)).build());
		}
	}

	@Test(priority = 2, enabled = false)
	public void verifyLoginPageHeaderTest() throws IOException {
        System.out.println("verifyLoginPageHeaderTest() thread name: " + Thread.currentThread().getId());
		String header = page.getInstance(LoginPage.class).getLoginPageHeaader();
		System.out.println(header);
		String expectedTitle = "Welcome, please sign in!";
		if (header.equals(expectedTitle)) {
			test.log(Status.PASS, "page header is verified",
					MediaEntityBuilder.createScreenCaptureFromPath(capture(driver)).build());
		} else {
			test.log(Status.FAIL,
					"failed to validate page header: " + " expected title is : " + expectedTitle + " but found " + header,
					MediaEntityBuilder.createScreenCaptureFromPath(capture(driver)).build());
		}
	}

	@Test(priority = 3, enabled = false)
	public void doLogin() throws InterruptedException, IOException {
        System.out.println("verifyLoginPageHeaderTest() thread name: " + Thread.currentThread().getId());
		HomePage homePage = page.getInstance(LoginPage.class).doLogin(ConfigReader.getusernmeValue(),
				ConfigReader.getpasswordValue());
		String headerHome = homePage.getHomePageHeader();
		String expectedTitle = "Dashboard";
		if (headerHome.equals(expectedTitle)) {
			test.log(Status.PASS, "login title is verified",
					MediaEntityBuilder.createScreenCaptureFromPath(capture(driver)).build());
		} else {
			test.log(Status.FAIL,
					"failed to validate login title: " + " expected title is : " + expectedTitle + " but found " + headerHome,
					MediaEntityBuilder.createScreenCaptureFromPath(capture(driver)).build());
		}
	}
	@Test(priority = 4, enabled = false)
	public void doLoginWithoutCreds() throws InterruptedException, IOException {
        System.out.println("verifyLoginPageHeaderTest() thread name: " + Thread.currentThread().getId());
		page.getInstance(LoginPage.class).doLogin();
		String title = page.getInstance(LoginPage.class).getLoginPageTitle();
		System.out.println(title);
		String expectedTitle = "Your store. Login";
		if (title.equals(expectedTitle)) {
			// Assert.assertEquals(title, "Your store. Login");
			test.log(Status.PASS, "page title is verified",
					MediaEntityBuilder.createScreenCaptureFromPath(capture(driver)).build());
		} else {
			test.log(Status.FAIL,
					"failed to validate page title: " + " expected title is : " + expectedTitle + " but found " + title,
					MediaEntityBuilder.createScreenCaptureFromPath(capture(driver)).build());
		}
	}

	}

