package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonFunctions.CommonFunc;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFunctions.GooglePageFunctions;

public class DuckSearch {

	WebDriver driver = null;

	GooglePageFunctions fuc;

	CommonFunc common = new CommonFunc();

	@Given("Initiate webdriver")
	public void initiate_webdriver() {
		System.out.println(" driver intiattion");

		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "/src/test/resources/drivers/chromedriver");

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Given("I open and navigate to google.com")
	public void open_google_com() {

		System.out.println(" open_google_com");
		common.waitForPageLoaded(driver);
		driver.navigate().to("https://google.com");

	}

	@When("^I Search \"([^\"]*)\" in google$")
	public void search_ducks_in_google(String str) {
		System.out.println(" search_ducks_in_google"+str);

		common.waitForPageLoaded(driver);
		fuc = new GooglePageFunctions(driver);
		fuc.searchIngoogle(str);

	}

	@Then("^I Verify ducks results are showing - \"([^\"]*)\"$")
	public void verify_ducks_results_are_showing(String verifytext) {
		System.out.println(" verify_ducks_results_are_showing"+verifytext);

		Assert.assertTrue(driver.getPageSource().contains(verifytext));

	}

	@After
	public void afterScenario() {
		if (driver !=null) {
			driver.close();
			driver.quit();
		}
		
	}

}
