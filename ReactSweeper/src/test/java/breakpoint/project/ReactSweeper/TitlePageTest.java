package breakpoint.project.ReactSweeper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import breakpoint.project.Driver.Driver;

@Test
public class TitlePageTest {
	
	WebDriver driver = Driver.InitDriver("chrome").start("https://reactsweeper.netlify.com/");
	TitlePage titlePage = TitlePage.initTitlePageDriver(driver);
	
	@BeforeTest
	public void setUp() {
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
	}

	public void titleEqualsReactSweeper() {
		String title = titlePage.getTitle().getText();
		Assert.assertEquals(title, "React Sweeper");
	}
	
	public void testGamePageRoute() {
		titlePage.clickStartButton();
		String url = titlePage.getFullPath();
		Assert.assertEquals(url, "https://reactsweeper.netlify.com/game");
	}
	
	@AfterTest
	public void cleanUp() {
		driver.quit();
	}
	
}
