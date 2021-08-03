package pack1_maven;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class LoginTest {
	WebDriver driver;
	@Test
	public void login() {
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	
	@Test
	public void synchTest() throws InterruptedException {
		driver.get("http://omayo.blogspot.com/");
		driver.findElement(By.xpath("//button[@class='dropbtn']")).click();
		Thread.sleep(4000);
		driver.findElement(By.linkText("Facebook")).click();
	}
	
	
	@BeforeClass // tout ce qui va s'executer avant le test (pré-conditions)
	public void setup() {
		//System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();//chercher le chemin du driver
		driver = new ChromeDriver(); // créer une instance du navigateur chrome
		driver.manage().window().maximize();
		
	}

	@AfterClass // tout ce qui va s'executer apres le test (post conditions)
	public void tearDown() {
		//driver.quit();
	}

}
