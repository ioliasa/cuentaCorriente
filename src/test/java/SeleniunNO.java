package test.java;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniunNO {

	
	private WebDriver driver;
	
	@Before
	public void inicial() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
		ChromeOptions options = new ChromeOptions();
		
		
		/*
		options.addArguments("start-maximized"); 
		options.addArguments("enable-automation"); 
		options.addArguments("--no-sandbox"); 
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-browser-side-navigation"); 
		options.addArguments("--disable-gpu");*/
	
		driver = new ChromeDriver(options);
	}
	
	@Test
	public void Pantalla() throws InterruptedException {
		
		//assertTrue(true);
		
		driver.get("http://localhost:8081/CuentaCorriente-0.0.1-SNAPSHOT/");
		
		WebElement ncc = driver.findElement(By.id("ncc"));
		WebElement saldo = driver.findElement(By.id("saldo"));
		WebElement ok = driver.findElement(By.id("ok"));
		Thread.sleep(4000);
		ncc.sendKeys("12345678");
		Thread.sleep(4000);

		saldo.sendKeys("1000");
		Thread.sleep(4000);

		ok.click();
		Thread.sleep(4000);

		String titulo = driver.getCurrentUrl();
		
		assertTrue(titulo.equals("http://localhost:8081/CuentaCorriente-0.0.1-SNAPSHOT/adminBanco?action=empezar"));
		
}

	@After
	public void shutdown() {
		driver.quit();
	}
}
