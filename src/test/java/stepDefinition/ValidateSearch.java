package stepDefinition;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.SearchPage;
import resources.Base;
import resources.ExcelDataProvider;
import resources.Helper;

public class ValidateSearch extends Base {

	@Given("user opens homepage for search")
	public void user_opens_homepage_for_search() throws IOException {
	    driver = initializeDriver();
	    Logger log = Helper.getLogger(getClass());
	    log.info("Validating Search");
	}

	@When("user enters search query")
	public void user_enters_search_query() throws IOException {
		ExcelDataProvider excel = new ExcelDataProvider();
		LandingPage lp = new LandingPage(driver);
		lp.searchElement().sendKeys(excel.getStringData("Data", 1, 0));
	}

	@When("presses ENTER")
	public void presses_enter() {
		LandingPage lp = new LandingPage(driver);
		lp.searchElement().sendKeys(Keys.ENTER);
	}

	@Then("user must be able to see the count of items displayed")
	public void user_must_be_able_to_see_the_count_of_items_displayed() {
		SearchPage sp = new SearchPage(driver);
		System.out.println(sp.getCount().getText());
		Assert.assertTrue(sp.getCount().isDisplayed());
		Logger log = Helper.getLogger(getClass());
	    log.info("Successfully validated Search");
	    driver.close();
	}
	
}
