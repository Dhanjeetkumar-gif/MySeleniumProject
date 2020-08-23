package roughWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Practice {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\rageaholic\\eclipse-workspace2\\MySeleniumProject\\src\\Drivers\\geckodriver.exe" );
		WebDriver driver=new FirefoxDriver();
		driver.get("https://s1.demo.opensourcecms.com/wordpress/wp-login.php");
		System.out.println(driver.getTitle());
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("opensourcecms");
        driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys("opensourcecms");
        driver.findElement(By.xpath("//input[@id='wp-submit']")).click();
        System.out.println(driver.getTitle());
	}

}
