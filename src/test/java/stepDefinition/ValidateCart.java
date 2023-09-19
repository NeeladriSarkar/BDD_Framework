package stepDefinition;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CartPage;
import pageObjects.LandingPage;
import resources.Base;
import resources.Helper;

public class ValidateCart extends Base {

	@Given("user opens homepage for cart")
	public void user_opens_homepage_for_cart() throws IOException {
	    driver = initializeDriver();
	    Logger log = Helper.getLogger(getClass());
	    log.info("Validating Cart");
	}

	@When("user clicks on Cart option")
	public void user_clicks_on_cart_option() {
		LandingPage lp = new LandingPage(driver);
		lp.clickCart().click();
	}

	@Then("user must be able to see Empty Cart and Browse in Cart page")
	public void user_must_be_able_to_see_empty_cart_and_browse_in_cart_page() {
		CartPage cp = new CartPage(driver);
		Assert.assertTrue(cp.emptyCartText().isDisplayed());
		Assert.assertTrue(cp.browseText().isDisplayed());
		Logger log = Helper.getLogger(getClass());
	    log.info("Successfully validated Cart");
	    driver.close();
	}
	
}
