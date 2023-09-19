package stepDefinition;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BulkOrdersPage;
import pageObjects.LandingPage;
import resources.Base;
import resources.Helper;

public class ValidateBulkOrders extends Base {

	@Given("user opens homepage for bulk orders")
	public void user_opens_homepage_for_bulk_orders() throws IOException {
	    driver = initializeDriver();
	    Logger log = Helper.getLogger(getClass());
	    log.info("Validating Bulk Orders");
	}

	@When("user clicks on Bulk Orders option")
	public void user_clicks_on_bulk_orders_option() {
		LandingPage lp = new LandingPage(driver);
		lp.clickBulkOrder().click();
	}

	@Then("user must be able to see the image")
	public void user_must_be_able_to_see_the_image() {
		BulkOrdersPage bp = new BulkOrdersPage(driver);
		Assert.assertTrue(bp.getImage().isDisplayed());
		Logger log = Helper.getLogger(getClass());
	    log.info("Successfully validated Bulk Orders");
	    driver.close();
	}
	
}
