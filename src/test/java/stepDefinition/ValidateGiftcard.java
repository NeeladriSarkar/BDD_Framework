package stepDefinition;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.GiftPage;
import pageObjects.LandingPage;
import resources.Base;
import resources.Helper;

public class ValidateGiftcard extends Base {

	@Given("user opens homepage for gift card")
	public void user_opens_homepage_for_gift_card() throws IOException {
		driver = initializeDriver();
	    Logger log = Helper.getLogger(getClass());
	    log.info("Validating Gift Cards");
	}

	@When("user clicks on Gift Cards option")
	public void user_clicks_on_gift_cards_option() {
		LandingPage lp = new LandingPage(driver);
		lp.clickGiftCard().click();
	}

	@Then("user must be able to see Special Occassions on Gift Cards page")
	public void user_must_be_able_to_see_special_occassions_on_gift_cards_page() {
		GiftPage gp = new GiftPage(driver);
		Assert.assertTrue(gp.getText().isDisplayed());
		Logger log = Helper.getLogger(getClass());
	    log.info("Successfully validated Gift Cards");
	    driver.close();
	}
	
}
