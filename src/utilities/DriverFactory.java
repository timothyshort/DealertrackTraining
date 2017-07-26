package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/*
 * This class delivers a WebDriver object
 * This class has 3 overloaded GET() methods to return a browser:
 * 1. Default get()
 * 2. BrowserType get(String browserType)
 * 3. BrowserType + URL get(String browserType, String webURL)
 */

public class DriverFactory {
	
	private static String driverPath = "C:\\DealerTrackTraining\\Software\\";
	private static String chromeDriver = "chromedriver.exe";
	
	// Write a function that returns a default WebDriver (user does not specify)
	public static WebDriver get() {
		WebDriver driver;
		System.out.println("Opening chrome browser");
		System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}
	
	// Write a function that returns a WebDriver when user sends desired browser
	public static WebDriver get(String browserType) {
		WebDriver driver;
		if (browserType.equalsIgnoreCase("Chrome")) {
			System.out.println("Opening chrome browser");
			System.setProperty("webdriver.chrome.driver", driverPath + chromeDriver);
			driver = new ChromeDriver();
		}
		else if (browserType.equalsIgnoreCase("Firefox")) {
			System.out.println("Opening Firefox browser");
			System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if (browserType.equalsIgnoreCase("IE")) {
			System.out.println("Opening IE browser");
			System.setProperty("webdriver.ie.driver", driverPath + "IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else {
			System.out.println("Could not understand input. Will open Chrome as default");
			System.setProperty("webdriver.chrome.driver", "C:\\DealerTrackTraining\\Software\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		setConfigs(driver);
		return driver;
	}
	
	// Exercise: write one more overloaded method, that includes the URL the user wants to test
	public static WebDriver get(String browserType, String webURL) {
		WebDriver driver;
		if (browserType.equalsIgnoreCase("Chrome")) {
			System.out.println("Opening chrome browser");
			System.setProperty("webdriver.chrome.driver", "C:\\DealerTrackTraining\\Software\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browserType.equalsIgnoreCase("Firefox")) {
			System.out.println("Opening Firefox browser");
			System.setProperty("webdriver.gecko.driver", "C:\\DealerTrackTraining\\Software\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if (browserType.equalsIgnoreCase("IE")) {
			System.out.println("Opening IE browser");
			System.setProperty("webdriver.ie.driver", "C:\\DealerTrackTraining\\Software\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else {
			System.out.println("Could not understand input. Will open Chrome as default");
			System.setProperty("webdriver.chrome.driver", "C:\\DealerTrackTraining\\Software\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.get(webURL);
		setConfigs(driver);
		return driver;
	}
	
	// This function returns a WebDriver with maximized window and 3 second wait
	private static void setConfigs(WebDriver driver) {
		System.out.println("Setup basic WebDriver configurations");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	public static int switchFrames(String browserType, int frame) {
		if (browserType.equalsIgnoreCase("Firefox") || browserType.equalsIgnoreCase("ff")) {
			return frame + 1;
		}
		else {
			return frame;
		}
	}

}
