package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utilities.Base;

public class PO_FlightsResults extends Base {

	public PO_FlightsResults(WebDriver driver) {
		super();
		// this.driver=driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 5);
		PageFactory.initElements(factory, this);
	}

	// Element objects from login page

	@FindBy(css = ".EqQR69V_vxhhLF5pnfmh")
	public WebElement sortByDiv;

}
