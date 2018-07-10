package com.qa.stepDefinitions;

import org.junit.Assert;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class HomePageSteps extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	
	
	@Given("^user opens browser$")
	public void user_opens_browser() throws Throwable {
		initalization();
	}
	
	@Then("^user is on login page$")
	public void user_is_on_login_page() throws Throwable {
		loginPage = new LoginPage();
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals("Free CRM software in the cloud powers sales and customer service", title);
	}
	
	@Then("^user login to application$")
	public void user_login_to_application() throws Throwable {
	    homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Then("^validate home page title$")
	public void validate_home_page_title() throws Throwable {
		String homeTitle = homePage.verifyHomePageTitle();
	    Assert.assertEquals("CRMPRO", homeTitle);
	}
	
	@Then("^validate logged in username$")
	public void validate_logged_in_username() throws Throwable {
		boolean flag = homePage.verifyCorrectUserName();
		Assert.assertTrue(flag);
	}



}
