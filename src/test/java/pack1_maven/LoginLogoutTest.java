package pack1_maven;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class LoginLogoutTest {
	WebDriver driver;

	@Test
	public void loginLogout() throws Exception {
		// aller sur le site orange
		driver.get("https://opensource-demo.orangehrmlive.com/");
		// login sur l'application orange
		WebElement username=driver.findElement(By.xpath("//input[@name='txtUsername']"));
		username.click();
		//driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		// logout de l'application orange
		driver.findElement(By.xpath("//a[@id='welcome']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@href='/index.php/auth/logout']")).click();
	}

	@BeforeClass // tout ce qui va s'executer avant le test (pré-conditions)
	public void setup() {
		// System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();// chercher le chemin du driver
		driver = new ChromeDriver(); // créer une instance du navigateur chrome
		driver.manage().window().maximize();
	}

	@AfterClass // tout ce qui va s'executer apres le test (post conditions)
	public void tearDown() {
		 driver.quit();
	}

}
