package web_test;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import page.DynamicLoadingPage;
import page.HerokuappHomePage;

public class DynamicLoadingTest {
	
	String driverPath = "D:\\chromedriver.exe";
	private static WebDriver driver;
	
	DynamicLoadingPage dynamicLoadingTest;
	HerokuappHomePage herokuappHomePage;
	
	@BeforeClass
	public static  void BrowserOpen() {
		
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	/**
	 * navigating to home page and click on dynamic link 
	 * then click on example 2 link and click on start 
	 * waiting for loading Hello World!
	 */
	@Test
	public void startDynamicLoading() {
		dynamicLoadingTest = new DynamicLoadingPage(driver);
		herokuappHomePage = new HerokuappHomePage(driver);
		
		herokuappHomePage.open();
		herokuappHomePage.clickIn("Dynamic Loading");
		
		dynamicLoadingTest.clickOnExample2();
		dynamicLoadingTest.clickOnStart();
		dynamicLoadingTest.waitForLoading();
		
	}
	
	/**
	 * check the displayed text
	 */
	@Test
	public void checkTheTextMessage() {
		
		assertTrue(dynamicLoadingTest.checkTheDispalyedText());
		
	}
	

	@AfterClass
	public static void BrowserClose() {
		driver.close();
	}

}
