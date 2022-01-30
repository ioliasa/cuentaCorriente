package test.java;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

	
	private WebDriver driver;
	
	@Before
	public void inicial() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
		driver = new ChromeDriver();
	}
	
	@Test
	public void Pantalla() {
		
		
		
		driver.get("http://localhost:8081/CuentaCorriente-0.0.1-SNAPSHOT/");
		
		WebElement ncc = driver.findElement(By.id("ncc"));
		WebElement saldo = driver.findElement(By.id("saldo"));
		WebElement ok = driver.findElement(By.id("ok"));
		
		ncc.sendKeys("1234");

		saldo.sendKeys("1000");

		ok.click();
		String titulo = driver.getCurrentUrl();
		
		assertTrue(titulo.equals("http://localhost:8081/CuentaCorriente-0.0.1-SNAPSHOT/adminBanco?action=empezar"));
		
}

	@After
	public void shutdown() {
		driver.quit();
	}
}
