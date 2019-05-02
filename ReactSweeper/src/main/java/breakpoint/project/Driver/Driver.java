package breakpoint.project.Driver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
	
	private static Driver instance;
	private WebDriver driver;
	
	private Driver(String browser) throws IOException {
		Properties props = new Properties();
		InputStream inp = new FileInputStream("src/main/resources/driver.properties");
		props.load(inp);
		if(browser.equalsIgnoreCase("chrome")) {
			String chrome = props.getProperty("chrome");
			System.setProperty("webdriver.chrome.driver", chrome);
			this.driver = new ChromeDriver();
		} else if(browser.equalsIgnoreCase("firefox")) {
			String firefox = props.getProperty("firefox");
			System.setProperty("webdriver.firefox.driver", firefox);
			this.driver = new FirefoxDriver();
		}
	}
	
	public static Driver InitDriver(String browser) {
		try {
			instance = instance == null ? new Driver(browser) : instance;
			return instance;
		} catch(IOException ioe) {
			System.out.println(ioe.getMessage());
			return null;
		}
	}
	
	public WebDriver start(String url) {
		if(instance == null) {
			throw new NullPointerException();
		}
		instance.driver.get(url);
		return instance.driver;
	}
	
	public void quit() {
		if(instance == null) {
			throw new NullPointerException();
		}
		instance.driver.quit();
	}
 }
