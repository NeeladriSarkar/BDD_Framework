package stepDefinition;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.StoresPage;
import resources.Base;
import resources.Helper;

public class ValidateStores extends Base {

	@Given("user opens homepage for stores")
	public void user_opens_homepage_for_stores() throws IOException {
		driver = initializeDriver();
		Logger log = Helper.getLogger(getClass());
	    log.info("Validating Stores");
	}

	@When("user clicks on Stores option")
	public void user_clicks_on_stores_option() {
		LandingPage lp = new LandingPage(driver);
		lp.clickStores().click();
	}

	@Then("user must be able to see the location of the store on Stores page")
	public void user_must_be_able_to_see_the_location_of_the_store_on_stores_page() {
		StoresPage sp = new StoresPage(driver);
		Assert.assertTrue(sp.getLocation().isDisplayed());
		Logger log = Helper.getLogger(getClass());
	    log.info("Successfully validated Stores");
	    driver.close();
	}
	
}
