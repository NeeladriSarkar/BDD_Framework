package stepDefinition;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.WishlistPage;
import resources.Base;
import resources.Helper;

public class ValidateWishlist extends Base {

	@Given("user opens homepage for wishlist")
	public void user_opens_homepage_for_wishlist() throws IOException {
		driver = initializeDriver();
		Logger log = Helper.getLogger(getClass());
	    log.info("Validating Wishlist");
	}

	@When("user clicks on Wishlist option")
	public void user_clicks_on_wishlist_option() {
		LandingPage lp = new LandingPage(driver);
		lp.clickWishlist().click();
	}

	@Then("user must be able to see message on Wishlist page")
	public void user_must_be_able_to_see_message_on_wishlist_page() {
		WishlistPage wp = new WishlistPage(driver);
		Assert.assertTrue(wp.loginText().isDisplayed());
		Logger log = Helper.getLogger(getClass());
	    log.info("Successfully validated Wishlist");
	    driver.close();
	}
	
}
