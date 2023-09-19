package stepDefinition;

import java.io.IOException;

import org.apache.log4j.Logger;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import resources.Base;
import resources.Helper;


@SuppressWarnings("deprecation")
public class ValidateTitle extends Base {

	@Given("user opens website for title")
	public void user_opens_website_for_title() throws IOException {
	    driver = initializeDriver();
	}

	@When("user lands on website")
	public void user_lands_on_website() {
	    Logger log = Helper.getLogger(getClass());
	    log.info("Validating Title");
	}

	@Then("title is verified")
	public void title_is_verified() {
		Assert.assertEquals(driver.getTitle(), "Furniture Online: @Upto 40% Off on Wooden Furniture Online in India at Best Price - Urban Ladder");
		Logger log = Helper.getLogger(getClass());
		log.info("Successfully validated title");
		driver.close();
	}

	
}
