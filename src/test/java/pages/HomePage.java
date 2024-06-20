package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	private WebDriver dri = null;
	
	public HomePage(WebDriver dri){
		
		this.dri = dri;
		
	}
	
	private By titleH2 = By.xpath("//h1");
	private By authorLink = By.xpath("//section/p/a[@href='https://joakimskoog.com/']");
	
	public String getTitleH2() {
		WebElement ele = dri.findElement(titleH2);
		return ele.getText();
	}

	public boolean isAuthorsLinkExists() {
		WebElement ele = dri.findElement(authorLink);
		return ele.isDisplayed();
	}
	
	public void clickAuthorLink() {
		WebElement ele = dri.findElement(authorLink);
		ele.click();
	}
}
