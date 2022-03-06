package com;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;

public class TestTitle {
	private WebDriver driver = null;

	// public String URL = "https://www.aetna.com/";

	@Test
	@Parameters({ "myURL", "myTitle" })
	public void testEasy(String myURL, String myTitle) {
		driver.get(myURL);
		String title = driver.getTitle();
		Assert.assertTrue(title.contains(myTitle));
		// Assert.assertTrue(title
		// .contains("Health Insurance Plans | Aetna"));
	}

	@BeforeTest
	public void beforeTest() throws Exception {
		driver = new ChromeDriver();
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
