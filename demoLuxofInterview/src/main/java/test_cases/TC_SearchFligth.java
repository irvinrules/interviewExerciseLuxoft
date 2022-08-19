package test_cases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageobjects.PO_FlightsResults;
import pageobjects.PO_Home;
import utilities.Base;

public class TC_SearchFligth extends Base{
	

	PO_Home po_home;
	PO_FlightsResults po_flightResults;
	
	@Parameters({"url","month"})
	@Test
	public void SearchFlightsTest(String url1, String month) {
		po_home=new PO_Home(driver);
		po_flightResults=new PO_FlightsResults(driver);
		
		//steps
		driver.get(url1);
		po_home.setDarkMode();
		try {Thread.sleep(2000);}catch(InterruptedException e){e.printStackTrace();}
		po_home.citiesToSeachFlights("New York","Berlin");
		try {Thread.sleep(2000);}catch(InterruptedException e){e.printStackTrace();}	
		po_home.setFromDate(month);
		try {Thread.sleep(2000);}catch(InterruptedException e){e.printStackTrace();}
		po_home.setPassengers();
		try {Thread.sleep(2000);}catch(InterruptedException e){e.printStackTrace();}
		po_home.searchFlight();
		try {Thread.sleep(2000);}catch(InterruptedException e){e.printStackTrace();}
		//expectedResults
		Assert.assertTrue(po_flightResults.sortByDiv.isDisplayed());
		
	}
}
