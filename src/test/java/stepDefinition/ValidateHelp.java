package stepDefinition;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HelpPage;
import pageObjects.LandingPage;
import resources.Base;
import resources.Helper;

public class ValidateHelp extends Base {

	@Given("user opens homepage for help")
	public void user_opens_homepage_for_help() throws IOException {
		driver = initializeDriver();
		Logger log = Helper.getLogger(getClass());
	    log.info("Validating Help");
	}

	@When("user clicks on Help option")
	public void user_clicks_on_help_option() {
		LandingPage lp = new LandingPage(driver);
		lp.clickHelp().click();
	}

	@Then("user must be able to see Help Center on Help page")
	public void user_must_be_able_to_see_help_center_on_help_page() {
		HelpPage hp = new HelpPage(driver);
		Assert.assertTrue(hp.verifyHelpCenter().isDisplayed());
		Logger log = Helper.getLogger(getClass());
	    log.info("Successfully validated Help");
	    driver.close();
	}

	
}
