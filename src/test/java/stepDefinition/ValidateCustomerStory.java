package stepDefinition;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CustomerStoryPage;
import pageObjects.LandingPage;
import resources.Base;
import resources.Helper;

public class ValidateCustomerStory extends Base {

	@Given("user opens homepage for customer story")
	public void user_opens_homepage_for_customer_story() throws IOException {
	    driver = initializeDriver();
	    Logger log = Helper.getLogger(getClass());
	    log.info("Validating Customer Stories");
	    
	}

	@When("user clicks on Customer Stories option")
	public void user_clicks_on_customer_stories_option() {
		LandingPage lp = new LandingPage(driver);
		lp.customerStoryClick().click();
	}

	@Then("user must be able to see the required name in Customer Stories page")
	public void user_must_be_able_to_see_the_required_name_in_customer_stories_page() {
		CustomerStoryPage cp = new CustomerStoryPage(driver);
		Assert.assertTrue(cp.getText().isDisplayed());
		Logger log = Helper.getLogger(getClass());
	    log.info("Successfully validated Customer Stories");
	    driver.close();
	}
	
}
