package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(partialLinkText = "BOOKS")
	private WebElement getBookLink;
	
	@FindBy(partialLinkText = "Computers")
	private WebElement getComputerLink;
	
	@FindBy(partialLinkText = "Electronics")
	private WebElement getElectronicsLink;
	
	@FindBy(linkText = "Log out")
	private WebElement logoutButton;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLogoutButton() {
		return logoutButton;
	}

	public WebElement getGetBookLink() {
		return getBookLink;
	}

	public WebElement getGetComputerLink() {
		return getComputerLink;
	}

	public WebElement getGetElectronicsLink() {
		return getElectronicsLink;
	}
	
}
