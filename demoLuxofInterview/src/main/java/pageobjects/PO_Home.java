package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.Base;

public class PO_Home extends Base {

	public PO_Home(WebDriver driver) {
		super();
		// this.driver=driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 5);
		PageFactory.initElements(factory, this);
	}

	// Element objects from login page

	@FindBy(css = ".checkbox_bc31d76")
	public WebElement nightModeButton;
	@FindBy(css = "#origin")
	public WebElement departureTextField;
	@FindBy(css = "#destination")
	public WebElement destinationTextField;
	@FindBy(css = "div[data-test-id='departure-date-field']")
	public WebElement FromDateDiv;
	@FindBy(css = ".calendar-caption__select")
	public WebElement fromDateDropdownElement;
	@FindBy(xpath = "//div[contains(text(),'30')]")
	public List<WebElement> thirtyDayDiv;
	@FindBy(xpath = "//div[contains(text(),'1 passenger')]")
	public WebElement passengersDiv;
	@FindBy(css = ".additional-fields__passenger-row :nth-child(3)")
	public WebElement adultPassengersIncrementButton;
	@FindBy(css = "button[data-test-id='form-submit']")
	public WebElement searchButton;
	
	
	
	
	public void date_dropdown(String month) {
		Select fromDateDdropdown = new Select(fromDateDropdownElement);
		fromDateDdropdown.selectByVisibleText(month);	
	}
	public void setDarkMode() {
		nightModeButton.click();
	}
	public void citiesToSeachFlights(String departure, String destination) {
		departureTextField.clear();
		departureTextField.sendKeys(departure);
		destinationTextField.sendKeys(destination);
	}
	public void setFromDate(String month) {
		date_dropdown(month);
		System.out.println("size "+thirtyDayDiv.size());
		System.out.println(thirtyDayDiv.toString());
		System.out.println(" last____ -> "+thirtyDayDiv.get(thirtyDayDiv.size()-1));
		System.out.println("_________________");
		
		thirtyDayDiv.get(1).click();
		System.out.println("_________________");
	}
	public void setPassengers() {
		passengersDiv.click();
		adultPassengersIncrementButton.click();
	}
	
	public void searchFlight() {
		searchButton.click();
	}
}