package breakpoint.project.ReactSweeper;

import java.lang.reflect.Field;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TitlePage {
	
	private WebDriver driver;
	private static TitlePage instance;
	private WebElement title;
	private WebElement subTitle;
	private WebElement button;
	
	private TitlePage(WebDriver driver) {
		this.driver = driver;
		this.title = driver.findElement(By.cssSelector("header h1"));
		this.button = driver.findElement(By.cssSelector("button"));
	}
	
	
	public static TitlePage initTitlePageDriver(WebDriver driver) {
		if(instance == null) {
			instance = new TitlePage(driver);
			return instance;
		} else {
			return instance;
		}
	}
	
	public String getFullPath() {
		return this.driver.getCurrentUrl();
	}
	
	public WebElement getTitle() {
		return this.title;
	}
	
	public WebElement getSubTitle() {
		return this.subTitle;
	}
	
	public void clickStartButton() {
		this.button.click();
	}
}
