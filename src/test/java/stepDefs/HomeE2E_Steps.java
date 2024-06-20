package stepDefs;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import pages.AuthorPage;
import pages.HomePage;

public class HomeE2E_Steps {

	static WebDriver dri = null;
	static HomePage homePage = null;
	static AuthorPage authorPage = null;
	
	@After
	public void tearDown() {
		
		if(dri != null)
			dri.quit();
	
	}
	
	@Given("user is on homepage")
	public void user_is_on_homepage() {

		System.setProperty("webdriver.edge.driver", "src/test/resources/Drivers/msedgedriver.exe");
		
		dri = new EdgeDriver();
		dri.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		dri.manage().window().maximize();
		
		dri.get("https://anapioficeandfire.com/");
		
		
	}

	@Given("user can see the title of the page")
	public void user_can_see_the_title_of_the_page() {

		homePage = new HomePage(dri);
		
		Assert.assertEquals(dri.getTitle(), "An API of Ice And Fire");
		
	}

	@Given("user can see the title of the header section")
	public void user_can_see_the_title_of_the_header_section() {

		Assert.assertEquals(homePage.getTitleH2(), "An API of Ice And Fire");

	}

	@Given("user can see the authors link")
	public void user_can_see_the_authors_link() {

		Assert.assertEquals(homePage.isAuthorsLinkExists(), true);

	}

	@When("user clicks on the authors link")
	public void user_clicks_on_the_authors_link() {

		homePage.clickAuthorLink();

	}

	@Then("user should be able to land in the authors personal page")
	public void user_should_be_able_to_land_in_the_authors_personal_page() {

		authorPage = new AuthorPage(dri);
		
		Assert.assertEquals(authorPage.getAuthorsTitle(), "Joakim Skog Lundell");

	}

}
