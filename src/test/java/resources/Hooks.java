package resources;

import java.io.IOException;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Hooks extends Base {

	@After
	public void teardown(Scenario scenario) throws IOException {
		
		Helper h = new Helper();
		
		if(scenario.isFailed()) {
			h.getScreenshot(driver);
		}
		
		else if(!scenario.isFailed()) {
			h.getScreenshot(driver);
		}
		
	}
	
}
