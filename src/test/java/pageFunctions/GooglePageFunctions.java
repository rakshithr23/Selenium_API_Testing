package pageFunctions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GooglePageFunctions {

	WebDriver driver;

	public GooglePageFunctions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = ".//input[@name='q']")
	private WebElement txt_search;

	public void searchIngoogle(String str) {

		txt_search.sendKeys(str);
		txt_search.sendKeys(Keys.ENTER);

	}

}
