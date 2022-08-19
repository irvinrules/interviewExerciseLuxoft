package utilities;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public WebDriver driver;
	public WebDriverWait wait;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if(result.getStatus()==ITestResult.SUCCESS) {
			System.out.println("Test passed: "+ result.getName());
		}
		else if(result.getStatus()==ITestResult.FAILURE) {
			System.out.println("Test failed: "+ result.getName());	
			Throwable testResult = result.getThrowable();
            System.out.println(testResult);	
		}
		else if(result.getStatus()==ITestResult.SKIP) {
			System.out.println("Test skipped: "+ result.getName());			
		}
		driver.close();
		driver.quit();
	}

}
