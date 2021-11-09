package homeworkPro;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class OnlineBankTest {
	public static void main(String[] args) {
		//System path for web driver
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\drivers\\chromedriver.exe");
		
		//intialize webdriver
		
		WebDriver driver = new ChromeDriver();
		
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//open browser
				driver.get("http://zero.webappsecurity.com/");
				
				
				String actualTitle = driver.getTitle();
				String expTitle= "Zero - Personal Banking - Loans - Credit Cards";
				
				assertEquals(actualTitle, expTitle);
				
				try {
					
					assertEquals(driver.getTitle(), "Zero - Log in");
					
				} catch (AssertionError e) {
					System.out.println(e); 
				}
				
		//check nav bar online banking button
		driver.findElement(By.id("onlineBankingMenu")).click();		
		
		// check account summary button
		
		driver.findElement(By.id("account_summary_link")).click();

				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				//enter username
				driver.findElement(By.name("user_login")).sendKeys("username");
				//enter password
				driver.findElement(By.name("user_password")).sendKeys("password");
				
				// click on signin
				driver.findElement(By.name("submit")).click();
				
				driver.findElement(By.id("primary-button")).click();
				
				driver.findElement(By.id("onlineBankingMenu")).click();	
				
				driver.findElement(By.id("account_summary_link")).click();
				
		//pay bills
		driver.findElement(By.xpath("//*[@id='pay_bills_tab']")).click();
		
		driver.findElement(By.name("payee")).findElements(By.tagName("option")).get(2).click();
		
		driver.findElement(By.name("account")).findElements(By.tagName("option")).get(2).click();
		
		driver.findElement(By.name("amount")).sendKeys("420");
		
		//calendar 
		driver.findElement(By.id("sp_date")).sendKeys("2012-04-12");
		
//		driver.findElement(By.className("ui-datepicker-next ui-corner-all")).click();
		
//		driver.findElement(By.className("ui-state-default")).;
		
		driver.findElement(By.id("sp_description")).sendKeys("Gotta pay my baby momma");
		
//		driver.findElement(By.id("pay_saved_payees")).click();
		driver.findElement(By.tagName("input")).findElement(By.id("pay_saved_payees")).click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.close();
		driver.quit();
	}
	

	

}
