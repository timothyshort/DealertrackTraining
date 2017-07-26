package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/*
 * This class takes a screenshot
 */

public class Screenshot {
	
	// This method takes a screenshot of the browser and saves as a file
	// This method takes a WebDriver and filename
	public static void snap(WebDriver driver, String filename) {
		File ScreenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(ScreenshotFile, new File (GlobalConfigs.testDataFolder + filename + ".jpg"));
		} catch (IOException e) {
			System.out.println("Could not save the file");
			e.printStackTrace();
		}
	}

}
