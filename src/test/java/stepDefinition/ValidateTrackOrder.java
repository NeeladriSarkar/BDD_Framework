package stepDefinition;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.TrackOrderPage;
import resources.Base;
import resources.ExcelDataProvider;
import resources.Helper;

public class ValidateTrackOrder extends Base {

	@Given("user opens homepage for tracking order")
	public void user_opens_homepage_for_tracking_order() throws IOException {
		driver = initializeDriver();
		Logger log = Helper.getLogger(getClass());
	    log.info("Validating Track Orders");
	}

	@When("user clicks on Track Orders")
	public void user_clicks_on_track_orders() {
		LandingPage lp = new LandingPage(driver);
		lp.clickTrackOrder().click();
	}

	@When("enters order number and phone number")
	public void enters_order_number_and_phone_number() throws IOException {
		ExcelDataProvider excel = new ExcelDataProvider();
		TrackOrderPage to = new TrackOrderPage(driver);
		to.getOrderNumber().sendKeys(excel.getNumericData("Data", 0, 0));
		to.getPhoneNumber().sendKeys(excel.getNumericData("Data", 0, 1));
	}

	@When("clicks on submit")
	public void clicks_on_submit() {
		TrackOrderPage to = new TrackOrderPage(driver);
		to.clickSubmit().click();
	}

	@Then("user must be able to see error message")
	public void user_must_be_able_to_see_error_message() {
		TrackOrderPage to = new TrackOrderPage(driver);
		Assert.assertTrue(to.verifyText().isDisplayed());
		Logger log = Helper.getLogger(getClass());
	    log.info("Successfully validated Track Orders");
	    driver.close();
	}
	
}
