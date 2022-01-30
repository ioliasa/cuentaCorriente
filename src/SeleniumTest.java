import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class SeleniumTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		try {
			driver.get("http://localhost:8081/CuentaCorriente-0.0.1-SNAPSHOT/");
			
			WebElement ncc = driver.findElement(By.id("ncc"));
			WebElement saldo = driver.findElement(By.id("saldo"));
			WebElement ok = driver.findElement(By.id("ok"));
			
			ncc.sendKeys("1234");
			Thread.sleep(2000);

			saldo.sendKeys("1000");
			Thread.sleep(2000);

			ok.click();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.quit();
		
	}

}
