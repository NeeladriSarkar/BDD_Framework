package resources;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.Scenario;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

public class Helper {

	public static boolean root = false;
	
	public static Logger getLogger(Class cls) {
		if(root) {
			return Logger.getLogger(cls);
		}
		PropertyConfigurator.configure("log4j.properties");
		root = true;
		return Logger.getLogger(cls);
	}
	
	public static String getTime() {
		
		DateFormat current = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		return current.format(currentDate);
		
	}
	
	public void getScreenshot(WebDriver driver) throws IOException {
			
			File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String destination =System.getProperty("user.dir")+File.separator+".\\screenshots"+File.separator+Helper.getTime()+".png";
			FileUtils.copyFile(screenshot, new File(destination));
	
	}
		
	
}
