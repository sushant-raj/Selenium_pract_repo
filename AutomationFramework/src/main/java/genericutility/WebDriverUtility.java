package genericutility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility {
	
	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void rightClick(WebDriver driver) {
		Actions act = new Actions(driver);
		act.contextClick().perform();	
	}
	
	public void mouseHover(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element);
	}
	
	public void doubleClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
		act.doubleClick().perform();
	}
	
	public void dragAnddrop(WebDriver driver, WebElement source, WebElement target){
		Actions act = new Actions(driver);
		act.dragAndDrop(source, target).perform();	
	}
	
	public void selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	public void selectByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	
	public void selectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
	
	public void swtichToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver, String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	
	public void switchToFrame(WebDriver driver, WebElement frameElement, int index) {
		driver.switchTo().frame(frameElement);
	}
	
	public void switchToAlerAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void switchToAlertAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public void getPhoto(WebDriver driver) throws IOException {
		JavaUtility jUtility = new JavaUtility();
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File temp = screenshot.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshots/"+ jUtility.getSystemTime()+ ".png");
		FileHandler.copy(temp, dest);
	}
	

}
