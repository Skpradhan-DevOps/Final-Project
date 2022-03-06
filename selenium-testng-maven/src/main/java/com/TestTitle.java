package com;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestTitle {
	//private RemoteWebDriver driver = null;

	// public String URL = "https://www.aetna.com/";
	// public void testEasy(String myURL, String myTitle) throws InterruptedException
	// @Parameters({ "myURL", "myTitle" })
	
	@Test
	public void beforeTest() throws InterruptedException, MalformedURLException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option= new ChromeOptions();
		WebDriver driver = new ChromeDriver(option);
		
		URL url=new URL("http://localhost:4444/wd/hub");
		RemoteWebDriver drivers = new RemoteWebDriver(url,(Capabilities) driver);
		
		drivers.get("https://www.aetna.com/");
		Thread.sleep(4000);
		String title = drivers.getTitle();
		System.out.println("Title is : "+title);
		Assert.assertTrue(title.contains("Health Insurance Plans | Aetna"));
		
		
		/*DesiredCapabilities dc = DesiredCapabilities.chrome();
		URL url=new URL("http://localhost:4444");
		RemoteWebDriver driver = new RemoteWebDriver(url,dc);
		driver.get("https://www.aetna.com/");
		Thread.sleep(4000);
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("Health Insurance Plans | Aetna"));*/
		
		drivers.quit();
	}

	/*@Test
	public void testEasy() throws InterruptedException {
		driver.get("https://www.aetna.com/");
		Thread.sleep(4000);
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("Health Insurance Plans | Aetna"));
		// Assert.assertTrue(title
		// .contains("Health Insurance Plans | Aetna"));
	}



	@AfterTest
	public void afterTest() {
		driver.quit();
	}*/

}
