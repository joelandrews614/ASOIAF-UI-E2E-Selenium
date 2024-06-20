package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthorPage {

	private WebDriver dri;
	
	public AuthorPage(WebDriver dri) {
		this.dri = dri;
	}
	
	private By authorsTitle = By.xpath("//h1[@id='joakim-skog-lundell']");
	
	public String getAuthorsTitle() {
		WebElement ele = dri.findElement(authorsTitle);
		return ele.getText();
	}
	
}
